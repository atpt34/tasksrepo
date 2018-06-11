package me.myself.xml_json.model;

import java.util.Objects;

import javax.xml.bind.annotation.*;


/**
 * 
 * @author Oleksii_Tretinichenko
 * 
 *
 */
@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

	@XmlAttribute(name="id")
	private int id;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="address")
	private String address;
	
	@XmlElement(name="cash")
	private int cash;
	
	@XmlElement(name="education")
	private String education;
	
	public Person() {
	}
	
	public Person(int id, String name, String address, int cash, String education) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.cash = cash;
		this.education = education;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = Objects.requireNonNull(address);
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cash;
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cash != other.cash)
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s, address=%s, cash=%s, education=%s]", id, name, address, cash,
				education);
	}
	
	
}
