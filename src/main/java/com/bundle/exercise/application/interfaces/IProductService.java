package com.bundle.exercise.application.interfaces;

import com.bundle.exercise.domain.models.Product;

public interface IProductService {
    Product[] GetAll();
    Product GetById(int id);
}
