package com.solidpayments.isp.before;

import java.math.BigDecimal;

/**
 * Forced to implement three methods it cannot support.
 */
public class BoletoGateway implements PaymentGateway {

    @Override
    public String charge(BigDecimal amount) {
        throw new UnsupportedOperationException("Use issueBoleto instead");
    }

    @Override
    public String refund(String transactionId) {
        throw new UnsupportedOperationException("Boleto cannot be refunded automatically");
    }

    @Override
    public String generatePixQrCode(BigDecimal amount) {
        throw new UnsupportedOperationException("Boleto gateway does not generate Pix QR codes");
    }

    @Override
    public String issueBoleto(BigDecimal amount, String dueDate) {
        return "34191.79001 01043.510047 ... R$ " + amount + " due " + dueDate;
    }
}
