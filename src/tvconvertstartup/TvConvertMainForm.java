/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvconvertstartup;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author brett
 */
public class TvConvertMainForm extends javax.swing.JFrame {

    /**
     *
     */
    protected File file = null;
    //ImageIcon icon = new ImageIcon("icon.png");

    /**
     * Creates new form ConvertMainForm
     */
    public TvConvertMainForm() {
        initComponents();
        setIcon();
    }

     private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Convert HD TV2Avi");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(1);
        setFocusTraversalPolicyProvider(true);
        setIconImages(null);
        setLocationByPlatform(true);
        setMinimumSize(getPreferredSize());
        setPreferredSize(new java.awt.Dimension(420, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TvConvert");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 384, 26);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 43, 67, 23);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(83, 43, 311, 23);

        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(10, 210, 384, 28);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 77, 394, 10);

        jButton2.setText("Resample");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 244, 124, 23);

        jButton3.setText("Cancle Job");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(140, 244, 124, 23);

        jButton4.setText("Exit App");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(270, 244, 124, 23);

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 11)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tvconvertstartup/TvConvertSplashScreen.png"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        jLabel2.setFocusTraversalPolicyProvider(true);
        jLabel2.setMaximumSize(new java.awt.Dimension(420, 320));
        jLabel2.setMinimumSize(new java.awt.Dimension(420, 320));
        jLabel2.setName("MyBack"); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(404, 293));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 404, 293);
        jLabel2.getAccessibleContext().setAccessibleName("MyBackGround");

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            TvConvertRunThread.startThread(this);
        } catch (IOException ex) {
            Logger.getLogger(TvConvertMainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            jTextField2.setText(file.getAbsolutePath());
            try {
                TvConvertSetUp.checkFile(file);
            } catch (IOException ex) {
                Logger.getLogger(TvConvertRunThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try {
            killMash.Kfpeg();
        } catch (IOException ex) {
            Logger.getLogger(TvConvertMainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

   



    /**
     * Gets the output from the startThread method and sets the value of the
     * progress bar.
     *
     * @param goods
     */
    public void setbar(int goods) {
        jProgressBar1.setValue(goods);
    }

    /**
     * @param args the command line arguments
     */
    public static void startForm(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TvConvertMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TvConvertMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TvConvertMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TvConvertMainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TvConvertMainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

   
}
