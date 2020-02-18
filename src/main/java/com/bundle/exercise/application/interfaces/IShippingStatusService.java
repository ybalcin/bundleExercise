package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.ResponseDto;

public interface IShippingStatusService {
    ResponseDto GetShippingInformation(int saleId);
}
