package com.solidpayments.srp.after;

/**
 * Only reason to change: validation rules.
 */
public class PaymentValidator {

    public void validate(Payment payment) {
        if (payment.amount() == null || payment.amount().signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (payment.payerEmail() == null || !payment.payerEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid payer e-mail");
        }
    }
}
