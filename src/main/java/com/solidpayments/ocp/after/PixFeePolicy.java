package com.solidpayments.ocp.after;

import java.math.BigDecimal;

public class PixFeePolicy implements FeePolicy {

    @Override
    public String paymentType() {
        return "PIX";
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return BigDecimal.ZERO;
    }
}
