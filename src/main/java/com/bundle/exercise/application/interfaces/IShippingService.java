package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.ShippingDto;
import com.bundle.exercise.application.dto.ShippingStatusDto;

public interface IShippingService {
    ShippingDto[] GetAll();
    ShippingDto GetBySaleId(int id);
    ShippingStatusDto GetShippingStatus(int saleId);
}
