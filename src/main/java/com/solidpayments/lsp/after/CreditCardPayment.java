package com.solidpayments.lsp.after;

import java.math.BigDecimal;

public record CreditCardPayment() implements RefundablePaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "CARD-TX-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        return "Card refund done for " + transactionId;
    }
}
