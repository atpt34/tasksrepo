package me.myself.xml_json.model.service;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.myself.xml_json.model.Person;

public class XmlServiceTest {

	private static final String EMPTY_XML = "empty.xml";
	private static final String TEST_XML = "test.xml";
	private static final List<Person> EMPTY_PERSONS = Collections.emptyList();
	private static final List<Person> PERSONS = List.of(new Person(), new Person(), new Person());
	
	
	private XmlService xmlService;
	
	@Before
	public void setUp() {
		xmlService = new XmlServiceImpl();
	}
	
	@Test(expected = NullPointerException.class)
	public void testParseNullFilename() throws Exception {
		xmlService.parseXml(null);
		fail();
	}
	
	@Test(expected = RuntimeException.class)
	public void testParseEmptyFile() throws Exception {
		xmlService.parseXml(EMPTY_XML);
		fail();
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateNullFilename() throws Exception {
		xmlService.createXml(null, PERSONS);
		xmlService.createXml(EMPTY_XML, null);
		xmlService.createXml(null, null);
		fail();
	}
	
	@Test
	public void testCreateEmptyPersons() throws Exception {
		xmlService.createXml(TEST_XML, EMPTY_PERSONS);
	}
	
	@Test
	public void testCreateNotEmptyPersons() throws Exception {
		xmlService.createXml(TEST_XML, PERSONS);
	}
}
