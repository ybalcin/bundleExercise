package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.ISaleRepository;
import com.bundle.exercise.domain.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SaleRepository implements ISaleRepository {
    private final RestTemplate restTemplate;
    private final String url;

    @Autowired
    public SaleRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "http://5e209e06e31c6e0014c60962.mockapi.io/api/sales/";
    }

    @Override
    public Sale[] GetAll() {
        return restTemplate.getForObject(url, Sale[].class);
    }

    @Override
    public Sale GetById(int id) {
        return restTemplate.getForObject(url + id, Sale.class);
    }
}
