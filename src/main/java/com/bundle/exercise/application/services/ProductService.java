package com.bundle.exercise.application.services;

import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product[] GetAll() {
        Product[] products = productRepository.GetAll();
        return products;
    }

    @Override
    public Product GetById(int id) {
        Product product = productRepository.GetById(id);
        return product;
    }
}
