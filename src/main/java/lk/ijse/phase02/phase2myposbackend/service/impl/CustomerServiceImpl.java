package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.CustomerDao;
import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.service.CustomerService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public CustomerStatus getNextNewId() {
        CustomerEntity customerEntity = customerDao.generateNextNewId();
        CustomerDTO customerDTO = customerMapping.toCustomerDTO(customerEntity);
        String id = customerDTO.getCustomerId();

        if (id == null){
            return "Cust-0001";
        }else {
            int nextId = Integer.parseInt(id.substring(5))+1;
            return "Cust-" + String.format("%04d",nextId);
        }
    }
}
