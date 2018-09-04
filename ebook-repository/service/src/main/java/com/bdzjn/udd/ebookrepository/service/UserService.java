package com.bdzjn.udd.ebookrepository.service;

import com.bdzjn.udd.ebookrepository.model.User;
import com.bdzjn.udd.ebookrepository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user;
    }

    public boolean changePassword(Long id, String newPassword) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            user.get().setPassword(newPassword);
            User u = userRepository.save(user.get());
            return u.getPassword().equals(newPassword);
        }

        return false;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(long id) {
        return userRepository.findById(id);
    }
}
