package me.myself.xml_json.model.service;

import java.util.List;

import me.myself.xml_json.model.Exchange;

public interface JsonService {

  List<Exchange> parseJson(String filename);
  
  List<Exchange> parseJsonByUrl(String url);
  
  void createJson(String filname, List<Exchange> exchanges);
    
}
