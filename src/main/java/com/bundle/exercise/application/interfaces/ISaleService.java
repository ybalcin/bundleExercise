package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.SaleDto;

public interface ISaleService {
    SaleDto[] GetAll();
    SaleDto GetById(int id);
}
