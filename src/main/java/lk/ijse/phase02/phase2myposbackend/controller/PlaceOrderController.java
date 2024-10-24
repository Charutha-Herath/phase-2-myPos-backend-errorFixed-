package lk.ijse.phase02.phase2myposbackend.controller;

import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.service.CustomerService;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/placeOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    //Generate New order Id
    @GetMapping("generateNextOrderId")
    public PlaceOrderStatus generateNewId(){
        return placeOrderService.getNextNewOrderId();

    }



    //Get all customer ids

    @GetMapping("getAllCustomerIds")
    public List<String> getAllCustomerIds(){
        return customerService.getAllIds();

    }

    //Get all Item codes

    @GetMapping("getAllItemIds")
    public List<String> getAllItemIds(){
        return itemService.getAllItemIds();

    }

    //Get name by selected customer
    @GetMapping(value = "/{customerId}")
    public String updateCustomer(@PathVariable("customerId") String customerId){
        return customerService.getCustomerName(customerId);
    }


    //Get details by selected item

    //Batch update in item table

    //save order details table (click purchase)


}
