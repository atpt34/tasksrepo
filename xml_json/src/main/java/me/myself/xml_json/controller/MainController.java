package me.myself.xml_json.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import me.myself.xml_json.controller.task.JsonTask;
import me.myself.xml_json.controller.task.Task;
import me.myself.xml_json.controller.task.XmlTask;
import me.myself.xml_json.model.service.JsonServiceImpl;
import me.myself.xml_json.model.service.XmlServiceImpl;
import me.myself.xml_json.model.service.XmlServiceJaxbImpl;
import me.myself.xml_json.view.View;

public class MainController {

	private static final String XML_REGEX = ".+\\.xml";
	private static final String JSON_REGEX = ".+\\.json";
	
    private View view;
    private final Task defaultTask = s -> view.printMessage("no matching file");
    private final Map<String, Task> tasks;

	public MainController(View view) {
	    this.view = view;
	    tasks = new HashMap<>();
//	    tasks.put(XML_REGEX, new XmlTask(new XmlServiceImpl(), view));
	    tasks.put(XML_REGEX, new XmlTask(new XmlServiceJaxbImpl(), view));
	    tasks.put(JSON_REGEX, new JsonTask(new JsonServiceImpl(), view));
    }

    public MainController(Map<String, Task> tasks, View view) {
        this.tasks = tasks;
        this.view = view;
    }

    public void processUser(String[] args) {
		Stream.of(args)
	        .forEach(arg -> tasks.entrySet()
	                .stream()
//	                .peek(e -> System.out.println(arg))
	                .filter(e -> arg.matches(e.getKey()))
//	                .peek(e -> System.out.println(e))
	                .findFirst()
	                .orElse(Map.entry(arg, defaultTask)).getValue()
	                .execute(arg)
	                );
	}
    
    
}
