package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.Profil;
import com.HRpath.MPM.dao.ProfilRepository;
@Service
@Transactional
public class ProfilService implements ProfilServiceInterface{

	@Autowired
	ProfilRepository profilRep;
	@Override
	public void save(Profil pro) {
		// TODO Auto-generated method stub
		profilRep.save(pro);
		
	}
	@Override
	public List<Profil> findAll() {
		// TODO Auto-generated method stub
		return profilRep.findAll();
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		profilRep.deleteById(id);
	}
	@Override
	public Profil findById(Integer id) {
		// TODO Auto-generated method stub
		return profilRep.findById(id).orElse(null);
	}
	

}
