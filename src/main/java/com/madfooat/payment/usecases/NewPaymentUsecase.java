package com.madfooat.payment.usecases;

import com.madfooat.payment.model.MadfooatViolation;
import com.madfooat.payment.model.Payment;
import com.madfooat.payment.repository.PaymentRepository;

import java.util.List;

public class NewPaymentUsecase {

    PaymentRepository paymentRepository;

    public List<MadfooatViolation> validateAndStore(Payment payment) {
        List<MadfooatViolation> violations = new ValidateTechnical().validate(payment);

        if (violations.isEmpty())
            violations.addAll(new ValidateBusinessRules(paymentRepository).validate(payment));

        return violations;

    }


}
