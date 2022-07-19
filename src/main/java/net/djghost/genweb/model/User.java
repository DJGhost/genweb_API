/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.djghost.genweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author admin
 */
@Data
@Entity
@Table(name="gw_usr")
public class User implements Serializable{

   
 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USR_ID")
    private Long id;

    @Column(name="USR_NOM")
    private String nom;

    @Column(name="USR_PRENOM")
    private String prenom;

    @Column(name="USR_SEXE")
    private Integer sexe;
    
    @Column(name="USR_PSW")
    private String password;

    @Column(name="USR_DATENAISSANCE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(name="USR_GROUP_ID")
    private Integer groupe;
    
    @Column(name="USR_DERNIERE_CO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date derniereCo;

    @Column(name="USR_FLAG_ACTIF")
    private Boolean actif;
    
    @Column(name="USR_CIVILITE_ID")
    private Integer civilite;

    @Column(name="USR_EMAIL")
    private String eMail;
    
}

