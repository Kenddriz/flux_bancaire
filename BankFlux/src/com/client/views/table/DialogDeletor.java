/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.views.table;

import com.retrait.delete.DeleteRetraitService;
import com.versement.delete.DeleteVersementService;

/**
 *
 * @author USER
 */
public class DialogDeletor extends javax.swing.JDialog {

    /**
     * Creates new form DialogDeletor
     * @param parent
     * @param modal
     */
    private final DeleteVersementService deleteVersementService;
    private final DeleteRetraitService deleteRetraitService;
    public String flux;
    public String id;
    
    public DialogDeletor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        deleteVersementService = new DeleteVersementService();
        deleteRetraitService = new DeleteRetraitService();
        
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/banking.png")));
        setLocationRelativeTo(parent);

    }

    private void deleteFlux(String flux, String id, String mode) {
        
        switch(flux) {
            case "VERSEMENT":
                deleteVersementService.setInput("id", id);
                deleteVersementService.setInput("mode", mode);
                deleteVersementService.submitDeleteVersement();
                break;
            case "RETRAIT":
                deleteRetraitService.setInput("id", id);
                deleteRetraitService.setInput("mode", mode);
                deleteRetraitService.submitDeleteRetrait();
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cancelMessageLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        closeModeDialogButton0 = new javax.swing.JButton();
        CancelModeButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        closeModeDialogButton1 = new javax.swing.JButton();
        deleteModeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(526, 200));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setBackground(new java.awt.Color(50, 69, 78));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Mode 1", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 204, 255)), "Annulation du flux", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("En cliquant sur annuler, vous aller");
        jPanel1.add(jLabel1);

        cancelMessageLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancelMessageLabel.setForeground(new java.awt.Color(204, 204, 255));
        cancelMessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelMessageLabel.setText("soustraire 4000Ar à la solde actuelle");
        jPanel1.add(cancelMessageLabel);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        closeModeDialogButton0.setBackground(new java.awt.Color(50, 69, 78));
        closeModeDialogButton0.setForeground(new java.awt.Color(204, 204, 255));
        closeModeDialogButton0.setText("Fermer");
        closeModeDialogButton0.setBorder(null);
        closeModeDialogButton0.setContentAreaFilled(false);
        closeModeDialogButton0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeModeDialogButton0.setFocusPainted(false);
        closeModeDialogButton0.setOpaque(true);
        closeModeDialogButton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeModeDialogButton0MouseClicked(evt);
            }
        });
        jPanel3.add(closeModeDialogButton0);

        CancelModeButton.setBackground(new java.awt.Color(50, 69, 78));
        CancelModeButton.setForeground(new java.awt.Color(204, 102, 0));
        CancelModeButton.setText("Annuler");
        CancelModeButton.setBorder(null);
        CancelModeButton.setContentAreaFilled(false);
        CancelModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelModeButton.setFocusPainted(false);
        CancelModeButton.setOpaque(true);
        CancelModeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelModeButtonMouseClicked(evt);
            }
        });
        jPanel3.add(CancelModeButton);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(43, 78, 78));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Mode 2", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 204, 255)), "Ecrasement du flux", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("En cliquant sur supprimer, vous aller");
        jPanel2.add(jLabel4);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("tout simplement effacer le flux.");
        jPanel2.add(jLabel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        closeModeDialogButton1.setBackground(new java.awt.Color(43, 78, 78));
        closeModeDialogButton1.setForeground(new java.awt.Color(204, 204, 255));
        closeModeDialogButton1.setText("Fermer");
        closeModeDialogButton1.setBorder(null);
        closeModeDialogButton1.setContentAreaFilled(false);
        closeModeDialogButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeModeDialogButton1.setFocusPainted(false);
        closeModeDialogButton1.setOpaque(true);
        closeModeDialogButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeModeDialogButton1MouseClicked(evt);
            }
        });
        jPanel4.add(closeModeDialogButton1);

        deleteModeButton.setBackground(new java.awt.Color(43, 78, 78));
        deleteModeButton.setForeground(new java.awt.Color(204, 102, 0));
        deleteModeButton.setText("Supprimer");
        deleteModeButton.setBorder(null);
        deleteModeButton.setContentAreaFilled(false);
        deleteModeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteModeButton.setFocusPainted(false);
        deleteModeButton.setOpaque(true);
        deleteModeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteModeButtonMouseClicked(evt);
            }
        });
        jPanel4.add(deleteModeButton);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeModeDialogButton0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeModeDialogButton0MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeModeDialogButton0MouseClicked

    private void CancelModeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelModeButtonMouseClicked
        // TODO add your handling code here:
        this.deleteFlux(flux, id, "cancel");
        dispose();
    }//GEN-LAST:event_CancelModeButtonMouseClicked

    private void closeModeDialogButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeModeDialogButton1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeModeDialogButton1MouseClicked

    private void deleteModeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteModeButtonMouseClicked
        // TODO add your handling code here
        this.deleteFlux(flux, id, "delete");
        dispose();
    }//GEN-LAST:event_deleteModeButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CancelModeButton;
    public javax.swing.JLabel cancelMessageLabel;
    public javax.swing.JButton closeModeDialogButton0;
    public javax.swing.JButton closeModeDialogButton1;
    public javax.swing.JButton deleteModeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
