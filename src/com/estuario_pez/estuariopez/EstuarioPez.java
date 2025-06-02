

package com.estuario_pez.estuariopez;

import Clases.Clientes;
import Clases.Estanques;
import Controlador.DaoEstanques;
import Formularios.EstanquesForm;
import Formularios.FormLogin;
import Formularios.Totales;

public class EstuarioPez {

    public static void main(String[] args){
       
        Clases.Conexion objConexion = new Clases.Conexion();
        objConexion.estableceConexion();
        
        Estanques estanques = new Estanques();
        EstanquesForm estanquesCircularesForm = new EstanquesForm();
        Clientes clientes = new Clientes();
        Totales t = new Totales();
        
        DaoEstanques controladorVistas = new DaoEstanques(clientes, estanques, estanquesCircularesForm, t);
        controladorVistas.Iniciar();
        
        FormLogin objLogin = new FormLogin();
        objLogin.setVisible(true);
        
//        Formularios.MenuPrincipal menuPricipal = new Formularios.MenuPrincipal();
//        menuPricipal.setExtendedState(MAXIMIZED_BOTH);
//        menuPricipal.setVisible(true);
    
    }
    
}
