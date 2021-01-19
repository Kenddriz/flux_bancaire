/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;
import java.util.Iterator;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class RequestErrors{
     
    public static String messages(String error) {
        
        JSONObject errors = new JSONObject(error);
        
        String message = "";
        Iterator<String>it = errors.keySet().iterator();
        
        while(it.hasNext()){
            String key = it.next();
            try {
                /*If errors is JONARRAY*/
                Iterator<Object>itErrorMessages = errors.getJSONArray(key).iterator();

                while(itErrorMessages.hasNext())
                    message += itErrorMessages.next() + " - ";  
                
            } catch(org.json.JSONException ex) {
                /*If errors is JONOBJECT*/
                message += errors.getString(key)+ " - ";
            } finally {
                /*Remove if dash is at message end*/
                int lengh = message.length();
                if(message.charAt(lengh - 2) == '-')
                    message = message.substring(0, lengh - 3);
            }

        }
        
        return message;
    }
}
