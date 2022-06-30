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
@Table(name="gw_medecin")
public class Medecin implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="MED_ID")
    private Long id;

    @Column(name="MED_NOM")
    private String nom;

    @Column(name="MED_PRENOM")
    private String prenom;

    @Column(name="MED_SEXE")
    private Integer sexe;

    @Column(name="MED_DATENAISSANCE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(name="MED_ETABLISSEMENT_ID")
    private Integer etablissement;

    @Column(name="MED_FLAG_ACTIF")
    private Boolean actif;
    
    @Column(name="MED_TEL")
    private String tel;

    @Column(name="MED_FAX")
    private String fax;
    
    @Column(name="MED_EMAIL")
    private String eMail;
    
}
