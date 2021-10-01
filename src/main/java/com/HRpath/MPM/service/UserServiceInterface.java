package com.HRpath.MPM.service;

import java.util.List;

import com.HRpath.MPM.bean.User;

public interface UserServiceInterface {

	
	public void save(User user);
	public User findById(Integer id);
	public List<User> findAllById(List<Integer> id);
	public List <User> ListManager();
	public List<User> ListAdmin();
	public List<User> ListPrestataire();
	public List<User> ListAffecter(Integer id);
	public List<User> ListNonAffecterManager();
	public User findByEmail(String email);


}
