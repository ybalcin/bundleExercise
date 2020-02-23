package com.bundle.exercise.unittest;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.services.ProductService;
import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ProductServiceTest {
    private ProductDto productDto = new ProductDto();
    private Product product1 = new Product();

    @Mock
    private IProductRepository productRepository;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductService productService;

    @Before
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        productDto.setId(1);
        productDto.setName("Handcrafted Steel Sausages");
        productDto.setPrice(336.00d);
        productDto.setCategory("Baby");
        productDto.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");

        when(productRepository.GetById(anyInt())).thenReturn(product1);
        when(modelMapper.map(any(), any())).thenReturn(productDto);

        ProductDto result = productService.GetById(1);
        assertEquals(1, result.getId());
        assertEquals("Handcrafted Steel Sausages", result.getName());
    }
}