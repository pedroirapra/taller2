package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDao {

    Conexion con;

    public VendedorDao() {
        this.con = new Conexion();
    }


    public Vendedor getEmpleado(int idEmp) {
        Connection accesoBD = con.getConexion();
        Vendedor em = null;

        try {
            String sql = "SELECT * FROM vendedor WHERE id_vendedor='" + idEmp + "'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int id_vendedor=resultados.getInt("id_vendedor");
                String nombre=resultados.getString("nombre");
                String apellido=resultados.getString("apellido");
                String rut=resultados.getString("rut");
                em= new Vendedor(id_vendedor,nombre,apellido,rut);
            }
            
           return em; 
        } catch (Exception e) {
   System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }
       public ArrayList<Vendedor> getEmpleados(){
        
        ArrayList<Vendedor> empleados = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try{
            String sql="SELECT * FROM vendedor ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
           
            
            while ( resultados.next() ) {
                int id_vendedor=resultados.getInt("id_vendedor");
                String nombre=resultados.getString("nombre");
                String apellido=resultados.getString("apellido");
                String rut=resultados.getString("rut");
                empleados.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            return empleados;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
        
    }

   

}
