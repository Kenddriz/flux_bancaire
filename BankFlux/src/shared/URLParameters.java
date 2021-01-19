/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.util.Map;

/**
 *
 * @author USER
 */
public class URLParameters {
    private final Map<String, String>input;
    public URLParameters(Map<String, String>input) {
        this.input = input;
    }
    public  String build() {
        StringBuilder params = new StringBuilder();
        for(Map.Entry<String, String>param: input.entrySet()){
            if(params.length() > 0)
                params.append("&");
            params.append(param.getKey());
            params.append("=");
            params.append(param.getValue());
        }
        return params.toString();
    }
}
