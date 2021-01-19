/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.cancel;

import java.util.HashMap;

/**
 *
 * @author rcara
 */
public class CancelTransfertForm {
   protected HashMap<String, String> input; 
   public CancelTransfertForm() {
       input = new HashMap();
   }
   public void setTransfert(String id) {
       input.put("transfer_id", id);
   }
}
