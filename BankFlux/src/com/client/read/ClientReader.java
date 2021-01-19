/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.read;

/**
 *
 * @author rcara
 */
public class ClientReader {
    private static ClientReadService clientReadService;
    private ClientReader() {
        clientReadService = new ClientReadService();
    }
        public static ClientReadService getInstance() {
        if(clientReadService == null)
            new ClientReader();
        return clientReadService;
    }
}
