package com.solidpayments.lsp.before;

import java.math.BigDecimal;

/**
 * The base class PROMISES that every payment method can pay AND refund.
 */
public abstract class PaymentMethod {

    public abstract String pay(BigDecimal amount);

    public abstract String refund(String transactionId);
}
