package com.HRpath.MPM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.HRpath.MPM.service.ContratServiceInterface;
import com.HRpath.MPM.service.ProfilServiceInterface;

@Controller
public class PrestataireController {
	@Autowired
	private ProfilServiceInterface profilRep;
	@Autowired
	private ContratServiceInterface contratRep;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("Profils", profilRep.findAll());
		model.addAttribute("Contrats", contratRep.findAll());
		return "Calendrier";
	}
	
}
