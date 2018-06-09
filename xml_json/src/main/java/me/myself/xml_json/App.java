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
    
    public static int returnArray()[] {
    	int[] res = new int[2];
    	res[0] = -1;
    	res[1] = 13;
		return res;
    }
}
