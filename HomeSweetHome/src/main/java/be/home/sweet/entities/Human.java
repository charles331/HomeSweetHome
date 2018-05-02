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
	private Boolean god;
	
	
	public Human(String firstName,String lastName,Boolean god) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.god=god;
	}

	public Human() {
		// TODO Auto-generated constructor stub
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
		
	
	public Boolean getGod() {
		return god;
	}

	public void setGod(Boolean god) {
		this.god = god;
	}

	@Override
	public String toString() {
		return this.id.toString() + " " + this.firstName + " " + this.lastName + " isGod=" + this.god.toString();
	}
	
	
}
