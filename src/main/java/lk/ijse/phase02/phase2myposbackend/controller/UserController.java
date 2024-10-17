package lk.ijse.phase02.phase2myposbackend.controller;


import lk.ijse.phase02.phase2myposbackend.customStatusCodes.SelectedUserErrorStatus;
import lk.ijse.phase02.phase2myposbackend.dto.UserStatus;
import lk.ijse.phase02.phase2myposbackend.dto.impl.UserDTO;
import lk.ijse.phase02.phase2myposbackend.exception.DataPersistException;
import lk.ijse.phase02.phase2myposbackend.service.UserService;
import lk.ijse.phase02.phase2myposbackend.util.AppUtil;
import lk.ijse.phase02.phase2myposbackend.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("name") String name,
            @RequestPart("email") String email,
            @RequestPart("password")String password
    ){
        try {
            System.out.println("Awoooo...... \n\n");

            UserDTO buildUserDTO = new UserDTO();

            String userId = AppUtil.generateUserId();

            System.out.println("\n"+name+" \n"+email+" \n"+password);

            buildUserDTO.setUserId(userId);
            buildUserDTO.setName(name);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            System.out.println("buildUser : "+buildUserDTO.toString());
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUserByEmail(@PathVariable("email") String email){
        if(!RegexProcess.userEmailMatcher(email)){

            System.out.println(email+"  Not valid \n\n");
            return new SelectedUserErrorStatus(1,"User email not valid");
        }
        System.out.println(email+"  valid \n\n");
        return userService.getUserByEmail(email);

    }

}
