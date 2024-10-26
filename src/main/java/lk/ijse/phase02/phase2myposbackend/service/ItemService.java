package lk.ijse.phase02.phase2myposbackend.service;


import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    ItemStatus getNextNewItemId();

    void saveItem(ItemDTO itemDTO);

    void updateItem(String itemId, ItemDTO itemDTO);

    void deleteItem(String itemId);

    List<ItemDTO> getAllItems();

    List<String> getAllItemIds();

    Optional<ItemEntity> getAllItemDetailsById(String itemId);

    List<ItemEntity> updateItems(List<ItemEntity> itemsToUpdate);
}
