/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastos;
import Entidades.*;
import Procesos.*;
import GUI.*;

/**
 *
 * @author roban
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    
    private static Factory factory;
    
    public static void main(String[] args) {
        factory = new Factory();
        BaseDatos base = factory.basedatos();
        Usuario user = base.obtenerUsuario();

        /*Fechas fecha = new Fechas();
        fecha.EstaSemana();
        
        fecha.EsteMes();
        
        fecha.Ahora();*/
        
        
        if(user == null){
            System.out.print("El usuario es nulo");
            factory = new Factory();
            Registro regi = factory.registro();
            regi.setVisible(true);
        }else{
            System.out.print("Hay un usuario registrado");
            Double fondos = base.obtenerFondos();
            user.setSaldo(fondos);
            base.actualizarSaldo(fondos);
            Principal form = factory.principal(user);
            form.setVisible(true);
        }
    }
}
