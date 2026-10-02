package com.solidpayments.lsp.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RefundServiceTest {

    private final RefundService refundService = new RefundService();

    @Test
    @DisplayName("BEFORE: card and Pix can replace PaymentMethod safely")
    void cardAndPixWork() {
        assertEquals("Card refund done for TX-1", refundService.refund(new CreditCardPayment(), "TX-1"));
        assertEquals("Pix refund (MED) done for TX-2", refundService.refund(new PixPayment(), "TX-2"));
    }

    @Test
    @DisplayName("BEFORE: boleto compiles as a PaymentMethod but crashes at runtime")
    void boletoBreaksTheContract() {
        PaymentMethod method = new BoletoPayment(); // compiler says this is fine...

        assertThrows(UnsupportedOperationException.class,
                () -> refundService.refund(method, "TX-3")); // ...but it explodes here
    }
}
