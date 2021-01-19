/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.login;

import java.util.HashMap;

/**
 *
 * @author USER
 */
public class LoginForm {
  
  protected HashMap<String, String> input;
  
  public LoginForm() {
      this.input = new HashMap();
      this.input.put("username",  "");
      this.input.put("password",  "");
  }
  
  public void setUsername(String username) {
      this.input.put("username",  username);
  }
  
   public void setPassword(String password) {
      this.input.put("password",  password);
  } 
  
}
