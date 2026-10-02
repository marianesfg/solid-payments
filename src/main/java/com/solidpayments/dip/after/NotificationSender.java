package com.solidpayments.dip.after;

/**
 * Abstraction OWNED by the business layer. E-mail, SMS or push are details.
 */
public interface NotificationSender {

    void send(String to, String message);
}
