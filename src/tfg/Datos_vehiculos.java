/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Imad
 */
public class Datos_vehiculos extends javax.swing.JFrame {

    Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Datos_vehiculos() {
        initComponents();
        Consultar();
    }
    
 void Consultar() {
    String sql = "SELECT v.nombre, v.año_fabricación, v.capacidad, v.conbustible, v.transmision, v.precio_dia, v.precio_mes, m.nombre AS nombre_modelo " +
                 "FROM vehiculos v " +
                 "JOIN modelo m ON v.id_modelo = m.id";
    try {
        conet = con1.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        
        Object[] cabecera = new Object[] { "nombre","nombre_modelo" , "capacidad", "conbustible", "transmision", "precio_dia", "precio_mes","año_fabricación"  }; 
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        jTable1.setModel(modelo);
         
        Object[] vehiculos = new Object[8];
        modelo = (DefaultTableModel) jTable1.getModel();
        
        while (rs.next()) {
            vehiculos[0] = rs.getString("nombre");
            vehiculos[1] = rs.getString("nombre_modelo");
            vehiculos[2] = rs.getInt("capacidad");
            vehiculos[3] = rs.getString("conbustible");
            vehiculos[4] = rs.getString("transmision");
            vehiculos[5] = rs.getInt("precio_dia");
            vehiculos[6] = rs.getInt("precio_mes");
            vehiculos[7] = rs.getInt("año_fabricación");
            
            modelo.addRow(vehiculos);
        }
        
        jTable1.setModel(modelo);
      
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 18, 963, 158));

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 140, -1));

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editar();
    }//GEN-LAST:event_jButton1ActionPerformed
 //===========================================================================
    void editar(){
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String nombre = jTable1.getValueAt(filaSeleccionada, 0).toString();
        String modelo = jTable1.getValueAt(filaSeleccionada, 1).toString();
        int capacidad = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 2).toString());
        String conbustible = jTable1.getValueAt(filaSeleccionada, 3).toString();
        String transmision = jTable1.getValueAt(filaSeleccionada, 4).toString();
        int precioDia = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 5).toString());
        int precioMes = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 6).toString());
        int añoFabricacion = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 7).toString());

        Añadir_Vehiculo añadirVehiculoFrame = new Añadir_Vehiculo(nombre, modelo, añoFabricacion, capacidad, conbustible, transmision, precioDia, precioMes);
        añadirVehiculoFrame.setVisible(true);
        añadirVehiculoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         añadirVehiculoFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    Consultar();
                }
            });
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un registro para editar");
    }
    
}
    
    
    
 //========================================================================
    void eliminar() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String nombrevehiculo = jTable1.getValueAt(filaSeleccionada, 0).toString(); // Suponiendo que el nombre del modelo está en la primera columna
        String sqlSelectId = "SELECT id FROM vehiculos WHERE nombre = '" + nombrevehiculo + "'";
        String idvehiculo = null;

        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sqlSelectId);

            if (rs.next()) {
                idvehiculo = rs.getString("id");
            }

            if (idvehiculo != null) {
                String sqlDelete = "DELETE FROM vehiculos WHERE id = " + idvehiculo;
                st.executeUpdate(sqlDelete);

                // Actualizar la tabla después de la eliminación
                ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Vehiculo borrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el ID del modelo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar");
    }
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
            java.util.logging.Logger.getLogger(Datos_vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_vehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_vehiculos().setVisible(true);
                 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
