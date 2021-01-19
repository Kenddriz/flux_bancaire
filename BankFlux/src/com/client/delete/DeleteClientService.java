/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.delete;

import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;
import com.client.read.ClientReader;
/**
 *
 * @author rcara
 */
public class DeleteClientService extends DeleteClientForm {
    
    public DeleteClientService() {
       super();
    }
    public void submitDeleteClient() {
       String deletedClient = null;
       URLParameters params = new URLParameters(this.input);
       ArrayList response =  shared.APIRequest.send("delete_client?" + params.build(), null);
        if((Integer)response.get(0) == 200) 
            deletedClient = new JSONObject(response.get(1).toString()).getString("id");
        
        ClientReader.getInstance().deleteClient(deletedClient);
    }
    
}
