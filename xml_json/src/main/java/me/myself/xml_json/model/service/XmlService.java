package me.myself.xml_json.model.service;

import java.util.List;

import me.myself.xml_json.model.Person;

public interface XmlService {

	List<Person> parseXml(String filename);
	
	void createXml(String filename, List<Person> persons);
	
}
