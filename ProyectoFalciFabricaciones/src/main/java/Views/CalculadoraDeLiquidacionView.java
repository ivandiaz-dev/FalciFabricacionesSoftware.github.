/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controllers.LiquidacionController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ivand
 */
public class CalculadoraDeLiquidacionView extends javax.swing.JPanel {

    /**
     * Creates new form CalculadoraLiquidacion
     */
    public CalculadoraDeLiquidacionView() {
        initComponents();
        
        initStyle();
    }

    private void initStyle(){
        sueldoLabel.putClientProperty("FlatLaf.styleClass", "large");
        sueldoLabel.setForeground(Color.black);
        horasLabel.putClientProperty("FlatLaf.styleClass", "large");
        horasLabel.setForeground(Color.black);
        horasExtrasLabel.putClientProperty("FlatLaf.styleClass", "large");
        horasExtrasLabel.setForeground(Color.black);
        horasText.putClientProperty("JTextField.placeholderText", "Ingrese la cantidad de horas de la semana.");
        horasExtrasText.putClientProperty("JTextField.placeholderText", "Ingrese la cantidad de horas extras de la semana.");
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
        sueldoLabel = new javax.swing.JLabel();
        sueldoText = new javax.swing.JTextField();
        horasLabel = new javax.swing.JLabel();
        horasText = new javax.swing.JTextField();
        horasExtrasLabel = new javax.swing.JLabel();
        horasExtrasText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        sueldoLabel.setText("Sueldo");

        horasLabel.setText("Cantidad de horas");

        horasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasTextActionPerformed(evt);
            }
        });

        horasExtrasLabel.setText("Cantidad de horas extras");

        horasExtrasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasExtrasTextActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(168, 48, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calcular");
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
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sueldoLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(horasLabel)
                                .addComponent(horasText, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(horasExtrasLabel)
                                .addComponent(horasExtrasText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(sueldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(sueldoLabel)
                .addGap(18, 18, 18)
                .addComponent(sueldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(horasLabel)
                        .addGap(18, 18, 18)
                        .addComponent(horasText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(horasExtrasLabel)
                        .addGap(18, 18, 18)
                        .addComponent(horasExtrasText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
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
        LiquidacionController.calcularLiquidacion();
        sueldoText.setText("");
        horasText.setText("");
        horasExtrasText.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void horasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasTextActionPerformed

    private void horasExtrasTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasExtrasTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horasExtrasTextActionPerformed

    public JLabel getHorasExtrasLabel() {
        return horasExtrasLabel;
    }

    public void setHorasExtrasLabel(JLabel horasExtrasLabel) {
        this.horasExtrasLabel = horasExtrasLabel;
    }

    public JTextField getHorasExtrasText() {
        return horasExtrasText;
    }

    public void setHorasExtrasText(JTextField horasExtrasText) {
        this.horasExtrasText = horasExtrasText;
    }

    public JLabel getHorasLabel() {
        return horasLabel;
    }

    public void setHorasLabel(JLabel horasLabel) {
        this.horasLabel = horasLabel;
    }

    public JTextField getHorasText() {
        return horasText;
    }

    public void setHorasText(JTextField horasText) {
        this.horasText = horasText;
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

    public JLabel getSueldoLabel() {
        return sueldoLabel;
    }

    public void setSueldoLabel(JLabel sueldoLabel) {
        this.sueldoLabel = sueldoLabel;
    }

    public JTextField getSueldoText() {
        return sueldoText;
    }

    public void setSueldoText(JTextField sueldoText) {
        this.sueldoText = sueldoText;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel horasExtrasLabel;
    private javax.swing.JTextField horasExtrasText;
    private javax.swing.JLabel horasLabel;
    private javax.swing.JTextField horasText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sueldoLabel;
    private javax.swing.JTextField sueldoText;
    // End of variables declaration//GEN-END:variables
}