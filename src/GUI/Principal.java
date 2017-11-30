/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entidades.*;
import Procesos.*;
import GUI.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author roban
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private static Factory factory;
    static Usuario usuario;
    DecimalFormat def = new DecimalFormat("#.00");
    
    public Principal(Usuario usuario) {
        factory = new Factory();
        initComponents();
        this.usuario = usuario;
        cargarColumnasTabla();
        cargarModeloTabla();
        
        this.setLocationRelativeTo(null);
    }
    
    DefaultTableModel modeloTabla = new DefaultTableModel();

    private void cargarColumnasTabla(){
        
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Tipo de Movimiento");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Monto");
  
    }
    
    private void cargarModeloTabla(){
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        BaseDatos base = factory.basedatos();
        Fechas fechas = factory.fechas();
        RangoFecha rango = fechas.EsteMes();
        
        ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin()));
        int numeroMovimientos = listaMovimientos.size();
        modeloTabla.setNumRows(numeroMovimientos);
        Double total = 0.0;
        for(int i =0;i<numeroMovimientos;i++){
            Movimiento movimientos = listaMovimientos.get(i);
            
            String descripcion = movimientos.getDescripcion();
            String tipoMov = movimientos.getTipomovimiento();
            String fecha = movimientos.getFecha();
            Double monto = movimientos.getMonto();

            total = total+monto;
            
            modeloTabla.setValueAt(descripcion, i, 0);
            modeloTabla.setValueAt(tipoMov, i, 1);
            modeloTabla.setValueAt(fecha, i, 2);
            modeloTabla.setValueAt("$ "+monto, i, 3);
      
        } 
        this.lbl_total.setText("Total de Movimientos: $"+(double)Math.round(total * 100d) / 100d);
    }
    
    private void cargarModeloTablaPreFav(ArrayList<Movimiento> listado){
        Fechas fechas = factory.fechas();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        BaseDatos base = factory.basedatos();
        RangoFecha rango = fechas.EsteMes();
        
        //ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin()));
        int numeroMovimientos = listado.size();
        modeloTabla.setNumRows(numeroMovimientos);
        Double total = 0.0;
        for(int i =0;i<numeroMovimientos;i++){
            Movimiento movimientos = listado.get(i);
            
            String descripcion = movimientos.getDescripcion();
            String tipoMov = movimientos.getTipomovimiento();
            String fecha = movimientos.getFecha();
            Double monto = movimientos.getMonto();

            total = total+monto;
            
            modeloTabla.setValueAt(descripcion, i, 0);
            modeloTabla.setValueAt(tipoMov, i, 1);
            modeloTabla.setValueAt(fecha, i, 2);
            modeloTabla.setValueAt("$ "+monto, i, 3);
      
        } 
        this.lbl_total.setText("Total de Movimientos: $"+(double)Math.round(total * 100d) / 100d);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGroup_rango = new javax.swing.ButtonGroup();
        lbl_titulo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_saldo = new javax.swing.JLabel();
        btn_añadirFondos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_movimientos = new javax.swing.JTable();
        lbl_tituloTabla = new javax.swing.JLabel();
        btn_gasto = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        rbtn_mes = new javax.swing.JRadioButton();
        rtbn_semana = new javax.swing.JRadioButton();
        rbtn_dia = new javax.swing.JRadioButton();
        lbl_fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_perfil = new javax.swing.JMenuItem();
        menu_busquedaAvanzada = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        menu_ayuda = new javax.swing.JMenu();
        menu_acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finanzas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                VentanaActiva(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                apertura(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(240, 240, 240));
        lbl_titulo.setText("Finanzas Personales");
        getContentPane().add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(240, 240, 240));
        lbl_usuario.setText("Bienvenido Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        lbl_saldo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_saldo.setForeground(new java.awt.Color(240, 240, 240));
        lbl_saldo.setText("Saldo disponible:");
        getContentPane().add(lbl_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        btn_añadirFondos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_añadirFondos.setText("Añadir Fondos");
        btn_añadirFondos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirFondosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_añadirFondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 180, 90));

        tabla_movimientos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tabla_movimientos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tabla_movimientos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 1110, 340));

        lbl_tituloTabla.setFont(new java.awt.Font("Roboto", 2, 16)); // NOI18N
        lbl_tituloTabla.setForeground(new java.awt.Color(240, 240, 240));
        lbl_tituloTabla.setText("Movimientos de este mes");
        getContentPane().add(lbl_tituloTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btn_gasto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_gasto.setText("Nuevo Gasto");
        btn_gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gastoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 170, 90));
        getContentPane().add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 180, 190, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 180, 80, -1));

        lbl_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setText("Total:");
        getContentPane().add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, -1, -1));

        bGroup_rango.add(rbtn_mes);
        rbtn_mes.setSelected(true);
        rbtn_mes.setText("Este mes");
        rbtn_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_mesActionPerformed(evt);
            }
        });
        getContentPane().add(rbtn_mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, -1, -1));

        bGroup_rango.add(rtbn_semana);
        rtbn_semana.setText("Esta semana");
        rtbn_semana.setToolTipText("");
        rtbn_semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtbn_semanaActionPerformed(evt);
            }
        });
        getContentPane().add(rtbn_semana, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, -1, -1));

        bGroup_rango.add(rbtn_dia);
        rbtn_dia.setText("Este día");
        rbtn_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_diaActionPerformed(evt);
            }
        });
        getContentPane().add(rbtn_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-570, -460, 1800, 1070));

        menu_archivo.setText("Archivo");

        menu_perfil.setText("Ver Perfil");
        menu_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_perfilActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_perfil);

        menu_busquedaAvanzada.setText("Busqueda Avanzada");
        menu_busquedaAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_busquedaAvanzadaActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_busquedaAvanzada);

        menu_salir.setText("Salir");
        menu_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salirActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_salir);

        jMenuBar1.add(menu_archivo);

        menu_ayuda.setText("Ayuda");

        menu_acercade.setText("Acerca de");
        menu_ayuda.add(menu_acercade);

        jMenuBar1.add(menu_ayuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_menu_salirActionPerformed

    private void menu_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_perfilActionPerformed
        Perfil perfilGUI = factory.perfilGUI(usuario);
        perfilGUI.setVisible(true);
    }//GEN-LAST:event_menu_perfilActionPerformed

    private void apertura(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_apertura
        this.abridoPackman();
    }                         

    private void abridoPackman(){
        String nombreU = usuario.getNombre();
        Double saldoU = usuario.getSaldo();
        this.lbl_usuario.setText("Bienvenido "+nombreU);

        this.lbl_saldo.setText("Saldo: "+ def.format(saldoU));
    }//GEN-LAST:event_apertura

    private void btn_añadirFondosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirFondosActionPerformed
        AñadirFondos fondos = factory.fondos();
        fondos.setVisible(true);
    }//GEN-LAST:event_btn_añadirFondosActionPerformed

    private void btn_gastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gastoActionPerformed
        NuevoGasto gasto = factory.gastoGUI();
        gasto.setVisible(true);
    }//GEN-LAST:event_btn_gastoActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        BaseDatos base = factory.basedatos();
        ArrayList<Movimiento> listaMovimientos = base.buscarMovimiento_Descipcion(this.txt_busqueda.getText());
        int numeroMovimientos = listaMovimientos.size();
        modeloTabla.setNumRows(numeroMovimientos);
        
        for(int i =0;i<numeroMovimientos;i++){
            Movimiento movimientos = listaMovimientos.get(i);
            
            String descripcion = movimientos.getDescripcion();
            String tipoMov = movimientos.getTipomovimiento();
            String fecha = movimientos.getFecha();
            Double monto = movimientos.getMonto();

            modeloTabla.setValueAt(descripcion, i, 0);
            modeloTabla.setValueAt(tipoMov, i, 1);
            modeloTabla.setValueAt(fecha, i, 2);
            modeloTabla.setValueAt("$ "+monto, i, 3);
      
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void menu_busquedaAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_busquedaAvanzadaActionPerformed
        BusquedaAvanzada busquedaGUI = factory.busquedaAvanzada(usuario);
        busquedaGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_busquedaAvanzadaActionPerformed

    private void rbtn_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_mesActionPerformed
        this.rbtn_mes();
    }//GEN-LAST:event_rbtn_mesActionPerformed

    private void rbtn_mes(){
        Fechas fechas = factory.fechas();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        BaseDatos base = factory.basedatos();
        RangoFecha rango = fechas.EsteMes();
        
        this.lbl_tituloTabla.setText("Movimientos de este mes");
        //ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin()));
        this.cargarModeloTablaPreFav(base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin())));
    }
    
    private void rtbn_semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtbn_semanaActionPerformed
        this.rbtn_semana();
    }//GEN-LAST:event_rtbn_semanaActionPerformed

    private void rbtn_semana(){
        Fechas fechas = factory.fechas();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        BaseDatos base = factory.basedatos();
        RangoFecha rango = fechas.EstaSemana();
        
        this.lbl_tituloTabla.setText("Movimientos de esta semana");
        //ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin()));
        this.cargarModeloTablaPreFav(base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin())));
    }
    
    private void rbtn_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_diaActionPerformed
        this.rbtn_dia();
    }//GEN-LAST:event_rbtn_diaActionPerformed

    private void rbtn_dia(){
        Fechas fechas = factory.fechas();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        BaseDatos base = factory.basedatos();
        RangoFecha rango = fechas.Ahora();
        
        this.lbl_tituloTabla.setText("Movimientos de este día");
        //ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin()));
        this.cargarModeloTablaPreFav(base.obtenerMovimientosRango(df.format(rango.getInicio()),df.format(rango.getFin())));
    }
    
    private void VentanaActiva(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_VentanaActiva
        //System.out.print("La ventana esta activa");
        factory = new Factory();
        BaseDatos base = factory.basedatos();
        Usuario user = base.obtenerUsuario();
        Double fondos = base.obtenerFondos();
        user.setSaldo(fondos);
        base.actualizarSaldo(fondos);
        usuario = user;
        
        
        if(this.rbtn_mes.isSelected()==true){
            this.rbtn_mes();
        }else{
            if(this.rtbn_semana.isSelected()==true){
                this.rbtn_semana();
            }else{
                if(this.rbtn_dia.isSelected()==true){
                    this.rbtn_dia();
                }
            }
        }
        
        this.abridoPackman();
        
    }//GEN-LAST:event_VentanaActiva

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGroup_rango;
    private javax.swing.JButton btn_añadirFondos;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_gasto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_saldo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_tituloTabla;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenuItem menu_acercade;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JMenuItem menu_busquedaAvanzada;
    private javax.swing.JMenuItem menu_perfil;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JRadioButton rbtn_dia;
    private javax.swing.JRadioButton rbtn_mes;
    private javax.swing.JRadioButton rtbn_semana;
    private javax.swing.JTable tabla_movimientos;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
