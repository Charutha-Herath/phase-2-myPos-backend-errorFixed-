package lk.ijse.phase02.phase2myposbackend.service;


import lk.ijse.phase02.phase2myposbackend.dto.UserStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.UserDTO;

public interface UserService {

    void saveUser(UserDTO userDTO);

    //UserStatus getUserByEmail(String email);
}
