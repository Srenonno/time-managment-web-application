package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.Affectation;

public interface AffectationServiceInterface {

	public Affectation findById(Integer id);
	public void save(Affectation aff);
	
	public void saveAll(List<Affectation> aff);


}
