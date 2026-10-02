package com.solidpayments.lsp.after;

import java.math.BigDecimal;

public record PixPayment() implements RefundablePaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "PIX-TX-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        return "Pix refund (MED) done for " + transactionId;
    }
}
