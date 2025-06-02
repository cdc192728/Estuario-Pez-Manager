package Formularios;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Clases.Historial;
import Controlador.DaoEstanques;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EstanquesForm extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener {

    Controlador.DaoEstanques controladorVistas = new DaoEstanques();
    Clases.Clientes clientes = new Clientes();
    Clases.Estanques estanques = new Estanques();
    DaoEstanques cv = new DaoEstanques();
    HistorialForm h = new HistorialForm();
    DefaultTableModel modeloEstanques = new DefaultTableModel();
    Totales t = new Totales();

    Conexion cn = new Conexion();

    Connection cnx = cn.estableceConexion();

    public int tipoEst;

    public int idEst;

    boolean isSelectedMod;

    SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");

    public static String direccion;

    public static String telefono;

    public static String fechaFin;

    public static String propietario;

    public EstanquesForm() {
        initComponents();
        this.setTitle("Registro de estanques");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        estanques.setFkCli(ClientesForm.idCli);
        this.txtBuscar.getDocument().addDocumentListener(this);
        this.tablaEstanques.getSelectionModel().addListSelectionListener(this);
        lblId.setText(String.valueOf(ClientesForm.idCli));
        lblNombre.setText(ClientesForm.propietario);
        btnMod.setEnabled(false);
        btnCan.setEnabled(false);
        btnNot.setEnabled(false);
        btnGuardar.setEnabled(false);
        DesactivarCampos();
        DeshabilitarCampos();

        LimpiarTabla();
        listarEstanques();

    }

    public void listarEstanques() {
        List<Estanques> lista = cv.Listar();
        modeloEstanques = (DefaultTableModel) tablaEstanques.getModel();
        Object[] ob = new Object[27];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdEstanque();
            ob[1] = lista.get(i).getPropietario();
            ob[2] = lista.get(i).getFkCli();
            ob[3] = lista.get(i).getForma();
            ob[4] = lista.get(i).getEstanque();
            ob[5] = lista.get(i).getTipoEstanque();
            ob[6] = lista.get(i).getRadio();
            ob[7] = lista.get(i).getLargo();
            ob[8] = lista.get(i).getAncho();
            ob[9] = lista.get(i).getProfundidad();
            ob[10] = lista.get(i).getAreaM2Circulares();
            ob[11] = lista.get(i).getAreaM3Circulares();
            ob[12] = lista.get(i).getAreaM2Rectangulares();
            ob[13] = lista.get(i).getAreaM3Rectangulares();
            ob[14] = lista.get(i).getPecesSembreados();
            ob[15] = lista.get(i).getEspecie();
            ob[16] = lista.get(i).getDensidad();
            ob[17] = lista.get(i).getM45();
            ob[18] = lista.get(i).getM38();
            ob[19] = lista.get(i).getM34();
            ob[20] = lista.get(i).getM30();
            ob[21] = lista.get(i).getBultosTotales();
            ob[22] = lista.get(i).getFechaInicio();
            ob[23] = lista.get(i).getFechaFin();
            ob[24] = lista.get(i).getPesoPromedioCos();
            ob[25] = lista.get(i).getKGCos();
            ob[26] = lista.get(i).getTonCos();

            modeloEstanques.addRow(ob);
        }
        tablaEstanques.setModel(modeloEstanques);
    }

    public void BuscarClientes(String input, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Estanque");
        modelo.addColumn("Propietario");
        modelo.addColumn("Id Cliente");
        modelo.addColumn("Forma");
        modelo.addColumn("Estanque");
        modelo.addColumn("Tipo estanque");
        modelo.addColumn("Radio");
        modelo.addColumn("Largo");
        modelo.addColumn("Ancho");
        modelo.addColumn("Profundidad");
        modelo.addColumn("Area M2 Circulares");
        modelo.addColumn("Area M3 Circulares");
        modelo.addColumn("Area M2 Rectangulares");
        modelo.addColumn("Area M3 Rectangulares");
        modelo.addColumn("Peces sembrados");
        modelo.addColumn("Especie");
        modelo.addColumn("Densidad");
        modelo.addColumn("M-45");
        modelo.addColumn("M-38");
        modelo.addColumn("M-34");
        modelo.addColumn("M-30");
        modelo.addColumn("Bultos Totales");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Fin");
        modelo.addColumn("Peso Promedio");
        modelo.addColumn("Kg Cosechados");
        modelo.addColumn("Toneladas Cosechadas");   

        String consulta = "select estanque.idEstanque, estanque.forma, estanque.estanque, estanque.tipoEstanque, estanque.radio, estanque.largo, estanque.ancho, estanque.profundidad, estanque.areaM2Circulares, estanque.areaM3Circulares, estanque.areaM2Rectangulares, estanque.areaM3Rectangulares, estanque.pecesSembrados, estanque.especie, estanque.densidad, estanque.M45, estanque.M38, estanque.M34, estanque.M30, estanque.bultosTotales, estanque.fechaInicioCultivo, estanque.fechaFinalizacionCultivo ,estanque.pesoPromedioCosechado, estanque.kgCosechados, estanque.toneladasCosechadas , estanque.fkCliente, cliente.propietario from estanque inner join cliente on estanque.fkCliente = cliente.idCliente where fkCliente in (select idCliente from cliente where propietario like '" + input + "%' or forma like '" + input + "%') ORDER BY idEstanque;";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                Object[] lista = {rs.getInt(1),  rs.getString(27), rs.getString(26), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getFloat(8), rs.getFloat(9), rs.getFloat(10), rs.getFloat(11), rs.getFloat(12), rs.getFloat(13), rs.getString(14), rs.getFloat(15), rs.getFloat(16), rs.getFloat(17), rs.getFloat(18), rs.getFloat(19), rs.getFloat(20), rs.getString(21), rs.getString(22), rs.getFloat(23), rs.getFloat(24), rs.getFloat(25)};
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar datos " + e);
        }
    }

    public void LimpiarTabla() {
        for (int i = 0; i < modeloEstanques.getRowCount(); i++) {
            modeloEstanques.removeRow(i);
            i = 0 - 1;
        }
    }

