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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Datos_Cliente extends javax.swing.JFrame {

   Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
   
    public Datos_Cliente() {
        initComponents();
        Consultar();
    }
    

   void Consultar(){
    String sql = "SELECT nombre, apellido, correo, contraseña, fecha_nac, direccion, telefono, ciudad, edad, sexo FROM alquiler_clientes";
   try{
        conet=con1.getConnection();
        st=conet.createStatement();
        rs=st.executeQuery(sql);
        
         Object[] cabecera = new Object[] { "nombre", "apellido", 
        "correo","contraseña", "fecha_nac", "direccion", "telefono", "ciudad", "edad", "sexo" }; 
           DefaultTableModel modelo = new DefaultTableModel(null, cabecera);
        jTable1.setModel(modelo);
         
           Object [] empleados = new Object[10];
           
           modelo = (DefaultTableModel) jTable1.getModel();
           while(rs.next())
           {
               empleados [0] = rs.getString("nombre");
               empleados [1] = rs.getString("apellido");
               empleados [2] = rs.getString("correo");
               empleados [3] = rs.getString("contraseña");
               empleados [4] = rs.getDate("fecha_nac");
               empleados [5] = rs.getString("direccion");
               empleados [6] = rs.getString("telefono");
               empleados [7] = rs.getString("ciudad");
               empleados [8] = rs.getInt("edad");
               empleados [9] = rs.getString("sexo");
            
            modelo.addRow(empleados);
        };
        jTable1.setModel(modelo);
       TableColumn columnaCargo = jTable1.getColumnModel().getColumn(3); 
        columnaCargo.setPreferredWidth(150);
      
    }
    catch(Exception e){
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(2, 0, 43));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 990, 160));

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
 void eliminar() {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada >= 0) {
        String nombrecliente = jTable1.getValueAt(filaSeleccionada, 0).toString(); // Suponiendo que el nombre del modelo está en la primera columna
        String sqlSelectId = "SELECT id FROM alquiler_clientes WHERE nombre = '" + nombrecliente + "'";
        String idcliente = null;

        try {
            conet = con1.getConnection();
            st = conet.createStatement();
            rs = st.executeQuery(sqlSelectId);

            if (rs.next()) {
                idcliente = rs.getString("id");
            }

            if (idcliente != null) {
                String sqlDelete = "DELETE FROM alquiler_clientes WHERE id = " + nombrecliente;
                st.executeUpdate(sqlDelete);

                // Actualizar la tabla después de la eliminación
                ((DefaultTableModel) jTable1.getModel()).removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Cliente borrado correctamente");
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
 
 
 void editar() {
       int filaSeleccionada = jTable1.getSelectedRow();
       if (filaSeleccionada >= 0) {
           String nombre = jTable1.getValueAt(filaSeleccionada, 0).toString();
           String apellido = jTable1.getValueAt(filaSeleccionada, 1).toString();
           String correo = jTable1.getValueAt(filaSeleccionada, 2).toString();
           String contraseña = jTable1.getValueAt(filaSeleccionada, 3).toString();
           String fechaTexto = jTable1.getValueAt(filaSeleccionada, 4).toString();
           SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
           Date fechaNac = null;
           try {
               fechaNac = formatoFecha.parse(fechaTexto);
           } catch (ParseException e) {
               e.printStackTrace();
               JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha válida en el formato yyyy-MM-dd.");
               return;
           }
           String direccion = jTable1.getValueAt(filaSeleccionada, 5).toString();
           String telefono = jTable1.getValueAt(filaSeleccionada, 6).toString();
           String ciudad = jTable1.getValueAt(filaSeleccionada, 7).toString();
           int edad = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 8).toString());
           String sexo = jTable1.getValueAt(filaSeleccionada, 9).toString();

           Añadir_Cliente v = new Añadir_Cliente(nombre, apellido, correo, direccion, telefono, ciudad, edad, sexo);
           v.setVisible(true);
           v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           v.addWindowListener(new WindowAdapter() {
               @Override
               public void windowClosed(WindowEvent e) {
                   Consultar();
               }
           });
       } else {
           JOptionPane.showMessageDialog(null, "Seleccione un registro para editar");
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
            java.util.logging.Logger.getLogger(Datos_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_Cliente().setVisible(true);
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
