/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.service;

import java.util.Optional;
import lombok.Data;
import net.djghost.genweb.model.Medecin;
import net.djghost.genweb.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DJGhost
 */
@Data
@Service
public class MedecinService {
    
    @Autowired
    private MedecinRepository medecinRepository;
    
    public Optional<Medecin> getMedecin(final Long id) {
        return medecinRepository.findById(id);
    }

    public Iterable<Medecin> getMedecins() {
        return medecinRepository.findAll();
    }
    
    
    public void deleteMedecin(final Long id) {
	medecinRepository.deleteById(id);
    }
	
    public Medecin saveMedecin (Medecin medecin) {
	Medecin savedMedecin = medecinRepository.save(medecin);
	return savedMedecin;
    }
    
}
