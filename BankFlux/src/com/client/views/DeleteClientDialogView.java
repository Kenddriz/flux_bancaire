/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;

import com.client.views.dialogs.DeleteClientDialog;

/**
 *
 * @author rcara
 */
public class DeleteClientDialogView {
   public static DeleteClientDialog deleteClientDialog;
   
   private DeleteClientDialogView() {
       deleteClientDialog = new DeleteClientDialog();
   }
   public static DeleteClientDialog getInstance() {
       if(deleteClientDialog == null)
           new DeleteClientDialogView();
       return deleteClientDialog;
   }   
}
