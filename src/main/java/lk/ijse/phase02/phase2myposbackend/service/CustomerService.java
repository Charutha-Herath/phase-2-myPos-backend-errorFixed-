package lk.ijse.phase02.phase2myposbackend.service;

import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    CustomerStatus getNextNewId();

    void updateCustomer(String custId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    List<CustomerDTO> getAllCustomer();
}
