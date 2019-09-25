/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Vendedor;
import modelo.VendedorDao;
import modelo.Venta;
import modelo.VentaDao;
import vista.Reporte;

/**
 *
 * @author Pedro Pablo
 */
public class ReporteController implements ActionListener {

    private Reporte vReporte;

    public ReporteController(Reporte vReporte) {
        this.vReporte = vReporte;
    }

    public VendedorDao ed = new VendedorDao();
    public ArrayList<Vendedor> listadoEmp = ed.getEmpleados();
    public VentaDao vd = new VentaDao();
    public ArrayList<Venta> listadoVen = vd.getVentas();
    public int nroMes;
    public String mes;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("obtener")) {
            nroMes = vReporte.mesesCb.getSelectedIndex() + 1;
            mes = "" + vReporte.mesesCb.getSelectedItem();
            mejorVendedor();
            mayorVenta();
            promedioVentas();

        }
        if (e.getActionCommand().equals("cerrar")) {
            vReporte.dispose();
        }
        if (e.getActionCommand().equals("imprimir")) {
            JOptionPane.showMessageDialog(null, "Imprimiendo...");
        }
    }
     public void mayorVenta() {
        int vendedorMejorVenta = 0;
        int mejorMonto = 0;
        for (int i = 0; i < listadoVen.size(); i++) {
            if (nroMes == getMes(listadoVen.get(i).getFecha())) {
                if (mejorMonto < listadoVen.get(i).getMonto()) {
                    mejorMonto = listadoVen.get(i).getMonto();
                    vendedorMejorVenta = listadoVen.get(i).getIdVendedor();
                }
            }
        }

        vReporte.mayorVentaLabel.setText("$" + mejorMonto);
        if (ed.getEmpleado(vendedorMejorVenta)!=null) {
         vReporte.vendedorLabel.setText("" + ed.getEmpleado(vendedorMejorVenta));   
        }else{
         vReporte.vendedorLabel.setText(".");   
        }
        

    }

    public int getMes(String cadena) { //Obtiene el numero de mes de la fecha registrada como varchar en la base de datos 
        char[] cadena_div = cadena.toCharArray();
        String aux = "";
        aux = "" + cadena_div[5] + cadena_div[6];
        int mes = Integer.parseInt(aux);
        return mes;
    }

    public void mejorVendedor() {

        for (int j = 0; j < listadoEmp.size(); j++) {
            listadoEmp.get(j).setNroVentas(0);
            for (int i = 0; i < listadoVen.size(); i++) {
                if (nroMes == getMes(listadoVen.get(i).getFecha())) {
                    if (listadoVen.get(i).getIdVendedor() == listadoEmp.get(j).getId()) {
                        listadoEmp.get(j).setNroVentas(listadoEmp.get(j).getNroVentas() + 1);
                    }
                }
            }
        }

        int mejor = 0;
        String mejores = "";
        for (int j = 0; j < listadoEmp.size(); j++) {
            if (mejor < listadoEmp.get(j).getNroVentas()) {
                mejor = listadoEmp.get(j).getNroVentas();
            }
            if (listadoEmp.get(j).getNroVentas() == mejor && listadoEmp.get(j).getNroVentas() != 0) {

                mejores += listadoEmp.get(j).getNombre() + "- ";
            }
        }

        vReporte.mejorVendedorLabel.setText(mejores+".");
        vReporte.totalVentasLabel.setText("" + mejor);

    }

    public void promedioVentas() {
        double ventasMes = 0;
        int nroVentas = 0;

        for (int j = 0; j < listadoEmp.size(); j++) {
            ventasMes +=listadoEmp.get(j).getNroVentas();
        }

        double promedioVentas = (ventasMes / listadoEmp.size());
       
        vReporte.promVentasLabel.setText("" + promedioVentas);


    }
 

}
