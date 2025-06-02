package Controlador;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Estanques;
import Formularios.EstanquesForm;
import Formularios.Totales;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DaoEstanques implements ActionListener {

    public Clientes clientes;
    public Estanques e;
    public EstanquesForm estanquesForm;
    public Totales t;

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    Connection cxn = cn.estableceConexion();

    public int idCli;

    DecimalFormat f1 = new DecimalFormat("###,###,###,###.##"); // formato decimal para valores de dinero

    public DaoEstanques() {

    }

    public DaoEstanques(Clientes clientes, Estanques estanques, EstanquesForm estanquesCircularesForm, Totales t) {
        this.clientes = clientes;
        this.e = estanques;
        this.estanquesForm = estanquesCircularesForm;
        this.t = t;
    }

    public void Calcular() {

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        e.setEstanque(estanquesForm.txtEst.getText()); //asignacion variable estanque

        e.setTipoEstanque(estanquesForm.txtTipEst.getSelectedItem().toString()); // variable tipo estanque

        e.setEspecie(estanquesForm.txtEsp.getSelectedItem().toString());

        e.setFechaInicio(f.format(estanquesForm.txtFecIni.getDate()));

        e.setFechaFin(f.format(estanquesForm.txtFecFin.getDate()));

        e.setProfundidad(Float.parseFloat(estanquesForm.txtProf.getText()));

        e.setDensidad(Float.parseFloat(estanquesForm.txtDen.getText()));

        e.setPesoPromedioCos(Float.parseFloat(estanquesForm.txtPesoProm.getText()));

        if (estanquesForm.tipoEst == 0) { //Circulares

            e.setRadio(Float.parseFloat(estanquesForm.txtRadio.getText()));
            //calcular Area M2 Circulares
            e.setAreaM2Circulares(e.AreaM2Circulares(Float.parseFloat(estanquesForm.txtRadio.getText())));
            estanquesForm.txtAreaM2.setText(Float.toString(e.getAreaM2Circulares()));

            //Calcular Area M3 Circulares
            e.setAreaM3Circulares(e.AreaM3Circulares(Float.parseFloat(EstanquesForm.txtProf.getText()), e.getAreaM2Circulares()));
            estanquesForm.txtAreaM3.setText(Float.toString(e.getAreaM3Circulares()));

            e.setPecesSembreados(e.PecesSembradosCirculares(Float.parseFloat(estanquesForm.txtAreaM3.getText()), Float.parseFloat(estanquesForm.txtDen.getText())));
            estanquesForm.txtPeces.setText(Float.toString(e.getPecesSembreados()));

        }

        if (estanquesForm.tipoEst == 1) { //Rectangulares
            e.setLargo(Float.parseFloat(estanquesForm.txtLargo.getText()));

            e.setAncho(Float.parseFloat(estanquesForm.txtAncho.getText()));
            //Calcular Area M2
            e.setAreaM2Rectangulares(e.AreaM2Rectangulares(Float.parseFloat(estanquesForm.txtLargo.getText()), Float.parseFloat(estanquesForm.txtAncho.getText())));
            estanquesForm.txtAreaM2.setText(Float.toString(e.getAreaM2Rectangulares()));

            //Calcular Area M3 Rectangulares
            e.setAreaM3Circulares(e.AreaM3Rectangulares(Float.parseFloat(estanquesForm.txtProf.getText()), e.getAreaM2Rectangulares()));
            estanquesForm.txtAreaM3.setText(Float.toString(e.getAreaM3Rectangulares()));

            e.setPecesSembreados(e.pecesSembradosRectangulares(Float.parseFloat(estanquesForm.txtAreaM3.getText()), Float.parseFloat(estanquesForm.txtDen.getText())));
            estanquesForm.txtPeces.setText(Float.toString(e.getPecesSembreados()));
        }

        //M45
        e.setM45(e.M45(Float.parseFloat(estanquesForm.txtPeces.getText())));
        estanquesForm.txtM45.setText(Float.toString(e.getM45()));

        //M38
        e.setM38(e.M38(Float.parseFloat(estanquesForm.txtPeces.getText())));
        estanquesForm.txtM38.setText(Float.toString(e.getM38()));

        //M34
        e.setM34(e.M34(Float.parseFloat(estanquesForm.txtPeces.getText())));
        estanquesForm.txtM34.setText(Float.toString(e.getM34()));

        //M30
        e.setM30(e.M30(Float.parseFloat(estanquesForm.txtPeces.getText())));
        estanquesForm.txtM30.setText(Float.toString(e.getM30()));

        //bultos totales
        e.setBultosTotales(e.BultosTotales(Float.parseFloat(estanquesForm.txtM45.getText()), Float.parseFloat(estanquesForm.txtM38.getText()), Float.parseFloat(estanquesForm.txtM34.getText()), Float.parseFloat(estanquesForm.txtM30.getText())));
        estanquesForm.txtBultos.setText(Float.toString(e.getBultosTotales()));

        //kgCosechados
        e.setKGCos(e.KgCosechados(Float.parseFloat(estanquesForm.txtPesoProm.getText()), Float.parseFloat(estanquesForm.txtPeces.getText())));
        estanquesForm.txtKGCos.setText(Float.toString(e.getKGCos()));

        //TonCosechadas
        e.setTonCos(e.ToneladasCosechadas(Float.parseFloat(estanquesForm.txtKGCos.getText())));
        estanquesForm.txtTonCos.setText(Float.toString(e.getTonCos()));
    }

    public boolean Insertar(Estanques estanques) {
        String SQL = "insert into estanque (forma, estanque, tipoEstanque, radio, largo, ancho, profundidad, areaM2Circulares, areaM3Circulares, areaM2Rectangulares, areaM3Rectangulares, pecesSembrados, especie, densidad, M45, M38, M34, M30, bultosTotales, fechaInicioCultivo, fechaFinalizacionCultivo, pesoPromedioCosechado, kgCosechados, toneladasCosechadas, fkCliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            ps.setString(1, e.getForma());
            ps.setString(2, e.getEstanque());
            ps.setString(3, e.getTipoEstanque());
            ps.setFloat(4, e.getRadio());
            ps.setFloat(5, e.getLargo());
            ps.setFloat(6, e.getAncho());
            ps.setFloat(7, e.getProfundidad());
            ps.setFloat(8, e.getAreaM2Circulares());
            ps.setFloat(9, e.getAreaM3Circulares());
            ps.setFloat(10, e.getAreaM2Rectangulares());
            ps.setFloat(11, e.getAreaM3Rectangulares());
            ps.setFloat(12, e.getPecesSembreados());
            ps.setString(13, e.getEspecie());
            ps.setFloat(14, e.getDensidad());
            ps.setFloat(15, e.getM45());
            ps.setFloat(16, e.getM38());
            ps.setFloat(17, e.getM34());
            ps.setFloat(18, e.getM30());
            ps.setFloat(19, e.getBultosTotales());
            ps.setString(20, e.getFechaInicio());
            ps.setString(21, e.getFechaFin());
            ps.setFloat(22, e.getPesoPromedioCos());
            ps.setFloat(23, e.getKGCos());
            ps.setFloat(24, e.getTonCos());
            ps.setInt(25, e.getFkCli());
            int n = ps.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } finally {
            cn.cerrarConexion();
        }
    }

    public List Listar() {
        List<Estanques> lista = new ArrayList<>();
        String SQL = "select estanque.idEstanque, estanque.forma, estanque.estanque, estanque.tipoEstanque, estanque.radio, estanque.largo, estanque.ancho, estanque.profundidad, estanque.areaM2Circulares, estanque.areaM3Circulares, estanque.areaM2Rectangulares, estanque.areaM3Rectangulares, estanque.pecesSembrados, estanque.especie, estanque.densidad, estanque.M45, estanque.M38, estanque.M34, estanque.M30, estanque.bultosTotales, estanque.fechaInicioCultivo, estanque.fechaFinalizacionCultivo ,estanque.pesoPromedioCosechado, estanque.kgCosechados, estanque.toneladasCosechadas , estanque.fkCliente, cliente.propietario from estanque inner join cliente on estanque.fkCliente = cliente.idCliente ORDER BY idEstanque";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estanques e = new Estanques();
                e.setIdEstanque(rs.getInt(1));
                e.setForma(rs.getString(2));
                e.setEstanque(rs.getString(3));
                e.setTipoEstanque(rs.getString(4));
                e.setRadio(rs.getFloat(5));
                e.setLargo(rs.getFloat(6));
                e.setAncho(rs.getFloat(7));
                e.setProfundidad(rs.getFloat(8));
                e.setAreaM2Circulares(rs.getFloat(9));
                e.setAreaM3Circulares(rs.getFloat(10));
                e.setAreaM2Rectangulares(rs.getFloat(11));
                e.setAreaM3Rectangulares(rs.getFloat(12));
                e.setPecesSembreados(rs.getFloat(13));
                e.setEspecie(rs.getString(14));
                e.setDensidad(rs.getFloat(15));
                e.setM45(rs.getFloat(16));
                e.setM38(rs.getFloat(17));
                e.setM34(rs.getFloat(18));
                e.setM30(rs.getFloat(19));
                e.setBultosTotales(rs.getFloat(20));
                e.setFechaInicio(rs.getString(21));
                e.setFechaFin(rs.getString(22));
                e.setPesoPromedioCos(rs.getFloat(23));
                e.setKGCos(rs.getFloat(24));
                e.setTonCos(rs.getFloat(25));
                e.setFkCli(rs.getInt(26));
                e.setPropietario(rs.getString("propietario"));
                lista.add(e);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        } finally {
            cn.cerrarConexion();
        }
        return lista;
    }

    public void Actualizar(Estanques es, int id) {
        try {
            String sql = "UPDATE estanque SET forma=?, estanque=?, tipoEstanque=?, radio=?, largo=?, ancho=?, profundidad=?, areaM2Circulares=?, areaM3Circulares=?, areaM2Rectangulares=?, areaM3Rectangulares=?, pecesSembrados=?, especie=?, densidad=?, M45=?, M38=?, M34=?, M30=?, bultosTotales=?, fechaInicioCultivo=?, fechaFinalizacionCultivo=?, pesoPromedioCosechado=?, kgCosechados=?, toneladasCosechadas=? WHERE idEstanque=" + id + "";
            PreparedStatement ps = cxn.prepareStatement(sql);
            ps.setString(1, es.getForma());
            ps.setString(2, es.getEstanque());
            ps.setString(3, es.getTipoEstanque());
            ps.setFloat(4, es.getRadio());
            ps.setFloat(5, es.getLargo());
            ps.setFloat(6, es.getAncho());
            ps.setFloat(7, es.getProfundidad());
            ps.setFloat(8, es.getAreaM2Circulares());
            ps.setFloat(9, es.getAreaM3Circulares());
            ps.setFloat(10, es.getAreaM2Rectangulares());
            ps.setFloat(11, es.getAreaM3Rectangulares());
            ps.setFloat(12, es.getPecesSembreados());
            ps.setString(13, es.getEspecie());
            ps.setFloat(14, es.getDensidad());
            ps.setFloat(15, es.getM45());
            ps.setFloat(16, es.getM38());
            ps.setFloat(17, es.getM34());
            ps.setFloat(18, es.getM30());
            ps.setFloat(19, es.getBultosTotales());
            ps.setString(20, es.getFechaInicio());
            ps.setString(21, es.getFechaFin());
            ps.setFloat(22, es.getPesoPromedioCos());
            ps.setFloat(23, es.getKGCos());
            ps.setFloat(24, es.getTonCos());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ACTUALIZADO CORRECTAMENTE");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: " + e);
        } finally {
            cn.cerrarConexion();
        }
    }

    public void Eliminar(int id) {
        try {
            String sql = "DELETE FROM estanque WHERE idEstanque=" + id + "";
            PreparedStatement ps = cxn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR: " + e);
        } finally {
            cn.cerrarConexion();
        }
    }

    public void Buscar() {
        EstanquesForm estFrm = new EstanquesForm();
        String input = estFrm.txtBuscar.getText();
        estFrm.BuscarClientes(input, estFrm.tablaEstanques);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Iniciar() {
        //vis.setTitle("Descuento");
        estanquesForm.setLocationRelativeTo(null);
    }
}
