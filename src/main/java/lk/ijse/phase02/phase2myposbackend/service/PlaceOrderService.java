package lk.ijse.phase02.phase2myposbackend.service;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.PlaceOrderDTO;

public interface PlaceOrderService {

    PlaceOrderStatus getNextNewOrderId();

    void saveOrder(PlaceOrderDTO placeOrderDTO);
}
