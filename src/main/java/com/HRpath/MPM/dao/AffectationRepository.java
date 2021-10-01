package com.HRpath.MPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HRpath.MPM.bean.Affectation;

public interface AffectationRepository extends JpaRepository<Affectation, Integer>{

	

}
