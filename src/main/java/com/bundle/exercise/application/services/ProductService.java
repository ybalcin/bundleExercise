package com.bundle.exercise.application.services;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductService implements IProductService {
    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(IProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto[] GetAll() {
        Product[] products = productRepository.GetAll();
        return modelMapper.map(products, ProductDto[].class);
    }

    @Override
    public ProductDto GetById(int id) {
        Product product = productRepository.GetById(id);
        return modelMapper.map(product, ProductDto.class);
    }
}
