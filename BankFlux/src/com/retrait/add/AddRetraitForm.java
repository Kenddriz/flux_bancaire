/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retrait.add;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class AddRetraitForm {
    
    protected HashMap<String, String>input;
    
    public AddRetraitForm() {
        input = new HashMap();
        setInput("id", "");
        setInput("retrait", "0");
    }
    
    public final void setInput(String k, String v) {
       input.put(k, v);
    }
    
    public final HashMap<String, String> getInput() {
       return input;
    }
}
