package com.solidpayments.isp.after;

import java.math.BigDecimal;

/** Small, focused interface: only Pix QR codes. */
public interface PixQrCodeGenerator {

    String generatePixQrCode(BigDecimal amount);
}
