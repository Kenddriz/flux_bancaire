/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import shared.observing.Observable;
import shared.observing.Observer;

/**
 *
 * @author USER
 */
public class RequestConfig implements Observable{

    /**
     *api url
     */
    private String BASE_URL = "http://127.0.0.1/gestion_bancaire/public/api/";
    private String url_destination;
    private byte[] data;
    private String method;
    public static String token;
    public static String message;
    
    private final ArrayList<Observer>observerList;
    
    public RequestConfig() {
        BASE_URL = "http://127.0.0.1/gestion_bancaire/public/api/";
        url_destination = null;
        data = null;
        token = null;
        message = "";
        observerList = new ArrayList();
    }
    
    public ArrayList send() {
        
       ArrayList response =  new ArrayList();
       HttpURLConnection connection = null;
       
       try {
            URL url = new URL(this.BASE_URL + this.url_destination);

            connection = (HttpURLConnection)url.openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod(method);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "UTF-8");
            connection.setUseCaches(false);
            
            if(method.equals("POST")) {
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Length", Integer.toString(data.length));
                connection.getOutputStream().write(data);
            }
            
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            Integer responseCode = connection.getResponseCode();            
            String responseData = responseCode < 299 ?
                new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine() : 
                new BufferedReader(new InputStreamReader(connection.getErrorStream())).readLine();
            
            response.add(responseCode);
            
            switch(responseCode) {
                case 200:
                    response.add(responseData);
                    setMessage(connection.getResponseMessage());
                    break;
                case 201:
                    setMessage(RequestErrors.messages(responseData));
                    break;
                default:
                    message = responseData;
                    break;
            }
                     
       } catch (MalformedURLException ex) {
           response.add(201);
           setMessage("URL d'api mal formé");
       } catch (IOException ex) {
           response.add(201);
           setMessage("Erreur de connexion au serveur des données");
       }finally {
            if(connection!=null)
               connection.disconnect();
       }
       return response;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    public void setURL(String url_destination) {
        this.url_destination = url_destination;
    }
    
    public void setMessage(String msg) {
        message = msg;
        updateObserver();
    }
//Observer Methods
    @Override
    public void addObserver(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void updateObserver() {
        observerList.forEach((obs)->{
            obs.update();
        });
    }

    @Override
    public void delObserver() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
