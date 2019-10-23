package gawari._himanshu.PetClinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gawari._himanshu.PetClinic.services.VetService;

@Controller
public class VetController {

	private final VetService vetService;

	@Autowired
	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/index", "/vet_index", "/vet_index.html" })
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/vet_index";
	}
}
