package com.solidpayments.isp.before;

import java.math.BigDecimal;

/**
 * VIOLATES ISP: a "fat" interface.
 *
 * <p>It mixes operations from different payment products. Every gateway is
 * forced to implement all of them, even the ones that make no sense for it,
 * and every client depends on methods it never calls.
 */
public interface PaymentGateway {

    String charge(BigDecimal amount);

    String refund(String transactionId);

    String generatePixQrCode(BigDecimal amount);

    String issueBoleto(BigDecimal amount, String dueDate);
}
