package com.bundle.exercise.unit.application.service;

import com.bundle.exercise.application.dto.ProductDto;
import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.dto.ShippingDto;
import com.bundle.exercise.application.dto.ShippingStatusDto;
import com.bundle.exercise.application.interfaces.IProductService;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.services.ShippingService;
import com.bundle.exercise.domain.interfaces.IShippingRepository;
import com.bundle.exercise.domain.models.Shipping;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ShippingServiceTest {
    @Mock
    private IShippingRepository shippingRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private IProductService productService;
    @Mock
    private ISaleService saleService;

    @InjectMocks
    private ShippingService shippingService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Shipping shipping1 = new Shipping();
        shipping1.setStatus(false);
        shipping1.setSaleId(1);
        shipping1.setCreatedAt(new Date(1579464000));
        Shipping[] expectedEntity = new Shipping[]{shipping1};

        ShippingDto shippingDto1 = new ShippingDto();
        shippingDto1.setStatus(false);
        shippingDto1.setSaleId(1);
        shippingDto1.setCreatedAt(new Date(1579464000));
        ShippingDto[] expectedDto = new ShippingDto[]{shippingDto1};

        when(shippingRepository.GetAll()).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, ShippingDto[].class)).thenReturn(expectedDto);
        ShippingDto[] shipping = shippingService.GetAll();

        assertEquals(expectedDto, shipping);
        assertEquals(expectedEntity[0].getCreatedAt(), shipping[0].getCreatedAt());
        assertEquals(expectedEntity[0].getSaleId(), shipping[0].getSaleId());
        assertEquals(expectedEntity[0].isStatus(), shipping[0].isStatus());
    }

    @Test
    void getBySaleId() {
        Shipping expectedEntity = new Shipping();
        expectedEntity.setCreatedAt(new Date(1579464000));
        expectedEntity.setSaleId(1);
        expectedEntity.setStatus(false);

        ShippingDto expectedDto = new ShippingDto();
        expectedDto.setCreatedAt(new Date(1579464000));
        expectedDto.setSaleId(1);
        expectedDto.setStatus(false);

        when(shippingRepository.GetBySaleId(1)).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, ShippingDto.class)).thenReturn(expectedDto);
        ShippingDto shipping = shippingService.GetBySaleId(1);

        assertNotNull(shipping);
        assertEquals(expectedDto, shipping);
        assertEquals(expectedEntity.getSaleId(), shipping.getSaleId());
        assertEquals(expectedEntity.getCreatedAt(), shipping.getCreatedAt());
        assertEquals(expectedEntity.isStatus(), shipping.isStatus());
    }

    @Test
    void getShippingStatus() {
        ShippingStatusDto expectedDto = new ShippingStatusDto();
        SaleDto sale = new SaleDto();
        sale.setId(3);
        sale.setSaleCode("0c784421-3cbb-4566-ab72-06628413758b");
        sale.setProductId(15);

        ProductDto product = new ProductDto();
        product.setId(15);
        product.setName("Generic Concrete Ball");
        product.setCategory("Beauty");
        product.setImage("https://s3.amazonaws.com/uifaces/faces/twitter/petar_prog/128.jpg");

        ShippingDto shipping = new ShippingDto();
        shipping.setSaleId(3);
        shipping.setStatus(false);
        shipping.setCreatedAt(new Date(1579464000));

        expectedDto.setSale(sale);
        expectedDto.setProduct(product);
        expectedDto.setStatus(shipping.isStatus() ? "TESLİM EDİLDİ" : "TESLİM EDİLMEDİ");

        when(saleService.GetById(3)).thenReturn(sale);
        when(shippingService.GetBySaleId(sale.getId())).thenReturn(shipping);
        when(productService.GetById(sale.getProductId())).thenReturn(product);
        ShippingStatusDto result = shippingService.GetShippingStatus(3);

        assertNotNull(result);
        assertEquals(expectedDto.getSale(), result.getSale());
        assertEquals(expectedDto.getProduct(), result.getProduct());
        assertEquals(expectedDto.getStatus(), result.getStatus());
    }
}