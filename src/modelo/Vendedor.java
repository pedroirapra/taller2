package modelo;

public class Vendedor {

    private int id;
    private String nombre;
    private String apellido;
    private String rut;
    private int nroVentas;

    public Vendedor() {
    }

    public Vendedor(int id, String nombre, String apellido, String rut) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }
       public Vendedor(int id, String nombre, String apellido, String rut, int nroVentas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nroVentas=nroVentas;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getNroVentas() {
        return nroVentas;
    }

    public void setNroVentas(int nroVentas) {
        this.nroVentas = nroVentas;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    
}
