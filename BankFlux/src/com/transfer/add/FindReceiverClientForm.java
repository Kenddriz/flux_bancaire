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
public class FindReceiverClientForm {
    protected HashMap<String, String>input;
    public FindReceiverClientForm() {
        input = new HashMap();
    }
    public void setKeyword(String id) {
        input.put("keyword", id);
    }
        public void setSender(String id) {
        input.put("sender_id", id);
    }
}
