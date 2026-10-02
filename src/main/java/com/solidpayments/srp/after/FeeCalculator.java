package com.solidpayments.srp.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Only reason to change: fee rules.
 */
public class FeeCalculator {

    private static final BigDecimal FEE_RATE = new BigDecimal("0.02");

    public BigDecimal totalWithFee(BigDecimal amount) {
        BigDecimal fee = amount.multiply(FEE_RATE).setScale(2, RoundingMode.HALF_EVEN);
        return amount.add(fee);
    }
}
