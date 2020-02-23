package com.bundle.exercise.unittest.infrastructure.repository;

import com.bundle.exercise.domain.models.Shipping;
import com.bundle.exercise.infrastructure.repository.ShippingRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ShippingRepositoryTest {
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Environment env;

    @InjectMocks
    private ShippingRepository shippingRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Shipping[] expected = new Shipping[]{new Shipping(), new Shipping()};

        when(shippingRepository.GetAll()).thenReturn(expected);
        Shipping[] shipping = shippingRepository.GetAll();

        assertEquals(expected, shipping);
        assertNotNull(shipping);
    }

    @Test
    void getBySaleId() {
        Shipping expected = new Shipping();
        expected.setCreatedAt(new Date(System.currentTimeMillis()));
        expected.setSaleId(1);
        expected.setStatus(true);

        when(shippingRepository.GetBySaleId(1)).thenReturn(expected);
        Shipping shipping = shippingRepository.GetBySaleId(1);

        assertEquals(expected, shipping);
        assertNotNull(shipping);
    }
}