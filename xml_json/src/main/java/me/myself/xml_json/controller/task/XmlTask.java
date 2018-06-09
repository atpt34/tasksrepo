package me.myself.xml_json.controller.task;

import java.util.List;
import java.util.stream.Collectors;

import me.myself.xml_json.model.Person;
import me.myself.xml_json.model.service.XmlService;
import me.myself.xml_json.view.View;

public class XmlTask implements Task {

	private XmlService parseService;
    private View view;

	public XmlTask(XmlService parseService, View view) {
		this.parseService = parseService;
		this.view = view;
	}

	@Override
	public void execute(XmlTask this, String filename) {
		List<Person> list = parseService.parseXml(filename);
		List<Person> special = list.stream().filter(p -> p.getCash() > 10000).collect(Collectors.toList());
		view.printMessage(special.toString());
		parseService.createXml("output.xml", special);
	}

}
