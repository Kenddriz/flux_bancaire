/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.add;

import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;
import com.client.read.ClientReader;
/**
 *
 * @author USER
 */
public class AddClientService extends AddClientForm {
    
    public AddClientService() {
        super();
    }

    public void submitAddClient() {
       JSONObject addedClient = null;
       /*Add search year*/
       input.put("year", ClientReader.getInstance().getYear());
       URLParameters params = new URLParameters(input);
       ArrayList response =  shared.APIRequest.send("create_client", params.build().getBytes());

        if((Integer)response.get(0) == 200) { 
            addedClient = new JSONObject(response.get(1).toString());
        }
       
        ClientReader.getInstance().addClientList(addedClient);
    }
    
}
