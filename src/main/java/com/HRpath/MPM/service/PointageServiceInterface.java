package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.Pointage;

public interface PointageServiceInterface {

	public Pointage findById(Integer id);
	public void save(Pointage aff);
	public List<Pointage> findAll();
	public void delete(Integer id);
}
