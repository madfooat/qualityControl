package com.madfooat.payment.repository;

import com.madfooat.payment.model.Payment;

public interface PaymentRepository {

    boolean isExists(Payment payment);

}
