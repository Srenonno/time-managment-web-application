package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.Client;

public interface ClientServiceInterface {
	public Client findById(Integer id);
	public void save(Client aff);
	public List<Client> findAll();
	public void delete(Integer id);
}
