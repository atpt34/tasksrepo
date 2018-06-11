package me.myself.xml_json.controller.task;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import me.myself.xml_json.model.Exchange;
import me.myself.xml_json.model.service.JsonService;
import me.myself.xml_json.view.View;

public class JsonTask implements Task {

    private JsonService service;
    private View view;

    public JsonTask(JsonService service, View view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute(String filename) {

//        List<Exchange> exchanges = new ArrayList<>();
//        exchanges.add(new Exchange("one", "sldfj", BigDecimal.valueOf(29.29238), "casdf", LocalDate.of(2018, 5, 29)));
//        exchanges.add(new Exchange("two", "sdf", BigDecimal.valueOf(39.29238), "acsdf", LocalDate.of(2018, 5, 30)));
//        exchanges.add(new Exchange("three", "sdf", BigDecimal.valueOf(9.29238), "acsdf", LocalDate.of(2018, 6, 9)));
//        service.createJson(filename, exchanges);
        
        List<Exchange> list = service.parseJson(filename);
        view.printMessage(list.toString());
        
        Set<String> actualExchanges = Set.of("USD", "RUB", "EUR");
        List<Exchange> actual = list.stream()
//        						.filter(e -> e.getRate().compareTo(BigDecimal.valueOf(25)) > 0)
        						.filter(e -> actualExchanges.contains(e.getCc()))
        						.collect(Collectors.toList());
        view.printMessage(actual.toString());
        
        service.createJson("output.json", actual);
        
        List<Exchange> list2 = service.parseJson("output.json");
        view.printMessage(list2.toString());
        
    }

    
}
