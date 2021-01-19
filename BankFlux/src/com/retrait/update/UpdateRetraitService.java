/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retrait.update;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class UpdateRetraitService extends UpdateRetraitForm{
    
       public UpdateRetraitService() {
       super();
   }
   public void submitUpdateRetrait() {
       
        JSONObject updatedClientRetrait = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        ArrayList response = shared.APIRequest.send("update_retrait", params.build().getBytes());
      
        if((Integer)response.get(0) == 200) {
            updatedClientRetrait = new JSONObject(response.get(1).toString());
        }
        ClientReader.getInstance().updateClientList(updatedClientRetrait);
   }

}
