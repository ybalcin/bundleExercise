package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.ShippingDto;

public interface IShippingService {
    ShippingDto[] GetAll();
    ShippingDto GetBySaleId(int id);
}
