package com.bundle.exercise.unit.application.service;

import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.services.SaleService;
import com.bundle.exercise.domain.interfaces.ISaleRepository;
import com.bundle.exercise.domain.models.Sale;
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
class SaleServiceTest {
    @Mock
    private ISaleRepository saleRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private SaleService saleService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAll() {
        Sale sale1 = new Sale();
        sale1.setProductId(79);
        sale1.setSaleCode("a8a2700a-eb48-4265-b74a-f89da5ef0a14");
        sale1.setId(1);
        Sale[] expectedEntity = new Sale[]{sale1};

        SaleDto saleDto1 = new SaleDto();
        saleDto1.setProductId(79);
        saleDto1.setSaleCode("a8a2700a-eb48-4265-b74a-f89da5ef0a14");
        saleDto1.setId(1);
        SaleDto[] expectedDto = new SaleDto[]{saleDto1};

        when(saleRepository.GetAll()).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, SaleDto[].class)).thenReturn(expectedDto);
        SaleDto[] sales = saleService.GetAll();

        assertNotNull(sales);
        assertEquals(expectedDto, sales);
        assertEquals(expectedEntity[0].getId(), sales[0].getId());
        assertEquals(expectedEntity[0].getProductId(), sales[0].getProductId());
        assertEquals(expectedEntity[0].getSaleCode(), sales[0].getSaleCode());
    }

    @Test
    void getById() {
        Sale expectedEntity = new Sale();
        expectedEntity.setId(1);
        expectedEntity.setProductId(79);
        expectedEntity.setSaleCode("a8a2700a-eb48-4265-b74a-f89da5ef0a14");

        SaleDto expectedDto = new SaleDto();
        expectedDto.setId(1);
        expectedDto.setProductId(79);
        expectedDto.setSaleCode("a8a2700a-eb48-4265-b74a-f89da5ef0a14");

        when(saleRepository.GetById(1)).thenReturn(expectedEntity);
        when(modelMapper.map(expectedEntity, SaleDto.class)).thenReturn(expectedDto);
        SaleDto sale = saleService.GetById(1);

        assertNotNull(sale);
        assertEquals(expectedDto, sale);
        assertEquals(expectedEntity.getId(), sale.getId());
        assertEquals(expectedEntity.getSaleCode(), sale.getSaleCode());
        assertEquals(expectedEntity.getProductId(), sale.getProductId());
    }
}