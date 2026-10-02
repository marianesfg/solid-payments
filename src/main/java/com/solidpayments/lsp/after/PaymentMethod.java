package com.solidpayments.lsp.after;

import java.math.BigDecimal;

/**
 * The base contract now promises only what EVERY payment method can really do.
 */
public interface PaymentMethod {

    String pay(BigDecimal amount);
}
