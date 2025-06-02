package Formularios;

import Clases.Conexion;
import Clases.Reportes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GenerarReportesFrm extends javax.swing.JFrame {

    public GenerarReportesFrm() {
        initComponents();
        this.setTitle("Reportes");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        panelRound20 = new Clases.PanelRound();
        btnExc = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 30)); // NOI18N
        jLabel1.setText("ESTUARIO PEZ");

        panelRound20.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound20.setRoundBottomLeft(20);
        panelRound20.setRoundBottomRight(20);
        panelRound20.setRoundTopLeft(20);
        panelRound20.setRoundTopRight(20);

        btnExc.setBackground(new java.awt.Color(255, 72, 54));
        btnExc.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        btnExc.setForeground(new java.awt.Color(255, 255, 255));
        btnExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Excel.png"))); // NOI18N
        btnExc.setText("Reportes Excel");
        btnExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(255, 72, 54));
        btnPDF.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pdf.png"))); // NOI18N
        btnPDF.setText("Reportes PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar.setText("Volver");
        btnGuardar.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnGuardar.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnGuardar.setRound(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel2.setText("Generar reportes");

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnExc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btnPDF)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333))))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(51, 51, 51)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExc, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPDF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(220, 220, 220)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 50, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap())
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

    private void btnExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcActionPerformed
        Reportes.EjecutarReportes();
    }//GEN-LAST:event_btnExcActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        Document doc = new Document();
        Document doc3 = new Document();

        try {
//            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\pc\\Documents\\Data\\Reporte Clientes.pdf"));
            doc.open();

            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Id");
            tabla.addCell("Pisicola");
            tabla.addCell("Propietario");
            tabla.addCell("Dirección");
            tabla.addCell("Celular");
            tabla.addCell("Email");

            try {
                Conexion con = new Conexion();
                PreparedStatement ps;
                ResultSet rs;
                Connection conn = con.estableceConexion();

                ps = conn.prepareStatement("SELECT idCliente, pisicola, propietario, direccion, celular, email FROM cliente");
                rs = ps.executeQuery();
                
                if(rs.next()){
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                    } while (rs.next());
                    doc.add(tabla);
                }
                
            } catch (DocumentException | SQLException e) {
                JOptionPane.showMessageDialog(null, "No hay clientes registrados para crear el reporte");
            }
            doc.close();
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
//        try {
//            String ruta = System.getProperty("user.home");
//            PdfWriter.getInstance(doc2, new FileOutputStream(ruta + "/Desktop/Reporte Estanques.pdf"));
//            doc2.open();
//
//            PdfPTable tabla = new PdfPTable(26);
//            tabla.addCell("Id");
//            tabla.addCell("Forma");
//            tabla.addCell("Estanque");
//            tabla.addCell("Tipo Estanque");
//            tabla.addCell("Radio");
//            tabla.addCell("Largo");
//            tabla.addCell("Ancho");
//            tabla.addCell("Profundidad");
//            tabla.addCell("Area M2 Circular");
//            tabla.addCell("Area M3 Circular");
//            tabla.addCell("Area M2 Rectangular");
//            tabla.addCell("Area M3 Rectangular");
//            tabla.addCell("Peces sembrados");
//            tabla.addCell("Densidad");
//            tabla.addCell("M-45");
//            tabla.addCell("M-38");
//            tabla.addCell("M-34");
//            tabla.addCell("M-30");
//            tabla.addCell("Bultos Sembrados");
//            tabla.addCell("Fecha Inicio");
//            tabla.addCell("Fecha Fin");
//            tabla.addCell("Peso Promedio Cosechado");
//            tabla.addCell("Kg Promedio Cosechado");
//            tabla.addCell("Toneladas Cosechadas");
//            tabla.addCell("Propietario");
//            tabla.addCell("id Propietario");
//
//            try {
//                Conexion con = new Conexion();
//                PreparedStatement ps;
//                ResultSet rs;
//                Connection conn = con.estableceConexion();
//
//                ps = conn.prepareStatement("select estanque.idEstanque, estanque.forma, estanque.estanque, estanque.tipoEstanque, estanque.radio, estanque.largo, estanque.ancho, estanque.profundidad, estanque.areaM2Circulares, estanque.areaM3Circulares, estanque.areaM2Rectangulares, estanque.areaM3Rectangulares, estanque.pecesSembrados, estanque.especie, estanque.densidad, estanque.M45, estanque.M38, estanque.M34, estanque.M30, estanque.bultosTotales, estanque.fechaInicioCultivo, estanque.fechaFinalizacionCultivo ,estanque.pesoPromedioCosechado, estanque.kgCosechados, estanque.toneladasCosechadas , estanque.fkCliente, cliente.propietario from estanque inner join cliente on estanque.fkCliente = cliente.idCliente ORDER BY idEstanque");
//                rs = ps.executeQuery();
//                
//                if(rs.next()){
//                    do {                        
//                        tabla.addCell(rs.getString(1));
//                        tabla.addCell(rs.getString(2));
//                        tabla.addCell(rs.getString(3));
//                        tabla.addCell(rs.getString(4));
//                        tabla.addCell(rs.getString(5));
//                        tabla.addCell(rs.getString(6));
//                        tabla.addCell(rs.getString(7));
//                        tabla.addCell(rs.getString(8));
//                        tabla.addCell(rs.getString(9));
//                        tabla.addCell(rs.getString(10));
//                        tabla.addCell(rs.getString(11));
//                        tabla.addCell(rs.getString(12));
//                        tabla.addCell(rs.getString(13));
//                        tabla.addCell(rs.getString(14));
//                        tabla.addCell(rs.getString(15));
//                        tabla.addCell(rs.getString(16));
//                        tabla.addCell(rs.getString(17));
//                        tabla.addCell(rs.getString(18));
//                        tabla.addCell(rs.getString(19));
//                        tabla.addCell(rs.getString(20));
//                        tabla.addCell(rs.getString(21));
//                        tabla.addCell(rs.getString(22));
//                        tabla.addCell(rs.getString(23));
//                        tabla.addCell(rs.getString(24));
//                        tabla.addCell(rs.getString(25));
//                        tabla.addCell(rs.getString(26));
//                    } while (rs.next());
//                    doc2.add(tabla);
//                }
//                
//            } catch (DocumentException | SQLException e) {
//            }
//            doc2.close();
//            JOptionPane.showMessageDialog(null, "Reporte Creado");
//        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
//
//        }
        
        try {
//            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(doc3, new FileOutputStream("C:\\Users\\pc\\Documents\\Data\\Reporte Notas.pdf"));
            doc3.open();

            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Id");
            tabla.addCell("Nota");
            tabla.addCell("Fecha Inicio");
            tabla.addCell("Id Cliente");
            tabla.addCell("Propietario");
            tabla.addCell("Direccion");
            tabla.addCell("Celular");

            try {
                Conexion con = new Conexion();
                PreparedStatement ps;
                ResultSet rs;
                Connection conn = con.estableceConexion();

                ps = conn.prepareStatement("select historial.id, historial.nota, historial.fecFin, historial.fkCliente, cliente.propietario, cliente.celular, cliente.direccion from historial inner join cliente on historial.fkCliente = cliente.idCliente ORDER BY id");
                rs = ps.executeQuery();
                
                if(rs.next()){
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    doc3.add(tabla);
                }
                
            } catch (DocumentException | SQLException e) {
                JOptionPane.showMessageDialog(null, "No hay notas registradas para crear el reporte");
            }
            doc3.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExc;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Clases.PanelRound panelRound20;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
