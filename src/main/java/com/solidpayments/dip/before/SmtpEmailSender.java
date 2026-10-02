package com.solidpayments.dip.before;

/**
 * Low-level detail: sends real e-mails through an SMTP server.
 */
public class SmtpEmailSender {

    public void send(String to, String message) {
        throw new IllegalStateException("Could not connect to SMTP server");
    }
}
