/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.read;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import shared.URLParameters;
import shared.observing.Observer;

/**
 *
 * @author USER
 */
public class ClientReadService extends ClientReadForm implements shared.observing.Observable{
    
    private JSONArray clientList;
    private final ArrayList<Observer> clientSituationListObserver;
    
    public ClientReadService() {
        super();
        clientList = new JSONArray();
        clientSituationListObserver = new ArrayList<>();
    }
    
    public void submitSearchClient() {
        
        URLParameters params = new URLParameters(this.input);
        ArrayList response = shared.APIRequest.send("search_client?" + params.build(), null);
            
        if((Integer)response.get(0) == 200) {
            clientList = new JSONArray(response.get(1).toString());
            updateObserver();
        }
    }
    public JSONArray clientList() {
        return clientList;
    }
    
    public void addClientList(JSONObject client) {
        if(client != null) {
            clientList.put(client);
            /**Update each component using clientList*/
            updateObserver();
        }
    }
    
    public void updateClientList(JSONObject client) {
        if(client == null)
            return;
        boolean found = false;
        for(int i = 0; i < clientList.length(); i++) {
            if(clientList.getJSONObject(i).getString("id").equals(client.getString("id"))) 
            {
                clientList.remove(i);
                JSONArray clients = new JSONArray();
                clients.put(client);
                clients.putAll(clientList);
                clientList = clients;
                found = true;
                updateObserver();
                break;
            }
        }
        if(!found)
            addClientList(client);
    }
    public void deleteClient(String id) {
        for(int i = 0; i < clientList.length(); i++) {
            if(clientList.getJSONObject(i).getString("id").equals(id)) 
            {
                clientList.remove(i);
                updateObserver();
                break;
            }
        }   
    }
    @Override
    public void addObserver(Observer obs) {
        clientSituationListObserver.add(obs);
    }

    @Override
    public void updateObserver() {
        clientSituationListObserver.forEach((obs) -> {
                obs.update();
        }); 
    }

    @Override
    public void delObserver() {
        this.clientSituationListObserver.clear();
    }
}
