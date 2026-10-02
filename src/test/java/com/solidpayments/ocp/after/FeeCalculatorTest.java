package com.solidpayments.ocp.after;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeeCalculatorTest {

    @Test
    @DisplayName("AFTER: debit card is supported just by ADDING a new policy")
    void newTypeIsAddedWithoutModification() {
        FeeCalculator calculator = new FeeCalculator(List.of(
                new PixFeePolicy(),
                new BoletoFeePolicy(),
                new CreditCardFeePolicy(),
                new DebitCardFeePolicy()));

        assertEquals(BigDecimal.ZERO, calculator.calculateFee("PIX", new BigDecimal("100.00")));
        assertEquals(new BigDecimal("3.50"), calculator.calculateFee("BOLETO", new BigDecimal("100.00")));
        assertEquals(new BigDecimal("3.99"), calculator.calculateFee("CREDIT_CARD", new BigDecimal("100.00")));
        assertEquals(new BigDecimal("1.49"), calculator.calculateFee("DEBIT_CARD", new BigDecimal("100.00")));
    }

    @Test
    @DisplayName("AFTER: even an anonymous policy plugs in without touching FeeCalculator")
    void anonymousPolicyPlugsIn() {
        FeePolicy promoPolicy = new FeePolicy() {
            @Override
            public String paymentType() {
                return "PROMO";
            }

            @Override
            public BigDecimal calculateFee(BigDecimal amount) {
                return BigDecimal.ONE;
            }
        };

        FeeCalculator calculator = new FeeCalculator(List.of(promoPolicy));

        assertEquals(BigDecimal.ONE, calculator.calculateFee("PROMO", new BigDecimal("100.00")));
    }
}
