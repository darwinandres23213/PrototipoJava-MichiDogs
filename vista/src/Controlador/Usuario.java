/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import modelo.conexion;
import vista.Vista;
/**
 *
 * @author usuario 1
 */
public class Usuario{

   public static Cliente cliente1=new Cliente();
    public static Proveedor proveedor1=new Proveedor();
    public static Usuario usuario1 = new Usuario();
    
    
    public String nombre;
    public String correo;
    public String rol;
    public  String contraseña;  
    public String telefono;
    public  int id_administrador;
    
    
    public static conexion conexion=new conexion();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }
    
   
    
       public static void registro(){
   
         conexion conexion=new conexion();
         Scanner opcion= new Scanner(System.in);
         
         System.out.println("Bienvenido al regsitro de  MichiDogs");
         System.out.println(" ");
         System.out.println("Porfavor ingrese el nombre de usuario: ");
         usuario1.setNombre(opcion.next());
         System.out.println("Por favor ingrese el correo de usuario: ");
         usuario1.setCorreo(opcion.next());
         System.out.println("Por favor ingrese la contraseña: ");
         usuario1.setContraseña(opcion.next());
         System.out.println("Porfavor ingrese el telefono o numero celular : ");
         usuario1.setTelefono(opcion.next());
         System.out.println(" ");
         System.out.println("por favor ingrese el tipo de usuario ");
         System.out.println("1-Persona natural(comprador)");
         System.out.println("2-Empresa o proveedor");
         int op=opcion.nextInt();
         
         

         if(op==1){
             int dni,edad;
             String apellido;
             System.out.println("ingrese su numero documento");
             dni=opcion.nextInt();
             System.out.println("ingrese su edad ");
             edad=opcion.nextInt();
             System.out.println("ingrese su apellido ");
             apellido=opcion.next();
             try{
                 String consulta="insert into cliente_comprador (rol,nombre,apellido,contraseña,correo,dni,edad,telefono) "+"values (?,?,?,?,?,?,?,?)";
                 conexion.sentencia=conexion.getConexionBD().prepareStatement(consulta);
                 
                 conexion.sentencia.setString(1, "Cliente_Comprador");
                 conexion.sentencia.setString(2, usuario1.getNombre());
                 conexion.sentencia.setString(3, apellido);
                 conexion.sentencia.setString(4,usuario1.getContraseña());
                 conexion.sentencia.setString(5, usuario1.getCorreo());
                 conexion.sentencia.setInt(6, dni);
                 conexion.sentencia.setInt(7, edad);
                 conexion.sentencia.setString(8, usuario1.getTelefono());
                 conexion.sentencia.execute();
                 System.out.println("Cliente registrado ");
                 }catch(Exception e){
                     System.out.println("error : "+ e);
                 }
         }
         else if(op==2){
             System.out.println("ingrese rut empresa, si no posee por favor escriba (no) ");
            String  rut=opcion.next();
             try{
                 String consulta="insert into proveedor(rol,nombre,contraseña,correo,telefono,rut)" +" values (?,?,?,?,?,?)";
                 conexion.sentencia=conexion.getConexionBD().prepareStatement(consulta);
                 conexion.sentencia.setString(1, "Proveedor");
                 conexion.sentencia.setString(2, usuario1.getNombre());
                 conexion.sentencia.setString(3,usuario1.getContraseña());
                 conexion.sentencia.setString(4, usuario1.getCorreo());
                 conexion.sentencia.setString(5, usuario1.getTelefono());
                 conexion.sentencia.setString(6, rut);
                 conexion.sentencia.execute();
                 System.out.println("Cliente registrado ");
                 }catch(Exception e){
                     System.out.println("error : "+ e);
                 }
    
         }
    
    }

    
}

