package me.myself.xml_json.model.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import me.myself.xml_json.model.Person;

public class XmlServiceImpl implements XmlService {

	private static final String EDUCATION = "education";
    private static final String CASH = "cash";
    private static final String ADDRESS = "address";
    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String PERSON = "person";
    private static final String ROOT = "root";

    public List<Person> parseXml(String filename) {
		try {
		    List<Person> list = new ArrayList<>();
			SAXReader reader = new SAXReader();
			File file = new File(filename);
			Document document = reader.read(file);
			Element root = document.getRootElement();
			for (Iterator<Element> it = root.elementIterator(PERSON); it.hasNext();) {
			    Element elem = it.next();
			    int id = Integer.parseInt(elem.attributeValue(ID));
		        String name = elem.element(NAME).getStringValue();
                String address = elem.element(ADDRESS).getStringValue();
                int cash = Integer.parseInt(elem.element(CASH).getStringValue());
                String education = elem.element(EDUCATION).getStringValue();
                list.add(new Person(id, name, address, cash, education));
		    }
			return list;
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

    @Override
    public void createXml(String filename, List<Person> persons) {
        Document document = createDocument(persons);
        try (FileWriter out = new FileWriter(filename)) {
            document.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Document createDocument(List<Person> persons) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement(ROOT);
        for (Person person : persons) {
            root.addElement(PERSON)
                    .addAttribute(ID, Integer.toString(person.getId()))
                    .addElement(NAME).addText(person.getName())
                    .addElement(ADDRESS).addText(person.getAddress())
                    .addElement(EDUCATION).addText(person.getEducation())
                    .addElement(CASH).addText(Integer.toString(person.getCash()));
        }
        return document;
    }
    

}
