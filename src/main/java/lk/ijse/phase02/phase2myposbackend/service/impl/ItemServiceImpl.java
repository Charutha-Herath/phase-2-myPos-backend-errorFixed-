package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.CustomerDao;
import lk.ijse.phase02.phase2myposbackend.dao.ItemDao;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;

import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import lk.ijse.phase02.phase2myposbackend.exception.CustomerNotFoundException;
import lk.ijse.phase02.phase2myposbackend.exception.DataPersistException;
import lk.ijse.phase02.phase2myposbackend.exception.ItemNotFoundException;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public ItemStatus getNextNewItemId() {
        String Newid = itemDao.generateNextNewId();
        System.out.println("NewId : "+Newid);

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemCode(Newid);
        String id = (itemEntity != null) ? itemEntity.getItemCode() : null;

        if (id == null) {
            // If no ID exists, return the first
            return new ItemStatus() {
                @Override
                public String getItemCode() {
                    return "Item-0001";
                }
            };
        } else {
            // Extract the numeric part and increment it
            int nextId = Integer.parseInt(id.substring(5)) + 1;
            String newId = "Item-" + String.format("%04d", nextId);
            return new ItemStatus() {
                @Override
                public String getItemCode() {
                    return newId;
                }
            };
        }
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity savedItem = itemDao.save(mapping.toItemEntity(itemDTO));

        if (savedItem == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public void updateItem(String itemId, ItemDTO itemDTO) {
        Optional<ItemEntity> findItem = itemDao.findById(itemId);
        if (!findItem.isPresent()) {
            throw new ItemNotFoundException("Item not found");
        }else {
            findItem.get().setDescription(itemDTO.getDescription());
            findItem.get().setPrice(itemDTO.getPrice());
            findItem.get().setQty(itemDTO.getQty());
/*
            ItemEntity item = findItem.get();
            item.setDescription(itemDTO.getDescription());
            item.setPrice(itemDTO.getPrice());
            item.setQty(itemDTO.getQty());

            itemDao.save(item);*/

        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> findItem = itemDao.findById(itemId);
        if (!findItem.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            itemDao.deleteById(itemId);
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.asItemDTOList( itemDao.findAll());
    }
}
