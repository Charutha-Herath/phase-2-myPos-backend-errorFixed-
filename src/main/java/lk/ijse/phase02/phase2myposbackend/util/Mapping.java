package lk.ijse.phase02.phase2myposbackend.util;



import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.UserDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO toUserDTO(UserEntity userEntity) {return modelMapper.map(userEntity, UserDTO.class);}

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){return modelMapper.map(customerDTO, CustomerEntity.class);}

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){return modelMapper.map(customerEntity,CustomerDTO.class);}
}
