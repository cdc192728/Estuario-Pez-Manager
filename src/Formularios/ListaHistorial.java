package Formularios;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Clases.Historial;
import Controlador.DaoClientes;
import Controlador.DaoHistorial;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ListaHistorial extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener {

    Historial h = new Historial();
    DaoHistorial daoH = new DaoHistorial();

    DefaultTableModel modeloHistorial = new DefaultTableModel();
    Conexion cn = new Conexion();

    Connection cnx = cn.estableceConexion();

    public static int fkCli;

    public ListaHistorial() {
        initComponents();
        this.setTitle("Notas");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.txtBuscar.getDocument().addDocumentListener(this);
        this.tblHis.getSelectionModel().addListSelectionListener(this);
        listarHistorial();
//        btnVol.setIcon(setIcono("/Imagenes/Icono Atras.png", btnMod));
    }

    public Icon setIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();

        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public void listarHistorial() {
        List<Historial> lista = daoH.Listar();
        modeloHistorial = (DefaultTableModel) tblHis.getModel();
        Object[] ob = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdHis();
            ob[1] = lista.get(i).getPropietario();
            ob[2] = lista.get(i).getNota();
//            ob[2] = lista.get(i).getFkCliente();
            ob[3] = lista.get(i).getFechaFin();
            ob[4] = lista.get(i).getTelefono();
            ob[5] = lista.get(i).getDireccion();

            modeloHistorial.addRow(ob);
        }
        tblHis.setModel(modeloHistorial);
    }

    public void BuscarNotas(String input, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Propietario");
        modelo.addColumn("Nota");
        modelo.addColumn("Fecha Fin");
        modelo.addColumn("Celular");
        modelo.addColumn("Direccion");

        String consulta = "select historial.id, historial.nota, historial.fecFin, cliente.propietario, cliente.celular, cliente.direccion from historial inner join cliente on historial.fkCliente = cliente.idCliente where fkCliente in (select idCliente from cliente where propietario like '" + input + "%')";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                Object[] lista = {rs.getInt(1), rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar datos " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        popMenu = new javax.swing.JPopupMenu();
        btnEli = new javax.swing.JMenuItem();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHis = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnEli.setText("Eliminar");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        popMenu.add(btnEli);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setText("Historial");

        tblHis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Propietario", "Nota", "Fecha Fin", "Celular", "Dirección"
            }
        ));
        tblHis.setComponentPopupMenu(popMenu);
        tblHis.setGridColor(new java.awt.Color(255, 80, 78));
        tblHis.setSelectionBackground(new java.awt.Color(255, 80, 78));
        jScrollPane3.setViewportView(tblHis);
        if (tblHis.getColumnModel().getColumnCount() > 0) {
            tblHis.getColumnModel().getColumn(0).setMinWidth(30);
            tblHis.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHis.getColumnModel().getColumn(0).setMaxWidth(30);
            tblHis.getColumnModel().getColumn(1).setMinWidth(230);
            tblHis.getColumnModel().getColumn(1).setPreferredWidth(230);
            tblHis.getColumnModel().getColumn(1).setMaxWidth(230);
            tblHis.getColumnModel().getColumn(3).setMinWidth(150);
            tblHis.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblHis.getColumnModel().getColumn(3).setMaxWidth(150);
            tblHis.getColumnModel().getColumn(4).setMinWidth(150);
            tblHis.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblHis.getColumnModel().getColumn(4).setMaxWidth(150);
            tblHis.getColumnModel().getColumn(5).setMinWidth(150);
            tblHis.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblHis.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Buscar");

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBuscar.setCaretColor(new java.awt.Color(153, 153, 153));
        txtBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(267, 267, 267)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(472, 472, 472)
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
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

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed

    }//GEN-LAST:event_btnEliActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCanActionPerformed

    public void LimpiarTabla() {
        for (int i = 0; i < modeloHistorial.getRowCount(); i++) {
            modeloHistorial.removeRow(i);
            i = 0 - 1;
        }
    }

    public void Buscar() {
        String input = txtBuscar.getText();
        BuscarNotas(input, tblHis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Buscar();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Buscar();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        Buscar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Buscar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Buscar();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private javax.swing.JMenuItem btnEli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu popMenu;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JTable tblHis;
    public rojeru_san.rsfield.RSTextFullRound txtBuscar;
    // End of variables declaration//GEN-END:variables
}
