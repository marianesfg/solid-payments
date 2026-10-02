package com.solidpayments.lsp.after;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RefundServiceTest {

    @Test
    @DisplayName("AFTER: every RefundablePaymentMethod can really refund")
    void allRefundablesWork() {
        RefundService refundService = new RefundService();

        assertEquals("Card refund done for TX-1", refundService.refund(new CreditCardPayment(), "TX-1"));
        assertEquals("Pix refund (MED) done for TX-2", refundService.refund(new PixPayment(), "TX-2"));
        // refundService.refund(new BoletoPayment(), "TX-3"); // <- does not compile. Try uncommenting it!
    }

    @Test
    @DisplayName("AFTER: every PaymentMethod, including boleto, can pay with no surprises")
    void allPaymentMethodsCanPay() {
        List<PaymentMethod> methods = List.of(new CreditCardPayment(), new PixPayment(), new BoletoPayment());

        methods.forEach(method -> assertFalse(method.pay(new BigDecimal("50.00")).isBlank()));
    }
}
