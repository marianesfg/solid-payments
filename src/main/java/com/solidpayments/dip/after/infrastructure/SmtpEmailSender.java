package com.solidpayments.dip.after.infrastructure;

import com.solidpayments.dip.after.NotificationSender;

public class SmtpEmailSender implements NotificationSender {

    @Override
    public void send(String to, String message) {
        throw new IllegalStateException("Could not connect to SMTP server");
    }
}
