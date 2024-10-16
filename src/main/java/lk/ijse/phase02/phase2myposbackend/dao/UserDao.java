package lk.ijse.phase02.phase2myposbackend.dao;


import lk.ijse.phase02.phase2myposbackend.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    //UserEntity findByEmail(String email);
}
