package com.solidpayments.srp.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentServiceTest {

    @Test
    @DisplayName("BEFORE: to test only the fee rule we must run validation, persistence and e-mail too")
    void feeCannotBeTestedInIsolation() {
        PaymentService service = new PaymentService();

        BigDecimal total = service.process("mari@email.com", new BigDecimal("100.00"));

        assertEquals(new BigDecimal("102.00"), total);
        // Side effects we did not care about, but could not avoid:
        assertEquals(1, service.database().size());
        assertEquals(1, service.sentEmails().size());
    }
}
