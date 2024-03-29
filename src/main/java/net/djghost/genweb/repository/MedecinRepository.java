/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.djghost.genweb.repository;

import net.djghost.genweb.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DJGhost
 */
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long>{
    
}
