package com.bundle.exercise.domain.models;

import java.sql.Date;

public class Shipping {
    private int saleId;
    private boolean status;
    private Date createdAt;

    public int getSaleId() {
        return saleId;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
