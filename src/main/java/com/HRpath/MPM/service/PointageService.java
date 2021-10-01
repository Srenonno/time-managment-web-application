package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.Pointage;
import com.HRpath.MPM.dao.PointageRepository;

@Service
@Transactional
public class PointageService implements PointageServiceInterface{
	@Autowired
	PointageRepository pointageRepo;

	@Override
	public Pointage findById(Integer id) {
		// TODO Auto-generated method stub
		return pointageRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Pointage aff) {
		// TODO Auto-generated method stub
		pointageRepo.save(aff);
	}

	@Override
	public List<Pointage> findAll() {
		// TODO Auto-generated method stub
		return pointageRepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		pointageRepo.deleteById(id);
	}

}
