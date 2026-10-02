package com.solidpayments.isp.after;

/** Small, focused interface: only refunding. */
public interface Refundable {

    String refund(String transactionId);
}
