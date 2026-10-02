package com.solidpayments.dip.after;

import java.math.BigDecimal;

/**
 * FOLLOWS DIP.
 *
 * <p>The business rule depends only on abstractions, received through the
 * constructor (dependency injection). Whoever builds this object decides
 * which implementations to plug in: MySQL in production, in-memory in tests.
 * This is exactly what frameworks like Spring do for you with
 * {@code @Autowired} / constructor injection.
 */
public class CheckoutService {

    private final PaymentRepository repository;
    private final NotificationSender notificationSender;

    public CheckoutService(PaymentRepository repository, NotificationSender notificationSender) {
        this.repository = repository;
        this.notificationSender = notificationSender;
    }

    public void checkout(String orderId, String customerEmail, BigDecimal amount) {
        repository.save(orderId, amount);
        notificationSender.send(customerEmail, "Order " + orderId + " paid: R$ " + amount);
    }
}
