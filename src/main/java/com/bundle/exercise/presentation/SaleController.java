package com.bundle.exercise.presentation;

import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.dto.ShippingStatusDto;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Sale Operations", description = "Sale Operations")
@RestController
@RequestMapping("/sale")
public class SaleController {
    private final IShippingStatusService statusService;
    private final ISaleService saleService;

    @Autowired
    public SaleController
            (IShippingStatusService shippingStatusService, ISaleService saleService) {
        this.statusService = shippingStatusService;
        this.saleService = saleService;
    }

    @ApiOperation(value = "Shipping status", response = ShippingStatusDto.class)
    @GetMapping("/{id}/shipping")
    public ResponseEntity<ShippingStatusDto> Shipping(@PathVariable int id) throws Exception {
        ShippingStatusDto shippingStatus = statusService.GetShippingInformation(id);
        return ResponseEntity.ok().body(shippingStatus);
    }

    @ApiOperation(value = "Sale detail", response = SaleDto.class)
    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> Sale(@PathVariable int id) throws Exception {
        SaleDto sale = saleService.GetById(id);
        return ResponseEntity.ok().body(sale);
    }

    @ApiOperation(value = "All sales", response = SaleDto[].class)
    @GetMapping
    public ResponseEntity<SaleDto[]> Sale() throws Exception {
        SaleDto[] sales = saleService.GetAll();
        return ResponseEntity.ok().body(sales);
    }
}
