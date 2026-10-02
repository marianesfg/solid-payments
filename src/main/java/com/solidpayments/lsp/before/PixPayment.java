package com.solidpayments.lsp.before;

import java.math.BigDecimal;

public class PixPayment extends PaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "PIX-TX-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        return "Pix refund (MED) done for " + transactionId;
    }
}
