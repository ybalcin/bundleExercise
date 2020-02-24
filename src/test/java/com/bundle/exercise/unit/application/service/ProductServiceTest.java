package com.bundle.exercise.unit.application.service;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.services.ProductService;
import com.bundle.exercise.domain.interfaces.IProductRepository;
import com.bundle.exercise.domain.models.Product;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {
    @Mock
    private IProductRepository productRepository;
    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Handcrafted Steel Sausages");
        product1.setPrice(336.00d);
        product1.setCategory("Baby");
        product1.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");
        Product[] expectedEntity = new Product[]{product1};

        ProductDto productDto1 = new ProductDto();
        productDto1.setId(1);
        productDto1.setName("Handcrafted Steel Sausages");
        productDto1.setPrice(336.00d);
        productDto1.setCategory("Baby");
        productDto1.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");
        ProductDto[] expectedDto = new ProductDto[]{productDto1};

        when(productRepository.GetAll()).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, ProductDto[].class)).thenReturn(expectedDto);
        ProductDto[] products = productService.GetAll();

        assertNotNull(products);
        assertEquals(expectedDto, products);
        assertEquals(expectedEntity[0].getId(), products[0].getId());
        assertEquals(expectedEntity[0].getName(), products[0].getName());
        assertEquals(expectedEntity[0].getPrice(), products[0].getPrice());
        assertEquals(expectedEntity[0].getCategory(), products[0].getCategory());
        assertEquals(expectedEntity[0].getImage(), products[0].getImage());
    }

    @Test
    void getById() {
        Product expectedEntity = new Product();
        expectedEntity.setId(1);
        expectedEntity.setName("Handcrafted Steel Sausages");
        expectedEntity.setPrice(336.00d);
        expectedEntity.setCategory("Baby");
        expectedEntity.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");

        ProductDto expectedDto = new ProductDto();
        expectedDto.setId(1);
        expectedDto.setName("Handcrafted Steel Sausages");
        expectedDto.setPrice(336.00d);
        expectedDto.setCategory("Baby");
        expectedDto.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");

        when(productRepository.GetById(1)).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, ProductDto.class)).thenReturn(expectedDto);
        ProductDto product = productService.GetById(1);

        assertNotNull(product);
        assertEquals(expectedDto, product);
        assertEquals(expectedEntity.getImage(), product.getImage());
        assertEquals(expectedEntity.getCategory(), product.getCategory());
        assertEquals(expectedEntity.getPrice(), product.getPrice());
        assertEquals(expectedEntity.getName(), product.getName());
        assertEquals(expectedEntity.getId(), product.getId());
    }
}