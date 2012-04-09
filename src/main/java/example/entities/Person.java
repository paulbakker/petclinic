package example.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

/**
 * Simple JavaBean domain object representing an person.
 *
 * @author Ken Krebs
 */
@Entity
public class Person extends BaseEntity {

    @NotEmpty
	private String firstName;

    @NotEmpty
	private String lastName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



}
