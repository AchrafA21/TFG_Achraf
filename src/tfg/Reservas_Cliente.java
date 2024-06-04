/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Imad
 */
public class Reservas_Cliente extends javax.swing.JFrame {
   Conexion con1 = new Conexion();
   Connection conet;
   
   private String nombreUsuario;
  

    public Reservas_Cliente(String nombreUsuario) {
        initComponents();
         this.setLocationRelativeTo(this);
        this.nombreUsuario = nombreUsuario; // Configurar el nombre de usuario
        jLabel2.setText(nombreUsuario); // Configurar el nombre de usuario en el JLabel
        cargarDatosUsuario(nombreUsuario);
    }
//     void setNombreUsuario(String nombreUsuario) {
//        this.nombreUsuario = nombreUsuario;
//        jLabel2.setText(nombreUsuario);
//        cargarDatosUsuario(nombreUsuario);
//        System.out.println(nombreUsuario);
//    }

    
    
    
      void cargarDatosUsuario(String nombreUsuario) {
        try {
            conet = con1.getConnection();
            
            // Consulta SQL para obtener los detalles de la reserva del cliente
            String sql = "SELECT v.nombre AS nombre_vehiculo, m.nombre AS nombre_modelo, r.fecha_recogida, r.fecha_devolucion " +
                         "FROM reserva r " +
                         "JOIN vehiculos v ON r.id_vehiculo = v.id " +
                         "JOIN modelo m ON r.id_modelo = m.id " +
                         "WHERE r.id_cliente = (SELECT id FROM alquiler_clientes WHERE nombre = ?)";
            
            PreparedStatement statement = conet.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Obtener los datos de la reserva
                String nombreVehiculo = resultSet.getString("nombre_vehiculo");
                String nombreModelo = resultSet.getString("nombre_modelo");
                Date fechaRecogida = resultSet.getDate("fecha_recogida");
                Date fechaDevolucion = resultSet.getDate("fecha_devolucion");
                
                // Imprimir en consola para depuración
                System.out.println("Vehículo: " + nombreVehiculo);
                System.out.println("Modelo: " + nombreModelo);
                System.out.println("Fecha de Recogida: " + fechaRecogida);
                System.out.println("Fecha de Devolución: " + fechaDevolucion);

                // Actualizar los componentes de la interfaz gráfica con los datos obtenidos
                jLabel3.setText(nombreVehiculo);
                jLabel4.setText(nombreModelo);
                jLabel5.setText(fechaRecogida.toString());
                jLabel6.setText(fechaDevolucion.toString());
            } else {
                // Si no se encuentra ninguna reserva para el cliente
                JOptionPane.showMessageDialog(this, "No tines Ninguna reserva " + nombreUsuario, "Reserva no encontrada", JOptionPane.ERROR_MESSAGE);
                
                
                jLabel3.setText("No existe");
                jLabel4.setText("No existe");
                jLabel5.setText("No existe");
                jLabel6.setText("No existe");
            }
            
            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (Exception ex) {
            // Manejar cualquier excepción que ocurra durante la ejecución de la consulta SQL
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 240, 20));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 190, 20));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 100, 20));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, 20));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 200, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reservas.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Reservas_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String nombreUsuario = "usuario";
                new Reservas_Cliente(nombreUsuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
