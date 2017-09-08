package com.madfooat.payment.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class Payment {

    @NotNull(message = "Reference cannot be null")
    private String reference;

    private Date dueDate;

    @DecimalMin(value = "0.001", message = "Minimum amount should be 0.001")
    private BigDecimal amount;

    public Payment(String reference, Date dueDate, BigDecimal amount) {
        this.reference = reference;
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
