/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.versement.update;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;


/**
 *
 * @author USER
 */
public class UpdateVersementService extends UpdateVersementForm {
    
    public UpdateVersementService() {
       super();
   }
   public void submitUpdateVersement() {
       
        JSONObject updatedClientVersement = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        ArrayList response = shared.APIRequest.send("update_versement", params.build().getBytes());
      
        if((Integer)response.get(0) == 200) {
            updatedClientVersement = new JSONObject(response.get(1).toString());
        }
        ClientReader.getInstance().updateClientList(updatedClientVersement);
   }
}
