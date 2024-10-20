package lk.ijse.phase02.phase2myposbackend.util;



import lk.ijse.phase02.phase2myposbackend.dto.impl.CustomerDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.ItemDTO;
import lk.ijse.phase02.phase2myposbackend.dto.impl.UserDTO;
import lk.ijse.phase02.phase2myposbackend.entity.impl.CustomerEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.ItemEntity;
import lk.ijse.phase02.phase2myposbackend.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntities) {
        return modelMapper.map(customerEntities, new TypeToken<List<CustomerDTO>>() {}.getType());
    }



    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public ItemDTO toItemDTO(ItemEntity itemEntity) {return modelMapper.map(itemEntity, ItemDTO.class);}

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntities) {
        return modelMapper.map(itemEntities, new TypeToken<List<ItemDTO>>() {}.getType());
    }
}
