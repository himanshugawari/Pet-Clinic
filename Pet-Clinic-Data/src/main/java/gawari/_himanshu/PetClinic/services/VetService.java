package gawari._himanshu.PetClinic.services;

import java.util.Set;

import gawari._himanshu.PetClinic.model.Vet;

public interface VetService {
	Vet findById(Long id);

	Vet save(Vet owner);

	Set<Vet> findAll();
}
