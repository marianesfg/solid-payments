package com.solidpayments.dip.before;

import java.math.BigDecimal;

/**
 * Low-level detail: talks to a real database.
 * (Simulated here: there is no database, so it always fails.)
 */
public class MySqlPaymentRepository {

    public void save(String orderId, BigDecimal amount) {
        throw new IllegalStateException("Could not connect to MySQL at localhost:3306");
    }
}
