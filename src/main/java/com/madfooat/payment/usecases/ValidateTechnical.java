package com.madfooat.payment.usecases;

import com.madfooat.payment.PaymentValidator;
import com.madfooat.payment.model.MadfooatViolation;
import com.madfooat.payment.model.Payment;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateTechnical implements PaymentValidator {


    private Validator validator;

    public ValidateTechnical() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Override
    public List<MadfooatViolation> validate(Payment payment) {
        Set<ConstraintViolation<Payment>> violations = new HashSet<>();
        violations.addAll(validator.validate(payment));
        return convertToMadfooatViolations(violations);
    }

    private List<MadfooatViolation> convertToMadfooatViolations(Set<ConstraintViolation<Payment>> violations) {
        return violations.stream().map(v -> new MadfooatViolation("C-001", v.getMessage())).collect(Collectors.toList());
    }
}
