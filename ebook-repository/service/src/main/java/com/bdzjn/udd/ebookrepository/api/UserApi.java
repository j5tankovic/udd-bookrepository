package com.bdzjn.udd.ebookrepository.api;

import com.bdzjn.udd.ebookrepository.dto.LoginResponseDTO;
import com.bdzjn.udd.ebookrepository.dto.LoginDTO;
import com.bdzjn.udd.ebookrepository.dto.PasswordChangeDTO;
import com.bdzjn.udd.ebookrepository.dto.UserDTO;
import com.bdzjn.udd.ebookrepository.dto.mapper.UserMapper;
import com.bdzjn.udd.ebookrepository.model.User;
import com.bdzjn.udd.ebookrepository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
@CrossOrigin("http://localhost:8081")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        Optional<User> user = userService.login(loginDTO.getUsername(), loginDTO.getPassword());

        if (user.isPresent()) {
            LoginResponseDTO loginResponseDTO =
                    new LoginResponseDTO(user.get().getId(), user.get().getType());

            return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{id}/change-password")
    public ResponseEntity changePassword(
            @PathVariable Long id,
            @RequestBody PasswordChangeDTO passwordChangeDTO) {
        boolean result = userService.changePassword(id, passwordChangeDTO.getNewPassword());
        if (result)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOList = users
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable long id){
        Optional<User> user = userService.findOne(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.toModelWhenSave(userDTO);
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
        User user = UserMapper.toModelWhenUpdate(userDTO);
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
