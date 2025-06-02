
package Formularios;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Controlador.DaoClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ListaClientes extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener{

    Conexion con = new Conexion();
    Connection cn = con.estableceConexion();

    Clientes c = new Clientes();
    Estanques e = new Estanques();
    DaoClientes dao = new DaoClientes();
    DefaultTableModel modeloClientes = new DefaultTableModel();
    
    
    public ListaClientes() {
        initComponents();
        this.setTitle("Clientes");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.txtBuscar.getDocument().addDocumentListener(this);
        this.tablaClientes.getSelectionModel().addListSelectionListener(this);
        
        listarClientes();
    }

    public void BuscarClientes(String input, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Pisicola");
        modelo.addColumn("Propietario");
        modelo.addColumn("Direccion");
        modelo.addColumn("Celular");
        modelo.addColumn("Email");

        String consulta = "SELECT*FROM cliente WHERE propietario LIKE '%" + input + "%' OR pisicola LIKE '%" + input + "%'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                Object[] lista = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar datos " + e);
        }
    }
    
    private void listarClientes() {
        List<Clientes> lista = dao.Listar();
        modeloClientes = (DefaultTableModel) tablaClientes.getModel();
        Object[] ob = new Object[6];
        int filas = tablaClientes.getRowCount();

        for (int a = 0; filas > a; a++) {
            modeloClientes.removeRow(0);
        }

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdCliente();
            ob[1] = lista.get(i).getPisicola();
            ob[2] = lista.get(i).getPropietario();
            ob[3] = lista.get(i).getDireccion();
            ob[4] = lista.get(i).getCelular();
            ob[5] = lista.get(i).getEmail();
            modeloClientes.addRow(ob);
        }
        tablaClientes.setModel(modeloClientes);
    }
    
    public void Buscar() {
        String input = txtBuscar.getText();
        BuscarClientes(input, tablaClientes);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(1366, 768));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pisicola", "Propietario", "Direccion", "Celular", "Email"
            }
        ));
        tablaClientes.setGridColor(new java.awt.Color(255, 80, 78));
        tablaClientes.setSelectionBackground(new java.awt.Color(255, 80, 78));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesTomarDatos(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setMinWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaClientes.getColumnModel().getColumn(1).setMinWidth(200);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(200);
            tablaClientes.getColumnModel().getColumn(1).setMaxWidth(200);
            tablaClientes.getColumnModel().getColumn(2).setMinWidth(280);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(280);
            tablaClientes.getColumnModel().getColumn(2).setMaxWidth(280);
            tablaClientes.getColumnModel().getColumn(3).setMinWidth(150);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaClientes.getColumnModel().getColumn(3).setMaxWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setMinWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setText("Clientes");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Buscar");

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

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBuscar.setCaretColor(new java.awt.Color(153, 153, 153));
        txtBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 643, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(227, 227, 227)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(447, 447, 447)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesTomarDatos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesTomarDatos

    }//GEN-LAST:event_tablaClientesTomarDatos

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JTable tablaClientes;
    public rojeru_san.rsfield.RSTextFullRound txtBuscar;
    // End of variables declaration//GEN-END:variables

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
}
