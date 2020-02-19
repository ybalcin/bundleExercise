package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.ShippingStatusDto;

public interface IShippingStatusService {
    ShippingStatusDto GetShippingInformation(int saleId);
}
