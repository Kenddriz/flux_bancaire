/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;

import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class CustomLabelView extends JLabel{
    
    public CustomLabelView(String text) {
        
        super();
        
        setFont(new java.awt.Font("Tahoma", 0, 14));
        setForeground(new java.awt.Color(153,153,153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setText(text);
        
    }

}
