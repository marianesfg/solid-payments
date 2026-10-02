package com.solidpayments.srp.after;

import java.math.BigDecimal;

/**
 * FOLLOWS SRP.
 *
 * <p>The service now only coordinates the flow. Each step is delegated to a
 * class with a single responsibility. Changing the fee rule touches only
 * {@link FeeCalculator}; changing the notification touches only
 * {@link PaymentNotifier}, and so on.
 */
public class PaymentService {

    private final PaymentValidator validator;
    private final FeeCalculator feeCalculator;
    private final PaymentRepository repository;
    private final PaymentNotifier notifier;

    public PaymentService(PaymentValidator validator,
                          FeeCalculator feeCalculator,
                          PaymentRepository repository,
                          PaymentNotifier notifier) {
        this.validator = validator;
        this.feeCalculator = feeCalculator;
        this.repository = repository;
        this.notifier = notifier;
    }

    public BigDecimal process(Payment payment) {
        validator.validate(payment);
        BigDecimal total = feeCalculator.totalWithFee(payment.amount());
        repository.save(payment, total);
        notifier.notifyConfirmed(payment, total);
        return total;
    }
}
