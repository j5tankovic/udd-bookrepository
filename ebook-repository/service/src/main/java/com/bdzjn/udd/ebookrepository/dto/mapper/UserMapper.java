package com.bdzjn.udd.ebookrepository.dto.mapper;

import com.bdzjn.udd.ebookrepository.dto.UserDTO;
import com.bdzjn.udd.ebookrepository.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setPassword(user.getPassword());
        userDTO.setType(user.getType());
        userDTO.setSubscribedTo(user.getSubscribedCategory());

        return userDTO;
    }


    public static User toModelWhenSave(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setPassword(userDTO.getPassword());
        user.setType(userDTO.getType());

        return user;
    }

    public static User toModelWhenUpdate(UserDTO userDTO) {
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setType(userDTO.getType());
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setSubscribedCategory(userDTO.getSubscribedTo());

        return user;
    }
}
