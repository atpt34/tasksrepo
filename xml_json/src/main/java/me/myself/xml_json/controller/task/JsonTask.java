package me.myself.xml_json.controller.task;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import me.myself.xml_json.model.Exchange;
import me.myself.xml_json.model.service.JsonService;
import me.myself.xml_json.view.View;

public class JsonTask implements Task {

    private static final String OUTPUT_JSON = "src/resources/output.json";
    
    private JsonService service;
    private View view;

    public JsonTask(JsonService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute(String filename) {

        List<Exchange> list = service.parseJson(filename);

        view.printMessage(list.toString());
        
        List<Exchange> actual = getActual(list);
        view.printMessage(actual.toString());
        
        service.createJson(OUTPUT_JSON, actual);
        
        List<Exchange> list2 = service.parseJson(OUTPUT_JSON);
        view.printMessage(list2.toString());
        
    }

    public static List<Exchange> getActual(List<Exchange> list) {
        Set<String> actualExchanges = Set.of("USD", "RUB", "EUR");
        List<Exchange> actual = list.stream()
        						.filter(e -> actualExchanges.contains(e.getCc()))
        						.collect(Collectors.toList());
        return actual;
    }

    
}
