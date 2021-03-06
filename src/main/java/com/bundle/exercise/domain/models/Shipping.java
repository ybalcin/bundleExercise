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

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
