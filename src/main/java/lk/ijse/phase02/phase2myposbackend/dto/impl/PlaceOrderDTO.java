package lk.ijse.phase02.phase2myposbackend.dto.impl;


import lk.ijse.phase02.phase2myposbackend.dto.PlaceOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrderDTO implements PlaceOrderStatus {

    private String orderId;
    private String customerId;
    private Date orderDate;
    private Double total;
    private Double discount;
    private int cash;
}
