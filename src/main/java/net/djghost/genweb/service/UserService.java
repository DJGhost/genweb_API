/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.service;

import java.util.Optional;
import lombok.Data;
import net.djghost.genweb.model.User;
import net.djghost.genweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    
    public void deleteUser(final Long id) {
	userRepository.deleteById(id);
    }
	
    public User saveUser(User user) {
	User savedUser = userRepository.save(user);
	return savedUser;
    }
    
}
