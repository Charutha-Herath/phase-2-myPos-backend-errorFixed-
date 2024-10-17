package lk.ijse.phase02.phase2myposbackend.dto.impl;

import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {

    private String customerId;
    private String customerName;
    private String contact;
    private String address;
}
