package com.solidpayments.isp.after;

import java.math.BigDecimal;

/**
 * FOLLOWS ISP: no more methods that only throw exceptions.
 */
public class BoletoGateway implements BoletoIssuer {

    @Override
    public String issueBoleto(BigDecimal amount, String dueDate) {
        return "34191.79001 01043.510047 ... R$ " + amount + " due " + dueDate;
    }
}
