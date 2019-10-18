package gawari._himanshu.PetClinic.services;

import gawari._himanshu.PetClinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
