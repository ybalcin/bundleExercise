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
    public ResponseDto GetShippingInformation(int saleId) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResponseStatus(true);
        responseDto.setMessage("success");
        responseDto.setData(null);

        ShippingDto shipping = new ShippingDto();
        ProductDto product = new ProductDto();

        SaleDto sale = null;
        try {
            sale = saleService.GetById(saleId);
            if (sale == null) {
                responseDto.setMessage("Satış bulunamadı.");
            } else {
                shipping = shippingService.GetBySaleId(sale.getId());
                if (shipping == null) {
                    responseDto.setMessage("Kargo durumu bulunamadı.");
                    return responseDto;
                }

                product = productService.GetById(sale.getProductId());
                if (product == null){
                    responseDto.setMessage("Ürün bulunamadı.");
                    return responseDto;
                }
            }
        } catch (Exception e) {
            responseDto.setMessage(e.getMessage());
            responseDto.setResponseStatus(false);
            return responseDto;
        }
        ShippingStatusDto statusDto = new ShippingStatusDto();
        statusDto.setProduct(product);
        statusDto.setSale(sale);
        statusDto.setStatus(shipping.isStatus() ? "TESLİM EDİLDİ" : "TESLİM EDİLMEDİ");
        responseDto.setData(statusDto);

        return responseDto;
    }
}
