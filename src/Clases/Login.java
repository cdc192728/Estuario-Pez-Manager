
package Clases;

import Formularios.FormLogin;
import Formularios.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Login {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuarios validarUsuario(String usuario, String contrasenia){
        Usuarios us = new Usuarios();
        String consulta="select * from usuarios where usuario = '"+usuario+"' and contrasenia=aes_encrypt('"+contrasenia+"','clave')";
        try {
            
            con = cn.estableceConexion();
            ps = con.prepareStatement(consulta);
            rs=ps.executeQuery();
            
            while(rs.next()){
                us.setUsuario(rs.getString(1));
                us.setContrasenia(rs.getString(2));
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "ERROR: "+e.toString());
        }
        return us;
    }
}
