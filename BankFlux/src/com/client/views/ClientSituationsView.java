/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class ClientSituationsView extends javax.swing.JPanel{

    public JSONObject client;
    
    public ClientSituationsView(JSONObject client) {
        initComponents();
        this.client = client;
        
        numAccoutLabel.setText("N°Compte : " + client.get("id"));
        nameLabel.setText(client.getString("nom"));
        soldLabel.setText("Somme : " + client.get("solde") + " Ar");
        
        DeleteClientDialogView.getInstance().setClient(client.getString("nom"), client.getString("id"));
        DeleteClientDialogView.getInstance().setLocationRelativeTo(null);
        
        TransferDialogView.getInstance().setLocationRelativeTo(null);
        
        MultifunctionDialogView.getInstance().setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identifiantPanel = new javax.swing.JPanel();
        numAccoutLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        soldePanel = new javax.swing.JPanel();
        soldLabel = new javax.swing.JLabel();
        soldeButttons = new javax.swing.JPanel();
        VersementButton = new javax.swing.JButton();
        RetraitButton = new javax.swing.JButton();
        TransfertButton = new javax.swing.JButton();
        deleteClientLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 47, 64));
        setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Etat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 153, 153))); // NOI18N

        identifiantPanel.setBackground(new java.awt.Color(35, 47, 64));
        identifiantPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Identité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        identifiantPanel.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        numAccoutLabel.setForeground(new java.awt.Color(153, 153, 153));
        numAccoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numAccoutLabel.setText("N°Compte :");
        identifiantPanel.add(numAccoutLabel);

        nameLabel.setForeground(new java.awt.Color(153, 153, 153));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/edit.png"))); // NOI18N
        nameLabel.setText("Inconnu");
        nameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameLabelMouseClicked(evt);
            }
        });
        identifiantPanel.add(nameLabel);

        soldePanel.setBackground(new java.awt.Color(35, 47, 64));
        soldePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Solde actuelle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153))); // NOI18N
        soldePanel.setLayout(new java.awt.GridLayout(2, 1));

        soldLabel.setForeground(new java.awt.Color(153, 153, 153));
        soldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soldLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/edit.png"))); // NOI18N
        soldLabel.setText("Montant : 0 Ar");
        soldLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        soldLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soldLabelMouseClicked(evt);
            }
        });
        soldePanel.add(soldLabel);

        soldeButttons.setBackground(new java.awt.Color(38, 46, 58));
        soldeButttons.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        VersementButton.setBackground(new java.awt.Color(58, 67, 80));
        VersementButton.setForeground(new java.awt.Color(153, 153, 153));
        VersementButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/credit-card.png"))); // NOI18N
        VersementButton.setText("versement");
        VersementButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 67, 80), 1, true));
        VersementButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VersementButton.setFocusPainted(false);
        VersementButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VersementButtonMouseClicked(evt);
            }
        });
        soldeButttons.add(VersementButton);

        RetraitButton.setBackground(new java.awt.Color(58, 67, 80));
        RetraitButton.setForeground(new java.awt.Color(153, 153, 153));
        RetraitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/withdraw.png"))); // NOI18N
        RetraitButton.setText("retrait");
        RetraitButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 67, 80), 1, true));
        RetraitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RetraitButton.setFocusPainted(false);
        RetraitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RetraitButtonMouseClicked(evt);
            }
        });
        soldeButttons.add(RetraitButton);

        TransfertButton.setBackground(new java.awt.Color(58, 67, 80));
        TransfertButton.setForeground(new java.awt.Color(153, 153, 153));
        TransfertButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/transfer.png"))); // NOI18N
        TransfertButton.setText("Transfert");
        TransfertButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(58, 67, 80), 1, true));
        TransfertButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransfertButton.setFocusPainted(false);
        TransfertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransfertButtonMouseClicked(evt);
            }
        });
        soldeButttons.add(TransfertButton);

        soldePanel.add(soldeButttons);

        deleteClientLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteClientLabel.setForeground(new java.awt.Color(153, 153, 153));
        deleteClientLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteClientLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/remove-client0.png"))); // NOI18N
        deleteClientLabel.setText("Supprimer");
        deleteClientLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteClientLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteClientLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteClientLabel)
                .addContainerGap())
            .addComponent(identifiantPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(soldePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deleteClientLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(identifiantPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soldePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameLabelMouseClicked
        // TODO add your handling code here:
        MultifunctionDialogView.getInstance().open("nom", client);
    }//GEN-LAST:event_nameLabelMouseClicked

    private void soldLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soldLabelMouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        MultifunctionDialogView.getInstance().open("solde", client);
    }//GEN-LAST:event_soldLabelMouseClicked

    private void VersementButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VersementButtonMouseClicked
        // TODO add your handling code here
        MultifunctionDialogView.getInstance().open("versement", client);
    }//GEN-LAST:event_VersementButtonMouseClicked

    private void RetraitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetraitButtonMouseClicked
       
        MultifunctionDialogView.getInstance().open("retrait", client);
    }//GEN-LAST:event_RetraitButtonMouseClicked

    private void deleteClientLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteClientLabelMouseClicked
        // TODO add your handling code here:
         DeleteClientDialogView.getInstance().setVisible(true);
    }//GEN-LAST:event_deleteClientLabelMouseClicked

    private void TransfertButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransfertButtonMouseClicked
        // TODO add your handling code here:
        TransferDialogView.getInstance().setSender(client);
        TransferDialogView.getInstance().setVisible(true);
    }//GEN-LAST:event_TransfertButtonMouseClicked
 
    /**Choose specific operation according to dialog title*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RetraitButton;
    private javax.swing.JButton TransfertButton;
    private javax.swing.JButton VersementButton;
    private javax.swing.JLabel deleteClientLabel;
    private javax.swing.JPanel identifiantPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel numAccoutLabel;
    private javax.swing.JLabel soldLabel;
    private javax.swing.JPanel soldeButttons;
    private javax.swing.JPanel soldePanel;
    // End of variables declaration//GEN-END:variables

}
