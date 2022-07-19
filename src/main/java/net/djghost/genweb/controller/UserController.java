/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.controller;


import java.util.Optional;
import net.djghost.genweb.model.User;
import net.djghost.genweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
    * Create - Add a new user
     * @param user
    * @return The user object saved
    */
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
	return userService.saveUser(user);
    }
    
    /**
    * Read - Get one user 
    * @param id The id of the user
    * @return An User object full filled
    */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") final Long id) {
       	Optional<User> user = userService.getUser(id);
	if(user.isPresent()) {
		return user.get();
	} else {
		return null;
	}
    }
    
     /**
    * Read - Get all users
    * @return - An Iterable object of Medecin full filled
    */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
    
    /**
	 * Update - Update an existing user
	 * @param id - The id of the user to update
	 * @param user - The user object updated
	 * @return
	 */
	@PutMapping("/user/{id}")
	public User updateEmployee(@PathVariable("id") final Long id, @RequestBody User user) {
		Optional<User> u = userService.getUser(id);
		if(u.isPresent()) {
			User currentUser = u.get();
			
			String prenom = user.getPrenom();
			if(prenom != null) {
				currentUser.setPrenom(prenom);
			}
			String nom = user.getNom();
			if(nom != null) {
				currentUser.setNom(nom);
			}
			String mail = user.getEMail();
			if(mail != null) {
				currentUser.setEMail(mail);
			}
			String password = user.getPassword();
			if(password != null) {
				currentUser.setPassword(password);   ///// A refaire
			}
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an user
	 * @param id - The id of the user to delete
	 */
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		userService.deleteUser(id);
	}
	
}
