package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotEmpty
	private String nom;
	
	@Column
	@NotEmpty
	private String prenom;
	
	@Column
	@NotEmpty
	private String address;
	
	@Column
	@NotEmpty
	private String numeroTel;
	
	@Column
	@NotEmpty
	private String email;
	
	@Column
	private Date dateNaissance;

	@OneToMany(mappedBy="client")
	private List<Contrat> contrats;
	
	
	
	
	public Client() {
		super();
	}


	public Client(@NotEmpty String nom, @NotEmpty String prenom, @NotEmpty String address, @NotEmpty String numeroTel,
			@NotEmpty String email, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
		this.numeroTel = numeroTel;
		this.email = email;
		this.dateNaissance = dateNaissance;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getNumeroTel() {
		return numeroTel;
	}


	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	

}
