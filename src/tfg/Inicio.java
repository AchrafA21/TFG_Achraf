/*2
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import Config.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
/**
 *
 * @author Imad
 */
public class Inicio extends javax.swing.JFrame {

   Conexion con1 = new Conexion();
   Connection conet;
   Statement st;
   ResultSet rs;
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(this);
//        jTextField1.setText("AntonioR@gmail.com");
//        jPasswordField1.setText("antonioJ@2021");
        
        
        jTextField1.setText("carlos@gmail.com");
        jPasswordField1.setText("secreta789");

//         jTextField1.setText("MarcosGzl@gmail.com");
//        jPasswordField1.setText("Wb3¿xdZA6");
        
//         jTextField1.setText("AnaMart@gmail.com");
//        jPasswordField1.setText("Ss9v91XG");
        
//        
//         jTextField1.setText("LauraG@gmail.com");
//        jPasswordField1.setText("Laura34*pass");
    }

//   private void acceder() {
//        String correo = jTextField1.getText();
//       char[] contrasenaChars = jPasswordField1.getPassword(); // Obtener la contraseña como arreglo de caracteres
//        String contraseña = new String(contrasenaChars);
//
//        try {
//            conet = con1.getConnection();
//
//            if (conet != null) {
//                String sql = "SELECT * FROM trabajadores WHERE correo = ? AND contraseña = ?";
//                
//                try (PreparedStatement statement = conet.prepareStatement(sql)) {
//                    statement.setString(1, correo);
//                    statement.setString(2, contraseña);
//
//                    ResultSet resultSet = statement.executeQuery();
//
//                    if (resultSet.next()) {
//                        // Si se encuentra un registro, significa que las credenciales son válidas
//                        //JOptionPane.showMessageDialog(this, "Acceso concedido.", "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
//                        this.setVisible(false);
//
//                        // Mostrar la nueva ventana (Panel_Gestión)
//                        Centro_Control g = new Centro_Control();
//                        g.setVisible(true);
//                    
//                    } else {
//                        // Si no se encuentra ningún registro, las credenciales son incorrectas
//                        JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "La conexión no está disponible.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Error al intentar acceder: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    private void acceder() {
    String correo = jTextField1.getText();
    char[] contrasenaChars = jPasswordField1.getPassword(); // Obtener la contraseña como arreglo de caracteres
    String contraseña = new String(contrasenaChars);

    try {
        conet = con1.getConnection();

        if (conet != null) {
            String sqlTrabajador = "SELECT * FROM trabajadores WHERE correo = ? AND contraseña = ?";
            String sqlCliente = "SELECT * FROM alquiler_clientes WHERE correo = ? AND contraseña = ?";

            boolean accesoConcedido = false;
            String tipoUsuario = null;
             String nombreUsuario = null;
             String nombreUsuario1=null;

            // Verificar en la tabla trabajadores
            try (PreparedStatement statementTrabajador = conet.prepareStatement(sqlTrabajador)) {
                statementTrabajador.setString(1, correo);
                statementTrabajador.setString(2, contraseña);

                try (ResultSet resultSet = statementTrabajador.executeQuery()) {
                    if (resultSet.next()) {
                        accesoConcedido = true;
                        tipoUsuario = "trabajador";
                        nombreUsuario = resultSet.getString("nombre");
                        
                    }
                }
            }

            // Si no se encontró en la tabla trabajadores, verificar en la tabla alquiler_clientes
            if (!accesoConcedido) {
                try (PreparedStatement statementCliente = conet.prepareStatement(sqlCliente)) {
                    statementCliente.setString(1, correo);
                    statementCliente.setString(2, contraseña);

                    try (ResultSet resultSet = statementCliente.executeQuery()) {
                        if (resultSet.next()) {
                            accesoConcedido = true;
                            tipoUsuario = "cliente";
                            nombreUsuario = resultSet.getString("nombre");
                            nombreUsuario1 = resultSet.getString("nombre");
                            System.out.println(nombreUsuario);
                        }
                    }
                }
            }

            if (accesoConcedido) {
                this.setVisible(false);

                if ("trabajador".equals(tipoUsuario)) {
                    Centro_Control g = new Centro_Control();
                    g.setNombreUsuario(nombreUsuario);
                    g.setVisible(true);
                } else if ("cliente".equals(tipoUsuario)) {
                    ClientesPanel m = new ClientesPanel();
//                    Reservas_Cliente k = new Reservas_Cliente();
                    m.setNombreUsuario(nombreUsuario);
                   
                    m.setVisible(true);
                    
                  
                }
            } else {
                // Si no se encuentra ningún registro, las credenciales son incorrectas
                JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "La conexión no está disponible.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al intentar acceder: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField1.setBackground(new java.awt.Color(223, 223, 223));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setBorder(null);
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 200, 30));

        jTextField1.setBackground(new java.awt.Color(223, 223, 223));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 210, 30));

        jButton4.setBackground(new java.awt.Color(184, 25, 25));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Registrarse");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 100, 20));

        jButton1.setBackground(new java.awt.Color(184, 25, 25));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Acceder");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 100, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/foto.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        acceder();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        Reguistro_Datos p = new Reguistro_Datos();
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
