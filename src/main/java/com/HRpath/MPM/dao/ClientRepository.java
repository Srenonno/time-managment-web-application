package com.HRpath.MPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HRpath.MPM.bean.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{

}
