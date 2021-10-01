package com.HRpath.MPM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HRpath.MPM.bean.User;
import com.HRpath.MPM.dao.UserRepository;


@Service
@Transactional
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository userRep;

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRep.save(user);

	}
	

	

	@Override
	public List<User> ListAdmin() {
		// TODO Auto-generated method stub
		return userRep.ListAdmin();
	}

	@Override
	public List<User> ListAffecter(Integer id) {
		// TODO Auto-generated method stub
		return userRep.ListAffecter(id);
	}

	@Override
	public List<User> ListNonAffecterManager() {
		// TODO Auto-generated method stub
		return userRep.ListNonAffecterManager();
	}


	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userRep.findById(id).orElse(null);
	}


	@Override
	public List<User> findAllById(List<Integer> id) {
		// TODO Auto-generated method stub
		return  userRep.findAllById(id);
	}


	


	@Override
	public List<User> ListPrestataire() {
		// TODO Auto-generated method stub
		return userRep.ListPrestataire();
	}




	@Override
	public List<User> ListManager() {

		return userRep.ListManager();
	}




	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRep.findByEmail(email).orElse(null);
	}




	

}
