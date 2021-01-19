/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.update;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class UpdateClientService extends UpdateClientForm {
    
   public UpdateClientService() {
       super();
   }
   
   public void submitUpdateClient() {
       
        JSONObject updatedClient = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        ArrayList response = shared.APIRequest.send("update_client", params.build().getBytes());
      
        if((Integer)response.get(0) == 200)
            updatedClient = new JSONObject(response.get(1).toString());
        
        ClientReader.getInstance().updateClientList(updatedClient);
   }
}
