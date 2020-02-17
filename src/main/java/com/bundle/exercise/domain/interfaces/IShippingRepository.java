package com.bundle.exercise.domain.interfaces;

import com.bundle.exercise.domain.models.Shipping;

public interface IShippingRepository {
    Shipping[] GetAll();
    Shipping GetBySaleId(int id);
}
