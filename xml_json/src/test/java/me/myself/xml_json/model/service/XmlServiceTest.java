package me.myself.xml_json.model.service;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.myself.xml_json.model.Person;

public class XmlServiceTest {

    private static final String RESOURCES = "src/resources/";
	private static final String EMPTY_XML = RESOURCES + "empty.xml";
	private static final String TEST_XML = RESOURCES + "test.xml";
	private static final String NOSUCH_XML = RESOURCES + "nosuchfile.xml";
	
	private static final String WITHOUT_ROOT_XML = RESOURCES + "withoutroot.xml";
	private static final String VALID_REARRAGEMENT_XML = RESOURCES + "validrearrange.xml";
	private static final String INVALID_REARRAGEMENT_XML = RESOURCES + "invalidrearrange.xml";
	private static final String INVALID_ELEMENT_XML = RESOURCES + "invalidelem.xml";
	private static final String INVALID_ELEMENT_NAME_XML = RESOURCES + "invalidelemname.xml";
	
	private static final List<Person> EMPTY_LIST_PERSONS = Collections.emptyList();
	private static final List<Person> EMPTY_PERSONS = List.of(new Person(), new Person(), new Person());
	
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
	
	@Test(expected = RuntimeException.class)
    public void testParseWithoutRoot() throws Exception {
        xmlService.parseXml(WITHOUT_ROOT_XML);
        fail();
    }
	
	@Test(expected = RuntimeException.class)
    public void testParseInvalidRearrange() throws Exception {
        xmlService.parseXml(INVALID_REARRAGEMENT_XML);
        fail();
    }
	
	@Test
    public void testParseInvalidElement() throws Exception {
        List<Person> parseXml = xmlService.parseXml(INVALID_ELEMENT_XML);
        assertEquals("", parseXml.get(0).getName());
    }
	
	@Test(expected = RuntimeException.class)
    public void testParseInvalidElementName() throws Exception {
        xmlService.parseXml(INVALID_ELEMENT_NAME_XML);
        fail();
    }
	
	@Test
    public void testParseValidRearrage() throws Exception {
        xmlService.parseXml(VALID_REARRAGEMENT_XML);
    }
	
	@Test(expected = RuntimeException.class)
    public void testParseNoSuchFile() throws Exception {
        xmlService.parseXml(NOSUCH_XML);
        fail();
    }
	
	@Test(expected = NullPointerException.class)
	public void testCreateNulls() throws Exception {
		xmlService.createXml(null, EMPTY_PERSONS);
		xmlService.createXml(EMPTY_XML, null);
		xmlService.createXml(null, null);
		fail();
	}
	
	@Test
	public void testCreateEmptyListPersons() throws Exception {
		xmlService.createXml(TEST_XML, EMPTY_LIST_PERSONS);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCreateEmptyPersons() throws Exception {
		xmlService.createXml(TEST_XML, EMPTY_PERSONS);
		fail();
	}
}
