package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.StatutContrat;
import com.HRpath.MPM.dao.StatutRepository;

@Service
@Transactional
public class StatutService implements StatutServiceInterface{

	@Autowired
	StatutRepository statutRep;
	@Override
	public void save(StatutContrat statut) {
		// TODO Auto-generated method stub
		statutRep.save(statut);
	}

	@Override
	public List<StatutContrat> findAll() {
		// TODO Auto-generated method stub
		return statutRep.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		statutRep.deleteById(id);
	}

	@Override
	public StatutContrat findById(Integer id) {
		// TODO Auto-generated method stub
		return statutRep.findById(id).orElse(null);
	}

}
