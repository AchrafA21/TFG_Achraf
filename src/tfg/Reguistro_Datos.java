/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Imad
 */
public class Reguistro_Datos extends javax.swing.JFrame {

    Conexion con1 = new Conexion();
   Connection conet;
   Statement st;
   ResultSet rs;
    public Reguistro_Datos() {
        initComponents();
         this.setLocationRelativeTo(this);
        
//        jComboBox1.addItem("Seleccione una opción");
//        jComboBox1.addItem("Trabajador");
//        jComboBox1.addItem("Cliente");
    }

    void GuardarUsuario() {
        
    String nombre = jTextField1.getText();
    String correo = jTextField2.getText(); 
    char[] contrasenaChars = jPasswordField1.getPassword(); // Obtener la contraseña como arreglo de caracteres
    String contraseña = new String(contrasenaChars); 
    String fecha_nac_str = jTextField3.getText(); 
   Object tipoObj = jComboBox1.getSelectedItem();
String tipo = null;

if (tipoObj != null) {
    tipo = tipoObj.toString(); // Convertir el objeto tipo a String
} else {
    // Manejar el caso cuando no se selecciona ningún elemento en el JComboBox
    JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de usuario.", "Tipo de Usuario No Seleccionado", JOptionPane.WARNING_MESSAGE);
    return; // Salir del método si no se selecciona ningún tipo de usuario
}
    
     if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || fecha_nac_str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return; // Detener el proceso de guardado si hay campos vacíos
        }
 // Validar el formato del correo electrónico
    String correoRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    if (!correo.matches(correoRegex)) {
        JOptionPane.showMessageDialog(this, "Por favor, introduce un correo electrónico válido.", "Correo Inválido", JOptionPane.WARNING_MESSAGE);
        return; // Detener el proceso de guardado si el correo no es válido
    }
    System.out.println("Correo: " + correo);
    System.out.println("Correo válido: " + correo.matches(correoRegex));
    // Validar la longitud de la contraseña
    if (contraseña.length() < 8) {
        JOptionPane.showMessageDialog(this, "La contraseña debe tener al menos 8 caracteres.", "Contraseña Inválida", JOptionPane.WARNING_MESSAGE);
        return; // Detener el proceso de guardado si la contraseña es demasiado corta
    }

    // Validar que la contraseña incluya letras mayúsculas, minúsculas, un número y un carácter especial
    String contraseñaRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
    if (!contraseña.matches(contraseñaRegex)) {
        JOptionPane.showMessageDialog(this, "La contraseña debe incluir letras mayúsculas, minúsculas, un número y un carácter especial.", "Contraseña Inválida", JOptionPane.WARNING_MESSAGE);
        return; // Detener el proceso de guardado si la contraseña no cumple con los requisitos
    }
    
  try {
    conet = con1.getConnection();

    if (conet != null) { // Verificar si la conexión es válida
        String sql = null;
       if ("Seleccione una opción".equals(tipo)) {
        JOptionPane.showMessageDialog(this, "El tipo de Usuario no valido seleccione uno valido", "Tipo Usuario", JOptionPane.WARNING_MESSAGE);
        return; // Detener el proceso de guardado si la contraseña es demasiado corta
    }

        if ("Trabajador".equals(tipo)) {
            sql = "INSERT INTO trabajadores (nombre, correo, contraseña, fecha_nac) VALUES (?, ?, ?, ?)";
        } else if ("Cliente".equals(tipo)) {
            sql = "INSERT INTO alquiler_clientes (nombre, correo, contraseña, fecha_nac) VALUES (?, ?, ?, ?)";
        }

        if (sql != null) {
            try (PreparedStatement statement = conet.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, correo);
                statement.setString(3, contraseña);

                SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha_nac = formatoEntrada.parse(fecha_nac_str);
                
               
                
                statement.setDate(4, new java.sql.Date(fecha_nac.getTime()));
                

                int filasInsertadas = statement.executeUpdate();

                if (filasInsertadas > 0) {
                    System.out.println("Nuevo " + tipo + " insertado correctamente.");
                    JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("No se pudo insertar el nuevo " + tipo + ".");
                }
            }
        } else {
            System.out.println("Tipo de usuario seleccionado: " + tipo); 
            System.out.println("Tipo de usuario no válido.");
        }
    } else {
        System.out.println("La conexión no está disponible.");
    }
} catch (SQLException e) {
    System.err.println("Error al insertar empleado: " + e.getMessage());
} catch (ParseException e) {
    System.err.println("Error al convertir la fecha de nacimiento: " + e.getMessage());
}
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(223, 223, 223));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Cliente", "Trabajador" }));
        jComboBox1.setBorder(null);
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 210, 20));

        jButton2.setBackground(new java.awt.Color(184, 25, 25));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Reguistrarse");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 480, 100, -1));

        jButton1.setBackground(new java.awt.Color(184, 25, 25));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 477, 100, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reguistro_Datos.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jTextField1.setBackground(new java.awt.Color(223, 223, 223));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 210, 20));

        jTextField2.setBackground(new java.awt.Color(223, 223, 223));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 210, 20));

        jPasswordField1.setBackground(new java.awt.Color(223, 223, 223));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setBorder(null);
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 308, 210, 20));

        jTextField3.setBackground(new java.awt.Color(223, 223, 223));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 362, 210, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GuardarUsuario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
        Inicio i = new Inicio();
        i.setVisible(true);
        i.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reguistro_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reguistro_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reguistro_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reguistro_Datos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reguistro_Datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
