package com.solidpayments.dip.after;

import java.math.BigDecimal;

/**
 * Abstraction OWNED by the business layer. It describes what checkout needs,
 * not how a specific database works.
 */
public interface PaymentRepository {

    void save(String orderId, BigDecimal amount);
}
