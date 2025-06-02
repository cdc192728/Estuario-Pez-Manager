
package Controlador;

import java.sql.Connection;
import Clases.Conexion;
import Clases.Clientes;
import Formularios.ClientesForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DaoClientes implements ActionListener, ListSelectionListener, DocumentListener{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    ClientesForm frmClientes;
    
    Clientes c = new Clientes();
    Conexion conn = new Conexion();
    Connection cxn = conn.estableceConexion();

    public DaoClientes() {
    }
    
    public DaoClientes(ClientesForm frmClientes) {
        this.frmClientes.txtBuscar.getDocument().addDocumentListener(this);
    }
    
    public boolean Insertar(Clientes c){
        String SQL = "insert into cliente (pisicola, propietario, direccion, celular, email) VALUES(?,?,?,?,?)";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            ps.setString(1, c.getPisicola());
            ps.setString(2, c.getPropietario());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getCelular());
            ps.setString(5, c.getEmail());
            int n = ps.executeUpdate();
            if(n != 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
            cn.cerrarConexion();
        }
    }
    
    public List Listar(){
        List<Clientes> lista = new ArrayList<>();
        String SQL = "select * from cliente";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Clientes c = new Clientes();
                c.setIdCliente(rs.getInt(1));
                c.setPisicola(rs.getString(2));
                c.setPropietario(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setCelular(rs.getString(5));
                c.setEmail(rs.getString(6));
                lista.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }finally{
            cn.cerrarConexion();
        }
        return lista;
    }
    
    public void Actualizar(Clientes c, int id){
        try {
            String sql = "UPDATE cliente SET pisicola=?, propietario = ?, direccion=?, celular=?, email=? WHERE idCliente="+id+"";
            PreparedStatement pst = cxn.prepareStatement(sql);
            pst.setString(1, c.getPisicola());
            pst.setString(2, c.getPropietario());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getCelular());
            pst.setString(5, c.getEmail());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "ACTUALIZADO CORRECTAMENTE");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: "+e);
        }finally{
            cn.cerrarConexion();
        }
    }
    
    public void Eliminar(int id){
        try {
            String sql = "DELETE FROM cliente WHERE idCliente="+id+"";
            PreparedStatement ps = cxn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR: "+e);
        }finally{
            cn.cerrarConexion();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
//        Buscar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
//        Buscar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
//        Buscar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void Buscar(){
        ClientesForm cliFrm = new ClientesForm();
        String input = cliFrm.txtBuscar.getText();
        cliFrm.BuscarClientes(input, cliFrm.tablaClientes);
    }
}
