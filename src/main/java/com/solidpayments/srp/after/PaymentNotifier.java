package com.solidpayments.srp.after;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Only reason to change: how the payer is notified.
 */
public class PaymentNotifier {

    private final List<String> sentMessages = new ArrayList<>();

    public void notifyConfirmed(Payment payment, BigDecimal total) {
        sentMessages.add("To: " + payment.payerEmail() + " - Payment of R$ " + total + " confirmed");
    }

    public List<String> sentMessages() {
        return List.copyOf(sentMessages);
    }
}
