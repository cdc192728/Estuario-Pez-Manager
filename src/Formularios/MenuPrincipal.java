package Formularios;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuPrincipal extends javax.swing.JFrame {

    ListaEstanques le = new ListaEstanques();
    SeleccionConsultas sc = new SeleccionConsultas();
    HistorialForm h = new HistorialForm();
    GenerarReportesFrm grf = new GenerarReportesFrm();
    
    
    public MenuPrincipal() {
        initComponents();
        this.setTitle("Estuario Pez");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new rspanelgradiente.RSPanelGradiente();
        panelRound1 = new Clases.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnReg = new RSMaterialComponent.RSButtonMaterialIconShadow();
        rSButtonMaterialIconShadow2 = new RSMaterialComponent.RSButtonMaterialIconShadow();
        rSButtonMaterialIconShadow3 = new RSMaterialComponent.RSButtonMaterialIconShadow();
        rSButtonMaterialIconShadow4 = new RSMaterialComponent.RSButtonMaterialIconShadow();
        rSButtonMaterialIconShadow5 = new RSMaterialComponent.RSButtonMaterialIconShadow();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setForeground(new java.awt.Color(204, 204, 204));
        Panel.setColorPrimario(new java.awt.Color(102, 102, 102));
        Panel.setColorSecundario(new java.awt.Color(153, 153, 153));
        Panel.setPreferredSize(new java.awt.Dimension(1366, 768));

        panelRound1.setBackground(new java.awt.Color(102, 102, 102));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("ESTUARIO PEZ");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        btnReg.setBackground(new java.awt.Color(255, 94, 66));
        btnReg.setText("Registrar");
        btnReg.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        btnReg.setRound(15);
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        rSButtonMaterialIconShadow2.setBackground(new java.awt.Color(255, 94, 66));
        rSButtonMaterialIconShadow2.setText("Reportes");
        rSButtonMaterialIconShadow2.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        rSButtonMaterialIconShadow2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NOTE);
        rSButtonMaterialIconShadow2.setRound(15);
        rSButtonMaterialIconShadow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconShadow2ActionPerformed(evt);
            }
        });

        rSButtonMaterialIconShadow3.setBackground(new java.awt.Color(255, 94, 66));
        rSButtonMaterialIconShadow3.setText("Consultar");
        rSButtonMaterialIconShadow3.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        rSButtonMaterialIconShadow3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BOOK);
        rSButtonMaterialIconShadow3.setRound(15);
        rSButtonMaterialIconShadow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconShadow3ActionPerformed(evt);
            }
        });

        rSButtonMaterialIconShadow4.setBackground(new java.awt.Color(255, 94, 66));
        rSButtonMaterialIconShadow4.setText("Guardado de datos");
        rSButtonMaterialIconShadow4.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        rSButtonMaterialIconShadow4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.BACKUP);
        rSButtonMaterialIconShadow4.setRound(15);
        rSButtonMaterialIconShadow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconShadow4ActionPerformed(evt);
            }
        });

        rSButtonMaterialIconShadow5.setBackground(new java.awt.Color(255, 94, 66));
        rSButtonMaterialIconShadow5.setText("Salir");
        rSButtonMaterialIconShadow5.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        rSButtonMaterialIconShadow5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXIT_TO_APP);
        rSButtonMaterialIconShadow5.setRound(15);
        rSButtonMaterialIconShadow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconShadow5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(rSButtonMaterialIconShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(159, 159, 159))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rSButtonMaterialIconShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(rSButtonMaterialIconShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(rSButtonMaterialIconShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(rSButtonMaterialIconShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSButtonMaterialIconShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(rSButtonMaterialIconShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSButtonMaterialIconShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        ClientesForm objClientes = new ClientesForm();
        //panelForm.add(objClientes);
        objClientes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegActionPerformed

    private void rSButtonMaterialIconShadow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconShadow2ActionPerformed
        grf.setVisible(true);
    }//GEN-LAST:event_rSButtonMaterialIconShadow2ActionPerformed

    private void rSButtonMaterialIconShadow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconShadow3ActionPerformed
        sc.setVisible(true);
    }//GEN-LAST:event_rSButtonMaterialIconShadow3ActionPerformed

    private void rSButtonMaterialIconShadow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconShadow4ActionPerformed
        RestauracionFrm r = new RestauracionFrm();
        r.setVisible(true);
    }//GEN-LAST:event_rSButtonMaterialIconShadow4ActionPerformed

    private void rSButtonMaterialIconShadow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconShadow5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSButtonMaterialIconShadow5ActionPerformed

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rspanelgradiente.RSPanelGradiente Panel;
    private RSMaterialComponent.RSButtonMaterialIconShadow btnReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private Clases.PanelRound panelRound1;
    private RSMaterialComponent.RSButtonMaterialIconShadow rSButtonMaterialIconShadow2;
    private RSMaterialComponent.RSButtonMaterialIconShadow rSButtonMaterialIconShadow3;
    private RSMaterialComponent.RSButtonMaterialIconShadow rSButtonMaterialIconShadow4;
    private RSMaterialComponent.RSButtonMaterialIconShadow rSButtonMaterialIconShadow5;
    // End of variables declaration//GEN-END:variables
}
