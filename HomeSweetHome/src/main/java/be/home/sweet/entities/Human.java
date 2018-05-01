package be.home.sweet.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Human {

	@Id
	@GeneratedValue()
	private Long id;
	private String firstName;
	private String lastName;
	
	public Human() {
		this.firstName="";
		this.lastName="";
	}
	
	public Human(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return this.id.toString() + " " + this.firstName + " " + this.lastName;
	}
	
	
}
