package me.myself.xml_json.model.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import me.myself.xml_json.model.Exchange;

public class JsonServiceImpl implements JsonService {

    private static final String DATE_PATTERN = "dd.MM.yyyy";
    
    private static class LocalDateSerializer implements JsonSerializer<LocalDate> {
        @Override
        public JsonElement serialize(LocalDate date, Type arg1, JsonSerializationContext arg2) {
            return new JsonPrimitive(DateTimeFormatter.ofPattern(DATE_PATTERN).format(date));
        }
    }
    
    private static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonElement elem, Type arg1, JsonDeserializationContext arg2)
                throws JsonParseException {
            return LocalDate.parse(elem.getAsString(), DateTimeFormatter.ofPattern(DATE_PATTERN));
        }
    }
    
    @Override
    public List<Exchange> parseJson(String filename) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateDeserializer()).create();
        File file = new File(filename);
        
//        Exchange exchange = gson.fromJson(
//                "{\"r030\":933,\"txt\":\"Білоруський рубль\",\"rate\":13.12192,\"cc\":\"BYN\",\"exchangedate\":\"09.06.2018\"}",
//                Exchange.class);
//        System.out.println(exchange);
        
        try {
            Exchange[] exchanges = gson.fromJson(new BufferedReader(new FileReader(file)), Exchange[].class);
            return new ArrayList<>(Arrays.asList(exchanges));
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createJson(String filename, List<Exchange> exchanges) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer()).create();
        String json = gson.toJson(exchanges.toArray());
        System.out.println(json);
        try (FileWriter out = new FileWriter(filename)) {
            out.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
