/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Entidades.*;
import Procesos.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author roban
 */
public class BaseDatos {
    private static Factory factory;

    String url = "LocalBD\\finanzas.bd";

    Connection connect;
    PreparedStatement st = null;
    ResultSet rs = null;
    
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }
        catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
    
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            //System.out.print(Conector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error al cerrar la conexion");
        }
    }
    
    //Metodos de insersion a la Base de Datos
     public void registrarUsuario(Usuario usuario){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "INSERT INTO usuario (nombre, edad, direccion, correo, telefono, saldo) VALUES (?,?,?,?,?,0)";
            st = connect.prepareStatement(SQLQuery);
            
            st.setString(1, usuario.getNombre());
            st.setInt(2, usuario.getEdad());
            st.setString(3, usuario.getDireccion());
            st.setString(4, usuario.getCorreo());
            st.setInt(5, usuario.getTelefono());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nuevo registro agregado correctamente");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void actualizarUsuario(Usuario usuarioActual){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            
            String nombre = usuarioActual.getNombre();
            int edad = usuarioActual.getEdad();
            String direccion = usuarioActual.getDireccion();
            String correo = usuarioActual.getCorreo();
            Double saldo = usuarioActual.getSaldo();
            int telefono = usuarioActual.getTelefono();
            
            String SQLQuery = "UPDATE usuario SET nombre = '"+nombre+"', edad = '"+edad+"', direccion = '"+direccion+"', correo = '"+correo+"', saldo = '"+saldo+"', telefono = '"+telefono+"'";
            
            
            st = connect.prepareStatement(SQLQuery);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
     
    public void actualizarSaldo(Double saldo){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "UPDATE usuario SET saldo="+saldo+"";
            st = connect.prepareStatement(SQLQuery);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void addCatFondos(String catIngreso){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "INSERT INTO tipoingreso (ingreso) VALUES (?)";
            st = connect.prepareStatement(SQLQuery);
            st.setString(1, catIngreso);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void addCatGastos(String catGasto){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "INSERT INTO tipogasto (gasto) VALUES (?)";
            st = connect.prepareStatement(SQLQuery);
            st.setString(1, catGasto);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
     
     public void ingresoMovimiento(Movimiento movimiento){
         try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "INSERT INTO movimientos (descripcion, tipomovimiento, fecha, monto) VALUES (?,?,?,?)";
            st = connect.prepareStatement(SQLQuery);
            
            st.setString(1, movimiento.getDescripcion());
            st.setString(2, movimiento.getTipomovimiento());
            st.setString(3, movimiento.getFecha());
            st.setDouble(4, movimiento.getMonto());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nuevo registro agregado correctamente");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
     }
     
   //Obtencion de la Base de Datos
   public Usuario obtenerUsuario(){
        factory = new Factory();
        Usuario perfil = null;
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM usuario";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                Double saldo = rs.getDouble("saldo");
                int telefono = rs.getInt("telefono");
                perfil = factory.usuario(nombre, edad, direccion, correo, saldo, telefono);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return perfil;
    }
   
   public Double obtenerFondos(){
       Double fondos = 0.0;
       try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT monto FROM movimientos";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){            
                Double monto = rs.getDouble("monto");
                fondos = fondos+monto;  
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       return fondos;
   }
   
   public ArrayList<Movimiento> obtenerMovimientosMES(String inicio, String fin){
        factory = new Factory();
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM movimientos WHERE fecha BETWEEN '"+inicio+"' AND '"+fin+"' ORDER BY fecha DESC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String descripcion = rs.getString("descripcion");
                String tipoMovimiento = rs.getString("tipomovimiento");
                String fecha = rs.getString("fecha");
                Double monto = rs.getDouble("monto");
                
                Date date = null;
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                
                //Es sumamente ineficiente pero lo que hace es convertir de un tipo de fecha a otro más bunito
                try {
                    date = format.parse(fecha);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
                String fecha2 = df.format(date);
                
                Movimiento movimientosBD = factory.movimiento(descripcion, tipoMovimiento, fecha2, monto);
                listaMovimientos.add(movimientosBD);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaMovimientos;
    }
   
   public ArrayList<Movimiento> obtenerMovimientosRango(String desde, String hasta){
        factory = new Factory();
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM movimientos WHERE fecha BETWEEN '"+desde+"' AND '"+hasta+"' ORDER BY fecha DESC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String descripcion = rs.getString("descripcion");
                String tipoMovimiento = rs.getString("tipomovimiento");
                String fecha = rs.getString("fecha");
                Double monto = rs.getDouble("monto");
                Date date = null;
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                
                //Es sumamente ineficiente pero lo que hace es convertir de un tipo de fecha a otro más bunito
                try {
                    date = format.parse(fecha);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
                String fecha2 = df.format(date);
                
                Movimiento movimientosBD = factory.movimiento(descripcion, tipoMovimiento, fecha2, monto);
                listaMovimientos.add(movimientosBD);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaMovimientos;
    }
   
   public ArrayList<Movimiento> obtenerMovimientosTODOS(){
        factory = new Factory();
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM movimientos ORDER BY fecha DESC ";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String descripcion = rs.getString("descripcion");
                String tipoMovimiento = rs.getString("tipomovimiento");
                String fecha = rs.getString("fecha");
                Double monto = rs.getDouble("monto");
                
                Date date = null;
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                
                //Es sumamente ineficiente pero lo que hace es convertir de un tipo de fecha a otro más bunito
                try {
                    date = format.parse(fecha);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
                String fecha2 = df.format(date);
                
                
                Movimiento movimientosBD = factory.movimiento(descripcion, tipoMovimiento, fecha2, monto);
                listaMovimientos.add(movimientosBD);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaMovimientos;
    }
   
   
   public ArrayList<String> tipoIngreso(){
       factory = new Factory();
       ArrayList<String> listaIngresos = new ArrayList<String>();
       try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM tipoingreso ORDER BY ingreso ASC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String ingreso = rs.getString("ingreso");

                listaIngresos.add(ingreso);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaIngresos;
   }
   
   public ArrayList<String> tipoGastos(){
       factory = new Factory();
       ArrayList<String> listaGastos = new ArrayList<String>();
       try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM tipogasto ORDER BY gasto ASC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String ingreso = rs.getString("gasto");

                listaGastos.add(ingreso);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaGastos;
   }

   //Metodos de busqueda
   
   public ArrayList<Movimiento> buscarMovimiento_Descipcion(String busqueda){
        factory = new Factory();
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM movimientos WHERE descripcion LIKE '%"+busqueda+"%' ORDER BY fecha DESC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String descripcion = rs.getString("descripcion");
                String tipoMovimiento = rs.getString("tipomovimiento");
                String fecha = rs.getString("fecha");
                Double monto = rs.getDouble("monto");
                
                Date date = null;
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                
                //Es sumamente ineficiente pero lo que hace es convertir de un tipo de fecha a otro más bunito
                try {
                    date = format.parse(fecha);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
                String fecha2 = df.format(date);
                
                Movimiento movimientosBD = factory.movimiento(descripcion, tipoMovimiento, fecha2, monto);
                listaMovimientos.add(movimientosBD);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaMovimientos;
    }
   
    public ArrayList<Movimiento> buscarMovimiento_TipoMov(String busqueda){
        factory = new Factory();
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            String SQLQuery = "SELECT * FROM movimientos WHERE tipomovimiento LIKE '%"+busqueda+"%' ORDER BY fecha DESC";
            st = connect.prepareStatement(SQLQuery);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                String descripcion = rs.getString("descripcion");
                String tipoMovimiento = rs.getString("tipomovimiento");
                String fecha = rs.getString("fecha");
                Double monto = rs.getDouble("monto");
                
                Date date = null;
                DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                
                //Es sumamente ineficiente pero lo que hace es convertir de un tipo de fecha a otro más bunito
                try {
                    date = format.parse(fecha);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
                String fecha2 = df.format(date);
                
                Movimiento movimientosBD = factory.movimiento(descripcion, tipoMovimiento, fecha2, monto);
                listaMovimientos.add(movimientosBD);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaMovimientos;
    }
   
}
