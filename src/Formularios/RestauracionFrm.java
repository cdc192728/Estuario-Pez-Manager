/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Backup.Respaldo;
import Backup.Restauracion;
import java.io.IOException;
import javax.swing.JOptionPane;

public class RestauracionFrm extends javax.swing.JFrame {

    Respaldo instanciaRespaldo = Respaldo.getInstance();
    Restauracion instanciaRestauracion = Restauracion.getInstance();

    public RestauracionFrm() {
        initComponents();
        this.setTitle("Restauracion");
        this.setLocationRelativeTo(null);
        this.setTitle("Respaldo y restauracion");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        panelRound20 = new Clases.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar2 = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));

        panelRound20.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound20.setRoundBottomLeft(20);
        panelRound20.setRoundBottomRight(20);
        panelRound20.setRoundTopLeft(20);
        panelRound20.setRoundTopRight(20);

        jLabel2.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel2.setText("Respaldo");

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

        btnGuardar.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar.setText("Crear respaldo");
        btnGuardar.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARCHIVE);
        btnGuardar.setRound(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardar2.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar2.setText("Crear restauración");
        btnGuardar2.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RESTORE);
        btnGuardar2.setRound(20);
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(284, 284, 284))
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setText("ESTUARIO PEZ");

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(275, 275, 275))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea crear el respaldo?", "Elimar cliente", JOptionPane.YES_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                instanciaRespaldo.crearBackup();
                JOptionPane.showMessageDialog(null, "Respaldo creado con exito . ");
            } else {
                JOptionPane.showMessageDialog(null, "Solicitud calcelada");
            }

        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        try {
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea crear la restauración?", "Elimar cliente", JOptionPane.YES_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                instanciaRestauracion.crearRestauracion();
                JOptionPane.showMessageDialog(null, "Restauracion creada con exito . ");
            } else {
                JOptionPane.showMessageDialog(null, "Solicitud calcelada");
            }
               
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }//GEN-LAST:event_btnGuardar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Clases.PanelRound panelRound20;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
