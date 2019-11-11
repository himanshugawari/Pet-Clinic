package gawari._himanshu.PetClinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import gawari._himanshu.PetClinic.model.Owner;
import gawari._himanshu.PetClinic.repositories.OwnerRepository;
import gawari._himanshu.PetClinic.repositories.PetRepository;
import gawari._himanshu.PetClinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	static final Long ownerId = 1L;

	static final String lastName = "Gawari";

	@InjectMocks
	OwnerSDJpaService ownerSDJpaService;

	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;

	Owner returnOwner;

	@BeforeEach
	public void setUp() throws Exception {
		returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();
	}

	@Test
	public void testFindAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		returnOwnerSet.add(Owner.builder().id(1L).build());
		returnOwnerSet.add(Owner.builder().id(2L).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

		Set<Owner> owners = ownerSDJpaService.findAll();

		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	public void testFindById() {
		when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

		Owner owner = ownerSDJpaService.findById(ownerId);

		assertNotNull(owner);
	}

	@Test
	public void testFindByIdNotFound() {
		when(ownerRepository.findById(any())).thenReturn(Optional.empty());

		Owner owner = ownerSDJpaService.findById(ownerId);

		assertNull(owner);
	}

	@Test
	public void testSave() {
		Owner ownerToSave = Owner.builder().id(ownerId).build();

		when(ownerRepository.save(any())).thenReturn(returnOwner);

		Owner savedOwner = ownerSDJpaService.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	public void testDelete() {
		ownerSDJpaService.delete(returnOwner);
		assertEquals(0, ownerSDJpaService.findAll().size());
		verify(ownerRepository).delete(any());
	}

	@Test
	public void testDeleteById() {
		ownerSDJpaService.delete(ownerSDJpaService.findById(ownerId));
		assertEquals(0, ownerSDJpaService.findAll().size());
		// verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	public void testFindByLastName() {
		// Owner returnOwner = Owner.builder().id(ownerId).lastName(lastName).build();

		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

		Owner gawari = ownerSDJpaService.findByLastName(lastName);

		assertEquals(lastName, gawari.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

}
