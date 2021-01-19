/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.delete;

import java.util.HashMap;

/**
 *
 * @author rcara
 */
public class DeleteClientForm {
    protected HashMap<String, String>input; 
    public DeleteClientForm() {
        input = new HashMap();
    }
    public void setClient(String id) { input.put("id", id); }
}
