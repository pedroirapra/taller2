/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pedro Pablo
 */
public class Venta {
    private int idVenta;
    private String fecha;
    private int idVendedor;
    private int monto;
    private String sucursal;

    public Venta() {
    }

    public Venta(int idVenta, String fecha, int idVendedor, int monto, String sucursal) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.monto = monto;
        this.sucursal = sucursal;
    }

    public Venta(String sucursal, int monto, String fecha, int vendedor) {
        this.sucursal=sucursal;
        this.monto=monto;
        this.fecha=fecha;
        this.idVendedor=vendedor;
       
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", idVendedor=" + idVendedor + ", monto=" + monto + ", sucursal=" + sucursal + '}';
    }
    
    
    
}
