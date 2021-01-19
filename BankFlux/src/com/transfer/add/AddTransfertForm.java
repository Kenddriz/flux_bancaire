/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.add;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class AddTransfertForm {
    
    protected HashMap<String, String> input;
    
    public AddTransfertForm() {
        
       input = new HashMap();
       input.put("sender_id", "0");
       input.put("receiver_id", "0");
       input.put("montant_transfert", "0");
    }
    public void setSender(String id) {
       input.put("sender_id", id);
    }
    public void setReceiver(String id) {
       input.put("receiver_id", id);
    }
    public void setMontant(String m) {
       input.put("montant_transfert", m);
    }
    public String getSender() {return input.get("sender_id");}
    public String getReceiver() {return input.get("receiver_id");}
}
