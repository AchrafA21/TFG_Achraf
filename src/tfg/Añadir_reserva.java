/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import Config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.JFrame;


public class Añadir_reserva extends javax.swing.JFrame {
 Conexion con1 = new Conexion();
   Connection conet;
   DefaultTableModel modelo;
   Statement st;
   ResultSet rs;
  
    
    public Añadir_reserva() {
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public Añadir_reserva(String nombreCliente, String nombreVehiculo, String nombreModelo, String fechaRecogida, String fechaDevolucion) {
        initComponents();
        this.setLocationRelativeTo(this);
 String[] datosCliente = obtenerDatosCliente(nombreCliente);

        // Cargar los datos en los campos de texto
        jTextField1.setText(nombreCliente);
        jTextField2.setText(datosCliente[0]); // Apellido
        jTextField3.setText(datosCliente[1]); // Correo
        jTextField4.setText(datosCliente[2]); // Teléfono
        jTextField7.setText(nombreVehiculo);
        jTextField8.setText(nombreModelo);
        jTextField5.setText(fechaRecogida);
        jTextField6.setText(fechaDevolucion);
    }
    private String[] obtenerDatosCliente(String nombreCliente) {
        String[] datosCliente = new String[3]; // Array para apellido, correo y teléfono

        String sql = "SELECT apellido, correo, telefono FROM alquiler_clientes WHERE nombre = ?";
        try {
            conet = con1.getConnection();
            PreparedStatement ps = conet.prepareStatement(sql);
            ps.setString(1, nombreCliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                datosCliente[0] = rs.getString("apellido");
                datosCliente[1] = rs.getString("correo");
                datosCliente[2] = rs.getString("telefono");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datosCliente;
    }

    // Resto de la clase...

    
   public int obtenerIdClientePorNombre(String nombreCliente) {
    int idCliente = -1; // Valor por defecto si no se encuentra el cliente
    
   
        String sql = "SELECT id FROM alquiler_clientes WHERE nombre = ?";
        
       try {
         
       Connection conet = con1.getConnection();
       
             try(PreparedStatement st = conet.prepareStatement(sql)) {
            
            st.setString(1, nombreCliente);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    idCliente = rs.getInt("id");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return idCliente;
}
//======================================================================
public int obtenerIdVehiculoPorNombre(String nombreVehiculo) {
    int idVehiculo = -1; // Valor por defecto si no se encuentra el vehículo
    
    
        String sql = "SELECT id FROM vehiculos WHERE nombre = ?";
        
        try {
         
       Connection conet = con1.getConnection();
       
             try(PreparedStatement st = conet.prepareStatement(sql)) {
            
            st.setString(1, nombreVehiculo);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    idVehiculo = rs.getInt("id");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return idVehiculo;
}

//==============================================================================
public int obtenerIdModeloPorNombre(String nombreModelo) {
    int idModelo = -1; // Valor por defecto si no se encuentra el modelo
    String sql = "SELECT id FROM modelo WHERE nombre = ?";
    try {
         
       Connection conet = con1.getConnection();
       
             try(PreparedStatement st = conet.prepareStatement(sql)) {
            
            st.setString(1, nombreModelo);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    idModelo = rs.getInt("id");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return idModelo;
}
//===============================================================
public void guardarReserva() {
    try {
        // Obtener los valores de los campos de texto
        String nombreCliente = jTextField1.getText();
        String apellidoCliente = jTextField2.getText();
        String correoCliente = jTextField3.getText();
        String telefonoCliente = jTextField4.getText();
        String fechaRecogida = jTextField5.getText();
        String fechaDevolucion = jTextField6.getText();
        String nombreVehiculo = jTextField7.getText();
        String nombreModelo = jTextField8.getText();
        Random rand = new Random();
        int idtrabajador = rand.nextInt(9) + 1;
        

        // Obtener el ID del cliente
        int idCliente = obtenerIdClientePorNombre(nombreCliente);

        // Obtener el ID del vehículo
        int idVehiculo = obtenerIdVehiculoPorNombre(nombreVehiculo);

        // Obtener el ID del modelo
        int idModelo = obtenerIdModeloPorNombre(nombreModelo);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaRecogidaDate = dateFormat.parse(fechaRecogida);
        java.util.Date fechaDevolucionDate = dateFormat.parse(fechaDevolucion);

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date sqlFechaRecogida = new java.sql.Date(fechaRecogidaDate.getTime());
        java.sql.Date sqlFechaDevolucion = new java.sql.Date(fechaDevolucionDate.getTime());

        conet = con1.getConnection();
        
        
        String queryCheck = "SELECT COUNT(*) FROM reserva WHERE id_cliente = ? AND id_vehiculo = ? AND id_modelo = ? AND fecha_recogida = ? AND fecha_devolucion = ?";
        PreparedStatement checkStmt = conet.prepareStatement(queryCheck);
        checkStmt.setInt(1, idCliente);
        checkStmt.setInt(2, idVehiculo);
        checkStmt.setInt(3, idModelo);
        checkStmt.setDate(4, sqlFechaRecogida);
        checkStmt.setDate(5, sqlFechaDevolucion);
        
        ResultSet rs = checkStmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        if (count > 0) {
            
            String sqlUpdate = "UPDATE reserva SET id_cliente = ?, id_vehiculo = ?, id_modelo = ?, fecha_recogida = ? , fecha_devolucion = ?  WHERE id_cliente = ? AND id_vehiculo = ? AND id_modelo = ? ";
            PreparedStatement updateStmt = conet.prepareStatement(sqlUpdate);
            updateStmt.setInt(1, idCliente);
            updateStmt.setInt(2, idVehiculo);
            updateStmt.setInt(3, idModelo);
            updateStmt.setDate(4, sqlFechaRecogida);
            updateStmt.setDate(5, sqlFechaDevolucion);
//            updateStmt.setInt(6, idtrabajador);
            updateStmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reserva actualizada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si no existe, inserta un nuevo registro
            String sqlInsert = "INSERT INTO reserva (id_cliente, id_vehiculo, id_modelo, fecha_recogida, fecha_devolucion, id_trabajador) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement insertStmt = conet.prepareStatement(sqlInsert);
            insertStmt.setInt(1, idCliente);
            insertStmt.setInt(2, idVehiculo);
            insertStmt.setInt(3, idModelo);
            insertStmt.setDate(4, sqlFechaRecogida);
            insertStmt.setDate(5, sqlFechaDevolucion);
            insertStmt.setInt(6, idtrabajador);
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Reserva agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        // Limpiar campos de texto
//        jTextField1.setText("");
//        jTextField2.setText("");
//        jTextField3.setText("");
//        jTextField4.setText("");
//        jTextField5.setText("");
//        jTextField6.setText("");
//        jTextField7.setText("");
//        jTextField8.setText("");
        
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al procesar las fechas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    

    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 613, 180, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/datos_reserva.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 140, 210, 20));

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 192, 210, 20));

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, 20));

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 210, 20));

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 362, 200, 20));

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 210, 20));

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 210, 20));

        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(null);
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 546, 210, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        Calendario2 s = new Calendario2(this);
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
        Calendario d= new Calendario(this);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardarReserva();
        generarPDF();
