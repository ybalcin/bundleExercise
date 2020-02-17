package com.bundle.exercise.domain.interfaces;

import com.bundle.exercise.domain.models.Sale;

public interface ISaleRepository {
    Sale[] GetAll();
    Sale GetById(int id);
}
