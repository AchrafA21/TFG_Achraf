/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imad
 */
public class Modificar_datos extends javax.swing.JFrame {

   Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Modificar_datos() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 190, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Config_User.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 640));

        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 184, 280, -1));

        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 242, 280, 20));

        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 280, 20));

        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 280, 20));

        jPasswordField1.setBorder(null);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 280, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            actualizarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public void actualizarDatos() {
        try {
            // Obtener los valores de los campos de texto
            String nombre = jTextField1.getText();
            String apellido = jTextField2.getText();
            Date fechaNacimiento = obtenerFecha(jTextField3.getText());
            String correo = jTextField4.getText();
            char[] passwordChars = jPasswordField1.getPassword();
            String Contraseña = new String(passwordChars);
 
            
            // Consulta SQL para actualizar datos en la tabla
            String sql = "UPDATE trabajadores SET nombre=?, correo=?, contraseña=?, fecha_nac=? WHERE apellido=?";
             conet=con1.getConnection();
            // Crear un PreparedStatement para ejecutar la consulta SQL
            PreparedStatement statement = conet.prepareStatement(sql);
            
            // Asignar valores a los parámetros de la consulta
            statement.setString(1, nombre); // nombre
            statement.setString(2, correo); // correo
            statement.setString(3, Contraseña); // contraseña
            statement.setDate(4, new java.sql.Date(fechaNacimiento.getTime())); // fecha_nac
            statement.setString(5, apellido); // apellido
            
            // Ejecutar la consulta
            int filasActualizadas = statement.executeUpdate();
            
            if (filasActualizadas > 0) {
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Datos del trabajador actualizados correctamente.");
            } else {
                // Mostrar mensaje de error si el trabajador no se encontró
                JOptionPane.showMessageDialog(null, "No se encontró ningún trabajador con el apellido proporcionado.");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del trabajador.");
        }
    }
    private Date obtenerFecha(String fechaString) {
        try {
            // Formato de fecha esperado en la cadena
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Convertir la cadena en un objeto Date
            return dateFormat.parse(fechaString);
        } catch (ParseException e) {
            // Manejo de excepciones si la cadena no puede ser parseada
            e.printStackTrace();
            return null; // Devuelve null si ocurre un error
        }
    }

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
            java.util.logging.Logger.getLogger(Modificar_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
