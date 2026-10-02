package com.solidpayments.ocp.before;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * VIOLATES OCP.
 *
 * <p>Every new payment type (debit card, PayPal, crypto...) forces us to OPEN
 * this class and add another {@code case}. Each edit risks breaking the
 * existing, already-tested rules for Pix, boleto and credit card.
 */
public class FeeCalculator {

    public BigDecimal calculateFee(String paymentType, BigDecimal amount) {
        return switch (paymentType) {
            case "PIX" -> BigDecimal.ZERO;
            case "BOLETO" -> new BigDecimal("3.50");
            case "CREDIT_CARD" -> amount.multiply(new BigDecimal("0.0399")).setScale(2, RoundingMode.HALF_EVEN);
            // To support DEBIT_CARD we would have to edit this method again.
            default -> throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        };
    }
}
