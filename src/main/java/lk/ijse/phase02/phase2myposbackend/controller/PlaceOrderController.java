package lk.ijse.phase02.phase2myposbackend.controller;

import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.PlaceOrderDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import lk.ijse.phase02.phase2myposbackend.exception.DataPersistException;
import lk.ijse.phase02.phase2myposbackend.service.CustomerService;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping( "getName/{customerId}")
    public String updateCustomer(@PathVariable("customerId") String customerId){
        return customerService.getCustomerName(customerId);
    }

    //Get details by selected item
    @GetMapping("getDetails/{itemId}")
    public ResponseEntity<ItemEntity> getAllDetailsById(@PathVariable("itemId") String itemId){
        //return itemService.getAllItemDetailsById(itemId);

        Optional<ItemEntity> item = itemService.getAllItemDetailsById(itemId);

        return item.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Batch update in item table
    @PutMapping("updateRows")
    public ResponseEntity<List<ItemEntity>> updateItems(@RequestBody List<ItemEntity> itemsToUpdate) {
        List<ItemEntity> updatedItems = itemService.updateItems(itemsToUpdate);
        return ResponseEntity.ok(updatedItems);
    }


    //save order details table (click purchase)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItems(@RequestBody PlaceOrderDTO placeOrderDTO) {
        try {
            placeOrderService.saveOrder(placeOrderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
