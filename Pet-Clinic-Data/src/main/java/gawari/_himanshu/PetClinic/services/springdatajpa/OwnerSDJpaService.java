package gawari._himanshu.PetClinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import gawari._himanshu.PetClinic.model.Owner;
import gawari._himanshu.PetClinic.repositories.OwnerRepository;
import gawari._himanshu.PetClinic.repositories.PetRepository;
import gawari._himanshu.PetClinic.repositories.PetTypeRepository;
import gawari._himanshu.PetClinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	@Autowired
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		// owners.addAll((Collection<? extends Owner>) ownerRepository.findAll());
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		/*
		 * if (optionalOwner.isPresent()) { return ownerRepository.findById(id).get(); }
		 * else { return null; }
		 */

		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return ownerRepository.findByLastName(lastName);
	}

}
