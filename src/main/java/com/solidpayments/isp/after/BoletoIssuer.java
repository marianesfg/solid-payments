package com.solidpayments.isp.after;

import java.math.BigDecimal;

/** Small, focused interface: only boleto issuing. */
public interface BoletoIssuer {

    String issueBoleto(BigDecimal amount, String dueDate);
}
