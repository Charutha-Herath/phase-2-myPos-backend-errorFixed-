package lk.ijse.phase02.phase2myposbackend.controller;


import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.exception.CustomerNotFoundException;
import lk.ijse.phase02.phase2myposbackend.exception.DataPersistException;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("generateNextItemId")
    public ItemStatus generateNewId(){
        return itemService.getNextNewItemId();

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItems(@RequestBody ItemDTO itemDTO) {
        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{itemId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable ("itemId") String itemId,
                                               @RequestBody ItemDTO updatedItemDto){
        //validations
        try {
            if(!RegexProcess.ItemIdMatcher(itemId) || updatedItemDto == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemId,updatedItemDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
