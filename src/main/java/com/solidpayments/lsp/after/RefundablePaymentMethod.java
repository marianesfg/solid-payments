package com.solidpayments.lsp.after;

/**
 * A more specific contract, implemented only by methods that truly support
 * refunds. Any implementation can be substituted for this type without
 * surprises.
 */
public interface RefundablePaymentMethod extends PaymentMethod {

    String refund(String transactionId);
}
