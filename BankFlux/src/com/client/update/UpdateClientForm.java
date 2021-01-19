/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.update;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class UpdateClientForm {
   public HashMap<String, String> input;
   public UpdateClientForm() {
       input = new HashMap();
   }
   
   public void set(String k, String v) {
       input.put(k, v);
   }
   public String get(String k) {
       return input.get(k);
   }
   
}
