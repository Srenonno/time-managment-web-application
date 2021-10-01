package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.Profil;

public interface ProfilServiceInterface {
	public void save(Profil pro);
	
	public List<Profil> findAll();
	
	public void delete(Integer id);

	public Profil findById(Integer id);

}
