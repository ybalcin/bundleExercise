package com.bundle.exercise.domain.interfaces;

import com.bundle.exercise.domain.models.Product;

public interface IProductRepository {
    Product[] GetAll();
    Product GetById(int id);
}
