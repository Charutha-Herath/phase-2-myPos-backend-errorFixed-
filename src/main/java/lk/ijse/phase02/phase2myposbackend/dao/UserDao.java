package lk.ijse.phase02.phase2myposbackend.dao;


import lk.ijse.phase02.phase2myposbackend.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {

    @Query(value = "SELECT * FROM user WHERE email = :email", nativeQuery = true)
    UserEntity findByEmail(@Param("email") String email);


}
