/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;
import GUI.*;
import Procesos.*;
import Entidades.*;

/**
 *
 * @author roban
 */
public class Factory {
    
    public BaseDatos basedatos(){
        return new BaseDatos();
    }
    
    public Usuario usuario(String nombre, int edad, String direccion, String correo, Double saldo, int telefono){
        return new Usuario(nombre, edad, direccion, correo, saldo, telefono);
    }
    
    public Movimiento movimiento(String descripcion, String tipomovimiento, String fecha, Double monto){
        return new Movimiento(descripcion, tipomovimiento, fecha, monto);
    }
    
    
    /*----------------------CARGA DE LAS GUI-----------------------------*/
    public Principal principal(Usuario usuario){
        return new Principal(usuario);
    }
    
    public Registro registro(){
        return new Registro();
    }
    
    public AñadirFondos fondos(){
        return new AñadirFondos();
    }
    
    public NuevoGasto gastoGUI(){
        return new NuevoGasto();
    }
    
    public Perfil perfilGUI(Usuario usuario){
        return new Perfil(usuario);
    }
    
    public BusquedaAvanzada busquedaAvanzada(Usuario usuario){
        return new BusquedaAvanzada(usuario);
    }
}
