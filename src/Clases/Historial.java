
package Clases;

public class Historial {
    int idHis;
    String nota;
    int fkCliente;
    String propietario;
    String telefono;
    String direccion;
    String fechaFin;

    public Historial() {
    }

    public Historial(String nota) {
        this.nota = nota;
    }

    public Historial(int idHis, String nota, int fkCliente, String propietario, String telefono, String direccion, String fechaFin) {
        this.idHis = idHis;
        this.nota = nota;
        this.fkCliente = fkCliente;
        this.propietario = propietario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaFin = fechaFin;
    }

    public int getIdHis() {
        return idHis;
    }

    public void setIdHis(int idHis) {
        this.idHis = idHis;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
    
}
