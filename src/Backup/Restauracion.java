package Backup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Restauracion{
    
    private static Restauracion instancia;
    
    //Creamos el método para generar la restauracion
    public void crearRestauracion() throws IOException{ 
        Process proceso = Runtime.getRuntime().exec("C:\\wamp\\bin\\mysql\\mysql5.5.24\\bin\\mysql -u root EstuarioPez"); //aqui tienes que poner el nombre de la base de datos en la cual vas a restaurar el respaldo
        OutputStream salida = proceso.getOutputStream();
//        String ruta = System.getProperty("user.home");
        FileInputStream archivo = new FileInputStream("C:\\Users\\pc\\Documents\\Data\\Respaldo base de datos.sql");
        
        byte[] buffer = new byte[1000];
        int byteLeido = archivo.read(buffer);
        
        while(byteLeido > 0){
            salida.write(buffer,0, byteLeido);
            byteLeido = archivo.read(buffer);
        }
        
        salida.flush();
        salida.close();
        archivo.close();
    }
    
    
    public static Restauracion getInstance(){
        if(instancia == null){
            instancia = new Restauracion();
        }
        return instancia;
    }
}
