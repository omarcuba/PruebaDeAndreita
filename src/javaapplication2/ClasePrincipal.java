/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Omar
 */
public class ClasePrincipal {
    ConexionMySql nuevaConexion;
    /**
     * @param args the command line arguments
     */
    //Este metodo devuelve los clientes de la base de datos =D
    public ClasePrincipal(){
         nuevaConexion=new ConexionMySql();
         nuevaConexion.crearConexion();
    }
    public ArrayList<Cliente> obtenerListadoClientes(){
        ArrayList<Cliente> clientes=new ArrayList();
        try{
            System.out.println("Hola ");
        //Select sirve para seleccionar los datos de la base de datos
        ResultSet resultados=nuevaConexion.ejecutarSQLSelect("select * from usuario");//Selecciona todos los datos de la tabla cliente
        //Aqui agrega los clientes a una lista de clientes
        while(resultados.next()){
            String dni=resultados.getString("dni");
            String nombre=resultados.getString("nombre");
            String apellidos= resultados.getString("apellidos");
            Cliente clienteBD=new Cliente();
            clienteBD.setApellidos(apellidos);
            clienteBD.setNombre(nombre);
            clienteBD.setDni(dni);
            clientes.add(clienteBD);
        }
        return clientes;
        }
        catch(Exception ex){
            System.err.println("Error en leer clientes/conexion a bd: "+ex.getMessage());
            return clientes;
        }
    }
    
}
