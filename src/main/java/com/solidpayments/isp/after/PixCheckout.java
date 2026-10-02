package com.solidpayments.isp.after;

import java.math.BigDecimal;

/**
 * A client that needs ONLY a QR code. It depends on the tiny
 * {@link PixQrCodeGenerator} interface, not on a whole gateway, so changes to
 * refunds or boletos can never affect it.
 */
public class PixCheckout {

    private final PixQrCodeGenerator qrCodeGenerator;

    public PixCheckout(PixQrCodeGenerator qrCodeGenerator) {
        this.qrCodeGenerator = qrCodeGenerator;
    }

    public String startCheckout(BigDecimal amount) {
        return qrCodeGenerator.generatePixQrCode(amount);
    }
}
