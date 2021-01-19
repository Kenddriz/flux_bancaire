/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views.table;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author USER
 */
public class LabelRenderer implements TableCellRenderer{
    private final JLabel label;
    public LabelRenderer() {
        label = new JLabel();
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/delete_flux.png")));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param isFocus
     * @param row
     * @param col
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value, 
            boolean isSelected, boolean isFocus, int row, int col)
    {
        return label;
    }
}
