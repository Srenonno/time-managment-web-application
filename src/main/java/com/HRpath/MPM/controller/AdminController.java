package com.HRpath.MPM.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.HRpath.MPM.bean.Affectation;
import com.HRpath.MPM.bean.Client;
import com.HRpath.MPM.bean.Contrat;
import com.HRpath.MPM.bean.Profil;
import com.HRpath.MPM.bean.StatutContrat;
import com.HRpath.MPM.bean.User;
import com.HRpath.MPM.service.AffectationServiceInterface;
import com.HRpath.MPM.service.ClientServiceInterface;
import com.HRpath.MPM.service.ContratServiceInterface;
import com.HRpath.MPM.service.ProfilServiceInterface;
import com.HRpath.MPM.service.RoleService;
import com.HRpath.MPM.service.StatutServiceInterface;
import com.HRpath.MPM.service.UserServiceInterface;

@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	UserServiceInterface userRep;

	@Autowired
	RoleService roleRep;

	@Autowired
	AffectationServiceInterface affectationRep;

	@Autowired
	PasswordEncoder bcryp;
	@Autowired
	ClientServiceInterface clientRep;
	
	@Autowired
	ProfilServiceInterface profilRep;
	
	@Autowired
	StatutServiceInterface statutRep;
	
	@Autowired
	ContratServiceInterface contratRep;

	@PostMapping("/AjouterEmployer")
	public String AjouterEmployer(Model model, @ModelAttribute User user) {

		user.setPassword(bcryp.encode(user.getPassword()));
		userRep.save(user);
		return "redirect:Enregistrer?success";
	}

	@RequestMapping(value = "/list/Manager", method = RequestMethod.GET)
	
	public String listManager(Model model) {
		model.addAttribute("User", userRep.ListManager());
		model.addAttribute("PresNonAff", userRep.ListNonAffecterManager());
		return "ListManager";
	}

	@RequestMapping(value = "/list/Prestataire", method = RequestMethod.GET)

	public ModelAndView listPrestataire(Model model) {
		ModelAndView m = new ModelAndView("ListPrestataire");
		m.getModelMap().addAttribute("User", userRep.ListPrestataire());
		return m;
	}

	@RequestMapping(value = "/list/Admin", method = RequestMethod.GET)
	public ModelAndView listAdmin(Model model) {
		ModelAndView m = new ModelAndView("ListAdmin");
		m.getModelMap().addAttribute("User", userRep.ListAdmin());
		return m;
	}

	@PostMapping("/FinAffectation")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody void FinAffectation(@RequestParam(name = "id") Integer id) {
		try {
			Affectation aff = affectationRep.findById(id);

			aff.setDateFin(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			affectationRep.save(aff);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/Enregistrer")
	public String home(Model model) {
		model.addAttribute("roles", roleRep.findAll());
		return "Enregistrer";

	}

	@GetMapping("/Enregistrer/{id}")
	public String homeUpdate(@PathVariable Integer id, Model model) {
		
		model.addAttribute("roles", roleRep.findAll());
		model.addAttribute("update", userRep.findById(id));

		return "redirect:?update";
	}

	@PostMapping("/AjouterAffectation")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody void AjouterAffectation(@RequestParam(value = "idUser[]") List<Integer> idUser,
			@RequestParam Integer idManager) {
		List<User> listUser = userRep.findAllById(idUser);
		User manager = userRep.findById(idManager);

		List<Affectation> listAff = new ArrayList<Affectation>();
		for (User u : listUser) {
			Affectation Af = new Affectation(manager, u, new java.sql.Date(Calendar.getInstance().getTime().getTime()),
					null);
			System.out.println(Af.toString());
			listAff.add(Af);
		}
		affectationRep.saveAll(listAff);

	}

	@GetMapping("/GetUser")

	public ResponseEntity<List<User>> getUser(Model model, @RequestParam(name = "id") Integer id) {

		List<User> user = userRep.ListAffecter(id);

		if (user == null)
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	@PostMapping("/AjouterClient")
	public String AjouterClient(Model model, @ModelAttribute Client client) {
		clientRep.save(client);
		
		return "redirect:/admin/list/client?success";
	}
	@GetMapping("/list/client")
	public String ListClient(Model model) {
		model.addAttribute("Client",clientRep.findAll());
		return "ListClient";
	}
	@PostMapping("/supprimerClient")
	public String supprimerClient(Model model,@RequestParam Integer id) {
		clientRep.delete(id);
		
		return "redirect:/admin/list/client";
	}
	
	@GetMapping("/list/profil")
	public String ListProfil(Model model) {
		model.addAttribute("Profils",profilRep.findAll());
		
		return "listprofil";

	}
	@PostMapping("/AjouterProfil")
	public String AjouterProfil(Model model,@RequestParam String profil,@RequestParam(required=false) Integer id) {
		
		if(id==null) {
			profilRep.save(new Profil(profil));
		}else {
			Profil prof=profilRep.findById(id);
			prof.setProfil(profil);
			profilRep.save(prof);
		}
		return "redirect:/admin/list/profil";

	}
	@PostMapping("/supprimerProfil")
	public String supprimerProfil(Model model,@RequestParam Integer id) {
		System.out.println("aaaaaaaaaaaaaa\n\n\n\n\n"+id);
		profilRep.delete(id);
		
		return "redirect:/admin/list/profil";
	}
	
	
	@GetMapping("/list/statut")
	public String ListStatut(Model model) {
		model.addAttribute("Statuts",statutRep.findAll());
		
		return "liststatut";

	}
	@PostMapping("/AjouterStatut")
	public String AjouterStatut(Model model,@RequestParam String Statut,@RequestParam(required=false) Integer id) {
		
		if(id==null) {
		statutRep.save(new StatutContrat(Statut));
		}else {
			StatutContrat stat= statutRep.findById(id);
			stat.setStatut(Statut);
			statutRep.save(stat);
		}
		return "redirect:/admin/list/statut";

	}
	@PostMapping("/supprimerStatut")
	public String supprimerStatut(Model model,@RequestParam Integer id) {
		System.out.println("aaaaaaaaaaaaaa\n\n\n\n\n"+id);
		statutRep.delete(id);
		return "redirect:/admin/list/statut";
	}

	@GetMapping("/list/contrat")
	public String VueContrat(Model model) {
		model.addAttribute("Clients",contratRep.getClient());
		model.addAttribute("Contrats",contratRep.findAll());

		return "listContrat";

	}
	@PostMapping("/AjouterContrat")
	public String AjouterContrat(Model model, @ModelAttribute Contrat contrat) {
		
		if(contrat.getId()==null) {
			contratRep.save(contrat);
			return "redirect:/admin/list/contrat?success";
		}else {
			contratRep.save(contrat);
			return "redirect:/admin/list/contrat?update";
		}
		
	}
	
	@PostMapping("/supprimerContrat")
	public String supprimerContrat(Model model,@RequestParam Integer id) {
		contratRep.delete(id);
		return "redirect:/admin/list/contrat";
	}

	

}
