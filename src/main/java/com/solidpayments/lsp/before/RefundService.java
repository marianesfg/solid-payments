package com.solidpayments.lsp.before;

/**
 * Client code that trusts the parent class contract.
 *
 * <p>It compiles fine with any {@link PaymentMethod}, but fails at RUNTIME
 * when given a {@link BoletoPayment}. The only "fix" would be an
 * {@code instanceof BoletoPayment} check here, which is a classic smell of an
 * LSP violation.
 */
public class RefundService {

    public String refund(PaymentMethod method, String transactionId) {
        return method.refund(transactionId);
    }
}
