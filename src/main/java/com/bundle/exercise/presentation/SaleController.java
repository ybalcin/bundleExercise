package com.bundle.exercise.presentation;

import com.bundle.exercise.application.dto.ResponseDto;
import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "Shipping status", response = ResponseDto.class)
    @GetMapping("/{saleId}/shipping")
    public ResponseDto Shipping(@PathVariable int saleId){
        return statusService.GetShippingInformation(saleId);
    }

    @ApiOperation(value = "Sale detail", response = SaleDto.class)
    @GetMapping("/{id}")
    public SaleDto Sale(@PathVariable int id){
        return saleService.GetById(id);
    }

    @ApiOperation(value = "All sales", response = SaleDto[].class)
    @GetMapping
    public SaleDto[] Sale(){
        return saleService.GetAll();
    }
}
