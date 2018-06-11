package me.myself.xml_json.model.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import me.myself.xml_json.model.Person;
import me.myself.xml_json.model.PersonList;

public class XmlServiceJaxbImpl implements XmlService {

	@Override
	public List<Person> parseXml(String filename) {
		
		try {
			JAXBContext jc = JAXBContext.newInstance(PersonList.class);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        PersonList persons = (PersonList) unmarshaller.unmarshal(new File(filename));
	        return persons.getPersons();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void createXml(String filename, List<Person> persons) {
		try {
			JAXBContext jc = JAXBContext.newInstance(PersonList.class);
	        Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(new PersonList(persons), new File(filename));
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
