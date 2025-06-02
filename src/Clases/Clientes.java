package Clases;

public class Clientes {

    int idCliente;
    String pisicola;
    String propietario;
    String direccion;
    String celular;
    String email;

    public Clientes() {
    }

    public Clientes(int idCliente, String pisicola, String propietario, String direccion, String celular, String email) {
        this.idCliente = idCliente;
        this.pisicola = pisicola;
        this.propietario = propietario;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }

    public Clientes(String pisicola, String propietario, String direccion, String celular, String email) {
        this.pisicola = pisicola;
        this.propietario = propietario;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPisicola() {
        return pisicola;
    }

    public void setPisicola(String pisicola) {
        this.pisicola = pisicola;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
