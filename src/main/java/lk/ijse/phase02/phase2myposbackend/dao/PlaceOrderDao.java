package lk.ijse.phase02.phase2myposbackend.dao;

import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.PlaceOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceOrderDao extends JpaRepository<PlaceOrderEntity,String> {
}
