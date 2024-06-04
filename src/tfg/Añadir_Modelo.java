package tfg;

import Config.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Imad
 */
public class Añadir_Modelo extends javax.swing.JFrame {

    Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Añadir_Modelo() {
        initComponents();
    }
    
    public Añadir_Modelo(String nombre, Date fechaCreacion, String nombreVehiculo) {
        initComponents();
        jTextField1.setText(nombre);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        jTextField2.setText(formatoFecha.format(fechaCreacion));
        jTextField3.setText(nombreVehiculo);
    }
    
    
    
    
    
    
// public void insertarOModificarVehiculo() {
//        try {
//            // Verificar que todos los campos estén llenos
//            if (!jTextField1.getText().isEmpty() &&
//                !jTextField2.getText().isEmpty() &&
//                !jTextField3.getText().isEmpty()) {
//                int idvehiculo = obtenerIdVehiculoPorNombre(jTextField3.getText());
//                if (idvehiculo == -1) {
//                    JOptionPane.showMessageDialog(null, "Modelo no encontrado.");
//                    return;
//                }
//                 String nombreModelo = jTextField1.getText();
//                String fechaTexto = jTextField2.getText();
//                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
//                Date añoFabricacion = null;
//                try {
//                    añoFabricacion = formatoFecha.parse(fechaTexto);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd.");
//                }
//                
//            // Consulta SQL para verificar si el vehículo ya existe
//                String queryCheck = "SELECT COUNT(*) FROM modelo WHERE nombre = ? AND id_vehiculo = ?";
//                conet = con1.getConnection();
//                PreparedStatement checkStmt = conet.prepareStatement(queryCheck);
//                checkStmt.setString(1, nombreModelo);
//                checkStmt.setInt(2, idvehiculo);
//
//                ResultSet rs = checkStmt.executeQuery();
//                rs.next();
//                int count = rs.getInt(1);
//
//                if (count > 0) {
//                    // Si existe, actualiza el registro
//                    String sqlUpdate = "UPDATE modelo SET nombre = ?, fecha_creacion = ?, id_vehiculo = ?";
//                    PreparedStatement updateStmt = conet.prepareStatement(sqlUpdate);
//                    updateStmt.setString(1, nombreModelo);
//                    java.sql.Date sqlDate = new java.sql.Date(añoFabricacion.getTime());
//
//                    updateStmt.setDate(2, sqlDate);
//                    updateStmt.setInt(3, idvehiculo);
//                    updateStmt.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "Vehículo actualizado con éxito.");
//                } else {
//                    // Si no existe, inserta un nuevo registro
//                    String sqlInsert = "INSERT INTO modelo (nombre, fecha_creacion, id_vehiculo) VALUES (?, ?, ?)";
//                    PreparedStatement insertStmt = conet.prepareStatement(sqlInsert);
//                    insertStmt.setString(1, nombreModelo);
//                     java.sql.Date sqlDate = new java.sql.Date(añoFabricacion.getTime());
//                    insertStmt.setDate(2, sqlDate);
//                    insertStmt.setInt(3, idvehiculo);
//                    insertStmt.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito.");
//                }
//
//                // Limpiar campos de texto
//                jTextField1.setText("");
//                jTextField2.setText("");
//                jTextField3.setText("");
//               
//            } else {
//                // Mostrar mensaje de error si algún campo está vacío
//                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
//            }
//        } catch (SQLException e) {
//            // Manejo de excepciones SQL
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error al agregar el vehículo: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            // Manejo de excepciones de formato numérico
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos en los campos correspondientes.");
//        }
//    }
    
    
    
    
    public void insertarOModificarModelo() {
        try {
            if (!jTextField1.getText().isEmpty() &&
                !jTextField2.getText().isEmpty() &&
                !jTextField3.getText().isEmpty()) {

                int idVehiculo = obtenerIdVehiculoPorNombre(jTextField3.getText());
                if (idVehiculo == -1) {
                    JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                    return;
                }

                String nombreModelo = jTextField1.getText();
                String fechaTexto = jTextField2.getText();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaCreacion = null;
                try {
                    fechaCreacion = formatoFecha.parse(fechaTexto);
                } catch (ParseException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd.");
                    return;
                }

                // Verificar si el modelo ya existe
                String queryCheck = "SELECT COUNT(*) FROM modelo WHERE nombre = ? AND id_vehiculo = ?";
                PreparedStatement checkStmt = conet.prepareStatement(queryCheck);
                checkStmt.setString(1, nombreModelo);
                checkStmt.setInt(2, idVehiculo);

                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    // Actualizar el registro existente
                    String sqlUpdate = "UPDATE modelo SET fecha_creacion = ? WHERE nombre = ? AND id_vehiculo = ?";
                    PreparedStatement updateStmt = conet.prepareStatement(sqlUpdate);
                    updateStmt.setDate(1, new java.sql.Date(fechaCreacion.getTime()));
                    updateStmt.setString(2, nombreModelo);
                    updateStmt.setInt(3, idVehiculo);
                    updateStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Modelo actualizado con éxito.");
                } else {
                    // Insertar un nuevo registro
                    String sqlInsert = "INSERT INTO modelo (nombre, fecha_creacion, id_vehiculo) VALUES (?, ?, ?)";
                    PreparedStatement insertStmt = conet.prepareStatement(sqlInsert);
                    insertStmt.setString(1, nombreModelo);
                    insertStmt.setDate(2, new java.sql.Date(fechaCreacion.getTime()));
                    insertStmt.setInt(3, idVehiculo);
                    insertStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Modelo agregado con éxito.");
                }

                // Limpiar campos de texto
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar o actualizar el modelo: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/datos_modelo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 200, -1));

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, -1));

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarOModificarModelo();
    }//GEN-LAST:event_jButton1ActionPerformed

   private int obtenerIdVehiculoPorNombre(String nombrevehiculo) {
    int idvehiculo = -1;
    
    String sql = "SELECT id FROM vehiculos WHERE nombre = ?";
    try {
        conet = con1.getConnection();
        PreparedStatement statement = conet.prepareStatement(sql);
        statement.setString(1, nombrevehiculo);
        
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            idvehiculo = resultSet.getInt("id");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el ID del vehiculo: " + e.getMessage());
    }
    
    return idvehiculo;
}
   
   
   
   
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
            java.util.logging.Logger.getLogger(Añadir_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Añadir_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Añadir_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Añadir_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir_Modelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
