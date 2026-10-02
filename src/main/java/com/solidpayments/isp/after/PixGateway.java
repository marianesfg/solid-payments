package com.solidpayments.isp.after;

import java.math.BigDecimal;

/**
 * FOLLOWS ISP: implements only the capabilities Pix really has.
 */
public class PixGateway implements Chargeable, Refundable, PixQrCodeGenerator {

    @Override
    public String charge(BigDecimal amount) {
        return "PIX-CHARGE-" + amount;
    }

    @Override
    public String refund(String transactionId) {
        return "PIX-REFUND-" + transactionId;
    }

    @Override
    public String generatePixQrCode(BigDecimal amount) {
        return "00020126...PIX-QR-" + amount;
    }
}
