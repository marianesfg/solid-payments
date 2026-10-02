package com.solidpayments.isp.after;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PixCheckoutTest {

    @Test
    @DisplayName("AFTER: the client depends only on what it uses, so a one-line fake is enough")
    void clientNeedsOnlyTheSmallInterface() {
        PixQrCodeGenerator fakeGenerator = amount -> "FAKE-QR-" + amount;
        PixCheckout checkout = new PixCheckout(fakeGenerator);

        assertEquals("FAKE-QR-10", checkout.startCheckout(BigDecimal.TEN));
    }

    @Test
    @DisplayName("AFTER: the real Pix gateway also fits, because it implements the small interface")
    void realGatewayFits() {
        PixCheckout checkout = new PixCheckout(new PixGateway());

        assertTrue(checkout.startCheckout(BigDecimal.TEN).contains("PIX-QR"));
    }

    @Test
    @DisplayName("AFTER: boleto gateway has only the method it really supports")
    void boletoGatewayIsFocused() {
        BoletoIssuer issuer = new BoletoGateway();

        assertTrue(issuer.issueBoleto(BigDecimal.TEN, "2026-10-30").contains("due 2026-10-30"));
    }
}
