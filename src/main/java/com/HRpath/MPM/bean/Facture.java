package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Date dateFacturation;
	
	@Column
	private Double HT;
	
	@Column
	private Double TTC;
	
	@Column
	private Date dateEcheance;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(Date dateFacturation, Double hT, Double tTC, Date dateEcheance) {
		super();
		this.dateFacturation = dateFacturation;
		HT = hT;
		TTC = tTC;
		this.dateEcheance = dateEcheance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public Double getHT() {
		return HT;
	}

	public void setHT(Double hT) {
		HT = hT;
	}

	public Double getTTC() {
		return TTC;
	}

	public void setTTC(Double tTC) {
		TTC = tTC;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	
	
	
	

}
