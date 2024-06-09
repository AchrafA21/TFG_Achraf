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
   private String nombreUsuario;
    public Modificar_datos(String nombreUsuario) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.nombreUsuario = nombreUsuario;
       
        cargarDatosUsuario(nombreUsuario);
    }
    
    private void cargarDatosUsuario(String nombreUsuario) {
        Connection conet = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        conet = con1.getConnection();
        
        String sql = "SELECT nombre, fecha_nac, correo, contraseña FROM trabajadores WHERE nombre = ?";
        
        statement = conet.prepareStatement(sql);
        statement.setString(1, nombreUsuario);
        
        resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            // Obtener los datos del usuario
            String nombre = resultSet.getString("nombre");
            String fechaNacimiento = resultSet.getString("fecha_nac");
            String correo = resultSet.getString("correo");
            String contraseña = resultSet.getString("contraseña");
            
            // Actualizar los campos de texto en el formulario
            jTextField1.setText(nombre);
            
            // Formatear la fecha en el formato deseado (dd-MM-yyyy)
//            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
//            jTextField2.setText(formatoFecha.format(fechaNacimiento));
            jTextField2.setText(fechaNacimiento);
            jTextField3.setText(correo);
            jPasswordField1.setText(contraseña);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron datos para el usuario " + nombreUsuario, "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jPasswordField1.setText("");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 190, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Config_User1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 640));

        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 184, 280, -1));

        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 280, 20));

        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 280, 20));

        jPasswordField1.setBorder(null);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 280, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            actualizarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public void actualizarDatos() {
        Connection conet = null;
    PreparedStatement statement = null;
        try {
        // Obtener los valores de los campos de texto
        String nombre = jTextField1.getText();
        String fechaNacimiento=jTextField2.getText();
        String correo = jTextField3.getText();
        char[] passwordChars = jPasswordField1.getPassword();
        String Contraseña = new String(passwordChars);

        // Consulta SQL para actualizar datos en la tabla
        String sql = "UPDATE trabajadores SET nombre=?, contraseña=?, fecha_nac=? WHERE correo=?";
        
        conet = con1.getConnection();
        
        // Crear un PreparedStatement para ejecutar la consulta SQL
        statement = conet.prepareStatement(sql);
        
        // Asignar valores a los parámetros de la consulta
        statement.setString(1, nombre); // nombre
        statement.setString(2, Contraseña); // contraseña
        statement.setString(3, fechaNacimiento); // fecha_nac
        statement.setString(4, correo); // correo
        
        // Ejecutar la consulta
        int filasActualizadas = statement.executeUpdate();
        
        if (filasActualizadas > 0) {
            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Datos del trabajador actualizados correctamente.");
        } else {
            // Mostrar mensaje de error si el trabajador no se encontró
            JOptionPane.showMessageDialog(null, "No se encontró ningún trabajador con el correo proporcionado.");
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
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
                 String nombreUsuario = "usuario";
               new  Modificar_datos(nombreUsuario).setVisible(true);
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
    // End of variables declaration//GEN-END:variables
}
