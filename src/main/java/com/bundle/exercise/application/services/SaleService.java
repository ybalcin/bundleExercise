package com.bundle.exercise.application.services;

import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.domain.interfaces.ISaleRepository;
import com.bundle.exercise.domain.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;

    @Autowired
    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale[] GetAll() {
        Sale[] sales = saleRepository.GetAll();
        return sales;
    }

    @Override
    public Sale GetById(int id) {
        Sale sale = saleRepository.GetById(id);
        return sale;
    }
}
