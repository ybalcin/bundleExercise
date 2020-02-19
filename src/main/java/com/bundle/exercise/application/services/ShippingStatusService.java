package com.bundle.exercise.application.services;

import com.bundle.exercise.application.dto.*;
import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingStatusService;
import com.bundle.exercise.application.interfaces.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShippingStatusService implements IShippingStatusService {
    private final IProductService productService;
    private final IShippingService shippingService;
    private final ISaleService saleService;

    @Autowired
    public ShippingStatusService
            (IProductService productService, IShippingService shippingService, ISaleService saleService) {
        this.productService = productService;
        this.shippingService = shippingService;
        this.saleService = saleService;
    }

    @Override
    public ShippingStatusDto GetShippingInformation(int saleId) {
        ShippingStatusDto statusDto = new ShippingStatusDto();

        SaleDto sale = saleService.GetById(saleId);
        ShippingDto shipping = shippingService.GetBySaleId(sale.getId());
        ProductDto product = productService.GetById(sale.getProductId());

        statusDto.setProduct(product);
        statusDto.setSale(sale);
        statusDto.setStatus(shipping.isStatus() ? "TESLİM EDİLDİ" : "TESLİM EDİLMEDİ");

        return statusDto;
    }
}
