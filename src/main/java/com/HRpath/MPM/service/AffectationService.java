package com.HRpath.MPM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HRpath.MPM.bean.Affectation;
import com.HRpath.MPM.dao.AffectationRepository;

@Service
@Transactional
public class AffectationService implements AffectationServiceInterface {

	@Autowired
	AffectationRepository affectationRepository;

	@Override
	public Affectation findById(Integer id) {

		return affectationRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Affectation aff) {
		// TODO Auto-generated method stub
		affectationRepository.save(aff);

	}

	@Override
	public void saveAll(List<Affectation> aff) {
		// TODO Auto-generated method stub
		affectationRepository.saveAll(aff);
	}
}
