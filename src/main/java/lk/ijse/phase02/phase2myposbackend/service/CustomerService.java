package lk.ijse.phase02.phase2myposbackend.service;

import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    CustomerStatus getNextNewId();
}
