package lk.ijse.phase02.phase2myposbackend.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "customerId")
    private String customerId;
    private String customerName;
    private String contact;
    private String address;
}
