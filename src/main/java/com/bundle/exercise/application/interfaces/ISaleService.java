package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.domain.models.Sale;

public interface ISaleService {
    Sale[] GetAll();
    Sale GetById(int id);
}
