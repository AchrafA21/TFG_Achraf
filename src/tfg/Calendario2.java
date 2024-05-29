/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tfg;

import java.text.SimpleDateFormat;

/**
 *
 * @author Imad
 */
public class Calendario2 extends javax.swing.JFrame {
 private Datos_reserva datos;
    
   public Calendario2(Datos_reserva datos) {
        initComponents();
        this.datos = datos;
        this.setLocationRelativeTo(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar2 = new com.toedter.calendar.JCalendar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCalendar2.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCalendar2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCalendar2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
      if(evt.getOldValue() !=null){
        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = f1.format(jCalendar2.getCalendar().getTime());
        datos.setFechaDevolucion(fecha);
         setVisible(false);
    }
    }//GEN-LAST:event_jCalendar2PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Calendario2().setVisible(true);
                   Datos_reserva datosReserva = new Datos_reserva();
            Calendario2 calendario2 = new Calendario2(datosReserva);
            calendario2.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar2;
    // End of variables declaration//GEN-END:variables
}
