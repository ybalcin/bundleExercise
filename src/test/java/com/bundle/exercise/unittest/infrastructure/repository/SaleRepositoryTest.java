package com.bundle.exercise.unittest.infrastructure.repository;

import com.bundle.exercise.domain.models.Sale;
import com.bundle.exercise.infrastructure.repository.SaleRepository;
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
class SaleRepositoryTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment env;

    @InjectMocks
    private SaleRepository saleRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Sale[] expected = new Sale[]{new Sale(), new Sale()};

        when(saleRepository.GetAll()).thenReturn(expected);
        Sale[] sales = saleRepository.GetAll();

        assertEquals(expected, sales);
        assertNotNull(sales);
    }

    @Test
    void getById() {
        Sale expected = new Sale();
        expected.setId(1);
        expected.setSaleCode("a8a2700a-eb48-4265-b74a-f89da5ef0a14");
        expected.setProductId(79);

        when(saleRepository.GetById(1)).thenReturn(expected);
        Sale sale = saleRepository.GetById(1);

        assertEquals(expected, sale);
        assertNotNull(sale);
    }
}