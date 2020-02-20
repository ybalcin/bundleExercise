package com.bundle.exercise.infrastructure.repository;

import com.bundle.exercise.domain.interfaces.ISaleRepository;
import com.bundle.exercise.domain.models.Sale;
import com.bundle.exercise.infrastructure.crossCutting.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SaleRepository implements ISaleRepository {
    private final RestTemplate _restTemplate;
    private final String _url;
    private final Environment _env;

    @Autowired
    public SaleRepository(RestTemplate restTemplate, Environment env) {
        this._env = env;
        this._restTemplate = restTemplate;
        this._url = String.format("%s/sales/", _env.getProperty("app.resourceUrl"));
    }

    @Override
    public Sale[] GetAll() {
        return _restTemplate.getForObject(_url, Sale[].class);
    }

    @Override
    public Sale GetById(int id) {
        Sale sale = _restTemplate.getForObject(_url + id, Sale.class);
        return sale;
    }
}
