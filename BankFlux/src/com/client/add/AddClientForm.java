/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.add;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class AddClientForm {
  protected HashMap<String, String>input;
  
  public AddClientForm() {
     this.input = new  HashMap();
     this.input.put("nom", "");
     this.input.put("solde", "0");
  }
 public void setNom(String nom) {
     this.input.put("nom", nom);
 }
 
  public void setSolde(String solde) {
     this.input.put("solde", solde);
 }
}
