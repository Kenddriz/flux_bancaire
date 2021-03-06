/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;



/**
 *
 * @author USER
 */
public class AddClientView extends javax.swing.JPanel{

    /**
     * Creates new form AddClientView
     */
    protected final com.client.add.AddClientService addClientService;
    
    public AddClientView() {
        initComponents();
        addClientService = new com.client.add.AddClientService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        soldField = new javax.swing.JFormattedTextField();
        submitAddClient = new javax.swing.JButton();

        setBackground(new java.awt.Color(43, 78, 95));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nouveau Client", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Rounded MT Bold", 0, 18), new java.awt.Color(204, 204, 255))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1303, 80));
        setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        nameField.setBackground(new java.awt.Color(101, 123, 134));
        nameField.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(204, 204, 255));
        nameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nom complet", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 255))); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });
        add(nameField);

        soldField.setBackground(new java.awt.Color(101, 123, 134));
        soldField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Solde Initiale", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 255))); // NOI18N
        soldField.setForeground(new java.awt.Color(204, 204, 255));
        soldField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        soldField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        soldField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soldField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                soldFieldKeyReleased(evt);
            }
        });
        add(soldField);

        submitAddClient.setBackground(new java.awt.Color(101, 123, 134));
        submitAddClient.setForeground(new java.awt.Color(204, 204, 255));
        submitAddClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/add.png"))); // NOI18N
        submitAddClient.setText("Ajouter le client");
        submitAddClient.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 92, 101), 1, true));
        submitAddClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitAddClient.setFocusPainted(false);
        submitAddClient.setPreferredSize(new java.awt.Dimension(50, 23));
        submitAddClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitAddClientMouseClicked(evt);
            }
        });
        add(submitAddClient);
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        switch(evt.getKeyCode()){
            case 10:
                addClientService.submitAddClient();
                break;
            default:
                addClientService.setNom(nameField.getText());
                break;
        }
    }//GEN-LAST:event_nameFieldKeyReleased

    private void submitAddClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitAddClientMouseClicked
        addClientService.submitAddClient();
    }//GEN-LAST:event_submitAddClientMouseClicked

    private void soldFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soldFieldKeyReleased
        // TODO add your handling code here:
        switch(evt.getKeyCode()){
            case 10:
                addClientService.submitAddClient();
                break;
            default:
                addClientService.setSolde(soldField.getText().trim());
                break;
        }
    }//GEN-LAST:event_soldFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField nameField;
    private javax.swing.JFormattedTextField soldField;
    private javax.swing.JButton submitAddClient;
    // End of variables declaration//GEN-END:variables

}
