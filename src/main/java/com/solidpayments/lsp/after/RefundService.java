package com.solidpayments.lsp.after;

/**
 * FOLLOWS LSP.
 *
 * <p>The parameter type is {@link RefundablePaymentMethod}, so the COMPILER
 * now prevents passing a {@link BoletoPayment}. The error moved from runtime
 * (a crash in production) to compile time (a red line in the IDE).
 *
 * <pre>{@code
 * refundService.refund(new BoletoPayment(), "TX-1"); // does not compile
 * }</pre>
 */
public class RefundService {

    public String refund(RefundablePaymentMethod method, String transactionId) {
        return method.refund(transactionId);
    }
}
