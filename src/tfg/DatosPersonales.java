/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Imad
 */
public class DatosPersonales extends javax.swing.JFrame {
 Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    private String nombreUsuario;
    public DatosPersonales(String nombreUsuario) {
        initComponents();
         this.nombreUsuario = nombreUsuario;
       
        cargarDatosUsuario(nombreUsuario);
    }

   private void cargarDatosUsuario(String nombreUsuario) {
    try {
        conet = con1.getConnection();
        
        String sql = "SELECT nombre, apellido, fecha_nac, correo, telefono,contraseña, direccion FROM alquiler_clientes WHERE nombre = ?";
        
        PreparedStatement statement = conet.prepareStatement(sql);
        statement.setString(1, nombreUsuario);
        
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            // Obtener los datos del usuario
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            Date fechaNacimiento = resultSet.getDate("fecha_nac");
            String correo = resultSet.getString("correo");
            String telefono = resultSet.getString("telefono");
            String direccion = resultSet.getString("direccion");
            String contraseña = resultSet.getString("contraseña");
            // Actualizar los campos de texto en el formulario
            jTextField1.setText(nombre);
            jTextField2.setText(apellido);
            // Formatear la fecha en el formato deseado (yyyy-MM-dd)
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            jTextField4.setText(formatoFecha.format(fechaNacimiento));
            jTextField3.setText(correo);
            jTextField5.setText(telefono);
            jTextField6.setText(direccion);
            jPasswordField1.setText(contraseña);
        } else {
            
            JOptionPane.showMessageDialog(this, "No se encontraron datos para el usuario " + nombreUsuario, "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
            
         
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField4.setText("");
            jTextField3.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
        }
        
    
        resultSet.close();
        statement.close();
    } catch (Exception ex) {
        
        ex.printStackTrace();
    }
}


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 200, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/DarosPersonales.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 132, 280, 20));

        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 280, -1));

        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 280, -1));

        jPasswordField1.setBorder(null);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 270, 10));

        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 382, 280, 20));

        jTextField5.setBorder(null);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 280, -1));

        jTextField6.setBorder(null);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       actualizarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed
  void actualizarDatos() {
        try {
            // Obtener los valores de los campos de texto
            String apellido = jTextField2.getText();
            Date fechaNacimiento = obtenerFecha(jTextField4.getText());
            String correo = jTextField3.getText();
            char[] passwordChars = jPasswordField1.getPassword();
            String Contraseña = new String(passwordChars);
            String telefono = jTextField5.getText();
            String direccion = jTextField6.getText();
            
            // Consulta SQL para actualizar los datos
            String sql = "UPDATE alquiler_clientes SET apellido=?, correo=?, contraseña=?, fecha_nac=?, telefono=?, direccion=? WHERE correo=?";
            conet = con1.getConnection();
            PreparedStatement statement = conet.prepareStatement(sql);

            // Asignar valores a los parámetros de la consulta
            statement.setString(1, apellido); // apellido
            statement.setString(2, correo); // correo
            statement.setString(3, Contraseña); // contraseña
            statement.setDate(4, new java.sql.Date(fechaNacimiento.getTime())); // fecha_nac
            statement.setString(5, telefono); // telefono
            statement.setString(6, direccion); // direccion
            statement.setString(7, correo); // correo (para el WHERE)

            // Ejecutar la consulta
            int filasActualizadas = statement.executeUpdate();

            if (filasActualizadas > 0) {
                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Datos del cliente actualizados correctamente.");
            } else {
                // Mostrar mensaje de error si el cliente no se encontró
                JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el correo proporcionado.");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del cliente.");
        }
    }
    
    // Método para convertir una cadena de texto a una fecha
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

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String nombreUsuario = "usuario";
                new DatosPersonales(nombreUsuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
