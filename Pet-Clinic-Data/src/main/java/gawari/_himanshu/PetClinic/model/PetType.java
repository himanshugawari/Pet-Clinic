package gawari._himanshu.PetClinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("serial")
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

	@Column(name = "name")
	private String name;

}
