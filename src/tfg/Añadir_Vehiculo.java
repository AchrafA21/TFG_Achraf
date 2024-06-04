/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author Imad
 */
public class Añadir_Vehiculo extends javax.swing.JFrame {

  Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Añadir_Vehiculo() {
        initComponents();
         this.setLocationRelativeTo(this);
    }
    
    public Añadir_Vehiculo(String nombre, String modelo, int añoFabricacion, int capacidad, String conbustible, String transmision, int precioDia, int precioMes) {
         initComponents();
         this.setLocationRelativeTo(this);
        jTextField1.setText(nombre);
        jTextField2.setText(modelo);
        jTextField3.setText(String.valueOf(añoFabricacion));
        jTextField4.setText(String.valueOf(capacidad));
        jTextField5.setText(conbustible);
        jTextField6.setText(transmision);
        jTextField7.setText(String.valueOf(precioDia));
        jTextField8.setText(String.valueOf(precioMes));
    }

// public void InsertarVehiculo() {
//    try {
//        // Verificar que todos los campos estén llenos
//        if (!jTextField1.getText().isEmpty() &&
//            !jTextField2.getText().isEmpty() &&
//            !jTextField3.getText().isEmpty() &&
//            !jTextField4.getText().isEmpty() &&
//            !jTextField5.getText().isEmpty() &&
//            !jTextField6.getText().isEmpty() &&
//            !jTextField7.getText().isEmpty() &&
//            !jTextField8.getText().isEmpty()) {
//            
//            // Obtener el id del modelo a través del nombre
//            int idModelo = obtenerIdModeloPorNombre(jTextField2.getText());
//            if (idModelo == -1) {
//                JOptionPane.showMessageDialog(null, "Modelo no encontrado.");
//                return;
//            }
//            
//            // Consulta SQL para insertar datos en la tabla
//            String sql = "INSERT INTO vehiculos (nombre, año_fabricación, capacidad, conbustible, transmision, precio_dia, precio_mes, id_modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//            conet = con1.getConnection();
//            
//            // Crear un PreparedStatement para ejecutar la consulta SQL
//            PreparedStatement statement = conet.prepareStatement(sql);
//            
//            // Asignar valores a los parámetros de la consulta
//            statement.setString(1, jTextField1.getText()); // nombre
//            statement.setInt(2, Integer.parseInt(jTextField3.getText())); // año_fabricación
//            statement.setInt(3, Integer.parseInt(jTextField4.getText())); // capacidad
//            statement.setString(4, jTextField5.getText()); // conbustible
//            statement.setString(5, jTextField7.getText()); // transmision
//            statement.setInt(6, Integer.parseInt(jTextField6.getText())); // precio_dia
//            statement.setInt(7, Integer.parseInt(jTextField8.getText())); // precio_mes
//            statement.setInt(8, idModelo); // id_modelo
//            
//            // Ejecutar la consulta
//            statement.executeUpdate();
//            
//            // Limpiar campos de texto
//            jTextField1.setText("");
//            jTextField2.setText("");
//            jTextField3.setText("");
//            jTextField4.setText("");
//            jTextField5.setText("");
//            jTextField6.setText("");
//            jTextField7.setText("");
//            jTextField8.setText("");
//            
//            // Mostrar mensaje de éxito
//            JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito.");
//        } else {
//            // Mostrar mensaje de error si algún campo está vacío
//            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
//        }
//    } catch (SQLException e) {
//        // Manejo de excepciones SQL
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Error al agregar el vehículo: " + e.getMessage());
//    } catch (NumberFormatException e) {
//        // Manejo de excepciones de formato numérico
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos en los campos correspondientes.");
//    }
//}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Post de Instagram Vacante Laboral Moderno Azul.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, -1));

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 192, 210, 20));

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 200, -1));

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 210, 20));

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 362, 210, 20));

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 210, -1));

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 480, 210, -1));

        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(null);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 210, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarOModificarVehiculo();
    }//GEN-LAST:event_jButton1ActionPerformed
