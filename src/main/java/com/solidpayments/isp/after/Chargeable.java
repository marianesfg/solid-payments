package com.solidpayments.isp.after;

import java.math.BigDecimal;

/** Small, focused interface: only charging. */
public interface Chargeable {

    String charge(BigDecimal amount);
}