//    public void ListarPropietario(){
//        try {
//            
//            String sql = "select estanque.fkCliente, cliente.propietario from estanque inner join cliente on estanque.fkCliente = cliente.idCliente";
//            
//            con = cn.estableceConexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            
//            tablaEstanques.setModel(modeloEstanques);
//            
//            
//            
//            while(rs.next()){
//                Object fila[] = new Object[3];
//                
//                modeloEstanques.addRow(fila);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        btnEli = new javax.swing.JMenuItem();
        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTipEst = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFecIni = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txtFecFin = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstanques = new javax.swing.JTable();
        txtEsp = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtEst = new rojeru_san.rsfield.RSTextFullRound();
        txtRadio = new rojeru_san.rsfield.RSTextFullRound();
        txtProf = new rojeru_san.rsfield.RSTextFullRound();
        txtLargo = new rojeru_san.rsfield.RSTextFullRound();
        txtAncho = new rojeru_san.rsfield.RSTextFullRound();
        txtDen = new rojeru_san.rsfield.RSTextFullRound();
        txtAreaM2 = new rojeru_san.rsfield.RSTextFullRound();
        txtAreaM3 = new rojeru_san.rsfield.RSTextFullRound();
        txtPeces = new rojeru_san.rsfield.RSTextFullRound();
        txtM45 = new rojeru_san.rsfield.RSTextFullRound();
        txtM38 = new rojeru_san.rsfield.RSTextFullRound();
        txtTonCos = new rojeru_san.rsfield.RSTextFullRound();
        txtM34 = new rojeru_san.rsfield.RSTextFullRound();
        txtM30 = new rojeru_san.rsfield.RSTextFullRound();
        txtBultos = new rojeru_san.rsfield.RSTextFullRound();
        txtKGCos = new rojeru_san.rsfield.RSTextFullRound();
        txtPesoProm = new rojeru_san.rsfield.RSTextFullRound();
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        btnCirc = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnRect = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnCalcular = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnMod = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnNot = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnMod8 = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnVolver = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel3 = new javax.swing.JLabel();
        lblIdEst = new javax.swing.JLabel();

        btnEli.setText("Eliminar");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });
        popMenu.add(btnEli);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rSPanelGradiente1.setForeground(new java.awt.Color(255, 255, 255));
        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTANQUES");

        jLabel2.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Cliente");

        jLabel5.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estanque");

        jLabel6.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de estanque");

        jLabel7.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Radio");

        jLabel8.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Profundidad");

        txtTipEst.setFont(new java.awt.Font("Work Sans", 0, 12)); // NOI18N
        txtTipEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tierra", "Piscina geomembrana", "Piscina concreto" }));
        txtTipEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipEstActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Densidad");

        jLabel11.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Especie");

        jLabel12.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha Inicio Cultivo");

        txtFecIni.setFont(new java.awt.Font("Work Sans", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fecha Fin Cultivo");

        txtFecFin.setFont(new java.awt.Font("Work Sans", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Peso promedio consechado (g)");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Area M2");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Area M3");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Peces sembrados");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("M-45");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("M-38");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("M-34");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("M-30");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bultos totales");

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Toneladas cosechadas");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Kg cosechados");

        jLabel29.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Largo");

        jLabel32.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Ancho");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setFocusable(false);

        tablaEstanques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Estanque", "Propietario", "Id Cliente", "Forma", "Estanque", "Tipo Estanque", "Radio", "Largo", "Ancho", "Profundidad", "Area M2 Circular", "Area M3 Circular", "Area M2 Rectangular", "Area M3 Rectangular", "Peces sembrados", "Especie", "Densidad", "M-45", "M-38", "M-34", "M-30", "Bultos Totales", "Fecha Inicio ", "Fecha Fin", "Peso Promedio Cosechado", "Kg Cosechados", "Toneladas Cosechadas"
            }
        ));
        tablaEstanques.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaEstanques.setComponentPopupMenu(popMenu);
        tablaEstanques.setGridColor(new java.awt.Color(255, 80, 78));
        tablaEstanques.setSelectionBackground(new java.awt.Color(255, 80, 78));
        jScrollPane1.setViewportView(tablaEstanques);
        if (tablaEstanques.getColumnModel().getColumnCount() > 0) {
            tablaEstanques.getColumnModel().getColumn(0).setMinWidth(40);
            tablaEstanques.getColumnModel().getColumn(0).setPreferredWidth(40);
            tablaEstanques.getColumnModel().getColumn(0).setMaxWidth(40);
            tablaEstanques.getColumnModel().getColumn(2).setMinWidth(40);
            tablaEstanques.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaEstanques.getColumnModel().getColumn(2).setMaxWidth(40);
            tablaEstanques.getColumnModel().getColumn(17).setMinWidth(45);
            tablaEstanques.getColumnModel().getColumn(17).setPreferredWidth(45);
            tablaEstanques.getColumnModel().getColumn(17).setMaxWidth(45);
            tablaEstanques.getColumnModel().getColumn(18).setMinWidth(45);
            tablaEstanques.getColumnModel().getColumn(18).setPreferredWidth(45);
            tablaEstanques.getColumnModel().getColumn(18).setMaxWidth(45);
            tablaEstanques.getColumnModel().getColumn(19).setMinWidth(45);
            tablaEstanques.getColumnModel().getColumn(19).setPreferredWidth(45);
            tablaEstanques.getColumnModel().getColumn(19).setMaxWidth(45);
            tablaEstanques.getColumnModel().getColumn(20).setMinWidth(45);
            tablaEstanques.getColumnModel().getColumn(20).setPreferredWidth(45);
            tablaEstanques.getColumnModel().getColumn(20).setMaxWidth(45);
        }

        txtEsp.setFont(new java.awt.Font("Work Sans", 0, 12)); // NOI18N
        txtEsp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cachama blanca", "Bocachico", "Tilapia roja", "Tilapia negra" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar");

        lblNombre.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Propiertario");

        lblId.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Id");

        lblNombre1.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre1.setText("Propiertario");

        txtEst.setBackground(new java.awt.Color(255, 255, 255));
        txtEst.setForeground(new java.awt.Color(51, 51, 51));
        txtEst.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtEst.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtEst.setPhColor(new java.awt.Color(255, 255, 255));
        txtEst.setPlaceholder("");
        txtEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstActionPerformed(evt);
            }
        });
        txtEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstKeyTyped(evt);
            }
        });

        txtRadio.setBackground(new java.awt.Color(255, 255, 255));
        txtRadio.setForeground(new java.awt.Color(51, 51, 51));
        txtRadio.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtRadio.setCaretColor(new java.awt.Color(102, 102, 102));
        txtRadio.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtRadio.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtRadio.setPhColor(new java.awt.Color(255, 255, 255));
        txtRadio.setPlaceholder("");
        txtRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRadioActionPerformed(evt);
            }
        });
        txtRadio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRadioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRadioKeyTyped(evt);
            }
        });

        txtProf.setBackground(new java.awt.Color(255, 255, 255));
        txtProf.setForeground(new java.awt.Color(51, 51, 51));
        txtProf.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtProf.setDisabledTextColor(new java.awt.Color(0, 0, 153));
        txtProf.setDoubleBuffered(true);
        txtProf.setDragEnabled(true);
        txtProf.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtProf.setPhColor(new java.awt.Color(255, 255, 255));
        txtProf.setPlaceholder("");
        txtProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfActionPerformed(evt);
            }
        });
        txtProf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProfKeyTyped(evt);
            }
        });

        txtLargo.setBackground(new java.awt.Color(255, 255, 255));
        txtLargo.setForeground(new java.awt.Color(51, 51, 51));
        txtLargo.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtLargo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtLargo.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtLargo.setPhColor(new java.awt.Color(255, 255, 255));
        txtLargo.setPlaceholder("");
        txtLargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLargoActionPerformed(evt);
            }
        });
        txtLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLargoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoKeyTyped(evt);
            }
        });

        txtAncho.setBackground(new java.awt.Color(255, 255, 255));
        txtAncho.setForeground(new java.awt.Color(51, 51, 51));
        txtAncho.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtAncho.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtAncho.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtAncho.setPhColor(new java.awt.Color(255, 255, 255));
        txtAncho.setPlaceholder("");
        txtAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnchoActionPerformed(evt);
            }
        });
        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnchoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoKeyTyped(evt);
            }
        });

        txtDen.setBackground(new java.awt.Color(255, 255, 255));
        txtDen.setForeground(new java.awt.Color(51, 51, 51));
        txtDen.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtDen.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtDen.setPhColor(new java.awt.Color(255, 255, 255));
        txtDen.setPlaceholder("");
        txtDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDenActionPerformed(evt);
            }
        });
        txtDen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDenKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDenKeyTyped(evt);
            }
        });

        txtAreaM2.setBackground(new java.awt.Color(153, 153, 153));
        txtAreaM2.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaM2.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtAreaM2.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtAreaM2.setPhColor(new java.awt.Color(255, 255, 255));
        txtAreaM2.setPlaceholder("");
        txtAreaM2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaM2ActionPerformed(evt);
            }
        });
        txtAreaM2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaM2KeyTyped(evt);
            }
        });

        txtAreaM3.setBackground(new java.awt.Color(153, 153, 153));
        txtAreaM3.setForeground(new java.awt.Color(51, 51, 51));
        txtAreaM3.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtAreaM3.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtAreaM3.setPhColor(new java.awt.Color(255, 255, 255));
        txtAreaM3.setPlaceholder("");
        txtAreaM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaM3ActionPerformed(evt);
            }
        });
        txtAreaM3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaM3KeyTyped(evt);
            }
        });

        txtPeces.setBackground(new java.awt.Color(153, 153, 153));
        txtPeces.setForeground(new java.awt.Color(51, 51, 51));
        txtPeces.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtPeces.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtPeces.setPhColor(new java.awt.Color(255, 255, 255));
        txtPeces.setPlaceholder("");
        txtPeces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPecesActionPerformed(evt);
            }
        });
        txtPeces.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPecesKeyTyped(evt);
            }
        });

        txtM45.setBackground(new java.awt.Color(153, 153, 153));
        txtM45.setForeground(new java.awt.Color(51, 51, 51));
        txtM45.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtM45.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtM45.setPhColor(new java.awt.Color(255, 255, 255));
        txtM45.setPlaceholder("");
        txtM45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtM45ActionPerformed(evt);
            }
        });
        txtM45.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtM45KeyTyped(evt);
            }
        });

        txtM38.setBackground(new java.awt.Color(153, 153, 153));
        txtM38.setForeground(new java.awt.Color(51, 51, 51));
        txtM38.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtM38.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtM38.setPhColor(new java.awt.Color(255, 255, 255));
        txtM38.setPlaceholder("");
        txtM38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtM38ActionPerformed(evt);
            }
        });
        txtM38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtM38KeyTyped(evt);
            }
        });

        txtTonCos.setBackground(new java.awt.Color(153, 153, 153));
        txtTonCos.setForeground(new java.awt.Color(51, 51, 51));
        txtTonCos.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtTonCos.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtTonCos.setPhColor(new java.awt.Color(255, 255, 255));
        txtTonCos.setPlaceholder("");
        txtTonCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTonCosActionPerformed(evt);
            }
        });
        txtTonCos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTonCosKeyTyped(evt);
            }
        });

        txtM34.setBackground(new java.awt.Color(153, 153, 153));
        txtM34.setForeground(new java.awt.Color(51, 51, 51));
        txtM34.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtM34.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtM34.setPhColor(new java.awt.Color(255, 255, 255));
        txtM34.setPlaceholder("");
        txtM34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtM34ActionPerformed(evt);
            }
        });
        txtM34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtM34KeyTyped(evt);
            }
        });

        txtM30.setBackground(new java.awt.Color(153, 153, 153));
        txtM30.setForeground(new java.awt.Color(51, 51, 51));
        txtM30.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtM30.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtM30.setPhColor(new java.awt.Color(255, 255, 255));
        txtM30.setPlaceholder("");
        txtM30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtM30ActionPerformed(evt);
            }
        });
        txtM30.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtM30KeyTyped(evt);
            }
        });

        txtBultos.setBackground(new java.awt.Color(153, 153, 153));
        txtBultos.setForeground(new java.awt.Color(51, 51, 51));
        txtBultos.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBultos.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtBultos.setPhColor(new java.awt.Color(255, 255, 255));
        txtBultos.setPlaceholder("");
        txtBultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBultosActionPerformed(evt);
            }
        });
        txtBultos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBultosKeyTyped(evt);
            }
        });

        txtKGCos.setBackground(new java.awt.Color(153, 153, 153));
        txtKGCos.setForeground(new java.awt.Color(51, 51, 51));
        txtKGCos.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtKGCos.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtKGCos.setPhColor(new java.awt.Color(255, 255, 255));
        txtKGCos.setPlaceholder("");
        txtKGCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKGCosActionPerformed(evt);
            }
        });
        txtKGCos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKGCosKeyTyped(evt);
            }
        });

        txtPesoProm.setBackground(new java.awt.Color(255, 255, 255));
        txtPesoProm.setForeground(new java.awt.Color(51, 51, 51));
        txtPesoProm.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtPesoProm.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtPesoProm.setPhColor(new java.awt.Color(255, 255, 255));
        txtPesoProm.setPlaceholder("");
        txtPesoProm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoPromActionPerformed(evt);
            }
        });
        txtPesoProm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoPromKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoPromKeyTyped(evt);
            }
        });

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setBorderColor(new java.awt.Color(0, 0, 0, 0));
        txtBuscar.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        txtBuscar.setPhColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPlaceholder("");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnCirc.setBackground(new java.awt.Color(255, 72, 54));
        btnCirc.setText("Circular");
        btnCirc.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCirc.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RADIO_BUTTON_CHECKED);
        btnCirc.setRound(20);
        btnCirc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCircActionPerformed(evt);
            }
        });

        btnRect.setBackground(new java.awt.Color(255, 72, 54));
        btnRect.setText("Rectangular");
        btnRect.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnRect.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INBOX);
        btnRect.setRound(20);
        btnRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectActionPerformed(evt);
            }
        });

        btnCalcular.setBackground(new java.awt.Color(255, 72, 54));
        btnCalcular.setText("Calcular");
        btnCalcular.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnCalcular.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VIEW_AGENDA);
        btnCalcular.setRound(20);
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 72, 54));
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
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
        btnMod.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
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

        btnNot.setBackground(new java.awt.Color(255, 72, 54));
        btnNot.setText("Ingresar Nota");
        btnNot.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnNot.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NOTE);
        btnNot.setRound(20);
        btnNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotActionPerformed(evt);
            }
        });

        btnMod8.setBackground(new java.awt.Color(255, 72, 54));
        btnMod8.setText("Limpiar");
        btnMod8.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnMod8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR);
        btnMod8.setRound(20);
        btnMod8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMod8ActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 72, 54));
        btnVolver.setText("Volver");
        btnVolver.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        btnVolver.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_RIGHT);
        btnVolver.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        btnVolver.setRound(20);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Work Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id Estanque");

        lblIdEst.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N
        lblIdEst.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEst.setText("Id");

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel14)
                .addGap(28, 28, 28)
                .addComponent(txtPesoProm, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(lblIdEst, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(13, 13, 13)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTipEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEst, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel32)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(txtRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)))
                                .addGap(18, 18, 18)
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecIni, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(btnCirc, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(btnRect, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(453, 453, 453))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(583, 583, 583))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(48, 48, 48)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtAreaM2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAreaM3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(71, 71, 71)
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(89, 89, 89))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(26, 26, 26)))
                                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtPeces, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtM45, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel19))
                                                .addGap(18, 18, 18)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtM38, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtM34, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                                .addGap(352, 352, 352)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel22))
                                                .addGap(31, 31, 31)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtM30, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(24, 24, 24)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel30))
                                                .addGap(29, 29, 29)
                                                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtKGCos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTonCos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                                        .addComponent(btnNot, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)
                                        .addComponent(btnMod8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(98, 98, 98)
                                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))))
            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(593, 593, 593))
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(249, 249, 249)
                            .addComponent(jLabel29)
                            .addContainerGap(875, Short.MAX_VALUE)))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lblIdEst))
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblId)))
                .addGap(21, 21, 21)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCirc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEst, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(23, 23, 23))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecIni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addComponent(txtEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtTipEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13))
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)))
                .addGap(34, 34, 34)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtPesoProm, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addComponent(txtAreaM2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeces, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtM38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(txtAreaM3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtM45, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtM34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel31)
                            .addComponent(txtM30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKGCos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30)
                            .addComponent(txtBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTonCos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMod8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNot, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMod, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                    .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel1))
                        .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombre1)
                                .addComponent(lblNombre))))
                    .addGap(59, 59, 59)
                    .addComponent(jLabel29)
                    .addContainerGap(624, Short.MAX_VALUE)))
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

    private void txtTipEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipEstActionPerformed

    }//GEN-LAST:event_txtTipEstActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        int filaObtenida = tablaEstanques.getSelectedRow();
        TableModel modelo = tablaEstanques.getModel();
        Object id = modelo.getValueAt(filaObtenida, 0);

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este estanque?", "Elimar estanque", JOptionPane.YES_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            DaoEstanques daoE = new DaoEstanques();
            daoE.Eliminar((int) id);

            LimpiarTabla();
            listarEstanques();

            LimpiarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "No selecciono nada");
        }
    }//GEN-LAST:event_btnEliActionPerformed

    private void txtEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstActionPerformed
        //        int key = evt.getKeyChar();
