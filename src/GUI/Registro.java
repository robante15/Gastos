/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entidades.*;
import Procesos.*;
import GUI.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author roban
 */
public class Registro extends javax.swing.JFrame {

    private static Factory factory;
    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        this.setLocationRelativeTo(null);
        factory = new Factory();
        
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

        lbl_registro = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_edad = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_direccion = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lbl_correo = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        lbl_numTel = new javax.swing.JLabel();
        spinner_edad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_registro.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        lbl_registro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_registro.setText("Registro de Nuevo Usuario");
        getContentPane().add(lbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        btn_aceptar.setBackground(new java.awt.Color(0, 0, 0));
        btn_aceptar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btn_aceptar.setForeground(new java.awt.Color(255, 255, 255));
        btn_aceptar.setText("Aceptar");
        btn_aceptar.setToolTipText("");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 130, 60));

        btn_cancelar.setBackground(new java.awt.Color(0, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 130, 60));

        lbl_nombre.setBackground(new java.awt.Color(0, 0, 0));
        lbl_nombre.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre.setText("Nombre");
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txt_nombre.setToolTipText("");
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 309, -1));

        lbl_edad.setBackground(new java.awt.Color(0, 0, 0));
        lbl_edad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_edad.setForeground(new java.awt.Color(255, 255, 255));
        lbl_edad.setText("Edad");
        getContentPane().add(lbl_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_direccion.setToolTipText("");
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 309, -1));

        lbl_direccion.setBackground(new java.awt.Color(0, 0, 0));
        lbl_direccion.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_direccion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_direccion.setText("Direccion");
        getContentPane().add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txt_correo.setToolTipText("");
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 309, -1));

        lbl_correo.setBackground(new java.awt.Color(0, 0, 0));
        lbl_correo.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_correo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_correo.setText("Correo");
        getContentPane().add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        txt_telefono.setToolTipText("");
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 309, -1));

        lbl_numTel.setBackground(new java.awt.Color(0, 0, 0));
        lbl_numTel.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        lbl_numTel.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numTel.setText("Telefono");
        getContentPane().add(lbl_numTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));
        getContentPane().add(spinner_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 310, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1100, -250, 1630, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        //Variables temporales para almacenar los datos que posteriormente se van a mandar al metodo
        String nombre = this.txt_nombre.getText();
        int edad = Integer.parseInt(this.spinner_edad.getValue().toString());
        String direccion = this.txt_direccion.getText();
        String correo = this.txt_correo.getText();
        Double saldo = 0.0;
        int telefono = Integer.parseInt(this.txt_telefono.getText());
        
        BaseDatos base = factory.basedatos();
        Usuario user = factory.usuario(nombre, edad, direccion, correo, saldo, telefono);
        base.registrarUsuario(user);
             
    }//GEN-LAST:event_btn_aceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_edad;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_numTel;
    private javax.swing.JLabel lbl_registro;
    private javax.swing.JSpinner spinner_edad;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
