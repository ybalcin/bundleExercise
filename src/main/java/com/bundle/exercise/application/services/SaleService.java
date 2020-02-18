package com.bundle.exercise.application.services;

import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.domain.interfaces.ISaleRepository;
import com.bundle.exercise.domain.models.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SaleService implements ISaleService {
    private final ISaleRepository saleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleService(ISaleRepository saleRepository, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SaleDto[] GetAll() {
        Sale[] sales = saleRepository.GetAll();
        return modelMapper.map(sales, SaleDto[].class);
    }

    @Override
    public SaleDto GetById(int id) {
        Sale sale = saleRepository.GetById(id);
        return modelMapper.map(sale, SaleDto.class);
    }
}
