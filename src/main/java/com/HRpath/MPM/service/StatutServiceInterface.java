package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.StatutContrat;

public interface StatutServiceInterface {

	public void save(StatutContrat statut);
	
	public List<StatutContrat> findAll();
	
	public void delete(Integer id);

	public StatutContrat findById(Integer id);

}
