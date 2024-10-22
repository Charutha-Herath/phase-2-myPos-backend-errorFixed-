package lk.ijse.phase02.phase2myposbackend.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class PlaceOrderEntity implements Serializable {

    @Id
    @Column(name = "orderId")
    private String orderId;
    private String customerId;
    private Date orderDate;
    private Double total;
    private Double discount;
    private int cash;
}
