/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import classes.ConfigReader;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author JebGy
 */
public class Splash extends javax.swing.JFrame {

    String images[] = {"Pc1.png", "Pc2.png", "Pc3.png"};

    /**
     * Creates new form Splash
     */
    public Splash() {
        this.setUndecorated(true);

        initComponents();
        this.setLocationRelativeTo(null);
        splashControl(images);
        this.setBackground(new Color(0,0,0,0));
        checkState();
        setIconImage(new ImageIcon(getClass().getResource("/images/2.png")).getImage());
    }

    public void splashControl(String images[]) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    for (int i = 0; i < images.length; i++) {
                        lblImage.setIcon(new ImageIcon(getClass().getResource("/images/" + images[i])));
                        Thread.sleep(500);
                        repaint();
                    }
                    splashControl(images);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.toString());
                }
            }
        });
        t.start();

    }

    public void checkState() {
        ConfigReader cr = new ConfigReader();
        cbxInstall.setSelected(cr.showDepen());

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(cr.timeToChange(6770, 100)*100);
                    System.out.println(cr.timeToChange(5770, 100)*100);
                    if(cr.showDepen()){
                        Main m= new Main();
                        m.setVisible(true);
                        dispose();
                    }else{
                        InstalDependeces id= new InstalDependeces();
                        id.setVisible(true);
                        dispose();
                    }
                    
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e);
                }
            }
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new componentes.Panel();
        lblImage = new javax.swing.JLabel();
        cbxInstall = new javax.swing.JCheckBox();
        loadBar1 = new componentes.LoadBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBorderRadius(16);

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pc1.png"))); // NOI18N

        cbxInstall.setBackground(new java.awt.Color(44, 44, 44));
        cbxInstall.setFont(new java.awt.Font("Lato Light", 0, 18)); // NOI18N
        cbxInstall.setForeground(new java.awt.Color(255, 255, 255));
        cbxInstall.setText("No install dependences.");
        cbxInstall.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbxInstallStateChanged(evt);
            }
        });

        javax.swing.GroupLayout loadBar1Layout = new javax.swing.GroupLayout(loadBar1);
        loadBar1.setLayout(loadBar1Layout);
        loadBar1Layout.setHorizontalGroup(
            loadBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        loadBar1Layout.setVerticalGroup(
            loadBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(cbxInstall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxInstall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxInstallStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbxInstallStateChanged
        ConfigReader cr = new ConfigReader();
        if (cbxInstall.isSelected()) {
            cr.saveConf(1);
        } else {
            cr.saveConf(0);
        }
    }//GEN-LAST:event_cbxInstallStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbxInstall;
    private javax.swing.JLabel lblImage;
    private componentes.LoadBar loadBar1;
    private componentes.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
