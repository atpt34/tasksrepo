package me.myself.xml_json.model.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import me.myself.xml_json.model.Exchange;

public class JsonServiceTest {

    private JsonService service;
    
    @Before
    public void setUp() {
        service = new JsonServiceImpl();
    }
    
    @Test
    public void testParseJsonByUrl() throws Exception {
      List<Exchange> list = service.parseJsonByUrl("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
      assertTrue(!list.isEmpty());
      assertNotNull(list.get(0));
      assertEquals(list.get(0).getExchangeDate(), LocalDate.now());
    }
    
}
