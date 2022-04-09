package com.java.uioks.messApp.service;

import com.java.uioks.messApp.entity.User;
import com.java.uioks.messApp.exception.EntityNotFoundException;
import com.java.uioks.messApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new EntityNotFoundException("user not founded: "  + username));
    }

    @Transactional
    public void deleteByUsername(final String username) {
        userRepository.deleteByUsername(username);
    }

    @Transactional
    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }

    public void save(final User user) {
        userRepository.save(user);
    }
}
