package com.HRpath.MPM.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.HRpath.MPM.bean.Contrat;
import com.HRpath.MPM.bean.Pointage;
import com.HRpath.MPM.bean.Profil;
import com.HRpath.MPM.bean.User;
import com.HRpath.MPM.service.ContratServiceInterface;
import com.HRpath.MPM.service.PointageServiceInterface;
import com.HRpath.MPM.service.ProfilServiceInterface;
import com.HRpath.MPM.service.UserServiceInterface;

import groovyjarjarcommonscli.ParseException;

@RequestMapping("/manager")
@RestController

public class ManagerController {

	@Autowired
	PointageServiceInterface pointageRep;

	@Autowired
	ProfilServiceInterface profilRep;

	@Autowired
	UserServiceInterface userRep;

	@Autowired
	ContratServiceInterface contratRep;

	@GetMapping("/getEvent")
	public @ResponseBody List<Pointage> GetEvents() {

		try {
			return pointageRep.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	@PostMapping("/CreateEvent")
	public @ResponseBody Integer CreateEvents(Model model, @RequestParam String title, @RequestParam String description,
			@RequestParam Integer profils, @RequestParam Integer contrats, @RequestParam("start") String start,
			@RequestParam("end") String end, @RequestParam String username, @RequestParam Integer id,
			@RequestParam String color) throws ParseException {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date date = sdf.parse(end);
			Timestamp theEnd = new Timestamp(date.getTime());
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee\n\n\n\n\n\n" + id);
			java.util.Date date1 = sdf.parse(start);
			Timestamp theStrat = new Timestamp(date1.getTime());
			User us = userRep.findByEmail(username);
			Profil prof = profilRep.findById(profils);
			Contrat cont = contratRep.findById(contrats);
			if (id == null) {
				Pointage p = new Pointage(title, description, theStrat, theEnd, color, prof, cont, us);
				pointageRep.save(p);
				return p.getId();
			} else {
				Pointage p = pointageRep.findById(id);
				p.setContrats(cont);
				p.setIntitule(title);
				p.setDateTimeDebut(theStrat);
				p.setDateTimeFin(theEnd);
				p.setDescription(description);
				p.setProfils(prof);
				p.setThemeColor(color);
				p.setUser(us);
				pointageRep.save(p);
				return p.getId();

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
