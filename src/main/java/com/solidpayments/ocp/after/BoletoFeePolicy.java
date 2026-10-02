package com.solidpayments.ocp.after;

import java.math.BigDecimal;

public class BoletoFeePolicy implements FeePolicy {

    private static final BigDecimal FIXED_FEE = new BigDecimal("3.50");

    @Override
    public String paymentType() {
        return "BOLETO";
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return FIXED_FEE;
    }
}
