package Formularios;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Controlador.DaoEstanques;
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


public class ListaEstanques extends javax.swing.JFrame implements ActionListener, ListSelectionListener, DocumentListener{

    Clientes c = new Clientes();
    DaoClientes dao = new DaoClientes();
    DaoEstanques cv = new DaoEstanques();
    DefaultTableModel modeloEstanques = new DefaultTableModel();
    Estanques estanques = new Estanques();
    
    Conexion cn = new Conexion();

    Connection cnx = cn.estableceConexion();
    
    
    public ListaEstanques() {
        initComponents();
        this.setTitle("Estanques");
        setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        this.txtBuscar.getDocument().addDocumentListener(this);
        this.tablaEstanques.getSelectionModel().addListSelectionListener(this);
        
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
    
    public void Buscar() {
        String input = txtBuscar.getText();
        BuscarClientes(input, tablaEstanques);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelGradiente1 = new rspanelgradiente.RSPanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        tablaClientes = new javax.swing.JScrollPane();
        tablaEstanques = new javax.swing.JTable();
        btnCan = new RSMaterialComponent.RSButtonMaterialIconDos();
        txtBuscar = new rojeru_san.rsfield.RSTextFullRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(153, 153, 153));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(102, 102, 102));
        rSPanelGradiente1.setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 36)); // NOI18N
        jLabel1.setText("Estanques");

        tablaClientes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablaClientes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaEstanques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Propietario", "Id Cliente", "Forma", "Estanque", "Tipo Estanque", "Radio", "Largo", "Ancho", "Profundidad", "Area M2 Circular", "Area M3 Circular", "Area M2 Rectangular", "Area M3 Rectangular", "Peces sembrados", "Especie", "Densidad", "M-45", "M-38", "M-34", "M-30", "Bultos Totales", "Fecha Inicio ", "Fecha Fin", "Peso Promedio Cosechado", "Kg Cosechados", "Toneladas Cosechadas"
            }
        ));
        tablaEstanques.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaEstanques.setGridColor(new java.awt.Color(255, 80, 78));
        tablaEstanques.setSelectionBackground(new java.awt.Color(255, 80, 78));
        tablaClientes.setViewportView(tablaEstanques);
        if (tablaEstanques.getColumnModel().getColumnCount() > 0) {
            tablaEstanques.getColumnModel().getColumn(0).setMinWidth(30);
            tablaEstanques.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaEstanques.getColumnModel().getColumn(0).setMaxWidth(30);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Buscar");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Decorativo Interfaz 2.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(478, 478, 478)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                        .addComponent(tablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addComponent(tablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnCan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private rspanelgradiente.RSPanelGradiente rSPanelGradiente1;
    public javax.swing.JScrollPane tablaClientes;
    public javax.swing.JTable tablaEstanques;
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
