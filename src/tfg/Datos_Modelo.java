/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Imad
 */
public class Datos_Modelo extends javax.swing.JFrame {

   Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Datos_Modelo() {
        initComponents();
     Consultar();
    }
    

  void Consultar() {
    String sql = "SELECT modelo.nombre AS modelo_nombre, vehiculos.nombre AS vehiculo_nombre, modelo.fecha_creacion " +
                 "FROM modelo " +
                 "JOIN vehiculos ON modelo.id_vehiculo = vehiculos.id";
    try {
        conet = con1.getConnection();
        st = conet.createStatement();
        rs = st.executeQuery(sql);
        
        Object[] cabecera = new Object[] { "Modelo", "Vehículo", "Fecha de Creación" }; 
        DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        jTable1.setModel(modelo);
        
        Object[] datos = new Object[3];
        
        modelo = (DefaultTableModel) jTable1.getModel();
        while (rs.next()) {
            datos[0] = rs.getString("modelo_nombre");
            datos[1] = rs.getString("vehiculo_nombre");
            datos[2] = rs.getDate("fecha_creacion");
            
            modelo.addRow(datos);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 640, 130));

        jButton1.setText("Editar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 130, -1));

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
eliminar();    }//GEN-LAST:event_jButton2ActionPerformed

   void eliminar() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String nombreModelo = jTable1.getValueAt(filaSeleccionada, 0).toString(); // Suponiendo que el nombre del modelo está en la primera columna
        String sqlSelectId = "SELECT id FROM modelo WHERE nombre = '" + nombreModelo + "'";
        String idModelo = null;

        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sqlSelectId);

            if (rs.next()) {
                idModelo = rs.getString("id");
            }

            if (idModelo != null) {
                String sqlDelete = "DELETE FROM modelo WHERE id = " + idModelo;
                st.executeUpdate(sqlDelete);

                // Actualizar la tabla después de la eliminación
                ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada);
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
            java.util.logging.Logger.getLogger(Datos_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_Modelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_Modelo().setVisible(true);
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
