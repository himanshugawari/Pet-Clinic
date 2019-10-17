package gawari._himanshu.PetClinic.services;

import java.util.Set;

import gawari._himanshu.PetClinic.model.Pet;

public interface PetService {
	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
