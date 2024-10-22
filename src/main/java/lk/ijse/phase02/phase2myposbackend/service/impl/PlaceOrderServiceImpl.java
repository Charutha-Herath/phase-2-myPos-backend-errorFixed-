package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.PlaceOrderDao;
import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;
import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.PlaceOrderEntity;
import lk.ijse.phase02.phase2myposbackend.service.PlaceOrderService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private PlaceOrderDao placeOrderDao;
    @Autowired
    private Mapping mapping;
    @Override
    public PlaceOrderStatus getNextNewOrderId() {
        String Newid = placeOrderDao.generateNextNewId();
        System.out.println("NewId : "+Newid);

        PlaceOrderEntity placeOrderEntity = new PlaceOrderEntity();
        placeOrderEntity.setOrderId(Newid);
        String id = (placeOrderEntity != null) ? placeOrderEntity.getOrderId() : null;

        if (id == null) {
            // If no ID exists, return the first
            return new PlaceOrderStatus() {
                @Override
                public String getOrderId() {
                    return "Order-0001";
                }
            };
        } else {
            // Extract the numeric part and increment it
            int nextId = Integer.parseInt(id.substring(5)) + 1;
            String newId = "Order-" + String.format("%04d", nextId);
            return new PlaceOrderStatus() {
                @Override
                public String getOrderId() {
                    return newId;
                }
            };
        }
    }
}
