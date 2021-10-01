package com.HRpath.MPM.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Contrat implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String intitule;
	
	@Column 
	private Date dateContrat;
	
	@Column
	private Date dateFin;
	
	@Column
	private Date dateFinPrevue;

    @Column
    private Date dateCommencementPrevu;
    
    @Column
    private Double nombreRessources;
	
	@Column
	private Double budgetTotaleEstime;
	
	@Column 
	private String description;
	
	@ManyToOne
    private Client client;
	
	

	@OneToMany(mappedBy="contrats")
	private List<Pointage> pointage;	

	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Contrat(String intitule, Date dateContrat, Date dateFinPrevue, Date dateCommencementPrevu,
			Double nombreRessources, Double budgetTotaleEstime, String description, Client client) {
		super();
		this.intitule = intitule;
		this.dateContrat = dateContrat;
		this.dateFinPrevue = dateFinPrevue;
		this.dateCommencementPrevu = dateCommencementPrevu;
		this.nombreRessources = nombreRessources;
		this.budgetTotaleEstime = budgetTotaleEstime;
		this.description = description;
		this.client = client;
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

	public Date getDateContrat() {
		return dateContrat;
	}

	public void setDateContrat(Date dateContrat) {
		this.dateContrat = dateContrat;
	}



	public Date getDateFin() {
		return dateFin;
	}



	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



	public Date getDateFinPrevue() {
		return dateFinPrevue;
	}



	public void setDateFinPrevue(Date dateFinPrevue) {
		this.dateFinPrevue = dateFinPrevue;
	}



	public Date getDateCommencementPrevu() {
		return dateCommencementPrevu;
	}



	public void setDateCommencementPrevu(Date dateCommencementPrevu) {
		this.dateCommencementPrevu = dateCommencementPrevu;
	}



	public Double getNombreRessources() {
		return nombreRessources;
	}



	public void setNombreRessources(Double nombreRessources) {
		this.nombreRessources = nombreRessources;
	}



	public Double getBudgetTotaleEstime() {
		return budgetTotaleEstime;
	}



	public void setBudgetTotaleEstime(Double budgetTotaleEstime) {
		this.budgetTotaleEstime = budgetTotaleEstime;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "Contrat [id=" + id + ", intitule=" + intitule + ", dateContrat=" + dateContrat + ", dateFin=" + dateFin
				+ ", dateFinPrevue=" + dateFinPrevue + ", dateCommencementPrevu=" + dateCommencementPrevu
				+ ", nombreRessources=" + nombreRessources + ", budgetTotaleEstime=" + budgetTotaleEstime
				+ ", description=" + description + ", client=" + client + ", pointage=" + pointage + "]";
	}

	 

	
	
   
	
}
