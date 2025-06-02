
package Backup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Respaldo {
    
    private static Respaldo instancia;
    
    //Creamos el método para generar la copia
    public void crearBackup() throws IOException{ //puede llamarse crearRespaldo()
        Process proceso = Runtime.getRuntime().exec("C:\\wamp\\bin\\mysql\\mysql5.5.24\\bin\\mysqldump -u root estuarioPez"); //aqui pones tu ruta de Mysql , usuario y password
        InputStream entrada = proceso.getInputStream();
//        String ruta = System.getProperty("user.home");
        FileOutputStream archivo = new FileOutputStream("C:\\Users\\pc\\Documents\\Data\\Respaldo base de datos.sql");
        
        byte[] buffer = new byte[1000]; 
        int byteLeido = entrada.read(buffer);
        
        while(byteLeido > 0){
            archivo.write(buffer,0, byteLeido);
            byteLeido = entrada.read(buffer);
        }
        
        archivo.close();
    }
    
    
    public static Respaldo getInstance(){
        if(instancia == null){
            instancia = new Respaldo();
        }
        return instancia;
    }
    
}
