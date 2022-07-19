/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author DJGhost
 */

@Data
@Entity
@Table (name = "gw_alertes")
public class Alerte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ALT_ID")
    private Long id;

    @Column(name="ALT_JOUR_DE_RECEPTION")
    private Integer jrReception;
    
    @Column(name="ALT_MIN")
    private Integer min;
    
    @Column(name="ALT_MAX")
    private Integer max;
    
    @Column(name="ALT_FLAG_ACTIF")
    private Boolean actif;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALT_CREE_USER")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User creePar;
    
    
    @Column(name="ALT_CREE_DATE")
    private Date creeDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ALT_MODIFIE_USER")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User modifiePar;
    
    
    @Column(name="ALT_MODIFIE_DATE")
    private Date modifDate;
    
}
