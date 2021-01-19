/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views.table;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import shared.observing.Observable;
import shared.observing.Observer;

/**
 *
 * @author USER
 */
public class TableModel extends AbstractTableModel implements Observable{
    
    private Object[][] data;
    private final String[] title;
    boolean[] canEdit;
    Class[] types;
    
    private final ArrayList<Observer>observerList;
    public JSONObject client;
    
    public TableModel() {
        super();
        data = new Object[][]{};
        title = new String[]{"N°CHEQUE", "VERSEMENT", "RETRAIT", "DATE DE CREATION", "DERNIERE MODIFICATION", "SUPPRESSION"};
        types = new Class [] {
            java.lang.String.class, 
            java.lang.Integer.class, 
            java.lang.Integer.class, 
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
        };
        canEdit = new boolean [] {false, true, true, false, false, true};
        observerList = new ArrayList();
        client = new JSONObject();
    }
    
    @Override
    public int getRowCount() {
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.title.length;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    @Override
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }
    
    /**
     *
     * @param col
     * @return
     */
    @Override
    public String getColumnName(int col) {
        return this.title[col];
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        if(getValueAt(rowIndex, columnIndex) == null)
            return false;
        
        return canEdit [columnIndex];
    }

    /**
     *
     * @param columnIndex
     * @return
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
    
    public final void setData(JSONObject client) {
        
        this.client = client;
        
        updateObserver();
        
        ArrayList<Object[]>rows = new ArrayList<>();
        
        JSONArray versements = client.getJSONArray("versements");
        for(int i = 0; i < versements.length(); i++) {
            JSONObject versement = versements.getJSONObject(i);
            Object row[] = {
                versement.get("id"), 
                versement.getInt("montant_versement"),
                null,
                versement.get("created_at"),
                versement.get("updated_at"),
               "VERSEMENT"
            };
            rows.add(row);
            
        }
        
        JSONArray retraits = client.getJSONArray("retraits");
        for(int i = 0; i < retraits.length(); i++) {
            JSONObject retrait = retraits.getJSONObject(i);
            Object row[] = {
                retrait.get("id"), 
                null,
                retrait.get("montant_retrait"),
                retrait.get("created_at"),
                retrait.get("updated_at"),
                "RETRAIT"
            };
            rows.add(row);
            
        }
        
        this.data = rows.toArray(new Object[][]{});
    }

    @Override
    public void addObserver(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void updateObserver() {
        observerList.forEach((obs) -> {
            obs.update();
        });
    }

    @Override
    public void delObserver() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
