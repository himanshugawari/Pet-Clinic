package gawari._himanshu.PetClinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	@RequestMapping({ "", "/", "/index", "/owner_index", "/owner_index.html" })
	public String listOwners() {
		return "owners/owner_index";
	}
}
