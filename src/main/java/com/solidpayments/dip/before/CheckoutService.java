package com.solidpayments.dip.before;

import java.math.BigDecimal;

/**
 * VIOLATES DIP.
 *
 * <p>The high-level business rule (checkout) creates its low-level details
 * with {@code new}. Consequences:
 * <ul>
 *   <li>It is impossible to unit test without a real MySQL and SMTP server.</li>
 *   <li>Switching to PostgreSQL or to SMS means editing business code.</li>
 * </ul>
 */
public class CheckoutService {

    private final MySqlPaymentRepository repository = new MySqlPaymentRepository();
    private final SmtpEmailSender emailSender = new SmtpEmailSender();

    public void checkout(String orderId, String customerEmail, BigDecimal amount) {
        repository.save(orderId, amount);
        emailSender.send(customerEmail, "Order " + orderId + " paid: R$ " + amount);
    }
}
