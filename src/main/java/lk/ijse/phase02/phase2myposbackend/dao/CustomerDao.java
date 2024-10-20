package lk.ijse.phase02.phase2myposbackend.dao;

import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {

   /* @Query(value = "SELECT MAX(customerId) AS last_customer_id FROM customer", nativeQuery = true)
    CustomerEntity generateNextNewId();*/

    @Query(value = "SELECT MAX(customerId) FROM customer", nativeQuery = true)
    String generateNextNewId();


}
