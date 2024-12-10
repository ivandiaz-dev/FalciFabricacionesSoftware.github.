/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.PrincipalController;
import Controllers.StockController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ivand
 */
public class AgregarStockView extends javax.swing.JPanel {

    /**
     * Creates new form AgregarStock
     */
    public AgregarStockView() {
        initComponents();
        
        initStyle();
    }
    
    private void initStyle(){
        idStockLabel.putClientProperty("FlatLaf.styleClass", "large");
        idStockLabel.setForeground(Color.black);
        cantidadCañosLabel.putClientProperty("FlatLaf.styleClass", "large");
        cantidadCañosLabel.setForeground(Color.black);
        cantidadCañosText.putClientProperty("JTextField.placeholderText", "Ingrese la cantidad de caños para agregar.");
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
        idStockLabel = new javax.swing.JLabel();
        idStockText = new javax.swing.JTextField();
        cantidadCañosLabel = new javax.swing.JLabel();
        cantidadCañosText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        idStockLabel.setText("ID Stock");

        cantidadCañosLabel.setText("Cantidad de Caños a Agregar");

        jButton1.setBackground(new java.awt.Color(168, 48, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cantidadCañosLabel)
                        .addComponent(idStockLabel)
                        .addComponent(idStockText, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addComponent(cantidadCañosText))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(idStockLabel)
                .addGap(18, 18, 18)
                .addComponent(idStockText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cantidadCañosLabel)
                .addGap(18, 18, 18)
                .addComponent(cantidadCañosText, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
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
        StockController.agregarStock();
        PrincipalController.mostrarStock();
        StockController.mostrarStock();
        idStockText.setText("");
        cantidadCañosText.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public JLabel getCantidadCañosLabel() {
        return cantidadCañosLabel;
    }

    public void setCantidadCañosLabel(JLabel cantidadCañosLabel) {
        this.cantidadCañosLabel = cantidadCañosLabel;
    }

    public JTextField getCantidadCañosText() {
        return cantidadCañosText;
    }

    public void setCantidadCañosText(JTextField cantidadCañosText) {
        this.cantidadCañosText = cantidadCañosText;
    }

    public JLabel getIdStockLabel() {
        return idStockLabel;
    }

    public void setIdStockLabel(JLabel idStockLabel) {
        this.idStockLabel = idStockLabel;
    }

    public JTextField getIdStockText() {
        return idStockText;
    }

    public void setIdStockText(JTextField idStockText) {
        this.idStockText = idStockText;
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantidadCañosLabel;
    private javax.swing.JTextField cantidadCañosText;
    private javax.swing.JLabel idStockLabel;
    private javax.swing.JTextField idStockText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
