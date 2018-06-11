package me.myself.xml_json.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType (XmlAccessType.FIELD)
public class PersonList {

	@XmlElement(name="person")
	private List<Person> persons;
	
	public PersonList() {
	}
	
	public PersonList(List<Person> persons) {
		this.persons = persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Person> getPersons() {
		return persons;
	}
}
