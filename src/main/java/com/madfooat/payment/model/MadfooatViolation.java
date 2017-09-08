package com.madfooat.payment.model;

public class MadfooatViolation {

    private String errorCode;
    private String errorDescription;

    public MadfooatViolation(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
