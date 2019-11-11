package gawari._himanshu.PetClinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gawari._himanshu.PetClinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;

	final Long ownerId = 1L;

	final String lastName = "Gawari";

	@BeforeEach
	public void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	/*
	 * @Test public void testOwnerServiceMap() { fail("Not yet implemented"); }
	 */

	@Test
	public void testFindAll() {
		Set<Owner> own = ownerServiceMap.findAll();
		assertEquals(1L, own.size());
	}

	@Test
	public void testFindByIdLong() {
		Owner o = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, o.getId());
	}

	@Test
	public void testSaveExistingOwner() {
		Long id = 2L;
		Owner oo = Owner.builder().id(id).build();
		Owner savedOwner = ownerServiceMap.save(oo);
		assertEquals(id, savedOwner.getId());
	}

	@Test
	public void testSaveNoIdOwner() {
		Owner saveOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(saveOwner);
		assertNotNull(saveOwner.getId());
	}

	@Test
	public void testDeleteByIdLong() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void testDeleteOwner() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void testFindByLastName() {
		Owner gawari = ownerServiceMap.findByLastName(lastName);
		assertNotNull(gawari);
		assertEquals(ownerId, gawari.getId());
	}

	@Test
	public void testFindByLastNameNotFound() {
		Owner gawari = ownerServiceMap.findByLastName("foo");
		assertNull(gawari);
	}

}
