package gawari._himanshu.PetClinic.services;

import java.util.Set;

import gawari._himanshu.PetClinic.model.Owner;

public interface OwnerService {
	Owner findById(Long id);

	Owner save(Owner owner);

	Owner findByLastName(String lastName);

	Set<Owner> findAll();

}
