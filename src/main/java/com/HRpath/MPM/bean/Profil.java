package com.HRpath.MPM.bean;

import java.io.Serializable;
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

@Entity
public class Profil implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String profil;
	

	@OneToMany(mappedBy="profils")
	private List<Pointage> pointage;	

	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profil(String Profil) {
		super();
		profil = Profil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}
	

	

	@Override
	public String toString() {
		return "Profil [id=" + id + ", profil=" + profil + "]";
	}

}
