
package Formularios;

import Clases.Usuarios;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {

    Usuarios us = new Usuarios();

    public FormLogin() {
        initComponents();
        this.setTitle("Login");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        evaluatorLong1 = new org.jdesktop.core.animation.timing.evaluators.EvaluatorLong();
        Panel = new rspanelgradiente.RSPanelGradiente();
        jLabel4 = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        rSButtonMaterialDos4 = new RSMaterialComponent.RSButtonMaterialDos();
        jLabel7 = new javax.swing.JLabel();
        rSButtonMaterialDos3 = new RSMaterialComponent.RSButtonMaterialDos();
        txtUsu = new rojeru_san.rsfield.RSTextFullRound();
        txtCon = new rojeru_san.rsfield.RSPassViewRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setColorPrimario(new java.awt.Color(255, 85, 80));
        Panel.setColorSecundario(new java.awt.Color(255, 129, 92));

        jLabel4.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ESTUARIO PEZ");

        panelRound1.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        rSButtonMaterialDos4.setBackground(new java.awt.Color(255, 72, 54));
        rSButtonMaterialDos4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rSButtonMaterialDos4.setText("Ingresar");
        rSButtonMaterialDos4.setBackgroundHover(new java.awt.Color(153, 109, 52));
        rSButtonMaterialDos4.setFocusable(false);
        rSButtonMaterialDos4.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        rSButtonMaterialDos4.setRound(20);
        rSButtonMaterialDos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialDos4ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario 2.png"))); // NOI18N

        rSButtonMaterialDos3.setBackground(new java.awt.Color(255, 72, 54));
        rSButtonMaterialDos3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rSButtonMaterialDos3.setText("Salir");
        rSButtonMaterialDos3.setBackgroundHover(new java.awt.Color(153, 109, 52));
        rSButtonMaterialDos3.setFont(new java.awt.Font("Space Grotesk Light", 1, 24)); // NOI18N
        rSButtonMaterialDos3.setRound(20);
        rSButtonMaterialDos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialDos3ActionPerformed(evt);
            }
        });

        txtUsu.setBackground(new java.awt.Color(255, 80, 78));
        txtUsu.setForeground(new java.awt.Color(255, 255, 255));
        txtUsu.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtUsu.setPhColor(new java.awt.Color(255, 255, 255));
        txtUsu.setPlaceholder("Usuario");

        txtCon.setBackground(new java.awt.Color(255, 80, 78));
        txtCon.setForeground(new java.awt.Color(255, 255, 255));
        txtCon.setBorderColor(new java.awt.Color(204, 153, 0, 0));
        txtCon.setPhColor(new java.awt.Color(255, 255, 255));
        txtCon.setPlaceholder("Contraseña");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7))
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(rSButtonMaterialDos4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(199, 199, 199))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(rSButtonMaterialDos3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSButtonMaterialDos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSButtonMaterialDos3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel5.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bienvenido");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(219, 219, 219)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(33, 33, 33)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMaterialDos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialDos3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSButtonMaterialDos3ActionPerformed

    private void rSButtonMaterialDos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialDos4ActionPerformed
        Clases.Login objLogin = new Clases.Login();
        us = objLogin.validarUsuario(txtUsu.getText(), txtCon.getText());
        if (us.getUsuario() != null && us.getContrasenia() != null) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Credenciales INCORRECTAS");
        }
    }//GEN-LAST:event_rSButtonMaterialDos4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rspanelgradiente.RSPanelGradiente Panel;
    private org.jdesktop.core.animation.timing.evaluators.EvaluatorLong evaluatorLong1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private Clases.PanelRound panelRound1;
    private RSMaterialComponent.RSButtonMaterialDos rSButtonMaterialDos3;
    private RSMaterialComponent.RSButtonMaterialDos rSButtonMaterialDos4;
    private rojeru_san.rsfield.RSPassViewRound txtCon;
    private rojeru_san.rsfield.RSTextFullRound txtUsu;
    // End of variables declaration//GEN-END:variables
}
