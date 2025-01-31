/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.LiquidacionController;
import Controllers.PrincipalController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author ivand
 */
public class RegistroLiquidacionView extends javax.swing.JPanel {

    /**
     * Creates new form RegistroLiquidacion
     */
    public RegistroLiquidacionView() {
        initComponents();
        
        initStyle();
    }
    
    private void initStyle(){
        nombreLabel.putClientProperty("FlatLaf.styleClass", "large");
        nombreLabel.setForeground(Color.black);
        apellidoLabel.putClientProperty("FlatLaf.styleClass", "large");
        apellidoLabel.setForeground(Color.black);
        documentoLabel.putClientProperty("FlatLaf.styleClass", "large");
        documentoLabel.setForeground(Color.black);
        semanalLabel.putClientProperty("FlatLaf.styleClass", "large");
        semanalLabel.setForeground(Color.black);
        nombreText.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del empleado.");
        apellidoText.putClientProperty("JTextField.placeholderText", "Ingrese el apellido del empleado.");
        documentoText.putClientProperty("JTextField.placeholderText", "Ingrese el documento del empleado.");
        semanalText.putClientProperty("JTextField.placeholderText", "Ingrese el sueldo semanal del empleado.");
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
        apellidoLabel = new javax.swing.JLabel();
        apellidoText = new javax.swing.JTextField();
        documentoLabel = new javax.swing.JLabel();
        documentoText = new javax.swing.JTextField();
        semanalLabel = new javax.swing.JLabel();
        semanalText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nombreLabel.setText("Nombre");

        apellidoLabel.setText("Apellido");

        documentoLabel.setText("Documento");

        semanalLabel.setText("Semanal");

        jButton1.setBackground(new java.awt.Color(168, 48, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar Sueldo");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidoLabel)
                    .addComponent(apellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(documentoLabel)
                    .addComponent(documentoText, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(semanalLabel)
                    .addComponent(semanalText, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nombreLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(documentoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(documentoText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(semanalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(semanalText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(apellidoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(apellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
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
        LiquidacionController.registrarLiquidacion();
        PrincipalController.mostrarLiquidacion();
        LiquidacionController.mostrarLiquidacion();
        nombreText.setText("");
        apellidoText.setText("");
        documentoText.setText("");
        semanalText.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public JLabel getApellidoLabel() {
        return apellidoLabel;
    }

    public void setApellidoLabel(JLabel apellidoLabel) {
        this.apellidoLabel = apellidoLabel;
    }

    public JTextField getApellidoText() {
        return apellidoText;
    }

    public void setApellidoText(JTextField apellidoText) {
        this.apellidoText = apellidoText;
    }

    public JLabel getDocumentoLabel() {
        return documentoLabel;
    }

    public void setDocumentoLabel(JLabel documentoLabel) {
        this.documentoLabel = documentoLabel;
    }

    public JTextField getDocumentoText() {
        return documentoText;
    }

    public void setDocumentoText(JTextField documentoText) {
        this.documentoText = documentoText;
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

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
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

    public JLabel getSemanalLabel() {
        return semanalLabel;
    }

    public void setSemanalLabel(JLabel semanalLabel) {
        this.semanalLabel = semanalLabel;
    }

    public JTextField getSemanalText() {
        return semanalText;
    }

    public void setSemanalText(JTextField semanalText) {
        this.semanalText = semanalText;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField apellidoText;
    private javax.swing.JLabel documentoLabel;
    private javax.swing.JTextField documentoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel semanalLabel;
    private javax.swing.JTextField semanalText;
    // End of variables declaration//GEN-END:variables
}
