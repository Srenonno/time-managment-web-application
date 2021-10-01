package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Affectation implements Serializable{


	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="Manager_id")
	@JsonBackReference
	private User manager;
	

	@ManyToOne
	@JoinColumn(name="Prestataire_id")
	@JsonBackReference
	private User prestataire;
	
	@Column(name = "date_debut")
	private Date dateDebut;
	
	@Column(name = "date_fin")
	private Date dateFin;
	


	public User getManager() {
		return manager;
	}
	


	public Integer getId() {
		return id;
	}



	



	public void setManager(User manager) {
		this.manager = manager;
	}


	public User getPrestataire() {
		return prestataire;
	}


	public void setPrestataire(User prestataire) {
		this.prestataire = prestataire;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	@Override
	public String toString() {
		return "Affectation [dateFin=" + dateFin+", manager=" + manager + ", prestataire=" + prestataire + ", dateDebut="
				+ dateDebut + " id=" + id  + "]";
	}



	public Affectation(User manager, User prestataire, Date dateDebut, Date dateFin) {
		super();
		this.manager = manager;
		this.prestataire = prestataire;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}



	public Affectation() {
		super();
	}


	
	
	
	
	
	

}
