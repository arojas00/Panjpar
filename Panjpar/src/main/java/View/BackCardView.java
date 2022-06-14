/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.io.File;

/**
 *
 * @author jafet
 */
public class BackCardView extends javax.swing.JPanel {

    private final String iconPath;
    /**
     * Creates new form BackCardView
     */
    public BackCardView() {
        this.iconPath = new File("src/main/img/backView.jpg").getAbsolutePath();
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

        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(100, 150));
        setMinimumSize(new java.awt.Dimension(100, 150));
        setPreferredSize(new java.awt.Dimension(100, 150));

        jLabel2.setIcon(new javax.swing.ImageIcon(iconPath));
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 150));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 150));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
