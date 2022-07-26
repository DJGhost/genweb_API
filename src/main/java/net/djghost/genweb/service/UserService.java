/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.service;

import java.util.ArrayList;
import java.util.Optional;
import lombok.Data;
import net.djghost.genweb.model.User;
import net.djghost.genweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DJGhost
 */
@Data
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder bcryptEncoder;
    
    //Basic CRUD Ops
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
        //User newUser = new User();
        //newUser.setNom(user.getNom());
        //newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
	User savedUser = userRepository.save(user);
	return savedUser;
    }
    
    /////////////////////////////////////////////////////////////////////////////
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNom(username);
	if (user == null) {
            throw new UsernameNotFoundException("Utilisateur Introuvable ");
	}
	return new org.springframework.security.core.userdetails.User(user.getNom(), user.getPassword(),
            new ArrayList<>());
	}
    
    
    
    
}
