package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.CustomerDao;
import lk.ijse.phase02.phase2myposbackend.dao.ItemDao;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;

import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import lk.ijse.phase02.phase2myposbackend.service.ItemService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
                public String getItemId() {
                    return "Item-0001";
                }
            };
        } else {
            // Extract the numeric part and increment it
            int nextId = Integer.parseInt(id.substring(5)) + 1;
            String newId = "Item-" + String.format("%04d", nextId);
            return new ItemStatus() {
                @Override
                public String getItemId() {
                    return newId;
                }
            };
        }
    }
}
