package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.IShippingRepository;
import com.bundle.exercise.domain.models.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShippingRepository implements IShippingRepository {
    private final RestTemplate restTemplate;
    private final String url;

    @Autowired
    public ShippingRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = "http://5e209e06e31c6e0014c60962.mockapi.io/api/shipping/";
    }

    @Override
    public Shipping[] GetAll() {
        return restTemplate.getForObject(url, Shipping[].class);
    }

    @Override
    public Shipping GetBySaleId(int id) {
        return restTemplate.getForObject(url + id, Shipping.class);
    }
}