package com.solidpayments.dip.after.infrastructure;

import com.solidpayments.dip.after.PaymentRepository;

import java.math.BigDecimal;

/**
 * Low-level detail that now DEPENDS ON the business abstraction (the arrow of
 * dependency is inverted: infrastructure -> business, never the opposite).
 */
public class MySqlPaymentRepository implements PaymentRepository {

    @Override
    public void save(String orderId, BigDecimal amount) {
        throw new IllegalStateException("Could not connect to MySQL at localhost:3306");
    }
}
