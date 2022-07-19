/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.controller;

import java.util.Optional;
import net.djghost.genweb.model.Medecin;
import net.djghost.genweb.service.MedecinService;
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
 * @author DJGhost
 */
@RestController
public class MedecinController {
    
    @Autowired
    private MedecinService medecinService;
    
    /**
    * Create - Add a new medecin
     * @param medecin
    * @return The Medecin object saved
    */
    @PostMapping("/medecin")
    public Medecin createMedecin(@RequestBody Medecin medecin) {
	return medecinService.saveMedecin(medecin);
    }
    
    /**
    * Read - Get one medecin 
    * @param id The id of the medecin
    * @return An Medecin object full filled
    */
    @GetMapping("/user/{id}")
    public Medecin getMedecin(@PathVariable("id") final Long id) {
       	Optional<Medecin> medecin = medecinService.getMedecin(id);
	if(medecin.isPresent()) {
		return medecin.get();
	} else {
		return null;
	}
    }
    
     /**
    * Read - Get all medecins
    * @return - An Iterable object of Medecin full filled
    */
    @GetMapping("/medecins")
    public Iterable<Medecin> getEMedecins() {
        return medecinService.getMedecins();
    }
    
    /**
	 * Update - Update an existing user
	 * @param id - The id of the medecin to update
	 * @param medecin - The medecin object updated
	 * @return
	 */
	@PutMapping("/medecin/{id}")     ///// A refaire
	public Medecin updateEmployee(@PathVariable("id") final Long id, @RequestBody Medecin medecin) {
		Optional<Medecin> m = medecinService.getMedecin(id);
		if(m.isPresent()) {
			Medecin currentMedecin = m.get();
			
			String prenom = medecin.getPrenom();
			if(prenom != null) {
				currentMedecin.setPrenom(prenom);
			}
			String nom = medecin.getNom();
			if(nom != null) {
				currentMedecin.setNom(nom);
			}
			String mail = medecin.getEMail();
			if(mail != null) {
				currentMedecin.setEMail(mail);
			}
			Boolean acrif = medecin.getActif();
			if(acrif != null) {
				currentMedecin.setActif(acrif);  
			}
			medecinService.saveMedecin(currentMedecin);
			return currentMedecin;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an Medecin
	 * @param id - The id of the medecin to delete
	 */
	@DeleteMapping("/medecin/{id}")
	public void deleteUser(@PathVariable("id") final Long id) {
		medecinService.deleteMedecin(id);
	}
    
}
