package com.bundle.exercise.app;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.dto.ShippingDto;
import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingService;
import com.bundle.exercise.domain.models.Product;
import com.bundle.exercise.infrastructure.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExerciseApplicationTests {

    @Autowired
    private IProductService productService;
    @Autowired
    private ISaleService saleService;
    @Autowired
    private IShippingService shippingService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
/*        ProductDto product = productService.GetById(55);
        ProductDto[] products = productService.GetAll();

        SaleDto[] sales = saleService.GetAll();
        SaleDto sale = saleService.GetById(15);

        ShippingDto shipping = shippingService.GetBySaleId(5);*/

        //ProductDto productDto = productService.GetById(4);
    }

}
