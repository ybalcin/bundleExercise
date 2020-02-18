package com.bundle.exercise.application.services;

import com.bundle.exercise.application.dto.ShippingDto;
import com.bundle.exercise.application.interfaces.IShippingService;
import com.bundle.exercise.domain.interfaces.IShippingRepository;
import com.bundle.exercise.domain.models.Shipping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShippingService implements IShippingService {
    private final IShippingRepository shippingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ShippingService(IShippingRepository shippingRepository, ModelMapper modelMapper) {
        this.shippingRepository = shippingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ShippingDto[] GetAll() {
        Shipping[] shipping = shippingRepository.GetAll();
        return modelMapper.map(shipping, ShippingDto[].class);
    }

    @Override
    public ShippingDto GetBySaleId(int id) {
        Shipping shipping = shippingRepository.GetBySaleId(id);
        return modelMapper.map(shipping, ShippingDto.class);
    }
}
