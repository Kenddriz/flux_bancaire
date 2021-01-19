/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

/**
 *
 * @author USER
 */
public class APIRequest {
  
    private static RequestConfig request;
    
    private APIRequest() {
        request = new RequestConfig();
    }
    public static RequestConfig getInstance() {
        if(request == null)
            new APIRequest();
        return request;
    }
    
    public static java.util.ArrayList send (String url_destination, byte[] data) {
        request = getInstance();
        request.setMethod(data == null ? "GET" : "POST");
        request.setData(data);
        request.setURL(url_destination);
        return request.send();
    }
}
