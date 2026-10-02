package com.solidpayments.lsp.before;

import java.math.BigDecimal;

/**
 * VIOLATES LSP.
 *
 * <p>A paid boleto cannot be refunded automatically, but the parent class
 * promised that every {@link PaymentMethod} can refund. This subclass breaks
 * that promise by throwing an exception, so it can NOT safely replace its
 * parent: code written for {@code PaymentMethod} blows up when it receives a
 * {@code BoletoPayment}.
 */
public class BoletoPayment extends PaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "BOLETO-TX-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        throw new UnsupportedOperationException("Boleto cannot be refunded automatically");
    }
}
