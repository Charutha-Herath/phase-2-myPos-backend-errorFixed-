package lk.ijse.phase02.phase2myposbackend.dao;


import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
    @Query(value = "SELECT MAX(itemCode) FROM item", nativeQuery = true)
    String generateNextNewId();
}
