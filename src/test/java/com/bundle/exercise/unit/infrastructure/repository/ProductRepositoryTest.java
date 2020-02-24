package com.bundle.exercise.unit.infrastructure.repository;

import com.bundle.exercise.domain.models.Product;
import com.bundle.exercise.infrastructure.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductRepositoryTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment env;

    @InjectMocks
    private ProductRepository productRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Product[] expected = new Product[]{new Product(), new Product()};

        when(productRepository.GetAll()).thenReturn(expected);
        Product[] products = productRepository.GetAll();

        assertEquals(expected, products);
        assertNotNull(products);
    }

    @Test
    void getById() {
        Product expected = new Product();
        expected.setId(1);
        expected.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/id835559/128.jpg");
        expected.setCategory("Baby");
        expected.setPrice(336.00d);
        expected.setName("Handcrafted Steel Sausages");

        when(productRepository.GetById(1)).thenReturn(expected);
        Product product = productRepository.GetById(1);

        assertEquals(expected, product);
        assertNotNull(product);
    }
}