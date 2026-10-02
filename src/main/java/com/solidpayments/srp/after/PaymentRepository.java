package com.solidpayments.srp.after;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Only reason to change: how payments are stored.
 *
 * <p>Note: this is a concrete class on purpose, to keep the SRP example focused.
 * Depending on abstractions instead of concrete classes is the subject of DIP.
 */
public class PaymentRepository {

    private final List<String> records = new ArrayList<>();

    public void save(Payment payment, BigDecimal total) {
        records.add(payment.payerEmail() + ";" + total);
    }

    public List<String> findAll() {
        return List.copyOf(records);
    }
}