//        Document documento = new Document();
//        try{
//            String ruta= System.getProperty("user.home");
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta +"/Documents/NetBeansProjects/Proyecto_Final/Datos_reserva.pdf"));
//            documento.open();
//            
//        
//        }catch(Exception e){
//        }
    }//GEN-LAST:event_jButton1ActionPerformed
   public void setFechaRecogida(String fechaRecogida) {
    jTextField5.setText(fechaRecogida);
   }
   public void setFechaDevolucion(String fecha) {
    jTextField6.setText(fecha);
   }
   
   
    public void generarPDF() {
            String nombreCliente = jTextField1.getText();
            String apellidoCliente = jTextField2.getText();
            String correoCliente = jTextField3.getText();
            String telefonoCliente = jTextField4.getText();
            String fechaRecogida = jTextField5.getText();
            String fechaDevolucion = jTextField6.getText();
            String nombreVehiculo = jTextField7.getText();
            String nombreModelo = jTextField8.getText();

        Document documento = new Document();
        String ruta = System.getProperty("user.home") + "/Documents/NetBeansProjects/TFG/Datos_reserva.pdf";

        try {
                    PdfWriter.getInstance(documento, new FileOutputStream(ruta));

//            String ruta = System.getProperty("user.home");
//            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Documents/NetBeansProjects/Proyecto_Final/Datos_reserva.pdf"));
          
            documento.open();

            // Descripción de la empresa
            Paragraph empresa = new Paragraph("Renta Car\n\n", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            empresa.setAlignment(Element.ALIGN_CENTER);
            documento.add(empresa);

            Paragraph descripcion = new Paragraph(
                "Renta Car es una empresa dedicada al alquiler de vehículos, ofreciendo una amplia gama de opciones " +
                "para satisfacer las necesidades de transporte de nuestros clientes. Nuestro compromiso es proporcionar " +
                "un servicio de calidad con vehículos en excelentes condiciones y precios competitivos.\n\n",
                new Font(Font.FontFamily.HELVETICA, 12)
            );
            descripcion.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(descripcion);

            // Tabla con los datos de la reserva
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            Font headFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12);

            PdfPCell cell;

            cell = new PdfPCell(new Phrase("Datos de la Reserva", headFont));
            cell.setColspan(2);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(10);
            table.addCell(cell);

            table.addCell(new PdfPCell(new Phrase("Nombre del Cliente:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(nombreCliente + " " + apellidoCliente, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Correo del Cliente:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(correoCliente, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Teléfono del Cliente:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(telefonoCliente, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Fecha de Recogida:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(fechaRecogida, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Fecha de Devolución:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(fechaDevolucion, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Nombre del Vehículo:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(nombreVehiculo, bodyFont)));

            table.addCell(new PdfPCell(new Phrase("Nombre del Modelo:", bodyFont)));
            table.addCell(new PdfPCell(new Phrase(nombreModelo, bodyFont)));

            documento.add(table);
            
             GregorianCalendar s = new GregorianCalendar();
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String fechaHoraActual = dateTimeFormat.format(s.getTime());
            
            Paragraph fechaHora = new Paragraph("Fecha y hora de generación del PDF: " + fechaHoraActual + "\n\n", new Font(Font.FontFamily.HELVETICA, 12));
            fechaHora.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fechaHora);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            documento.close();
           try {
            File file = new File(ruta);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("Apertura automática no soportada");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
           
            
        }
    }

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir_reserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
