package com.solidpayments.lsp.before;

import java.math.BigDecimal;

public class CreditCardPayment extends PaymentMethod {

    @Override
    public String pay(BigDecimal amount) {
        return "CARD-TX-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        return "Card refund done for " + transactionId;
    }
}
