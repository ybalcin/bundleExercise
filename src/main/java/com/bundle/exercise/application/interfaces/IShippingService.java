package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.domain.models.Shipping;

public interface IShippingService {
    Shipping[] GetAll();
    Shipping GetById(int id);
}
