/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pedro Pablo
 */
public class VentaDao {

    Conexion con;

    public VentaDao() {
        this.con = new Conexion();
    }

    public Venta getVenta(int idVen) {
        Connection accesoBD = con.getConexion();
        Venta v = null;

        try {
            String sql = "SELECT * FROM venta WHERE id_venta='" + idVen + "'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int id_venta = resultados.getInt("id_venta");
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha = resultados.getString("fecha");
                int id_vendedor = resultados.getInt("id_vendedor");
                v = new Venta(id_venta, fecha, id_vendedor, monto, sucursal);
            }

            return v;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Venta> getVentas() {

        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM venta;";

            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id_venta = resultados.getInt("id_venta");
                String sucursal = resultados.getString("sucursal");
                int monto = resultados.getInt("monto");
                String fecha = resultados.getString("fecha");
                int id_vendedor = resultados.getInt("id_vendedor");

                ventas.add(new Venta(id_venta, fecha, id_vendedor, monto, sucursal));
            }
            return ventas;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }

    public boolean insertarVenta(Venta v) {
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO venta(sucursal,monto,fecha,id_vendedor) VALUES ('" + v.getSucursal() + "'," + v.getMonto() + ",'" + v.getFecha() + "'," + v.getIdVendedor() + ")";
            Statement st = accesoBD.createStatement();
            st.executeUpdate(sql); //Execute update es para modificar la BD y meter info

            return true;
        } catch (Exception e) {
            System.out.println("Error al insertar");
            e.printStackTrace();
            return false;
        }

    }
}
