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

public class HistorialForm extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener {

    Historial h = new Historial();
    DaoHistorial daoH = new DaoHistorial();

    DefaultTableModel modeloHistorial = new DefaultTableModel();
    Conexion cn = new Conexion();

    Connection cnx = cn.estableceConexion();

    public static int fkCli;

    public HistorialForm() {
        initComponents();
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

        String consulta = "select historial.id, historial.nota, historial.fecFin, historial.fkCliente, cliente.propietario, cliente.celular, cliente.direccion from historial inner join cliente on historial.fkCliente = cliente.idCliente where fkCliente in (select idCliente from cliente where propietario like '" + input + "%')";
        try {
            Statement st = cnx.createStatement();
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

    public void CargarDatos() {
        txtProp.setText(EstanquesForm.propietario);
        txtTel.setText(EstanquesForm.telefono);
        txtDir.setText(EstanquesForm.direccion);
        txtFec.setText(EstanquesForm.fechaFin);
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
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        jLabel9 = new javax.swing.JLabel();
        panelRound20 = new Clases.PanelRound();
        jLabel30 = new javax.swing.JLabel();
        btnGua = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnMod = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new rojeru_san.rsfield.RSTextFullRound();
        txtProp = new rojeru_san.rsfield.RSTextFullRound();
        jLabel2 = new javax.swing.JLabel();
        txtFec = new rojeru_san.rsfield.RSTextFullRound();
        jLabel3 = new javax.swing.JLabel();
        txtDir = new rojeru_san.rsfield.RSTextFullRound();
        jLabel4 = new javax.swing.JLabel();
        txtId = new rojeru_san.rsfield.RSTextFullRound();
        jLabel6 = new javax.swing.JLabel();
        txtNota = new rojeru_san.rsfield.RSTextFullRound();
        jLabel5 = new javax.swing.JLabel();
        btnCan3 = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Work Sans", 3, 36)); // NOI18N
        jLabel1.setText("Notas");

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

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBuscar.setCaretColor(new java.awt.Color(153, 153, 153));
        txtBuscar.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Buscar");

        panelRound20.setBackground(new java.awt.Color(255, 147, 134, 110));
        panelRound20.setRoundBottomLeft(20);
        panelRound20.setRoundBottomRight(20);
        panelRound20.setRoundTopLeft(20);
        panelRound20.setRoundTopRight(20);

        jLabel30.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel30.setText("Notas");

        btnGua.setBackground(new java.awt.Color(255, 72, 54));
        btnGua.setText("Guardar");
        btnGua.setFont(new java.awt.Font("Work Sans", 1, 22)); // NOI18N
        btnGua.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGua.setRound(20);
        btnGua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuaActionPerformed(evt);
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
        btnCan.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCan.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCan.setRound(20);
        btnCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel7.setText("Fecha Fin");

        txtTel.setBackground(new java.awt.Color(255, 255, 255));
        txtTel.setForeground(new java.awt.Color(51, 51, 51));
        txtTel.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtTel.setCaretColor(new java.awt.Color(153, 153, 153));
        txtTel.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtTel.setPhColor(new java.awt.Color(255, 255, 255));
        txtTel.setPlaceholder("");
        txtTel.setSoloLetras(true);

        txtProp.setBackground(new java.awt.Color(255, 255, 255));
        txtProp.setForeground(new java.awt.Color(51, 51, 51));
        txtProp.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtProp.setCaretColor(new java.awt.Color(153, 153, 153));
        txtProp.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtProp.setPhColor(new java.awt.Color(255, 255, 255));
        txtProp.setPlaceholder("");

        jLabel2.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel2.setText("Id");

        txtFec.setBackground(new java.awt.Color(255, 255, 255));
        txtFec.setForeground(new java.awt.Color(51, 51, 51));
        txtFec.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtFec.setCaretColor(new java.awt.Color(153, 153, 153));
        txtFec.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtFec.setPhColor(new java.awt.Color(255, 255, 255));
        txtFec.setPlaceholder("");

        jLabel3.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel3.setText("Propietario");

        txtDir.setBackground(new java.awt.Color(255, 255, 255));
        txtDir.setForeground(new java.awt.Color(51, 51, 51));
        txtDir.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtDir.setCaretColor(new java.awt.Color(153, 153, 153));
        txtDir.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtDir.setPhColor(new java.awt.Color(255, 255, 255));
        txtDir.setPlaceholder("");

        jLabel4.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel4.setText("Dirección");

        txtId.setBackground(new java.awt.Color(255, 255, 255));
        txtId.setForeground(new java.awt.Color(51, 51, 51));
        txtId.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtId.setCaretColor(new java.awt.Color(153, 153, 153));
        txtId.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtId.setPhColor(new java.awt.Color(255, 255, 255));
        txtId.setPlaceholder("");

        jLabel6.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel6.setText("Nota");

        txtNota.setBackground(new java.awt.Color(255, 255, 255));
        txtNota.setForeground(new java.awt.Color(51, 51, 51));
        txtNota.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtNota.setCaretColor(new java.awt.Color(153, 153, 153));
        txtNota.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        txtNota.setPhColor(new java.awt.Color(255, 255, 255));
        txtNota.setPlaceholder("");

        jLabel5.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel5.setText("Telefono");

        btnCan3.setBackground(new java.awt.Color(255, 72, 54));
        btnCan3.setText("Volver");
        btnCan3.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCan3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnCan3.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnCan3.setRound(20);
        btnCan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCan3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelRound20Layout.createSequentialGroup()
                                    .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound20Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtProp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(panelRound20Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtFec, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(3, 3, 3)))))
                            .addComponent(btnGua, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound20Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(btnCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound20Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtProp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound20Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound20Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6)))
                        .addGap(19, 19, 19)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtFec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(455, 455, 455)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(15, 15, 15))
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
        int filaObtenida = tblHis.getSelectedRow();
        TableModel modelo = tblHis.getModel();
        Object id = modelo.getValueAt(filaObtenida, 0);

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta nota?", "Elimar nota", JOptionPane.YES_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            DaoHistorial daoh = new DaoHistorial();
            daoH.Eliminar((int) id);

            LimpiarTabla();
            listarHistorial();

            LimpiarCampos();

            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No selecciono nada");
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void btnGuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuaActionPerformed
        if (txtNota.getText().isEmpty() && txtProp.getText().isEmpty() && txtTel.getText().isEmpty() && txtDir.getText().isEmpty() && txtFec.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos vacios, rellene los campos para continuar");
        } else {
            h.setNota(txtNota.getText());
            h.setFechaFin(txtFec.getText());
            h.setFkCliente(fkCli);
            if (daoH.Insertar(h)) {
                JOptionPane.showMessageDialog(null, "Nota registrada con exito");
                btnGua.setEnabled(false);
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo regitrar el estanque");
            }
        }
        LimpiarTabla();
        listarHistorial();
        this.setVisible(false);
    }//GEN-LAST:event_btnGuaActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        int id = Integer.parseInt(txtId.getText());
        String nota = txtNota.getText();

        Historial h = new Historial(nota);
        DaoHistorial daoH = new DaoHistorial();

        daoH.Actualizar(h, id);
        LimpiarTabla();
        listarHistorial();
        LimpiarCampos();
        this.setVisible(false);
    }//GEN-LAST:event_btnModActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnCan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCan3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCan3ActionPerformed

    void LimpiarCampos() {
        txtNota.setText("");
        txtId.setText("");
        txtProp.setText("");
        txtTel.setText("");
        txtDir.setText("");
        txtFec.setText("");
    }

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

        if (!e.getValueIsAdjusting()) {
            if (e.getSource() == tblHis.getSelectionModel()) {
                int filaObtenida = tblHis.getSelectedRow();

//                Datos();
                if (filaObtenida >= 0) {
                    TableModel modelo = tblHis.getModel();
                    Object id = modelo.getValueAt(filaObtenida, 0);
                    Object Propietario = modelo.getValueAt(filaObtenida, 1);
                    Object nota = modelo.getValueAt(filaObtenida, 2);
                    Object fecFin = modelo.getValueAt(filaObtenida, 3);
                    Object telefono = modelo.getValueAt(filaObtenida, 4);
                    Object direccion = modelo.getValueAt(filaObtenida, 5);

                    txtId.setText(id.toString());
                    txtProp.setText(Propietario.toString());
                    txtNota.setText(nota.toString());
                    txtFec.setText(fecFin.toString());
                    txtTel.setText(telefono.toString());
                    txtDir.setText(direccion.toString());

                    btnGua.setEnabled(false);
                    btnCan.setEnabled(true);
                    btnMod.setEnabled(true);
                }

                System.out.println("seleccionado");
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
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan3;
    private javax.swing.JMenuItem btnEli;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGua;
    private RSMaterialComponent.RSButtonMaterialIconDos btnMod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private Clases.PanelRound panelRound20;
    private javax.swing.JPopupMenu popMenu;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JTable tblHis;
    public rojeru_san.rsfield.RSTextFullRound txtBuscar;
    public rojeru_san.rsfield.RSTextFullRound txtDir;
    public rojeru_san.rsfield.RSTextFullRound txtFec;
    public rojeru_san.rsfield.RSTextFullRound txtId;
    public rojeru_san.rsfield.RSTextFullRound txtNota;
    public rojeru_san.rsfield.RSTextFullRound txtProp;
    public rojeru_san.rsfield.RSTextFullRound txtTel;
    // End of variables declaration//GEN-END:variables
}
