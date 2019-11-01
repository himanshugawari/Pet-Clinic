package gawari._himanshu.PetClinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import gawari._himanshu.PetClinic.model.Owner;
import gawari._himanshu.PetClinic.model.Pet;
import gawari._himanshu.PetClinic.model.PetType;
import gawari._himanshu.PetClinic.model.Speciality;
import gawari._himanshu.PetClinic.model.Vet;
import gawari._himanshu.PetClinic.services.OwnerService;
import gawari._himanshu.PetClinic.services.PetService;
import gawari._himanshu.PetClinic.services.PetTypeService;
import gawari._himanshu.PetClinic.services.SpecialitiesService;
import gawari._himanshu.PetClinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialitiesService specialitiesService;

	// Hardcoded
	/*
	 * public DataLoader() { this.ownerService = new OwnerServiceMap();
	 * this.vetService = new VetServiceMap(); }
	 */

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitiesService specialitiesService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if (count == 0)
			loadData();

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");

		PetType savedDogType = petTypeService.save(dog);
		System.out.println("Loaded Dog.......");

		PetType cat = new PetType();
		cat.setName("Cat");

		PetType savedCatType = petTypeService.save(cat);
		System.out.println("Loaded Cat.......");

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");

		Speciality saveRadiology = specialitiesService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");

		Speciality saveSurgery = specialitiesService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");

		Speciality saveDentistry = specialitiesService.save(dentistry);

		System.out.println("Loaded Speciality.......");

		Owner owner1 = new Owner();
		// owner1.setId(1L);
		// Abstract Id Generation from Map Impl
		owner1.setFirstName("Himanshu");
		owner1.setLastName("Gawari");
		owner1.setAddress("Lower Parel");
		owner1.setCity("Mumbai");
		owner1.setTelephone("9082321535");

		Pet himanshusPet = new Pet();
		himanshusPet.setPetType(savedDogType);
		himanshusPet.setOwner(owner1);
		himanshusPet.setBirthDate(LocalDate.now());
		himanshusPet.setName("moti");
		owner1.getPets().add(himanshusPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		// owner2.setId(2L);
		owner2.setFirstName("Atsuko");
		owner2.setLastName("Maeda");
		owner2.setAddress("Akihabara");
		owner2.setCity("Tokyo");
		owner2.setTelephone("9868545495");

		Pet atsukosPet = new Pet();
		atsukosPet.setPetType(savedCatType);
		atsukosPet.setOwner(owner2);
		atsukosPet.setBirthDate(LocalDate.now());
		atsukosPet.setName("inu");
		owner2.getPets().add(atsukosPet);

		ownerService.save(owner2);

		System.out.println("Loaded Owners.......");

		Vet vet1 = new Vet();
		// vet1.setId(1L);
		vet1.setFirstName("Katy");
		vet1.setLastName("Perry");
		vet1.getSpecialities().add(saveRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		// vet2.setId(2L);
		vet2.setFirstName("Mary");
		vet2.setLastName("Elizabeth");
		vet2.getSpecialities().add(saveSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets.......");
	}

}
