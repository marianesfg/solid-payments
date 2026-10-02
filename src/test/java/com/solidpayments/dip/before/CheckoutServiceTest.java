package com.solidpayments.dip.before;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckoutServiceTest {

    @Test
    @DisplayName("BEFORE: impossible to unit test - the service insists on a real database")
    void cannotTestWithoutRealInfrastructure() {
        CheckoutService service = new CheckoutService();

        assertThrows(IllegalStateException.class,
                () -> service.checkout("ORDER-1", "mari@email.com", new BigDecimal("80.00")));
    }
}
