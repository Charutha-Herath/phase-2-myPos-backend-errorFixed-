package lk.ijse.phase02.phase2myposbackend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.phase02.phase2myposbackend.dao.CustomerDao;
import lk.ijse.phase02.phase2myposbackend.dto.CustomerStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.exception.CustomerNotFoundException;
import lk.ijse.phase02.phase2myposbackend.exception.DataPersistException;
import lk.ijse.phase02.phase2myposbackend.service.CustomerService;
import lk.ijse.phase02.phase2myposbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity savedCustomer = customerDao.save(mapping.toCustomerEntity(customerDTO));

        if (savedCustomer == null) {
            throw new DataPersistException("User not saved");
        }
    }

    @Override
    public CustomerStatus getNextNewId() {
        String Newid = customerDao.generateNextNewId();
        System.out.println("NewId : "+Newid);
        //CustomerEntity customerEntity = customerDao.generateNextNewId();
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(Newid);
        String id = (customerEntity != null) ? customerEntity.getCustomerId() : null;

        if (id == null) {
            // If no ID exists, return the first
            return new CustomerStatus() {
                @Override
                public String getCustomerId() {
                    return "Cust-0001";
                }
            };
        } else {
            // Extract the numeric part and increment it
            int nextId = Integer.parseInt(id.substring(5)) + 1;
            String newId = "Cust-" + String.format("%04d", nextId);
            return new CustomerStatus() {
                @Override
                public String getCustomerId() {
                    return newId;
                }
            };
        }
    }

    @Override
    public void updateCustomer(String custId, CustomerDTO customerDTO) {

        Optional<CustomerEntity> findCustomer = customerDao.findById(custId);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            findCustomer.get().setCustomerName(customerDTO.getCustomerName());
            findCustomer.get().setAddress(customerDTO.getAddress());
            findCustomer.get().setContact(customerDTO.getContact());

        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> findCustomer = customerDao.findById(customerId);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.asCustomerDTOList( customerDao.findAll());
    }

    @Override
    public List<String> getAllIds() {
        List<String> allCustomerIds = customerDao.findAllCustomerIds();
        return allCustomerIds;
    }


}
