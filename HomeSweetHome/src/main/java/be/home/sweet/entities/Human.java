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
	private String gender;
	
	public Human() {
		this.firstName="";
		this.lastName="";
		this.god=false;
		this.gender="";
	}
	
	public Human(String firstName,String lastName,Boolean god,String gender) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.god=god;
		this.gender=gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return this.id.toString() + " " + this.firstName + " " + this.lastName + " isGod=" + this.god.toString() + " " + this.gender;
	}
	
	
}
