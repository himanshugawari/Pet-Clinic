package gawari._himanshu.PetClinic.model;

import java.io.Serializable;
//Map based Implementaion
public class BaseEntity implements Serializable {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
