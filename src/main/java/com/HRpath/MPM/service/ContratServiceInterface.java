package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.Client;
import com.HRpath.MPM.bean.Contrat;
import com.HRpath.MPM.bean.Profil;
import com.HRpath.MPM.bean.StatutContrat;

public interface ContratServiceInterface {
	public Contrat findById(Integer id);
	public void save(Contrat aff);
	public List<Contrat> findAll();
	public void delete(Integer id);
	public List<Client> getClient();
	public List<StatutContrat> getStatut();
	public List<Profil> getProfil();
}