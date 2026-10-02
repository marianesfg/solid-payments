package com.solidpayments.ocp.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardFeePolicy implements FeePolicy {

    private static final BigDecimal RATE = new BigDecimal("0.0399");

    @Override
    public String paymentType() {
        return "CREDIT_CARD";
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
}
