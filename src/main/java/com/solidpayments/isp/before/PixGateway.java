package com.solidpayments.isp.before;

import java.math.BigDecimal;

/**
 * Forced to implement {@link #issueBoleto}, which has nothing to do with Pix.
 */
public class PixGateway implements PaymentGateway {

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

    @Override
    public String issueBoleto(BigDecimal amount, String dueDate) {
        throw new UnsupportedOperationException("Pix gateway does not issue boletos");
    }
}
