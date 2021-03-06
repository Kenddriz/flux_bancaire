/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auth.view;

import com.auth.login.LoginService;
import java.util.ArrayList;
import shared.observing.Observer;
/**
 *
 * @author USER
 */
public class AuthView extends javax.swing.JPanel implements shared.observing.Observable {

    public final LoginService loginService;
    private ArrayList<Observer> observerList = new ArrayList<>();
    /**
     * Creates new form Auth
     */
    public AuthView() {
        loginService = new LoginService();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Auth2Panel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        Auth2TitleLabel = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        Auth1Panel = new javax.swing.JPanel();
        auth1Label = new javax.swing.JLabel();

        Auth2Panel.setBackground(new java.awt.Color(186, 79, 84));
        Auth2Panel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        Auth2Panel.setPreferredSize(new java.awt.Dimension(325, 350));
        Auth2Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameField.setBackground(new java.awt.Color(186, 79, 84));
        usernameField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nom d'utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        usernameField.setName("usernameField"); // NOI18N
        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameFieldKeyReleased(evt);
            }
        });
        Auth2Panel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 200, 50));

        passwordField.setBackground(new java.awt.Color(186, 79, 84));
        passwordField.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mot de passe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        passwordField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        passwordField.setName("passwordField"); // NOI18N
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });
        Auth2Panel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 200, 50));

        passwordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/auth/view/images/lock.png"))); // NOI18N
        Auth2Panel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, 50));

        usernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/auth/view/images/user.png"))); // NOI18N
        Auth2Panel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 50));

        Auth2TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Auth2TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        Auth2TitleLabel.setText("AUTHENTIFICATION");
        Auth2Panel.add(Auth2TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 200, 30));

        connectButton.setBackground(new java.awt.Color(186, 79, 84));
        connectButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        connectButton.setForeground(new java.awt.Color(255, 255, 255));
        connectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/login.png"))); // NOI18N
        connectButton.setText("Connexion");
        connectButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        connectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        connectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                connectButtonMouseClicked(evt);
            }
        });
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        Auth2Panel.add(connectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 130, 40));

        Auth1Panel.setBackground(new java.awt.Color(74, 31, 61));
        Auth1Panel.setPreferredSize(new java.awt.Dimension(325, 350));

        auth1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/auth/view/images/log-in.png"))); // NOI18N

        javax.swing.GroupLayout Auth1PanelLayout = new javax.swing.GroupLayout(Auth1Panel);
        Auth1Panel.setLayout(Auth1PanelLayout);
        Auth1PanelLayout.setHorizontalGroup(
            Auth1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Auth1PanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(auth1Label)
                .addGap(32, 32, 32))
        );
        Auth1PanelLayout.setVerticalGroup(
            Auth1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Auth1PanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(auth1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Auth1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Auth2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Auth1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Auth2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyReleased
        loginService.setUsername(usernameField.getText());
        if(evt.getKeyCode() == 10) {
            loginService.submitLogin();
            updateObserver();
        }
    }//GEN-LAST:event_usernameFieldKeyReleased

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        loginService.setPassword(passwordField.getText());
        if(evt.getKeyCode() == 10) {
            loginService.submitLogin();
            updateObserver();
        }
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void connectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_connectButtonMouseClicked
        loginService.submitLogin();
        //**if connected condition*
        updateObserver();
        
    }//GEN-LAST:event_connectButtonMouseClicked

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectButtonActionPerformed

    /*Observation**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Auth1Panel;
    private javax.swing.JPanel Auth2Panel;
    private javax.swing.JLabel Auth2TitleLabel;
    private javax.swing.JLabel auth1Label;
    private javax.swing.JButton connectButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addObserver(Observer obs) {
        this.observerList.add(obs);
    }

    @Override
    public void updateObserver() {
            this.observerList.forEach((obs) -> {
                obs.update();
        }); 
    }

    @Override
    public void delObserver() {
        this.observerList = new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }
}
