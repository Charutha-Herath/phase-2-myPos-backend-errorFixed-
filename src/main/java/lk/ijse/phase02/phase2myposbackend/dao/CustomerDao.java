package lk.ijse.phase02.phase2myposbackend.dao;

import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;

import lk.ijse.phase02.phase2myposbackend.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {

   /* @Query(value = "SELECT MAX(customerId) AS last_customer_id FROM customer", nativeQuery = true)
    CustomerEntity generateNextNewId();*/

    @Query(value = "SELECT MAX(customerId) FROM customer", nativeQuery = true)
    String generateNextNewId();


    @Query(value = "SELECT customerId FROM customer", nativeQuery = true)
    List<String> findAllCustomerIds();

    @Query(value = "SELECT customerName FROM customer WHERE customerId = :customerId", nativeQuery = true)
    String getNameById(@Param("customerId") String customerId);



}
