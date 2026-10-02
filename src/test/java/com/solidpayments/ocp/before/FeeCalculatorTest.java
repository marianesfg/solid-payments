package com.solidpayments.ocp.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FeeCalculatorTest {

    private final FeeCalculator calculator = new FeeCalculator();

    @Test
    @DisplayName("BEFORE: existing types work")
    void existingTypesWork() {
        assertEquals(BigDecimal.ZERO, calculator.calculateFee("PIX", new BigDecimal("100.00")));
        assertEquals(new BigDecimal("3.50"), calculator.calculateFee("BOLETO", new BigDecimal("100.00")));
        assertEquals(new BigDecimal("3.99"), calculator.calculateFee("CREDIT_CARD", new BigDecimal("100.00")));
    }

    @Test
    @DisplayName("BEFORE: a new type (debit card) is impossible without editing FeeCalculator")
    void newTypeRequiresModification() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateFee("DEBIT_CARD", new BigDecimal("100.00")));
    }
}
