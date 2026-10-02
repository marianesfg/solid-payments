package com.solidpayments.dip.after.infrastructure;

import com.solidpayments.dip.after.PaymentRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Another implementation of the same abstraction. Useful for tests and local
 * development. Swapping it in requires no change to {@code CheckoutService}.
 */
public class InMemoryPaymentRepository implements PaymentRepository {

    private final Map<String, BigDecimal> payments = new HashMap<>();

    @Override
    public void save(String orderId, BigDecimal amount) {
        payments.put(orderId, amount);
    }

    public Optional<BigDecimal> findByOrderId(String orderId) {
        return Optional.ofNullable(payments.get(orderId));
    }
}
