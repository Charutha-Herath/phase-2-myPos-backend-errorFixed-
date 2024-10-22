package lk.ijse.phase02.phase2myposbackend.controller;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/placeOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    //Generate New order Id
    @GetMapping("generateNextOrderId")
    public ItemStatus generateNewId(){
        return placeOrderService.getNextNewOrderId();

    }

    //Get all customer ids

    //Get all Item codes

    //Get name by selected customer

    //Get details by selected item

    //Batch update in item table

    //save order details table (click purchase)


}
