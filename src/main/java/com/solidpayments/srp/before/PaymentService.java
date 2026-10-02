package com.solidpayments.srp.before;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * VIOLATES SRP.
 *
 * <p>This single class has four different reasons to change:
 * <ol>
 *   <li>Validation rules change (e.g. a new minimum amount).</li>
 *   <li>Fee rules change (e.g. the fee goes from 2% to 2.5%).</li>
 *   <li>Persistence changes (e.g. moving from a list to a database).</li>
 *   <li>Notification changes (e.g. sending SMS instead of e-mail).</li>
 * </ol>
 * Each of these is usually owned by a different person or team, so they all
 * end up editing the same file and breaking each other's work.
 */
public class PaymentService {

    private final List<String> database = new ArrayList<>();
    private final List<String> sentEmails = new ArrayList<>();

    public BigDecimal process(String payerEmail, BigDecimal amount) {
        // Responsibility 1: validation
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (payerEmail == null || !payerEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid payer e-mail");
        }

        // Responsibility 2: fee calculation
        BigDecimal fee = amount.multiply(new BigDecimal("0.02")).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal total = amount.add(fee);

        // Responsibility 3: persistence
        database.add(payerEmail + ";" + total);

        // Responsibility 4: notification
        sentEmails.add("To: " + payerEmail + " - Payment of R$ " + total + " confirmed");

        return total;
    }

    public List<String> database() {
        return List.copyOf(database);
    }

    public List<String> sentEmails() {
        return List.copyOf(sentEmails);
    }
}
