/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entidades.*;
import Procesos.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author roban
 */
public class Perfil extends javax.swing.JFrame {
    private static Factory factory;
    static Usuario usuario;

    /**
     * Creates new form Perfil
     */
    public Perfil(Usuario user) {
        factory = new Factory();
        initComponents();
        this.usuario = user;
        this.btn_actualizar.setVisible(false);
        
        this.setLocationRelativeTo(null);
        
        try {
        this.setIconImage(ImageIO.read(new File("icon.png")));
            } catch (IOException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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

        lbl_nombre = new javax.swing.JLabel();
        lbl_edad = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_saldo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_edad = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_saldo = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        btn_edicion = new javax.swing.JToggleButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Perfil de Usuario");
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                apertura(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombre.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(240, 240, 240));
        lbl_nombre.setText("Nombre");
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        lbl_edad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_edad.setForeground(new java.awt.Color(240, 240, 240));
        lbl_edad.setText("Edad");
        getContentPane().add(lbl_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lbl_direccion.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_direccion.setForeground(new java.awt.Color(240, 240, 240));
        lbl_direccion.setText("Direccion");
        getContentPane().add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        lbl_correo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(240, 240, 240));
        lbl_correo.setText("Correo");
        getContentPane().add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_telefono.setForeground(new java.awt.Color(240, 240, 240));
        lbl_telefono.setText("Telefono");
        getContentPane().add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        lbl_saldo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_saldo.setForeground(new java.awt.Color(240, 240, 240));
        lbl_saldo.setText("Saldo");
        getContentPane().add(lbl_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        txt_nombre.setEnabled(false);
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 220, -1));

        txt_edad.setEnabled(false);
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 220, -1));

        txt_direccion.setEnabled(false);
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 220, -1));

        txt_correo.setEnabled(false);
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 220, -1));

        txt_telefono.setEnabled(false);
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 220, -1));

        txt_saldo.setEnabled(false);
        getContentPane().add(txt_saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 220, -1));

        btn_salir.setBackground(new java.awt.Color(0, 0, 0));
        btn_salir.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 90, -1));

        btn_edicion.setBackground(new java.awt.Color(0, 0, 0));
        btn_edicion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_edicion.setForeground(new java.awt.Color(255, 255, 255));
        btn_edicion.setText("Edicion");
        btn_edicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edicionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        btn_actualizar.setBackground(new java.awt.Color(0, 0, 0));
        btn_actualizar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 210, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    
    private void btn_edicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edicionActionPerformed
        if (this.btn_edicion.isSelected()) {
            this.txt_correo.setEnabled(true);
            this.txt_direccion.setEnabled(true);
            this.txt_edad.setEnabled(true);
            this.txt_nombre.setEnabled(true);
            //this.txt_saldo.setEnabled(true);
            this.txt_telefono.setEnabled(true);
            this.btn_actualizar.setVisible(true);
        }
        else{
            this.txt_correo.setEnabled(false);
            this.txt_direccion.setEnabled(false);
            this.txt_edad.setEnabled(false);
            this.txt_nombre.setEnabled(false);
            this.txt_saldo.setEnabled(false);
            this.btn_actualizar.setVisible(false);
            this.txt_telefono.setEnabled(false);
        }
    }//GEN-LAST:event_btn_edicionActionPerformed

    private void apertura(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_apertura
        this.txt_correo.setText(usuario.getCorreo());
        this.txt_direccion.setText(usuario.getDireccion());
        this.txt_edad.setText(String.valueOf(usuario.getEdad()));
        this.txt_nombre.setText(usuario.getNombre());
        this.txt_saldo.setText(String.valueOf(usuario.getSaldo()));
        this.txt_telefono.setText(String.valueOf(usuario.getTelefono()));
    }//GEN-LAST:event_apertura

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        BaseDatos base = factory.basedatos();
        
        String nombre = this.txt_nombre.getText();
        int edad = Integer.parseInt(this.txt_edad.getText());
        String direccion = this.txt_direccion.getText();
        String correo = this.txt_correo.getText();
        Double saldo = Double.parseDouble(this.txt_saldo.getText());
        int telefono = Integer.parseInt(this.txt_telefono.getText());
        
        Usuario usuarioActualizado = factory.usuario(nombre, edad, direccion, correo, saldo, telefono);
        
        base.actualizarUsuario(usuarioActualizado);
    }//GEN-LAST:event_btn_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perfil(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JToggleButton btn_edicion;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_edad;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_saldo;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_saldo;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
