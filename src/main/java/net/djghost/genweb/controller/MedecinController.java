/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.controller;

import net.djghost.genweb.model.Medecin;
import net.djghost.genweb.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@RestController
public class MedecinController {
    
    @Autowired
    private MedecinService medecinService;
    
     /**
    * Read - Get all medecins
    * @return - An Iterable object of Medecin full filled
    */
    @GetMapping("/medecins")
    public Iterable<Medecin> getEmployees() {
        return medecinService.getEmployees();
    }
}
