package com.madfooat.payment;

import com.madfooat.payment.model.MadfooatViolation;
import com.madfooat.payment.model.Payment;

import java.util.List;

public interface PaymentValidator {
    List<MadfooatViolation> validate(Payment payment);
}
