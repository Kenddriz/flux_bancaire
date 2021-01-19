/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.add;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONArray;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class AddTransfertService extends AddTransfertForm {
    
    public AddTransfertService() {
        super();
    }

    public JSONArray submitAddTransfert() {
        
        JSONArray clients = new JSONArray();
        /*Add search year*/
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(input);
        ArrayList response =  shared.APIRequest.send("add_transfert", params.build().getBytes());
        
        if((Integer)response.get(0) == 200) { 
            clients = new JSONArray(response.get(1).toString());
        }
       return clients;
    }
}
