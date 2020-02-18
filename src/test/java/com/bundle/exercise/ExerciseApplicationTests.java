package com.bundle.exercise;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingStatusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTests {

    @Autowired
    private IProductService productService;
    @Autowired
    private ISaleService saleService;
    @Autowired
    private IShippingStatusService shippingStatusService;

    @Test
    void contextLoads() {
        ProductDto product = productService.GetById(1);
        ProductDto[] products = productService.GetAll();

        SaleDto[] sales = saleService.GetAll();
        SaleDto sale = saleService.GetById(15);

        //ShippingStatusDto statusDto = shippingStatusService.GetShippingInformation(30);
    }

}
