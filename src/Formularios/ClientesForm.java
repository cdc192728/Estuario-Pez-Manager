
package Formularios;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Clases.Historial;
import Controlador.DaoClientes;
import Controlador.DaoHistorial;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ClientesForm extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener {

    Conexion con = new Conexion();
    Connection cn = con.estableceConexion();

    Clientes c = new Clientes();
    Estanques e = new Estanques();
    DaoClientes dao = new DaoClientes();
    DefaultTableModel modeloClientes = new DefaultTableModel();

    public static int idCli;
    public static String propietario;

    public ClientesForm() {
        initComponents();
        this.setTitle("Registro de clientes");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.txtBuscar.getDocument().addDocumentListener(this);
        this.tablaClientes.getSelectionModel().addListSelectionListener(this);
        listarClientes();
    }

    private void listarClientes() {
        List<Clientes> lista = dao.Listar();
        modeloClientes = (DefaultTableModel) tablaClientes.getModel();
        Object[] ob = new Object[6];

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

    public void LimpiarTabla() {
        int filas = modeloClientes.getRowCount();
        
        for(int i = 0; i < filas; i++){
            modeloClientes.removeRow(0);
        }
    }

//    public void MostrarTabla(JTable tabla){
//        DefaultTableModel modelo = new DefaultTableModel();
//        modelo.addColumn("Id");
//        modelo.addColumn("Pisicola");
//        modelo.addColumn("Propietario");
//        modelo.addColumn("Direccion");
//        modelo.addColumn("Celular");
//        modelo.addColumn("Email");
//        String sql = "SELECT*FROM cliente";
//        Statement st;
//        try{
//            st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                Object[] lista = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
//                modelo.addRow(lista);
//            }
//            tabla.setModel(modelo);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, "Error al listar datos "+e);
//        }
//    }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        btnEli = new javax.swing.JMenuItem();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        panelRound20 = new Clases.PanelRound();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtId = new rojeru_san.rsfield.RSTextFullRound();
        txtPisc = new rojeru_san.rsfield.RSTextFullRound();
        txtDirec = new rojeru_san.rsfield.RSTextFullRound();
        txtProp = new rojeru_san.rsfield.RSTextFullRound();
        txtCel = new rojeru_san.rsfield.RSTextFullRound();
        txtEmail = new rojeru_san.rsfield.RSTextFullRound();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnMod = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnIngEst = new RSMaterialComponent.RSButtonMaterialIconShadow();
        btnIngEst1 = new RSMaterialComponent.RSButtonMaterialIconShadow();
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        panelRound20.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound20.setRoundBottomLeft(20);
        panelRound20.setRoundBottomRight(20);
        panelRound20.setRoundTopLeft(20);
        panelRound20.setRoundTopRight(20);

        jLabel29.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel29.setText("Email");

        jLabel30.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel30.setText("Clientes");

        jLabel31.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel31.setText("Propietario");

        jLabel32.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel32.setText("Pisicola");

        jLabel33.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel33.setText("Direccion");

        jLabel34.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel34.setText("Id");

        jLabel35.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel35.setText("Celular");

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(153, 153, 153));
        txtId.setForeground(new java.awt.Color(51, 51, 51));
        txtId.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtId.setCaretColor(new java.awt.Color(153, 153, 153));
        txtId.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtId.setPhColor(new java.awt.Color(255, 255, 255));
        txtId.setPlaceholder("");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtPisc.setBackground(new java.awt.Color(255, 255, 255));
        txtPisc.setForeground(new java.awt.Color(51, 51, 51));
        txtPisc.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtPisc.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtPisc.setPhColor(new java.awt.Color(255, 255, 255));
        txtPisc.setPlaceholder("");
        txtPisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPiscActionPerformed(evt);
            }
        });
        txtPisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPiscKeyTyped(evt);
            }
        });

        txtDirec.setBackground(new java.awt.Color(255, 255, 255));
        txtDirec.setForeground(new java.awt.Color(51, 51, 51));
        txtDirec.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtDirec.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtDirec.setPhColor(new java.awt.Color(255, 255, 255));
        txtDirec.setPlaceholder("");
        txtDirec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirecKeyTyped(evt);
            }
        });

        txtProp.setBackground(new java.awt.Color(255, 255, 255));
        txtProp.setForeground(new java.awt.Color(51, 51, 51));
        txtProp.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtProp.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtProp.setPhColor(new java.awt.Color(255, 255, 255));
        txtProp.setPlaceholder("");
        txtProp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPropKeyTyped(evt);
            }
        });

        txtCel.setBackground(new java.awt.Color(255, 255, 255));
        txtCel.setForeground(new java.awt.Color(51, 51, 51));
        txtCel.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtCel.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtCel.setPhColor(new java.awt.Color(255, 255, 255));
        txtCel.setPlaceholder("");
        txtCel.setSoloNumeros(true);
        txtCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelActionPerformed(evt);
            }
        });
        txtCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelKeyTyped(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));
        txtEmail.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtEmail.setPhColor(new java.awt.Color(255, 255, 255));
        txtEmail.setPlaceholder("");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setRound(20);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnMod.setBackground(new java.awt.Color(255, 72, 54));
        btnMod.setText("Modificar");
        btnMod.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnMod.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnMod.setRound(20);
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        btnCan.setBackground(new java.awt.Color(255, 72, 54));
        btnCan.setText("Cancelar");
        btnCan.setEnabled(false);
        btnCan.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCan.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCan.setRound(20);
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel35)
                            .addComponent(jLabel29))
                        .addGap(26, 26, 26)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPisc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDirec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPisc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)))
                .addGap(30, 30, 30)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtProp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Ingreso de clientes");

        tablaClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Pisicola", "Propietario", "Direccion", "Celular", "Email"
            }
        ));
        tablaClientes.setComponentPopupMenu(popMenu);
        tablaClientes.setGridColor(new java.awt.Color(255, 80, 78));
        tablaClientes.setSelectionBackground(new java.awt.Color(255, 80, 78));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TomarDatos(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setMinWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaClientes.getColumnModel().getColumn(1).setMinWidth(120);
            tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaClientes.getColumnModel().getColumn(1).setMaxWidth(120);
            tablaClientes.getColumnModel().getColumn(2).setMinWidth(230);
            tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(230);
            tablaClientes.getColumnModel().getColumn(2).setMaxWidth(230);
            tablaClientes.getColumnModel().getColumn(3).setMinWidth(150);
            tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaClientes.getColumnModel().getColumn(3).setMaxWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setMinWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablaClientes.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Buscar");

        btnIngEst.setBackground(new java.awt.Color(255, 72, 54));
        btnIngEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 3.png"))); // NOI18N
        btnIngEst.setText("Ingresar Estanque");
        btnIngEst.setEnabled(false);
        btnIngEst.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnIngEst.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnIngEst.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono Limpiar.png"))); // NOI18N
        btnIngEst.setRound(20);
        btnIngEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngEstActionPerformed(evt);
            }
        });

        btnIngEst1.setBackground(new java.awt.Color(255, 72, 54));
        btnIngEst1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 3.png"))); // NOI18N
        btnIngEst1.setText("Volver");
        btnIngEst1.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnIngEst1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnIngEst1.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnIngEst1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono Limpiar.png"))); // NOI18N
        btnIngEst1.setRound(20);
        btnIngEst1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngEst1ActionPerformed(evt);
            }
        });

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBuscar.setCaretColor(new java.awt.Color(153, 153, 153));
        txtBuscar.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(194, 194, 194)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngEst, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(btnIngEst1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(jLabel3)
                .addGap(20, 20, 20))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelRound20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngEst1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 68, Short.MAX_VALUE))
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
        int filaObtenida = tablaClientes.getSelectedRow();
        TableModel modelo = tablaClientes.getModel();
        Object id = modelo.getValueAt(filaObtenida, 0);

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este cliente?", "Elimar cliente", JOptionPane.YES_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            DaoClientes dao = new DaoClientes();
            dao.Eliminar((int) id);

            LimpiarCampos();

            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Solicitud calcelada");
        }

        LimpiarTabla();
        listarClientes();
    }//GEN-LAST:event_btnEliActionPerformed

    private void TomarDatos(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TomarDatos


    }//GEN-LAST:event_TomarDatos

    private void btnIngEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngEstActionPerformed
        Formularios.EstanquesForm estanquesCircularesForm = new Formularios.EstanquesForm();
        estanquesCircularesForm.setVisible(true);
        e.setFkCli(idCli);
        
        this.setVisible(false);
    }//GEN-LAST:event_btnIngEstActionPerformed

    private void btnIngEst1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngEst1ActionPerformed
        MenuPrincipal m = new MenuPrincipal();
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_btnIngEst1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtPisc.getText().isEmpty() || txtProp.getText().isEmpty() || txtDirec.getText().isEmpty() || txtCel.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos vacios, rellene los campos para continuar");
        } else {
            c.setPisicola(txtPisc.getText());
            c.setPropietario(txtProp.getText());
            c.setDireccion(txtDirec.getText());
            c.setCelular(txtCel.getText());
            c.setEmail(txtEmail.getText());
            if (dao.Insertar(c)) {
                JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo regitrar el estanque");
            }
        }
        LimpiarTabla();
        listarClientes();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String pisicola = txtPisc.getText();
        String prop = txtProp.getText();
        String dir = txtDirec.getText();
        String cel = txtCel.getText();
        String email = txtEmail.getText();

        Clientes c = new Clientes(pisicola, prop, dir, cel, email);
        DaoClientes daoC = new DaoClientes();

        daoC.Actualizar(c, id);
        LimpiarTabla();
        listarClientes();
        LimpiarCampos();
    }//GEN-LAST:event_btnModActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        btnMod.setEnabled(false);
        btnCan.setEnabled(false);
        btnGuardar.setEnabled(true);
        LimpiarCampos();
    }//GEN-LAST:event_btnCanActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtPiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPiscActionPerformed

    private void txtPiscKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPiscKeyTyped
        if (txtPisc.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPiscKeyTyped

    private void txtPropKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPropKeyTyped
        if (txtProp.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPropKeyTyped

    private void txtDirecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecKeyTyped
        if (txtDirec.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDirecKeyTyped

    private void txtCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelKeyTyped
        if (txtCel.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if (txtEmail.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelActionPerformed

    public Icon icono(String path, int width, int heigth) {
    Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
            .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
    return img;
}

    public void Buscar() {
    String input = txtBuscar.getText();
    BuscarClientes(input, tablaClientes);
}

    public void LimpiarCampos() {
    txtId.setText("");
    txtPisc.setText("");
    txtProp.setText("");
    txtDirec.setText("");
    txtCel.setText("");
    txtEmail.setText("");
}

    @Override
public void actionPerformed(ActionEvent e) {
    Buscar();
}

    public void Datos() {
    int id = tablaClientes.getSelectedRow();

    idCli = Integer.parseInt(modeloClientes.getValueAt(id, 0).toString());
    propietario = modeloClientes.getValueAt(id, 2).toString();
}

    @Override
public void valueChanged(ListSelectionEvent e) {

    if (e.getValueIsAdjusting()) {
        if (e.getSource() == tablaClientes.getSelectionModel()) {
            int filaObtenida = tablaClientes.getSelectedRow();

            Datos();

            if (filaObtenida >= 0) {
                TableModel modelo = tablaClientes.getModel();
                Object id = modelo.getValueAt(filaObtenida, 0);
                Object pisicola = modelo.getValueAt(filaObtenida, 1);
                Object prop = modelo.getValueAt(filaObtenida, 2);
                Object direccion = modelo.getValueAt(filaObtenida, 3);
                Object celular = modelo.getValueAt(filaObtenida, 4);
                Object email = modelo.getValueAt(filaObtenida, 5);

                txtId.setText(id.toString());
                txtPisc.setText(pisicola.toString());
                txtProp.setText(prop.toString());
                txtDirec.setText(direccion.toString());
                txtCel.setText(celular.toString());
                txtEmail.setText(email.toString());

                btnIngEst.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnCan.setEnabled(true);
                btnMod.setEnabled(true);
            }
        }
    }

//        Buscar();
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
    public javax.swing.JMenuItem btnEli;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconShadow btnIngEst;
    private RSMaterialComponent.RSButtonMaterialIconShadow btnIngEst1;
    private RSMaterialComponent.RSButtonMaterialIconDos btnMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private Clases.PanelRound panelRound20;
    private javax.swing.JPopupMenu popMenu;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JTable tablaClientes;
    public rojeru_san.rsfield.RSTextFullRound txtBuscar;
    private rojeru_san.rsfield.RSTextFullRound txtCel;
    private rojeru_san.rsfield.RSTextFullRound txtDirec;
    private rojeru_san.rsfield.RSTextFullRound txtEmail;
    private rojeru_san.rsfield.RSTextFullRound txtId;
    private rojeru_san.rsfield.RSTextFullRound txtPisc;
    private rojeru_san.rsfield.RSTextFullRound txtProp;
    // End of variables declaration//GEN-END:variables

}
