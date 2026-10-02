package com.solidpayments.srp.after;

import java.math.BigDecimal;

/**
 * Data only: who pays and how much. A record has a single job by nature.
 */
public record Payment(String payerEmail, BigDecimal amount) {
}
