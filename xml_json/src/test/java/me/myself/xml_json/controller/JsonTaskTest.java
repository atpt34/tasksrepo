package me.myself.xml_json.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import me.myself.xml_json.controller.task.JsonTask;
import me.myself.xml_json.model.Exchange;
import me.myself.xml_json.model.service.JsonService;
import me.myself.xml_json.view.View;

@RunWith(MockitoJUnitRunner.class)
public class JsonTaskTest {
    
    @Mock
    private JsonService service;
    
    private JsonTask task;

    private List<Exchange> exchanges = List.of(
            new Exchange("1", "1", BigDecimal.TEN, "EUR", LocalDate.now()),
            new Exchange("2", "2", BigDecimal.TEN, "CAN", LocalDate.now()),
            new Exchange("0", "0", BigDecimal.TEN, "USD", LocalDate.now()),
            new Exchange("0", "0", BigDecimal.TEN, "PJR", LocalDate.now())
            );
    
    @Before
    public void setup() {
        task = new JsonTask(service, new View());
    }
    
    @Test
    public void testExecute() throws Exception {
        when(service.parseJson(anyString())).thenReturn(exchanges);
        doNothing().when(service).createJson(anyString(), anyList());
        task.execute(anyString());
        verify(service, atLeastOnce()).parseJson(anyString());
    }
    
    @Test
    public void testGetActual() throws Exception {
        List<Exchange> expected = List.of(
                exchanges.get(0), exchanges.get(2));
        assertEquals(expected, JsonTask.getActual(exchanges));
    }
}
