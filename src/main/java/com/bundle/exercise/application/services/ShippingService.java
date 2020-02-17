package com.bundle.exercise.application.services;

import com.bundle.exercise.application.interfaces.IShippingService;
import com.bundle.exercise.domain.interfaces.IShippingRepository;
import com.bundle.exercise.domain.models.Shipping;
import org.springframework.beans.factory.annotation.Autowired;

public class ShippingService implements IShippingService {
    private final IShippingRepository shippingRepository;

    @Autowired
    public ShippingService(IShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    public Shipping[] GetAll() {
        return new Shipping[0];
    }

    @Override
    public Shipping GetById(int id) {
        return null;
    }
}
