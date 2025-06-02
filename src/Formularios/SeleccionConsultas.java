package Formularios;

import Clases.Conexion;
import Clases.Estanques;
import Controlador.DaoEstanques;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SeleccionConsultas extends javax.swing.JFrame {

    Totales t = new Totales();
    Estanques e = new Estanques();

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    Connection cxn = cn.estableceConexion();

    public SeleccionConsultas() {
        initComponents();
        this.setTitle("Consultas");
        setLocationRelativeTo(null);
    }

    ListaClientes lc = new ListaClientes();
    ListaEstanques le = new ListaEstanques();
    ListaHistorial lh = new ListaHistorial();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        panelRound20 = new Clases.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar1 = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar2 = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnTot = new RSMaterialComponent.RSButtonMaterialIconDos();
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
        jLabel2.setText("Consultas");

        btnGuardar.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar.setText("Clientes");
        btnGuardar.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnGuardar.setRound(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardar1.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar1.setText("Estanques");
        btnGuardar1.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ART_TRACK);
        btnGuardar1.setRound(20);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnGuardar2.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar2.setText("Notas");
        btnGuardar2.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnGuardar2.setRound(20);
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

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

        btnTot.setBackground(new java.awt.Color(255, 72, 54));
        btnTot.setText("Totales");
        btnTot.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnTot.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VIEW_AGENDA);
        btnTot.setRound(20);
        btnTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(342, 342, 342))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(345, 345, 345))))
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(btnTot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTot, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setText("ESTUARIO PEZ");

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(293, 293, 293))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        lc.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        le.setVisible(true);
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
        lh.setVisible(true);
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotActionPerformed
        t.setVisible(true);
        ListarTotales();
    }//GEN-LAST:event_btnTotActionPerformed

    public void ListarTotales() {
        SumaIterativa();
        TotalRegistros();

        double valorRedondeado = Math.round(e.getTotalM45() * 100.0) / 100.0;
        double valorRedondeado2 = Math.round(e.getTotalM38() * 100.0) / 100.0;
        double valorRedondeado3 = Math.round(e.getTotalM34() * 100.0) / 100.0;
        double valorRedondeado4 = Math.round(e.getTotalM30() * 100.0) / 100.0;
        double valorRedondeado5 = Math.round(e.getTotalPecesSem() * 100.0) / 100.0;
        double valorRedondeado6 = Math.round(e.getTotalBultos() * 100.0) / 100.0;

        t.txtSumM45.setText(Double.toString(valorRedondeado));
        t.txtSumM38.setText(Double.toString(valorRedondeado2));
        t.txtSumM34.setText(Double.toString(valorRedondeado3));
        t.txtSumM30.setText(Double.toString(valorRedondeado4));
        t.txtPecSem.setText(Double.toString(valorRedondeado5));
        t.txtBulTot.setText(Double.toString(valorRedondeado6));
    }

    public void TotalRegistros() {
        String SQL = "select COUNT(*) from cliente;";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                String tot1 = rs.getString("COUNT(*)");
                t.txtCliTot.setText(tot1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        String SQL2 = "select COUNT(*) from estanque;";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL2);
            rs = ps.executeQuery();

            if (rs.next()) {
                String tot2 = rs.getString("COUNT(*)");
                t.txtEstTot.setText(tot2);
            }
        } catch (Exception e) {

        }
        
        String SQL3 = "select COUNT(*) from historial;";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL3);
            rs = ps.executeQuery();

            if (rs.next()) {
                String tot3 = rs.getString("COUNT(*)");
                t.txtNotTot.setText(tot3);
            }
        } catch (Exception e) {

        }
    }

    public void SumaIterativa() {
        String SQL = "SELECT sum(M45) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum1 = rs.getString("sum(M45)");
                e.setTotalM45(Float.parseFloat(sum1));
            }
        } catch (Exception e) {

        }

        String SQL2 = "SELECT sum(M38) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL2);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum2 = rs.getString("sum(M38)");
                e.setTotalM38(Float.parseFloat(sum2));
            }
        } catch (Exception e) {

        }

        String SQL3 = "SELECT sum(M34) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL3);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum3 = rs.getString("sum(M34)");
                e.setTotalM34(Float.parseFloat(sum3));
            }
        } catch (Exception e) {

        }

        String SQL4 = "SELECT sum(M30) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL4);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum4 = rs.getString("sum(M30)");
                e.setTotalM30(Float.parseFloat(sum4));
            }
        } catch (Exception e) {

        }

        String SQL5 = "SELECT sum(pecesSembrados) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL5);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum5 = rs.getString("sum(pecesSembrados)");
                e.setTotalPecesSem(Float.parseFloat(sum5));
            }
        } catch (Exception e) {

        }

        String SQL6 = "SELECT sum(bultosTotales) FROM estanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL6);
            rs = ps.executeQuery();

            if (rs.next()) {
                String sum6 = rs.getString("sum(bultosTotales)");
                e.setTotalBultos(Float.parseFloat(sum6));
            }
        } catch (Exception e) {

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar1;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar2;
    private RSMaterialComponent.RSButtonMaterialIconDos btnTot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Clases.PanelRound panelRound20;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
