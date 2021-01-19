/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.versement.delete;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;


/**
 *
 * @author USER
 */
public class DeleteVersementService extends DeleteVersementForm{

    public DeleteVersementService() {
         super();
    }
   public void submitDeleteVersement() {
       
        JSONObject deletedClientVersement = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        ArrayList response = shared.APIRequest.send("delete_versement?" + params.build(), null);
        if((Integer)response.get(0) == 200) {
            deletedClientVersement = new JSONObject(response.get(1).toString());
        }
        ClientReader.getInstance().updateClientList(deletedClientVersement);
   }
}