//
//        boolean mayusculas = key >= 65 && key <= 90;
//        boolean minusculas = key >= 97 && key <= 122;
//        boolean espacio = key == 32;
//
//        if (!(minusculas || mayusculas || espacio)) {
//            evt.consume();
//        }
    }//GEN-LAST:event_txtEstActionPerformed

    private void txtRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRadioActionPerformed

    private void txtProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfActionPerformed

    private void txtLargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLargoActionPerformed

    private void txtAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnchoActionPerformed

    private void txtRadioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRadioKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
        
        if (txtRadio.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRadioKeyTyped

    private void txtRadioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRadioKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtRadioKeyPressed

    private void txtProfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProfKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtProfKeyPressed

    private void txtProfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProfKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
        
        if (txtProf.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtProfKeyTyped

    private void txtLargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtLargoKeyPressed

    private void txtLargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
        
        if (txtLargo.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLargoKeyTyped

    private void txtAnchoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnchoKeyTyped

    private void txtDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDenActionPerformed

    private void txtDenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDenKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
        
        if (txtEst.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDenKeyTyped

    private void txtAreaM2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaM2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaM2ActionPerformed

    private void txtAreaM2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaM2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaM2KeyTyped

    private void txtAreaM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaM3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaM3ActionPerformed

    private void txtAreaM3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaM3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaM3KeyTyped

    private void txtAnchoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtAnchoKeyPressed

    private void txtDenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDenKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtDenKeyPressed

    private void txtPecesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPecesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPecesActionPerformed

    private void txtPecesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPecesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPecesKeyTyped

    private void txtM45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtM45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM45ActionPerformed

    private void txtM45KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtM45KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM45KeyTyped

    private void txtM38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtM38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM38ActionPerformed

    private void txtM38KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtM38KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM38KeyTyped

    private void txtTonCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTonCosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTonCosActionPerformed

    private void txtTonCosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTonCosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTonCosKeyTyped

    private void txtM34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtM34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM34ActionPerformed

    private void txtM34KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtM34KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM34KeyTyped

    private void txtM30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtM30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM30ActionPerformed

    private void txtM30KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtM30KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtM30KeyTyped

    private void txtBultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBultosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBultosActionPerformed

    private void txtBultosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBultosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBultosKeyTyped

    private void txtKGCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKGCosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKGCosActionPerformed

    private void txtKGCosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKGCosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKGCosKeyTyped

    private void txtPesoPromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoPromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoPromActionPerformed

    private void txtPesoPromKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoPromKeyPressed
        btnGuardar.setEnabled(false);
        btnCalcular.setEnabled(true);
        btnMod.setEnabled(false);
    }//GEN-LAST:event_txtPesoPromKeyPressed

    private void txtPesoPromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoPromKeyTyped
        int key = evt.getKeyChar();

        boolean numero = key >= 48 && key <= 57 || key == 46;

        if (!numero) {
            evt.consume();
        }
        
        if (txtEst.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPesoPromKeyTyped

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnCircActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCircActionPerformed
        estanques.setForma("Circular");
        txtLargo.setEnabled(false);
        txtAncho.setEnabled(false);
        txtRadio.setEnabled(true);
        txtProf.setEnabled(true);

        txtEsp.setEnabled(true);
        txtDen.setEnabled(true);
        txtPesoProm.setEnabled(true);
        txtFecIni.setEnabled(true);
        txtFecFin.setEnabled(true);
        btnCirc.setEnabled(false);
        btnRect.setEnabled(true);

        txtLargo.setBackground(Color.decode("#999999"));
        txtAncho.setBackground(Color.decode("#999999"));
        txtProf.setBackground(Color.decode("#FFFFFF"));
        txtRadio.setBackground(Color.decode("#FFFFFF"));
        txtEsp.setBackground(Color.decode("#FFFFFF"));
        txtDen.setBackground(Color.decode("#FFFFFF"));
        txtPesoProm.setBackground(Color.decode("#FFFFFF"));

        tipoEst = 0;
    }//GEN-LAST:event_btnCircActionPerformed

    private void btnRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectActionPerformed
        estanques.setForma("Rectangular");
        txtRadio.setEnabled(false);
        txtProf.setEnabled(true);
        txtLargo.setEnabled(true);
        txtAncho.setEnabled(true);

        txtEsp.setEnabled(true);
        txtDen.setEnabled(true);
        txtPesoProm.setEnabled(true);
        txtFecIni.setEnabled(true);
        txtFecFin.setEnabled(true);
        btnCirc.setEnabled(true);
        btnRect.setEnabled(false);

        txtLargo.setBackground(Color.decode("#FFFFFF"));
        txtAncho.setBackground(Color.decode("#FFFFFF"));
        txtProf.setBackground(Color.decode("#FFFFFF"));
        txtRadio.setBackground(Color.decode("#999999"));
        txtEsp.setBackground(Color.decode("#FFFFFF"));
        txtDen.setBackground(Color.decode("#FFFFFF"));
        txtPesoProm.setBackground(Color.decode("#FFFFFF"));

        tipoEst = 1;
    }//GEN-LAST:event_btnRectActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (tipoEst == 0) {
            if (txtRadio.getText().isEmpty() || txtDen.getText().isEmpty() || txtPesoProm.getText().isEmpty() || txtProf.getText().isEmpty() || txtEst.getText().isEmpty() || txtFecIni.getDate() == null || txtFecFin.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Hay campos vacios, rellene los campos para continuar");
            } else {
                
                if (isSelectedMod) {
                    btnMod.setEnabled(true);
                } else {
                    btnGuardar.setEnabled(true);
                }
                
                isSelectedMod = false;
                
                controladorVistas = new DaoEstanques(clientes, estanques, this, t);

                controladorVistas.Calcular();

                btnCalcular.setEnabled(false);
            }
        } else if (tipoEst == 1) {
            if (txtAncho.getText().isEmpty() || txtLargo.getText().isEmpty() || txtDen.getText().isEmpty() || txtPesoProm.getText().isEmpty() || txtProf.getText().isEmpty() || txtEst.getText().isEmpty() || txtFecIni.getDate() == null || txtFecFin.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Hay campos vacios, rellene los campos para continuar");
            } else {
                
                if (isSelectedMod) {
                    btnMod.setEnabled(true);
                } else {
                    btnGuardar.setEnabled(true);
                }
                
                isSelectedMod = false;
                
                controladorVistas = new DaoEstanques(clientes, estanques, this, t);

                controladorVistas.Calcular();

                btnCalcular.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtEst.getText().isEmpty() || txtFecIni.getDate() == null || txtFecFin.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Hay campos vacios, rellene los campos para continuar");
        } else {
            if (controladorVistas.Insertar(estanques)) {
                JOptionPane.showMessageDialog(null, "Estanque registrado con exito");
                btnGuardar.setEnabled(false);
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo regitrar el estanque");
            }
        }
        LimpiarTabla();
        listarEstanques();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        int id = idEst;
        String forma = estanques.getForma();
        String estanque = txtEst.getText();
        String tipoEstanque = txtTipEst.getSelectedItem().toString();
        float radio = Float.parseFloat(txtRadio.getText());
        float largo = Float.parseFloat(txtLargo.getText());
        float ancho = Float.parseFloat(txtAncho.getText());
        float profundidad = Float.parseFloat(txtProf.getText());
        float areaM2Circulares = Float.parseFloat(txtAreaM2.getText());
        float areaM3Circulares = Float.parseFloat(txtAreaM3.getText());
        float areaM2Rectangulares = Float.parseFloat(txtAreaM2.getText());
        float areaM3Rectangulares = Float.parseFloat(txtAreaM3.getText());
        float pecesSembrados = Float.parseFloat(txtPeces.getText());
        String especie = txtEsp.getSelectedItem().toString();
        float densidad = Float.parseFloat(txtDen.getText());
        float M45 = Float.parseFloat(txtM45.getText());
        float M38 = Float.parseFloat(txtM38.getText());
        float M34 = Float.parseFloat(txtM34.getText());
        float M30 = Float.parseFloat(txtM30.getText());
        float bultosTotales = Float.parseFloat(txtBultos.getText());
        String fecIni = fecha.format(txtFecIni.getDate());
        String fecFin = fecha.format(txtFecFin.getDate());
        float pesoProm = Float.parseFloat(txtPesoProm.getText());
        float KgCos = Float.parseFloat(txtKGCos.getText());
        float TonCos = Float.parseFloat(txtTonCos.getText());

        Estanques e = new Estanques(id, forma, estanque, tipoEstanque, radio, largo, ancho, profundidad, areaM2Circulares, areaM3Circulares, areaM2Rectangulares, areaM3Rectangulares, pecesSembrados, especie, densidad, M45, M38, M34, M30, bultosTotales, fecIni, fecFin, pesoProm, KgCos, TonCos);
        DaoEstanques cv = new DaoEstanques();

        cv.Actualizar(e, id);
        modeloEstanques.removeRow(0);
        LimpiarTabla();
        listarEstanques();
        LimpiarCampos();
        btnMod.setEnabled(false);
        btnCan.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnModActionPerformed

    private void btnCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanActionPerformed
        btnMod.setEnabled(false);
        btnCan.setEnabled(false);
        btnGuardar.setEnabled(true);
        isSelectedMod = false;
        LimpiarCampos();
    }//GEN-LAST:event_btnCanActionPerformed

    private void btnNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotActionPerformed
        h.CargarDatos();
        h.setVisible(true);
    }//GEN-LAST:event_btnNotActionPerformed

    private void btnMod8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMod8ActionPerformed
        LimpiarCampos();
        btnMod.setEnabled(false);
        btnCalcular.setEnabled(false);
        btnCan.setEnabled(false);
        btnGuardar.setEnabled(true);
        isSelectedMod = false;
    }//GEN-LAST:event_btnMod8ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ClientesForm cf = new ClientesForm();
        this.setVisible(false);
        cf.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstKeyTyped
        if (txtEst.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEstKeyTyped

    public void DesactivarCampos() {
        txtRadio.setEnabled(false);
        txtProf.setEnabled(false);
        txtLargo.setEnabled(false);
        txtAncho.setEnabled(false);
        txtEsp.setEnabled(false);
        txtDen.setEnabled(false);
        txtPesoProm.setEnabled(false);
        txtFecIni.setEnabled(false);
        txtFecFin.setEnabled(false);
        txtLargo.setBackground(Color.decode("#999999"));
        txtAncho.setBackground(Color.decode("#999999"));
        txtProf.setBackground(Color.decode("#999999"));
        txtRadio.setBackground(Color.decode("#999999"));
        txtEsp.setBackground(Color.decode("#999999"));
        txtDen.setBackground(Color.decode("#999999"));
        txtPesoProm.setBackground(Color.decode("#999999"));

    }

    public void DeshabilitarCampos() {
        txtAreaM2.setEditable(false);
        txtAreaM3.setEditable(false);
        txtPeces.setEditable(false);
        txtM45.setEditable(false);
        txtM38.setEditable(false);
        txtM34.setEditable(false);
        txtM30.setEditable(false);
        txtBultos.setEditable(false);
        txtKGCos.setEditable(false);
        txtTonCos.setEditable(false);
    }

    public void LimpiarCampos() {
        txtEst.setText("");
        txtTipEst.setSelectedItem("");
        txtAreaM2.setText("");
        txtAreaM3.setText("");
        txtRadio.setText("");
        txtAncho.setText("");
        txtLargo.setText("");
        txtProf.setText("");
        txtPeces.setText("");
        txtEsp.setSelectedItem("");
        txtDen.setText("");
        txtM45.setText("");
        txtM38.setText("");
        txtM34.setText("");
        txtM30.setText("");
        txtBultos.setText("");
        txtFecIni.setDate(null);
        txtFecFin.setDate(null);
        txtPesoProm.setText("");
        txtKGCos.setText("");
        txtTonCos.setText("");
    }

    public void Buscar() {
        String input = txtBuscar.getText();
        BuscarClientes(input, tablaEstanques);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Buscar();
    }

//    public void Datos() {
//        int id = tablaEstanques.getSelectedRow();
//
//        idCli = Integer.parseInt(modeloEstanques.getValueAt(id, 0).toString());
//        propietario = modeloEstanques.getValueAt(id, 2).toString();
//    }
//    public void DatosCliente() {
//        String consulta = "select estanque.idEstanque, estanque.forma, estanque.estanque, estanque.tipoEstanque, estanque.radio, estanque.largo, estanque.ancho, estanque.profundidad, estanque.areaM2Circulares, estanque.areaM3Circulares, estanque.areaM2Rectangulares, estanque.areaM3Rectangulares, estanque.pecesSembrados, estanque.especie, estanque.densidad, estanque.M45, estanque.M38, estanque.M34, estanque.M30, estanque.bultosTotales, estanque.fechaInicioCultivo, estanque.fechaFinalizacionCultivo ,estanque.pesoPromedioCosechado, estanque.kgCosechados, estanque.toneladasCosechadas ,estanque.fkCliente, cliente.propietario from estanque inner join cliente on estanque.fkCliente = cliente.idCliente where fkCliente in (select idCliente from cliente where propietario like '" + input + "%')";
//        try {
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(consulta);
//
//            while (rs.next()) {
//                rs.getInt(1)
//                , rs.getString(2)
//            };
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Error al listar datos " + e);
//        }
//    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            isSelectedMod = true;
            if (e.getSource() == tablaEstanques.getSelectionModel()) {
                int filaObtenida = tablaEstanques.getSelectedRow();

                if (filaObtenida >= 0) {
                    TableModel modelo = tablaEstanques.getModel();
                    fechaFin = modelo.getValueAt(filaObtenida, 23).toString();
                    propietario = modelo.getValueAt(filaObtenida, 1).toString();
                    HistorialForm.fkCli = Integer.parseInt(modelo.getValueAt(filaObtenida, 2).toString());
                    Datos(Integer.parseInt(modelo.getValueAt(filaObtenida, 2).toString()));
                    Object id = modelo.getValueAt(filaObtenida, 0);
                    lblIdEst.setText(modelo.getValueAt(filaObtenida, 0).toString());
                    idEst = Integer.parseInt(lblIdEst.getText());
                    Object forma = modelo.getValueAt(filaObtenida, 3);
                    Object estanque = modelo.getValueAt(filaObtenida, 4);
                    Object tipoEstanque = modelo.getValueAt(filaObtenida, 5);
                    Object radio = modelo.getValueAt(filaObtenida, 6);
                    Object largo = modelo.getValueAt(filaObtenida, 7);
                    Object ancho = modelo.getValueAt(filaObtenida, 8);
                    Object profundidad = modelo.getValueAt(filaObtenida, 9);

                    if (modelo.getValueAt(filaObtenida, 3).equals("Circular")) {
                        Object areaM2Circulares = modelo.getValueAt(filaObtenida, 10);
                        Object areaM3Circulares = modelo.getValueAt(filaObtenida, 11);
                        txtAreaM2.setText(areaM2Circulares.toString());
                        txtAreaM3.setText(areaM3Circulares.toString());
                        estanques.setForma("Circular");
                        txtLargo.setEnabled(false);
                        txtAncho.setEnabled(false);
                        txtRadio.setEnabled(true);
                        txtProf.setEnabled(true);

                        txtEsp.setEnabled(true);
                        txtDen.setEnabled(true);
                        txtPesoProm.setEnabled(true);
                        txtFecIni.setEnabled(true);
                        txtFecFin.setEnabled(true);
                        btnCirc.setEnabled(false);
                        btnRect.setEnabled(true);

                        txtLargo.setBackground(Color.decode("#999999"));
                        txtAncho.setBackground(Color.decode("#999999"));
                        txtProf.setBackground(Color.decode("#FFFFFF"));
                        txtRadio.setBackground(Color.decode("#FFFFFF"));
                        txtEsp.setBackground(Color.decode("#FFFFFF"));
                        txtDen.setBackground(Color.decode("#FFFFFF"));
                        txtPesoProm.setBackground(Color.decode("#FFFFFF"));

                        tipoEstanque = 0;
                        
                        tipoEst = 0;
                        
                    } else if (modelo.getValueAt(filaObtenida, 3).equals("Rectangular")) {
                        Object areaM2Rectangulares = modelo.getValueAt(filaObtenida, 12);
                        Object areaM3Rectangulares = modelo.getValueAt(filaObtenida, 13);
                        txtAreaM2.setText(areaM2Rectangulares.toString());
                        txtAreaM3.setText(areaM3Rectangulares.toString());
                        estanques.setForma("Rectangular");
                        txtRadio.setEnabled(false);
                        txtProf.setEnabled(true);
                        txtLargo.setEnabled(true);
                        txtAncho.setEnabled(true);

                        txtEsp.setEnabled(true);
                        txtDen.setEnabled(true);
                        txtPesoProm.setEnabled(true);
                        txtFecIni.setEnabled(true);
                        txtFecFin.setEnabled(true);
                        btnCirc.setEnabled(true);
                        btnRect.setEnabled(false);

                        txtLargo.setBackground(Color.decode("#FFFFFF"));
                        txtAncho.setBackground(Color.decode("#FFFFFF"));
                        txtProf.setBackground(Color.decode("#FFFFFF"));
                        txtRadio.setBackground(Color.decode("#999999"));
                        txtEsp.setBackground(Color.decode("#FFFFFF"));
                        txtDen.setBackground(Color.decode("#FFFFFF"));
                        txtPesoProm.setBackground(Color.decode("#FFFFFF"));

                        tipoEstanque = 1;
                        
                        tipoEst = 1;
                    }

                    Object pecesSembrados = modelo.getValueAt(filaObtenida, 14);
                    Object especie = modelo.getValueAt(filaObtenida, 15);
                    Object densidad = modelo.getValueAt(filaObtenida, 16);
                    Object M45 = modelo.getValueAt(filaObtenida, 17);
                    Object M38 = modelo.getValueAt(filaObtenida, 18);
                    Object M34 = modelo.getValueAt(filaObtenida, 19);
                    Object M30 = modelo.getValueAt(filaObtenida, 20);
                    Object bultosTotales = modelo.getValueAt(filaObtenida, 21);
                    Object fechaInicio = modelo.getValueAt(filaObtenida, 22);
                    Object FechaFin = modelo.getValueAt(filaObtenida, 23);
                    Object pesoProm = modelo.getValueAt(filaObtenida, 24);
                    Object KgCos = modelo.getValueAt(filaObtenida, 25);
                    Object tonCos = modelo.getValueAt(filaObtenida, 26);

//                    txtId.setText(id.toString());
                    txtEst.setText(estanque.toString());
                    txtTipEst.setSelectedItem(tipoEstanque.toString());
                    txtRadio.setText(radio.toString());
                    txtAncho.setText(ancho.toString());
                    txtLargo.setText(largo.toString());
                    txtProf.setText(profundidad.toString());
                    txtPeces.setText(pecesSembrados.toString());
                    txtEsp.setSelectedItem(especie.toString());
                    txtDen.setText(densidad.toString());
                    txtM45.setText(M45.toString());
                    txtM38.setText(M38.toString());
                    txtM34.setText(M34.toString());
                    txtM30.setText(M30.toString());
                    txtBultos.setText(bultosTotales.toString());
                    txtFecIni.setDate(ParseFecha(fechaInicio.toString()));
                    txtFecFin.setDate(ParseFecha(FechaFin.toString()));
                    txtPesoProm.setText(pesoProm.toString());
                    txtKGCos.setText(KgCos.toString());
                    txtTonCos.setText(tonCos.toString());

//                    btnIngEst.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    btnCan.setEnabled(true);
                    btnMod.setEnabled(true);
                    btnNot.setEnabled(true);
                }
            }
        }
    }

    public void Datos(int index) {
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "select cliente.celular, cliente.direccion from estanque inner join cliente on estanque.fkCliente = cliente.idCliente where cliente.idCliente = '" + index + "%';";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes c = new Clientes();
                telefono = rs.getString(1);
                direccion = rs.getString(2);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        } finally {
            cn.cerrarConexion();
        }
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

    private static Date ParseFecha(String sDate) {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            return date;
        } catch (ParseException ex) {
            return new Date();
            //return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCalcular;
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private RSMaterialComponent.RSButtonMaterialIconDos btnCirc;
    private javax.swing.JMenuItem btnEli;
    private RSMaterialComponent.RSButtonMaterialIconDos btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnMod;
    private RSMaterialComponent.RSButtonMaterialIconDos btnMod8;
    private RSMaterialComponent.RSButtonMaterialIconDos btnNot;
    private RSMaterialComponent.RSButtonMaterialIconDos btnRect;
    private RSMaterialComponent.RSButtonMaterialIconDos btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblId;
    public javax.swing.JLabel lblIdEst;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblNombre1;
    private javax.swing.JPopupMenu popMenu;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JTable tablaEstanques;
    public rojeru_san.rsfield.RSTextFullRound txtAncho;
    public rojeru_san.rsfield.RSTextFullRound txtAreaM2;
    public static rojeru_san.rsfield.RSTextFullRound txtAreaM3;
    public rojeru_san.rsfield.RSTextFullRound txtBultos;
    public rojeru_san.rsfield.RSTextFullRound txtBuscar;
    public rojeru_san.rsfield.RSTextFullRound txtDen;
    public javax.swing.JComboBox<String> txtEsp;
    public rojeru_san.rsfield.RSTextFullRound txtEst;
    public com.toedter.calendar.JDateChooser txtFecFin;
    public com.toedter.calendar.JDateChooser txtFecIni;
    public rojeru_san.rsfield.RSTextFullRound txtKGCos;
    public rojeru_san.rsfield.RSTextFullRound txtLargo;
    public rojeru_san.rsfield.RSTextFullRound txtM30;
    public rojeru_san.rsfield.RSTextFullRound txtM34;
    public rojeru_san.rsfield.RSTextFullRound txtM38;
    public rojeru_san.rsfield.RSTextFullRound txtM45;
    public rojeru_san.rsfield.RSTextFullRound txtPeces;
    public rojeru_san.rsfield.RSTextFullRound txtPesoProm;
    public static rojeru_san.rsfield.RSTextFullRound txtProf;
    public rojeru_san.rsfield.RSTextFullRound txtRadio;
    public javax.swing.JComboBox<String> txtTipEst;
    public rojeru_san.rsfield.RSTextFullRound txtTonCos;
    // End of variables declaration//GEN-END:variables

}
