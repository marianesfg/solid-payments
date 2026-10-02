package com.solidpayments.dip.after;

import com.solidpayments.dip.after.infrastructure.InMemoryPaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutServiceTest {

    @Test
    @DisplayName("AFTER: we inject in-memory implementations and test the business rule alone")
    void businessRuleIsTestable() {
        InMemoryPaymentRepository repository = new InMemoryPaymentRepository();
        List<String> sentMessages = new ArrayList<>();
        NotificationSender fakeSender = (to, message) -> sentMessages.add(to + " | " + message);

        CheckoutService service = new CheckoutService(repository, fakeSender);
        service.checkout("ORDER-1", "mari@email.com", new BigDecimal("80.00"));

        assertEquals(new BigDecimal("80.00"), repository.findByOrderId("ORDER-1").orElseThrow());
        assertEquals(List.of("mari@email.com | Order ORDER-1 paid: R$ 80.00"), sentMessages);
    }
}
