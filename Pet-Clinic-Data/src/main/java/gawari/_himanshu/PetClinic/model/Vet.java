package gawari._himanshu.PetClinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	private Set<Speciality> specialities = new HashSet<>();

	public Set<Speciality> getSpecialities() {
		if (null == specialities || specialities.isEmpty())
			return new HashSet<>();
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
}
