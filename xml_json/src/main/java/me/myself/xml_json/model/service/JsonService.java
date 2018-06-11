package me.myself.xml_json.model.service;

import java.util.List;

import me.myself.xml_json.model.Exchange;

public interface JsonService {

  List<Exchange> parseJson(String filename);
  
  void createJson(String filname, List<Exchange> exchanges);
    
}
