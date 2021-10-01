package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pointage implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String intitule;
	
	@Column
	private String description;
	
	@Column
	private Timestamp dateTimeDebut;
	
	@Column
	private Timestamp dateTimeFin;
	
	@Column
	private String themeColor;
	
	@ManyToOne
    @JoinColumn(name = "profil_id")
    Profil profils;
	
	@ManyToOne
    @JoinColumn(name = "contrat_id")
	Contrat contrats;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	User user;

	public Pointage() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Pointage(String intitule, String description, Timestamp dateTimeDebut, Timestamp dateTimeFin,
			String themeColor, Profil profils, Contrat contrats, User user) {
		super();
		this.intitule = intitule;
		this.description = description;
		this.dateTimeDebut = dateTimeDebut;
		this.dateTimeFin = dateTimeFin;
		this.themeColor = themeColor;
		this.profils = profils;
		this.contrats = contrats;
		this.user = user;
	}



	public Timestamp getDateTimeDebut() {
		return dateTimeDebut;
	}



	public void setDateTimeDebut(Timestamp dateTimeDebut) {
		this.dateTimeDebut = dateTimeDebut;
	}



	public Timestamp getDateTimeFin() {
		return dateTimeFin;
	}



	public void setDateTimeFin(Timestamp dateTimeFin) {
		this.dateTimeFin = dateTimeFin;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

	public Profil getProfils() {
		return profils;
	}

	public void setProfils(Profil profils) {
		this.profils = profils;
	}

	public Contrat getContrats() {
		return contrats;
	}

	public void setContrats(Contrat contrats) {
		this.contrats = contrats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Pointage [id=" + id + ", intitule=" + intitule + ", description=" + description + ", dateTimeDebut="
				+ dateTimeDebut + ", dateTimeFin=" + dateTimeFin + ", themeColor=" + themeColor + "]";
	}



	
}
