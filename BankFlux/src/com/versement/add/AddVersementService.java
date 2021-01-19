/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.versement.add;

import com.client.read.ClientReader;
import org.json.JSONObject;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class AddVersementService extends AddVersementForm {
   
    public AddVersementService() {
        super();
    }
    public void submitAddVersment() {
        JSONObject addedClientVersement = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        java.util.ArrayList response = shared.APIRequest.send("add_versement", params.build().getBytes());
        
        if((Integer)response.get(0) == 200) {
            addedClientVersement = new JSONObject(response.get(1).toString());
        }
       ClientReader.getInstance().updateClientList(addedClientVersement);
    } 
}
