package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	@NotEmpty
	private String nom;
	
	@Column(nullable = false)
	@NotEmpty
	private String prenom;
	
	@Column(nullable = false)
	@NotEmpty
	private String address;
	
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String email;

	@Column(nullable = false)
	@JsonIgnore
	@NotEmpty
	@Length(min = 8)
	private String password;
	
	private Date dateNaissance;

	

	private Date dateEmbauche;
	
	 @JsonManagedReference
	 @OneToMany(mappedBy = "prestataire")
	 private List<Affectation> affectation=new ArrayList<Affectation>();
	 
	 @JsonManagedReference
	 @OneToMany(mappedBy = "manager")
	 private List<Affectation> affecter=new ArrayList<Affectation>();
	 

    @OneToMany(mappedBy="user")
	private List<Pointage> pointage;	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	@JsonManagedReference
	private List<Role> roles=new ArrayList<Role>();

	
	
	
	

	
	
	

	@Override
	public String toString() {
		return " '{ 'id' :" + id + ", 'nom' :" + nom + ", 'prenom' :" + prenom + ", 'address' :" + address + ", 'email' :" + email
				+ ", 'password' :" + password + ", 'dateNaissance' :" + dateNaissance + ", 'dateEmbauche' :" + dateEmbauche
				+ "}' ";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Affectation> getAffectation() {
		return affectation;
	}

	public void setAffectation(List<Affectation> affectation) {
		this.affectation = affectation;
	}

	
	public List<Affectation> getAffecter() {
		return affecter;
	}

	public void setAffecter(List<Affectation> affecter) {
		this.affecter = affecter;
	}
	
}
