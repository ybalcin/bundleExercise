package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductRepository implements IProductRepository {
    private final String url;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductRepository(RestTemplate restTemplate) {
        this.url = "http://5e209e06e31c6e0014c60962.mockapi.io/api/products/";
        this.restTemplate = restTemplate;
    }

    @Override
    public Product[] GetAll(){

        return restTemplate.getForObject(url, Product[].class);
    }

    @Override
    public Product GetById(int id){

        return restTemplate.getForObject(url + id, Product.class);
    }
}