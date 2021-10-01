package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.Client;
import com.HRpath.MPM.dao.ClientRepository;

@Service
@Transactional
public class ClientService implements ClientServiceInterface{

	@Autowired
	ClientRepository clientRepo;
	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return clientRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Client aff) {
		// TODO Auto-generated method stub
		clientRepo.save(aff);
		
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientRepo.deleteById(id);
	}
	
	
	

}
