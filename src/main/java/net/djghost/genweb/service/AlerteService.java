/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.service;

import java.util.Optional;
import lombok.Data;
import net.djghost.genweb.model.Alerte;
import net.djghost.genweb.repository.AlerteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DJGhost
 */

@Data
@Service
public class AlerteService {
    
    @Autowired
    private AlerteRepository alerteRepository; 
    
    public Optional<Alerte> getAlerte(final Long id) {
        return alerteRepository.findById(id);
    }

    public Iterable<Alerte> getAlertes() {
        return alerteRepository.findAll();
    }
    
    
    public void deleteAlerte(final Long id) {
	alerteRepository.deleteById(id);
    }
	
    public Alerte saveAlerte (Alerte alerte) {
	Alerte savedAlerte = alerteRepository.save(alerte);
	return savedAlerte;
    }
}
