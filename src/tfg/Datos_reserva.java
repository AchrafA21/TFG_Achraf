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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.JFrame;

/**
 *
 * @author Imad
 */
public class Datos_reserva extends javax.swing.JFrame {

   Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
    public Datos_reserva() {
        initComponents();
        Consultar();
    }
    
    void Consultar() {
        String sql = "SELECT c.nombre AS nombre_cliente, v.nombre AS nombre_vehiculo, m.nombre AS nombre_modelo, r.fecha_recogida, r.fecha_devolucion " +
                     "FROM reserva r " +
                     "JOIN alquiler_clientes c ON r.id_cliente = c.id " +
                     "JOIN vehiculos v ON r.id_vehiculo = v.id " +
                     "JOIN modelo m ON r.id_modelo = m.id";
        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            
            Object[] cabecera = new Object[] { "Nombre Cliente", "Nombre Vehículo", "Nombre Modelo","Fecha Recogida","Fecha Devolución" }; 
            DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
            jTable1.setModel(modelo);
             
            Object[] reservas = new Object[5];
            modelo = (DefaultTableModel) jTable1.getModel();
            
            while (rs.next()) {
                reservas[0] = rs.getString("nombre_cliente");
                reservas[1] = rs.getString("nombre_vehiculo");
                reservas[2] = rs.getString("nombre_modelo");
                reservas[3] = rs.getDate("fecha_recogida");
                reservas[4] = rs.getDate("fecha_devolucion");
                modelo.addRow(reservas);
            }
            
            jTable1.setModel(modelo);
          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar datos de la reserva: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo1.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        eliminar();
    }//GEN-LAST:event_jButton2ActionPerformed
public void editar() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String nombreCliente = jTable1.getValueAt(filaSeleccionada, 0).toString();
        String nombreVehiculo = jTable1.getValueAt(filaSeleccionada, 1).toString();
        String nombreModelo = jTable1.getValueAt(filaSeleccionada, 2).toString();
        String fechaRecogida = jTable1.getValueAt(filaSeleccionada, 3).toString();
        String fechaDevolucion = jTable1.getValueAt(filaSeleccionada, 4).toString();

        Añadir_reserva añadirReservaFrame = new Añadir_reserva(nombreCliente, nombreVehiculo, nombreModelo, fechaRecogida, fechaDevolucion);
        añadirReservaFrame.setVisible(true);
        añadirReservaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        añadirReservaFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Consultar();
            }
        });
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un registro para editar");
    }
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editar();
    }//GEN-LAST:event_jButton1ActionPerformed
void eliminar() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        // Obtener los valores de la fila seleccionada
        String nombreCliente = jTable1.getValueAt(filaSeleccionada, 0).toString();
        String nombreVehiculo = jTable1.getValueAt(filaSeleccionada, 1).toString();
        String nombreModelo = jTable1.getValueAt(filaSeleccionada, 2).toString();
        String fechaRecogida = jTable1.getValueAt(filaSeleccionada, 3).toString(); // asumiendo que está en formato compatible con SQL

        // Consulta SQL para obtener el ID de la reserva
        String sqlSelectId = "SELECT r.id FROM reserva r " +
                             "JOIN alquiler_clientes c ON r.id_cliente = c.id " +
                             "JOIN vehiculos v ON r.id_vehiculo = v.id " +
                             "JOIN modelo m ON r.id_modelo = m.id " +
                             "WHERE c.nombre = ? AND v.nombre = ? AND m.nombre = ? AND r.fecha_recogida = ?";

        try {
            conet = con1.getConnection();
            PreparedStatement pst = conet.prepareStatement(sqlSelectId);
            pst.setString(1, nombreCliente);
            pst.setString(2, nombreVehiculo);
            pst.setString(3, nombreModelo);
            pst.setString(4, fechaRecogida);

            rs = pst.executeQuery();

            if (rs.next()) {
                int idReserva = rs.getInt("id");

                // Consulta SQL para eliminar la reserva
                String sqlDelete = "DELETE FROM reserva WHERE id = ?";
                pst = conet.prepareStatement(sqlDelete);
                pst.setInt(1, idReserva);
                pst.executeUpdate();

                // Actualizar la tabla después de la eliminación
                ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Reserva borrada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la reserva.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(Datos_reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_reserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_reserva().setVisible(true);
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
