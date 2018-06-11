package me.myself.xml_json;

import me.myself.xml_json.controller.MainController;
import me.myself.xml_json.view.View;

/**
 * 
 * @author oleksiiubuntu
 */
public class App 
{
    public static void main( String[] args )
    {
    	new MainController(new View()).processUser(args);
    	
    }
}
