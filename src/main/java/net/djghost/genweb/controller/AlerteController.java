/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.controller;

import java.util.Optional;
import net.djghost.genweb.model.Alerte;
import net.djghost.genweb.service.AlerteService;
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
public class AlerteController {
    
    @Autowired
    private AlerteService alerteService;
    
    /**
    * Create - Add a new alerte
     * @param alerte
    * @return The Alerte object saved
    */
    @PostMapping("/alerte")
    public Alerte createAlerte(@RequestBody Alerte alerte) {
	return alerteService.saveAlerte(alerte);
    }
    
    /**
    * Read - Get one alerte 
    * @param id The id of the alerte
    * @return An Alerte object full filled
    */
    @GetMapping("/alerte/{id}")
    public Alerte getAlerte(@PathVariable("id") final Long id) {
       	Optional<Alerte> alerte = alerteService.getAlerte(id);
	if(alerte.isPresent()) {
		return alerte.get();
	} else {
		return null;
	}
    }
    
     /**
    * Read - Get all alertes
    * @return - An Iterable object of Alerte full filled
    */
    @GetMapping("/alertes")
    public Iterable<Alerte> getEAlertes() {
        return alerteService.getAlertes();
    }
    
    /**
	 * Update - Update an existing alerte
	 * @param id - The id of the alerte to update
	 * @param alerte - The alerte object updated
	 * @return
	 */
	@PutMapping("/alerte/{id}")     ///// A refaire
	public Alerte updateAlerte(@PathVariable("id") final Long id, @RequestBody Alerte alerte) {
		Optional<Alerte> a = alerteService.getAlerte(id);
		if(a.isPresent()) {
			Alerte currentAlerte = a.get();
			
			Integer jrReception = alerte.getJrReception();
			if(jrReception != null) {
				currentAlerte.setJrReception(jrReception);
			}
			Integer min = alerte.getMin();
			if(min != null) {
				currentAlerte.setMin(min);
			}
			Integer max = alerte.getMax();
			if(max != null) {
				currentAlerte.setMax(max);
			}
			Boolean acrif = alerte.getActif();
			if(acrif != null) {
				currentAlerte.setActif(acrif);
			}
			alerteService.saveAlerte(currentAlerte);
			return currentAlerte;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Delete - Delete an Alerte
	 * @param id - The id of the alerte to delete
	 */
	@DeleteMapping("/alerte/{id}")
	public void deleteAlerte(@PathVariable("id") final Long id) {
		alerteService.deleteAlerte(id);
	}
    
}
