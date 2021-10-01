package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.Client;
import com.HRpath.MPM.bean.Contrat;
import com.HRpath.MPM.bean.Profil;
import com.HRpath.MPM.bean.StatutContrat;
import com.HRpath.MPM.dao.ClientRepository;
import com.HRpath.MPM.dao.ContratRepository;
import com.HRpath.MPM.dao.ProfilRepository;
import com.HRpath.MPM.dao.StatutRepository;

@Service
@Transactional
public class ContratService implements ContratServiceInterface {

	@Autowired
	ContratRepository contratRep;
	@Autowired
	ClientRepository clienRep;
	@Autowired
	StatutRepository statutRep;
	
	@Autowired
	ProfilRepository profilRep;

	@Override
	public Contrat findById(Integer id) {
		// TODO Auto-generated method stub
		return contratRep.findById(id).orElse(null);
	}

	@Override
	public void save(Contrat aff) {
		// TODO Auto-generated method stub
		contratRep.save(aff);
	}

	@Override
	public List<Contrat> findAll() {
		// TODO Auto-generated method stub
		return contratRep.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		contratRep.deleteById(id);
	}

	@Override
	public List<Client> getClient() {
		// TODO Auto-generated method stub
		return clienRep.findAll();
	}

	@Override
	public List<StatutContrat> getStatut() {
		// TODO Auto-generated method stub
		return statutRep.findAll();
	}

	@Override
	public List<Profil> getProfil() {
		// TODO Auto-generated method stub
		return profilRep.findAll();
	}
}
