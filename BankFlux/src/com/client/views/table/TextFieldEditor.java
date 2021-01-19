/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views.table;

import com.retrait.update.UpdateRetraitService;
import com.versement.update.UpdateVersementService;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class TextFieldEditor extends DefaultCellEditor{
    
    public UpdateVersementService updateVersementService;
    public UpdateRetraitService updateRetraitService;
    
    public JTextField field;
    public String id;
    public String columnName;
    
    public TextFieldEditor() {
        
    //Par défaut, ce type d'objet travaille avec un JCheckBox
        super(new JCheckBox());
        //On crée à nouveau un bouton
        updateVersementService = new UpdateVersementService();
        updateRetraitService = new UpdateRetraitService();
        field = new JTextField();
        field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                /**When typing to enter*/
                if(evt.getKeyCode() == 10) {
                    switch(columnName) {
                        case "VERSEMENT":
                             updateVersementService.setInput("id", id); 
                             updateVersementService.setInput("montant_versement", field.getText());
                             updateVersementService.submitUpdateVersement();
                             break;
                        case "RETRAIT":
                             updateRetraitService.setInput("id", id); 
                             updateRetraitService.setInput("montant_retrait", field.getText());
                             updateRetraitService.submitUpdateRetrait();
                             break;
                    }                  
                }
               /**to allow updating data client list*/
            }
        });
    } 
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object
        value, boolean isSelected, int row, int column) {
        
        columnName = table.getColumnName(column);
        id = String.valueOf(table.getValueAt(row, 0));
        field.setText((value == null) ? "" : value.toString());
        
        return field;
    
    }
}
