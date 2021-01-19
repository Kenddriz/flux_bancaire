/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views.table;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author USER
 */
public class ButtonEditor extends DefaultCellEditor {
    public JButton button;
    private int row = -1;
    public DialogDeletor dialogDeletor;
    JTable table;
    
    public ButtonEditor() {
        super(new JCheckBox());
        button = new JButton("Mode ?");
        button.setBackground(new java.awt.Color(75, 92, 101));
        button.setForeground(new java.awt.Color(255, 204, 0));
        button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(72, 99, 113)));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        
        dialogDeletor = new DialogDeletor(null, true);
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //((TableModel)table.getModel()).client.get("nom")
                String msg = dialogDeletor.flux.equals("VERSEMENT") ? 
                    "soustraire " + table.getValueAt(row, 1) + " ariary de " : 
                    "rajouter " + table.getValueAt(row, 2) + " ariary à ";
                msg += "la solde actuelle";
                dialogDeletor.cancelMessageLabel.setText(msg);
                
                msg = "Mode de suppression - " + dialogDeletor.flux + " [" + dialogDeletor.id + "] - ";
                msg += ((TableModel)table.getModel()).client.get("nom");
                dialogDeletor.setTitle(msg);
                dialogDeletor.setVisible(true);
            } 
        });
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object
        value, boolean isSelected, int row, int column) {
        
        this.table = table;
        this.row = row;
        dialogDeletor.flux = value.toString();
        
        dialogDeletor.id = String.valueOf(table.getValueAt(row, 0));
        
        String notification = "Choix aux modes ";
        notification += " de suppression du " + value.toString().toLowerCase();
        notification += " N°" + dialogDeletor.id;
        shared.APIRequest.getInstance().setMessage(notification);
        shared.APIRequest.getInstance().setMessage(notification);
        
        return button;
    }
}
