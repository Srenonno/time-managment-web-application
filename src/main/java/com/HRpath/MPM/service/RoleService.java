package com.HRpath.MPM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRpath.MPM.bean.Role;
import com.HRpath.MPM.dao.RoleRepository;

@Service
@Transactional
public class RoleService implements RoleServiceInterface{

	@Autowired
	RoleRepository roleRep;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRep.findAll();
	}

}
