
package Formularios;

import Clases.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Totales extends javax.swing.JFrame {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    Connection cxn = cn.estableceConexion();
    
    public Totales() {
        initComponents();
        this.setTitle("Totales");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        panelRound20 = new Clases.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPecSem = new rojeru_san.rsfield.RSTextFullRound();
        txtSumM45 = new rojeru_san.rsfield.RSTextFullRound();
        txtSumM38 = new rojeru_san.rsfield.RSTextFullRound();
        txtSumM34 = new rojeru_san.rsfield.RSTextFullRound();
        txtSumM30 = new rojeru_san.rsfield.RSTextFullRound();
        txtBulTot = new rojeru_san.rsfield.RSTextFullRound();
        jLabel8 = new javax.swing.JLabel();
        txtCliTot = new rojeru_san.rsfield.RSTextFullRound();
        jLabel11 = new javax.swing.JLabel();
        txtEstTot = new rojeru_san.rsfield.RSTextFullRound();
        jLabel12 = new javax.swing.JLabel();
        txtNotTot = new rojeru_san.rsfield.RSTextFullRound();
        jLabel10 = new javax.swing.JLabel();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));

        panelRound20.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound20.setRoundBottomLeft(20);
        panelRound20.setRoundBottomRight(20);
        panelRound20.setRoundTopLeft(20);
        panelRound20.setRoundTopRight(20);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Peces Sembrados");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("M-45");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("M-34");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("M-38");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("M-30");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Bultos totales");

        jLabel9.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel9.setText("Totales");

        txtPecSem.setEditable(false);
        txtPecSem.setBackground(new java.awt.Color(153, 153, 153));
        txtPecSem.setForeground(new java.awt.Color(51, 51, 51));
        txtPecSem.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtPecSem.setCaretColor(new java.awt.Color(153, 153, 153));
        txtPecSem.setPhColor(new java.awt.Color(255, 255, 255));
        txtPecSem.setPlaceholder("");

        txtSumM45.setEditable(false);
        txtSumM45.setBackground(new java.awt.Color(153, 153, 153));
        txtSumM45.setForeground(new java.awt.Color(51, 51, 51));
        txtSumM45.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtSumM45.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSumM45.setPhColor(new java.awt.Color(255, 255, 255));
        txtSumM45.setPlaceholder("");

        txtSumM38.setEditable(false);
        txtSumM38.setBackground(new java.awt.Color(153, 153, 153));
        txtSumM38.setForeground(new java.awt.Color(51, 51, 51));
        txtSumM38.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtSumM38.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSumM38.setPhColor(new java.awt.Color(255, 255, 255));
        txtSumM38.setPlaceholder("");

        txtSumM34.setEditable(false);
        txtSumM34.setBackground(new java.awt.Color(153, 153, 153));
        txtSumM34.setForeground(new java.awt.Color(51, 51, 51));
        txtSumM34.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtSumM34.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSumM34.setPhColor(new java.awt.Color(255, 255, 255));
        txtSumM34.setPlaceholder("");
        txtSumM34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumM34ActionPerformed(evt);
            }
        });

        txtSumM30.setEditable(false);
        txtSumM30.setBackground(new java.awt.Color(153, 153, 153));
        txtSumM30.setForeground(new java.awt.Color(51, 51, 51));
        txtSumM30.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtSumM30.setCaretColor(new java.awt.Color(153, 153, 153));
        txtSumM30.setPhColor(new java.awt.Color(255, 255, 255));
        txtSumM30.setPlaceholder("");
        txtSumM30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumM30ActionPerformed(evt);
            }
        });

        txtBulTot.setEditable(false);
        txtBulTot.setBackground(new java.awt.Color(153, 153, 153));
        txtBulTot.setForeground(new java.awt.Color(51, 51, 51));
        txtBulTot.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBulTot.setCaretColor(new java.awt.Color(153, 153, 153));
        txtBulTot.setPhColor(new java.awt.Color(255, 255, 255));
        txtBulTot.setPlaceholder("");
        txtBulTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBulTotActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Clientes registrados");

        txtCliTot.setEditable(false);
        txtCliTot.setBackground(new java.awt.Color(153, 153, 153));
        txtCliTot.setForeground(new java.awt.Color(51, 51, 51));
        txtCliTot.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtCliTot.setCaretColor(new java.awt.Color(153, 153, 153));
        txtCliTot.setPhColor(new java.awt.Color(255, 255, 255));
        txtCliTot.setPlaceholder("");
        txtCliTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliTotActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Estanques registrados");

        txtEstTot.setEditable(false);
        txtEstTot.setBackground(new java.awt.Color(153, 153, 153));
        txtEstTot.setForeground(new java.awt.Color(51, 51, 51));
        txtEstTot.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtEstTot.setCaretColor(new java.awt.Color(153, 153, 153));
        txtEstTot.setPhColor(new java.awt.Color(255, 255, 255));
        txtEstTot.setPlaceholder("");
        txtEstTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstTotActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Notas resgitradas");

        txtNotTot.setEditable(false);
        txtNotTot.setBackground(new java.awt.Color(153, 153, 153));
        txtNotTot.setForeground(new java.awt.Color(51, 51, 51));
        txtNotTot.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtNotTot.setCaretColor(new java.awt.Color(153, 153, 153));
        txtNotTot.setPhColor(new java.awt.Color(255, 255, 255));
        txtNotTot.setPlaceholder("");
        txtNotTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotTotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(89, 89, 89))
                            .addGroup(panelRound20Layout.createSequentialGroup()
                                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(panelRound20Layout.createSequentialGroup()
                                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtSumM45, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPecSem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSumM38, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(35, 35, 35)
                                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4))))
                                .addGap(30, 30, 30)))
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBulTot, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSumM30, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSumM34, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(panelRound20Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(66, 66, 66)
                                    .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNotTot, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEstTot, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtCliTot, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(37, 37, 37)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPecSem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSumM34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSumM45, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtSumM30, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSumM38, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtBulTot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCliTot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEstTot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNotTot, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel10.setText("ESTUARIO PEZ");

        btnCan.setBackground(new java.awt.Color(255, 72, 54));
        btnCan.setText("Volver");
        btnCan.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCan.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnCan.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnCan.setRound(20);
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(0, 36, Short.MAX_VALUE)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCanActionPerformed

    private void txtSumM34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumM34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumM34ActionPerformed

    private void txtSumM30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumM30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumM30ActionPerformed

    private void txtBulTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBulTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBulTotActionPerformed

    private void txtCliTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliTotActionPerformed

    private void txtEstTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstTotActionPerformed

    private void txtNotTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotTotActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private Clases.PanelRound panelRound20;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public rojeru_san.rsfield.RSTextFullRound txtBulTot;
    public rojeru_san.rsfield.RSTextFullRound txtCliTot;
    public rojeru_san.rsfield.RSTextFullRound txtEstTot;
    public rojeru_san.rsfield.RSTextFullRound txtNotTot;
    public rojeru_san.rsfield.RSTextFullRound txtPecSem;
    public rojeru_san.rsfield.RSTextFullRound txtSumM30;
    public rojeru_san.rsfield.RSTextFullRound txtSumM34;
    public rojeru_san.rsfield.RSTextFullRound txtSumM38;
    public rojeru_san.rsfield.RSTextFullRound txtSumM45;
    // End of variables declaration//GEN-END:variables
}
