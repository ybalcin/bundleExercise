package com.bundle.exercise.presentation;

import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.dto.ShippingStatusDto;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Sale Operations", description = "Sale Operations")
@RestController
@RequestMapping("/sale")
public class SaleController {
    private final IShippingService shippingService;
    private final ISaleService saleService;

    @Autowired
    public SaleController
            (IShippingService shippingService, ISaleService saleService) {
        this.shippingService = shippingService;
        this.saleService = saleService;
    }

    @ApiOperation(value = "Shipping status", response = ShippingStatusDto.class)
    @GetMapping("/{id}/shipping")
    public ResponseEntity<ShippingStatusDto> Shipping(@PathVariable int id){
        ShippingStatusDto shippingStatus = shippingService.GetShippingStatus(id);
        return ResponseEntity.ok().body(shippingStatus);
    }

    @ApiOperation(value = "Sale detail", response = SaleDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> Sale(@PathVariable int id){
        SaleDto sale = saleService.GetById(id);
        return ResponseEntity.ok().body(sale);
    }

    @ApiOperation(value = "All sales", response = SaleDto[].class)
    @GetMapping
    public ResponseEntity<SaleDto[]> Sale(){
        SaleDto[] sales = saleService.GetAll();
        return ResponseEntity.ok().body(sales);
    }
}
