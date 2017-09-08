package com.madfooat.payment.usecases;

import com.madfooat.payment.PaymentValidator;
import com.madfooat.payment.model.MadfooatViolation;
import com.madfooat.payment.model.Payment;
import com.madfooat.payment.repository.PaymentRepository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

public class ValidateBusinessRules implements PaymentValidator {

    private PaymentRepository paymentRepository;

    public ValidateBusinessRules(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<MadfooatViolation> validate(Payment payment) {
        return paymentRepository.isExists(payment) ? Collections.singletonList(new MadfooatViolation("C-002", "Payment with same reference exists")) : Collections.emptyList();
    }



}
