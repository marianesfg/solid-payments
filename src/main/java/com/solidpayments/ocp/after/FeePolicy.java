package com.solidpayments.ocp.after;

import java.math.BigDecimal;

/**
 * The extension point. Each payment type brings its own fee rule by
 * implementing this interface.
 */
public interface FeePolicy {

    String paymentType();

    BigDecimal calculateFee(BigDecimal amount);
}
