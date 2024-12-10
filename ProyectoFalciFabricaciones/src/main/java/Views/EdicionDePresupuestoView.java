/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.PresupuestosController;
import Controllers.PrincipalController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ivand
 */
public class EdicionDePresupuestoView extends javax.swing.JPanel {

    /**
     * Creates new form EdicionDePresupuestoView
     */
    public EdicionDePresupuestoView() {
        initComponents();
        
        initStyle();
    }
    
    private void initStyle(){
        nombreLabel.putClientProperty("FlatLaf.styleClass", "large");
        nombreLabel.setForeground(Color.black);
        trabajoLabel.putClientProperty("FlatLaf.styleClass", "large");
        trabajoLabel.setForeground(Color.black);
        materialLabel.putClientProperty("FlatLaf.styleClass", "large");
        materialLabel.setForeground(Color.black);
        manoDeObraLabel.putClientProperty("FlatLaf.styleClass", "large");
        manoDeObraLabel.setForeground(Color.black);
        gananciaLabel.putClientProperty("FlatLaf.styleClass", "large");
        gananciaLabel.setForeground(Color.black);
        idPresupuestoLabel.putClientProperty("FlatLaf.styleClass", "large");
        idPresupuestoLabel.setForeground(Color.black);
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
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        trabajoLabel = new javax.swing.JLabel();
        trabajoText = new javax.swing.JTextField();
        materialLabel = new javax.swing.JLabel();
        materialText = new javax.swing.JTextField();
        manoDeObraLabel = new javax.swing.JLabel();
        manoDeObraText = new javax.swing.JTextField();
        gananciaLabel = new javax.swing.JLabel();
        gananciaText = new javax.swing.JTextField();
        idPresupuestoLabel = new javax.swing.JLabel();
        idPresupuestoText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nombreLabel.setText("Nombre");

        trabajoLabel.setText("Trabajo");

        materialLabel.setText("Material");

        manoDeObraLabel.setText("Mano de Obra");

        gananciaLabel.setText("Ganancia");

        idPresupuestoLabel.setText("ID Presupuesto");

        jButton1.setBackground(new java.awt.Color(168, 48, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Editar Presupuesto");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialLabel)
                    .addComponent(materialText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trabajoLabel)
                    .addComponent(trabajoText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idPresupuestoLabel)
                    .addComponent(idPresupuestoText)
                    .addComponent(gananciaLabel)
                    .addComponent(gananciaText)
                    .addComponent(manoDeObraLabel)
                    .addComponent(manoDeObraText)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(manoDeObraLabel)
                        .addGap(18, 18, 18)
                        .addComponent(manoDeObraText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gananciaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(gananciaText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idPresupuestoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(idPresupuestoText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(trabajoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(trabajoText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(materialLabel)
                        .addGap(18, 18, 18)
                        .addComponent(materialText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PresupuestosController.editarPresupuesto();
        nombreText.setText("");
        trabajoText.setText("");
        materialText.setText("");
        manoDeObraText.setText("");
        gananciaText.setText("");
        idPresupuestoText.setText("");
        PrincipalController.mostrarPresupuesto();
        PresupuestosController.mostrarPresupuesto();
    }//GEN-LAST:event_jButton1ActionPerformed

    public JLabel getGananciaLabel() {
        return gananciaLabel;
    }

    public void setGananciaLabel(JLabel gananciaLabel) {
        this.gananciaLabel = gananciaLabel;
    }

    public JTextField getGananciaText() {
        return gananciaText;
    }

    public void setGananciaText(JTextField gananciaText) {
        this.gananciaText = gananciaText;
    }

    public JLabel getIdPresupuestoLabel() {
        return idPresupuestoLabel;
    }

    public void setIdPresupuestoLabel(JLabel idPresupuestoLabel) {
        this.idPresupuestoLabel = idPresupuestoLabel;
    }

    public JTextField getIdPresupuestoText() {
        return idPresupuestoText;
    }

    public void setIdPresupuestoText(JTextField idPresupuestoText) {
        this.idPresupuestoText = idPresupuestoText;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getManoDeObraLabel() {
        return manoDeObraLabel;
    }

    public void setManoDeObraLabel(JLabel manoDeObraLabel) {
        this.manoDeObraLabel = manoDeObraLabel;
    }

    public JTextField getManoDeObraText() {
        return manoDeObraText;
    }

    public void setManoDeObraText(JTextField manoDeObraText) {
        this.manoDeObraText = manoDeObraText;
    }

    public JLabel getMaterialLabel() {
        return materialLabel;
    }

    public void setMaterialLabel(JLabel materialLabel) {
        this.materialLabel = materialLabel;
    }

    public JTextField getMaterialText() {
        return materialText;
    }

    public void setMaterialText(JTextField materialText) {
        this.materialText = materialText;
    }

    public JLabel getNombreLabel() {
        return nombreLabel;
    }

    public void setNombreLabel(JLabel nombreLabel) {
        this.nombreLabel = nombreLabel;
    }

    public JTextField getNombreText() {
        return nombreText;
    }

    public void setNombreText(JTextField nombreText) {
        this.nombreText = nombreText;
    }

    public JLabel getTrabajoLabel() {
        return trabajoLabel;
    }

    public void setTrabajoLabel(JLabel trabajoLabel) {
        this.trabajoLabel = trabajoLabel;
    }

    public JTextField getTrabajoText() {
        return trabajoText;
    }

    public void setTrabajoText(JTextField trabajoText) {
        this.trabajoText = trabajoText;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gananciaLabel;
    private javax.swing.JTextField gananciaText;
    private javax.swing.JLabel idPresupuestoLabel;
    private javax.swing.JTextField idPresupuestoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manoDeObraLabel;
    private javax.swing.JTextField manoDeObraText;
    private javax.swing.JLabel materialLabel;
    private javax.swing.JTextField materialText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel trabajoLabel;
    private javax.swing.JTextField trabajoText;
    // End of variables declaration//GEN-END:variables
}