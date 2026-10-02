package com.solidpayments.lsp.after;

import java.math.BigDecimal;

/**
 * FOLLOWS LSP.
 *
 * <p>Boleto only implements {@link PaymentMethod}, so it never promises a
 * refund it cannot deliver. It can replace any {@code PaymentMethod} safely.
 */
public record BoletoPayment() implements PaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "BOLETO-TX-" + amount;
    }
}
