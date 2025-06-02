
package Controlador;

import Clases.Clientes;
import Clases.Conexion;
import Clases.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DaoHistorial {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    Conexion conn = new Conexion();
    Connection cxn = conn.estableceConexion();
    Historial hh = new Historial();
    
    
    public boolean Insertar(Historial h){
        
        String SQL = "insert into historial (nota, fecFin, fkCliente) VALUES(?,?,?)";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            ps.setString(1, h.getNota());
            ps.setString(2, h.getFechaFin());
            ps.setInt(3, h.getFkCliente());
            int n = ps.executeUpdate();
            if (n != 0) {
                return true;
            } else {
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
        List<Historial> lista = new ArrayList<>();
            String SQL = "select historial.id, historial.nota, historial.fecFin, historial.fkCliente, cliente.propietario, cliente.celular, cliente.direccion from historial inner join cliente on historial.fkCliente = cliente.idCliente ORDER BY id";
        try {
            con = cn.estableceConexion();
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Historial h = new Historial();
                h.setIdHis(rs.getInt(1));
                h.setPropietario(rs.getString("propietario"));
                h.setNota(rs.getString(2));
                h.setFechaFin(rs.getString(3));
                h.setTelefono(rs.getString("celular"));
                h.setDireccion(rs.getString("direccion"));
                h.setFkCliente(rs.getInt(4));
                lista.add(h);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        finally{
            cn.cerrarConexion();
        }
        return lista;
    }
    
    public void Actualizar(Historial h, int id){
        try {
            String sql = "UPDATE historial SET nota=? WHERE id="+id+"";
            PreparedStatement ps = cxn.prepareStatement(sql);
            ps.setString(1, h.getNota());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ACTUALIZADO CORRECTAMENTE");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR al actualizar el registro: "+e);
        }
    }
    
    public void Eliminar(int id){
        try {
            String sql = "DELETE FROM historial WHERE id="+id+"";
            PreparedStatement ps = cxn.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR: "+e);
        }finally{
            cn.cerrarConexion();
        }
    }
}
