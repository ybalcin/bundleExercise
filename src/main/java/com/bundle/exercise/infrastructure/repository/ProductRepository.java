package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProductRepository implements IProductRepository {
    private final String url;
    private final RestTemplate _restTemplate;
    private final Environment _env;

    @Autowired
    public ProductRepository(RestTemplate restTemplate, Environment env) {
        this._env = env;
        this._restTemplate = restTemplate;
        this.url = String.format("%s/products/", _env.getProperty("app.resourceUrl"));
    }

    @Override
    public Product[] GetAll(){
        return _restTemplate.getForObject(url, Product[].class);
    }

    @Override
    public Product GetById(int id){
        return _restTemplate.getForObject(url + id, Product.class);
    }
}