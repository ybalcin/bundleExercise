package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.IShippingRepository;
import com.bundle.exercise.domain.models.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShippingRepository implements IShippingRepository {
    private final RestTemplate _restTemplate;
    private final String _url;
    private final Environment _env;

    @Autowired
    public ShippingRepository(RestTemplate restTemplate, Environment env) {
        this._env = env;
        this._restTemplate = restTemplate;
        this._url = String.format("%s/shipping/", _env.getProperty("app.resourceUrl"));
    }

    @Override
    public Shipping[] GetAll() {
        return _restTemplate.getForObject(_url, Shipping[].class);
    }

    @Override
    public Shipping GetBySaleId(int id) {
        return _restTemplate.getForObject(_url + id, Shipping.class);
    }
}
