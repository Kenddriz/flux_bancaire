/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.read;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class ClientReadForm {
    
   protected HashMap<String, String> input;
   
   public ClientReadForm() {
       input = new HashMap();
       input.put("keyword", "");
       input.put("year", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
   }
   public void setKeyword(String keyword) {
       input.put("keyword", keyword);
   }
   public void setYear(String year) {
       input.put("year", year);
   }
    public String getYear() {
       return input.get("year");
   }
}
