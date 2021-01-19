/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankflux;

import com.auth.view.AuthView;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;


/**
 *
 * @author rcara
 */
public class BankFlux extends javax.swing.JFrame {
    private final AuthView authView;
    public BankFlux() {
        
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/images/banking.png")));
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        authView = new AuthView();
        authView.addObserver(new shared.observing.Observer(){
            @Override
            public void update() {
                //setUndecorated(true);
                if(shared.RequestConfig.token == null)
                    setTitle(shared.RequestConfig.message.toUpperCase());
                else {
                    authView.setVisible(false);
                    setTitle("Gestion Bancaires");
                    setResizable(true);
                    getContentPane().removeAll();
                    getContentPane().add(new com.client.views.ClientHome(), java.awt.BorderLayout.CENTER);                    
                }
            }
            
        });
        
        this.getContentPane().add(this.authView, java.awt.BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // change globally colors 
        ColorUIResource cursorColor = new ColorUIResource(new java.awt.Color(204,204,255));
        UIManager.put("TextField.caretForeground", cursorColor);
        UIManager.put("PasswordField.caretForeground", cursorColor);
        UIManager.put("FormattedTextField.caretForeground", cursorColor);
        UIManager.put("TabbedPane.selected", new java.awt.Color(43,78,95));
        UIManager.put("ToolTip.background", cursorColor);
        UIManager.put("ToolTip.border",new LineBorder(cursorColor,1));
        
        BankFlux window = new BankFlux();
        window.setVisible(true);
    }
    
}
