/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;

import com.client.views.dialogs.TransferDialog;

/**
 *
 * @author rcara
 */
public class TransferDialogView {
   public static TransferDialog transferDialog;
   
   private TransferDialogView() {
       transferDialog = new TransferDialog();
   }
   public static TransferDialog getInstance() {
       if(transferDialog == null)
           new TransferDialogView();
       return transferDialog;
   }
}
