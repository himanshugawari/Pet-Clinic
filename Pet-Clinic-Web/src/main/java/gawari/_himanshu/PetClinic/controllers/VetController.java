package gawari._himanshu.PetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

	@RequestMapping({ "/vets", "/vets/index", "/vet_index", "/vet_index.html" })
	public String listVets() {
		return "vets/vet_index";
	}
}
