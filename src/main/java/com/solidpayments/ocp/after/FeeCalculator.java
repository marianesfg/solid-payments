package com.solidpayments.ocp.after;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * FOLLOWS OCP.
 *
 * <p>This class is CLOSED for modification: it never needs to change when a new
 * payment type appears. It is OPEN for extension: new behavior arrives as a
 * new {@link FeePolicy} passed in the constructor (Strategy pattern).
 */
public class FeeCalculator {

    private final Map<String, FeePolicy> policiesByType;

    public FeeCalculator(List<FeePolicy> policies) {
        this.policiesByType = policies.stream()
                .collect(Collectors.toUnmodifiableMap(FeePolicy::paymentType, Function.identity()));
    }

    public BigDecimal calculateFee(String paymentType, BigDecimal amount) {
        FeePolicy policy = policiesByType.get(paymentType);
        if (policy == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
        return policy.calculateFee(amount);
    }
}
