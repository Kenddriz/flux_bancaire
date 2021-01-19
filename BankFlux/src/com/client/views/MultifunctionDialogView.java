/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;

import com.client.views.dialogs.MultifunctionDialog;

/**
 *
 * @author rcara
 */
public class MultifunctionDialogView {
    private static MultifunctionDialog multifunctionDialog;
    private MultifunctionDialogView() {
        multifunctionDialog = new MultifunctionDialog(new java.awt.Frame());
    }
    public static MultifunctionDialog getInstance() {
        if(multifunctionDialog == null)
            new MultifunctionDialogView();
        return multifunctionDialog;
    }
}
