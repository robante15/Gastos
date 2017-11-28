/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entidades.*;
import Procesos.*;
import GUI.*;
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
        BaseDatos base = factory.basedatos();
        ArrayList<Movimiento> listaMovimientos = base.obtenerMovimientosMES();
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_titulo = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_saldo = new javax.swing.JLabel();
        btn_añadirFondos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_movimientos = new javax.swing.JTable();
        lbl_tituloTabla = new javax.swing.JLabel();
        btn_gasto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        menu_nuevo = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();
        menu_ayuda = new javax.swing.JMenu();
        menu_acercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finanzas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                apertura(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(240, 240, 240));
        lbl_titulo.setText("Finanzas Personales");
        getContentPane().add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(240, 240, 240));
        lbl_usuario.setText("Bienvenido Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        lbl_saldo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
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
        getContentPane().add(btn_añadirFondos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 180, 90));

        tabla_movimientos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tabla_movimientos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tabla_movimientos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 1110, 340));

        lbl_tituloTabla.setFont(new java.awt.Font("Roboto", 2, 14)); // NOI18N
        lbl_tituloTabla.setForeground(new java.awt.Color(240, 240, 240));
        lbl_tituloTabla.setText("Movimientos del ultimo mes");
        getContentPane().add(lbl_tituloTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        btn_gasto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_gasto.setText("Nuevo Gasto");
        btn_gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gastoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 170, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-570, -460, 1800, 1070));

        menu_archivo.setText("Archivo");

        menu_nuevo.setText("Nuevo usuario");
        menu_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_nuevoActionPerformed(evt);
            }
        });
        menu_archivo.add(menu_nuevo);

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

    private void menu_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_nuevoActionPerformed
        
    }//GEN-LAST:event_menu_nuevoActionPerformed

    private void apertura(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_apertura
        String nombreU = usuario.getNombre();
        Double saldoU = usuario.getSaldo();
        this.lbl_usuario.setText("Bienvenido "+nombreU);
        this.lbl_saldo.setText("Saldo: "+saldoU);
    }//GEN-LAST:event_apertura

    private void btn_añadirFondosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirFondosActionPerformed
        AñadirFondos fondos = factory.fondos();
        fondos.setVisible(true);
    }//GEN-LAST:event_btn_añadirFondosActionPerformed

    private void btn_gastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gastoActionPerformed
        NuevoGasto gasto = factory.gastoGUI();
        gasto.setVisible(true);
    }//GEN-LAST:event_btn_gastoActionPerformed

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
    private javax.swing.JButton btn_añadirFondos;
    private javax.swing.JButton btn_gasto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_saldo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_tituloTabla;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenuItem menu_acercade;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JMenuItem menu_nuevo;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JTable tabla_movimientos;
    // End of variables declaration//GEN-END:variables
}