//=============================================================================
     public void insertarOModificarVehiculo() {
        try {
            // Verificar que todos los campos estén llenos
            if (!jTextField1.getText().isEmpty() &&
                !jTextField2.getText().isEmpty() &&
                !jTextField3.getText().isEmpty() &&
                !jTextField4.getText().isEmpty() &&
                !jTextField5.getText().isEmpty() &&
                !jTextField6.getText().isEmpty() &&
                !jTextField7.getText().isEmpty() &&
                !jTextField8.getText().isEmpty()) {

                // Obtener el id del modelo a través del nombre
                int idModelo = obtenerIdModeloPorNombre(jTextField2.getText());
                if (idModelo == -1) {
                    JOptionPane.showMessageDialog(null, "Modelo no encontrado.");
                    return;
                }

                String nombreVehiculo = jTextField1.getText();
                int añoFabricacion = Integer.parseInt(jTextField3.getText());
                int capacidad = Integer.parseInt(jTextField4.getText());
                String conbustible = jTextField5.getText();
                String transmision = jTextField6.getText();
                int precioDia = Integer.parseInt(jTextField7.getText());
                int precioMes = Integer.parseInt(jTextField8.getText());

                // Consulta SQL para verificar si el vehículo ya existe
                String queryCheck = "SELECT COUNT(*) FROM vehiculos WHERE nombre = ? AND id_modelo = ?";
                conet = con1.getConnection();
                PreparedStatement checkStmt = conet.prepareStatement(queryCheck);
                checkStmt.setString(1, nombreVehiculo);
                checkStmt.setInt(2, idModelo);

                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    // Si existe, actualiza el registro
                    String sqlUpdate = "UPDATE vehiculos SET año_fabricación = ?, capacidad = ?, conbustible = ?, transmision = ?, precio_dia = ?, precio_mes = ? WHERE nombre = ? AND id_modelo = ?";
                    PreparedStatement updateStmt = conet.prepareStatement(sqlUpdate);
                    updateStmt.setInt(1, añoFabricacion);
                    updateStmt.setInt(2, capacidad);
                    updateStmt.setString(3, conbustible);
                    updateStmt.setString(4, transmision);
                    updateStmt.setInt(5, precioDia);
                    updateStmt.setInt(6, precioMes);
                    updateStmt.setString(7, nombreVehiculo);
                    updateStmt.setInt(8, idModelo);
                    updateStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Vehículo actualizado con éxito.");
                } else {
                    // Si no existe, inserta un nuevo registro
                    String sqlInsert = "INSERT INTO vehiculos (nombre, año_fabricación, capacidad, conbustible, transmision, precio_dia, precio_mes, id_modelo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement insertStmt = conet.prepareStatement(sqlInsert);
                    insertStmt.setString(1, nombreVehiculo);
                    insertStmt.setInt(2, añoFabricacion);
                    insertStmt.setInt(3, capacidad);
                    insertStmt.setString(4, conbustible);
                    insertStmt.setString(5, transmision);
                    insertStmt.setInt(6, precioDia);
                    insertStmt.setInt(7, precioMes);
                    insertStmt.setInt(8, idModelo);
                    insertStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Vehículo agregado con éxito.");
                }

                // Limpiar campos de texto
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField8.setText("");
            } else {
                // Mostrar mensaje de error si algún campo está vacío
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            }
        } catch (SQLException e) {
            // Manejo de excepciones SQL
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar el vehículo: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Manejo de excepciones de formato numérico
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos en los campos correspondientes.");
        }
    }
//=============================================================================
    private int obtenerIdModeloPorNombre(String nombreModelo) {
    int idModelo = -1;
    
    String sql = "SELECT id FROM Modelo WHERE nombre = ?";
    try {
        conet = con1.getConnection();
        PreparedStatement statement = conet.prepareStatement(sql);
        statement.setString(1, nombreModelo);
        
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            idModelo = resultSet.getInt("id");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el ID del modelo: " + e.getMessage());
    }
    
    return idModelo;
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
            java.util.logging.Logger.getLogger(Añadir_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Añadir_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Añadir_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Añadir_Vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir_Vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
