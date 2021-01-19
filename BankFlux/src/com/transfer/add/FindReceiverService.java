/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.add;

import com.client.read.ClientReader;
import java.util.ArrayList;
import org.json.JSONObject;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class FindReceiverService extends FindReceiverClientForm{
    
    public FindReceiverService() {
        super();
    }
    
    public JSONObject submitFindOneClient() {
        JSONObject client = null;
        input.put("year", ClientReader.getInstance().getYear());
        URLParameters params = new URLParameters(this.input);
        ArrayList response = shared.APIRequest.send("find_one_client?" + params.build(), null);
            
        if((Integer)response.get(0) == 200) {
            client = new JSONObject(response.get(1).toString());
        }
        return client;
    }
}
