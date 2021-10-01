package com.HRpath.MPM.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HRpath.MPM.bean.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
