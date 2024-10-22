package lk.ijse.phase02.phase2myposbackend.service;

import lk.ijse.phase02.phase2myposbackend.dto.ItemStatus;
import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;

public interface PlaceOrderService {

    PlaceOrderStatus getNextNewOrderId();
}
