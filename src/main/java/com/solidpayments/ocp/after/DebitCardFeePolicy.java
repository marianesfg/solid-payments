package com.solidpayments.ocp.after;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A NEW payment type added later.
 *
 * <p>Notice that supporting it required ZERO changes to {@link FeeCalculator}
 * or to the other policies: we only ADDED this class. That is OCP in action:
 * open for extension, closed for modification.
 */
public class DebitCardFeePolicy implements FeePolicy {

    private static final BigDecimal RATE = new BigDecimal("0.0149");

    @Override
    public String paymentType() {
        return "DEBIT_CARD";
    }

    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
}
