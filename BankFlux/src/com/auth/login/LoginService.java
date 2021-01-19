/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.login;
import org.json.JSONObject;

import shared.RequestConfig;
import shared.URLParameters;

/**
 *
 * @author USER
 */
public class LoginService extends LoginForm {
   
    public LoginService() {
        super();
    };
   
    public void submitLogin() {
       
        URLParameters params = new URLParameters(this.input);
        java.util.ArrayList response = shared.APIRequest.send("login", params.build().getBytes());
  
        if((Integer)response.get(0) == 200) {
            RequestConfig.token = (new JSONObject(response.get(1).toString())).getString("token");
        } 
   }
}
