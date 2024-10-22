package lk.ijse.phase02.phase2myposbackend.service;


import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;

public interface ItemService {
    ItemStatus getNextNewItemId();

    void saveItem(ItemDTO itemDTO);

    void updateItem(String itemId, ItemDTO itemDTO);

    void deleteItem(String itemId);
}
