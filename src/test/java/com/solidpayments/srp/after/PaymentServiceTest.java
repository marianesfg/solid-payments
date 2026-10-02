package com.solidpayments.srp.after;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentServiceTest {

    @Test
    @DisplayName("AFTER: the fee rule can be tested alone, with no side effects")
    void feeIsTestedInIsolation() {
        FeeCalculator calculator = new FeeCalculator();

        assertEquals(new BigDecimal("102.00"), calculator.totalWithFee(new BigDecimal("100.00")));
    }

    @Test
    @DisplayName("AFTER: validation can be tested alone")
    void validationIsTestedInIsolation() {
        PaymentValidator validator = new PaymentValidator();

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(new Payment("invalid-email", BigDecimal.TEN)));
    }

    @Test
    @DisplayName("AFTER: the service only orchestrates the collaborators")
    void serviceOrchestratesTheFlow() {
        PaymentRepository repository = new PaymentRepository();
        PaymentNotifier notifier = new PaymentNotifier();
        PaymentService service = new PaymentService(
                new PaymentValidator(), new FeeCalculator(), repository, notifier);

        BigDecimal total = service.process(new Payment("mari@email.com", new BigDecimal("100.00")));

        assertEquals(new BigDecimal("102.00"), total);
        assertEquals(1, repository.findAll().size());
        assertEquals(1, notifier.sentMessages().size());
    }
}
