/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.io.File;
import javax.swing.ImageIcon;

/**
 * Vista trasera de la carta
 * @author Adrian Rojas, Javier Donato, Jafet Picado
 */
public class BackCardView extends javax.swing.JPanel {

    /**
     * Creates new form BackCardView
     */
    public BackCardView() {
        ImageIcon icon = new ImageIcon("./src/main/img/backView.png");
        initComponents();
        jLabel2.setIcon(icon);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(100, 150));
        setMinimumSize(new java.awt.Dimension(100, 150));
        setPreferredSize(new java.awt.Dimension(100, 150));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
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
