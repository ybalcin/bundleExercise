package com.bundle.exercise;

import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.domain.models.Product;
import com.bundle.exercise.domain.models.Sale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTests {

    @Autowired
    private IProductService productService;
    @Autowired
    private ISaleService saleService;

    @Test
    void contextLoads() {
        Product product = productService.GetById(1);
        Product[] products = productService.GetAll();

        Sale[] sales = saleService.GetAll();
        Sale sale = saleService.GetById(15);
    }

}
