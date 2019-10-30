package gawari._himanshu.PetClinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gawari._himanshu.PetClinic.model.Owner;
import gawari._himanshu.PetClinic.model.PetType;
import gawari._himanshu.PetClinic.model.Vet;
import gawari._himanshu.PetClinic.services.OwnerService;
import gawari._himanshu.PetClinic.services.PetTypeService;
import gawari._himanshu.PetClinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	// Hardcoded
	/*
	 * public DataLoader() { this.ownerService = new OwnerServiceMap();
	 * this.vetService = new VetServiceMap(); }
	 */

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");

		PetType savedDogType = petTypeService.save(dog);
		System.out.println("Loaded Dog.......");

		PetType cat = new PetType();
		cat.setName("Cat");

		PetType savedCatType = petTypeService.save(cat);
		System.out.println("Loaded Cat.......");

		Owner owner1 = new Owner();
		// owner1.setId(1L);
		// Abstract Id Generation from Map Impl
		owner1.setFirstName("Himanshu");
		owner1.setLastName("Gawari");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		// owner2.setId(2L);
		owner2.setFirstName("Atsuko");
		owner2.setLastName("Maeda");

		ownerService.save(owner2);

		System.out.println("Loaded Owners.......");

		Vet vet1 = new Vet();
		// vet1.setId(1L);
		vet1.setFirstName("Katy");
		vet1.setLastName("Perry");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		// vet2.setId(2L);
		vet2.setFirstName("Mary");
		vet2.setLastName("Elizabeth");

		vetService.save(vet2);

		System.out.println("Loaded Vets.......");

	}

}
