package gawari._himanshu.PetClinic.repositories;

import org.springframework.data.repository.CrudRepository;

import gawari._himanshu.PetClinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
