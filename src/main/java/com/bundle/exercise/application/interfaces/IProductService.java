package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.application.dto.ProductDto;

public interface IProductService {
    ProductDto[] GetAll();
    ProductDto GetById(int id);
}
