package com.solidpayments.isp.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentGatewayTest {

    @Test
    @DisplayName("BEFORE: the fat interface exposes methods that only throw exceptions")
    void fatInterfaceHasUselessMethods() {
        PaymentGateway boletoGateway = new BoletoGateway();
        PaymentGateway pixGateway = new PixGateway();

        assertThrows(UnsupportedOperationException.class, () -> boletoGateway.charge(BigDecimal.TEN));
        assertThrows(UnsupportedOperationException.class, () -> boletoGateway.refund("TX-1"));
        assertThrows(UnsupportedOperationException.class, () -> boletoGateway.generatePixQrCode(BigDecimal.TEN));
        assertThrows(UnsupportedOperationException.class, () -> pixGateway.issueBoleto(BigDecimal.TEN, "2026-10-30"));
    }
}
