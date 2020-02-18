package com.bundle.exercise.presantation;

import com.bundle.exercise.application.dto.ResponseDto;
import com.bundle.exercise.application.dto.SaleDto;
import com.bundle.exercise.application.interfaces.ISaleService;
import com.bundle.exercise.application.interfaces.IShippingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{saleId}/shipping")
    public ResponseDto Shipping(@PathVariable int saleId){
        return statusService.GetShippingInformation(saleId);
    }

    @GetMapping("/{id}")
    public SaleDto Sale(@PathVariable int id){
        return saleService.GetById(id);
    }

    @GetMapping
    public SaleDto[] Sale(){
        return saleService.GetAll();
    }
}
