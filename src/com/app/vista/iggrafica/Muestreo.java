/*
Este el jframe se muestran los diales ejecutando cambios
de los sensores casi en tiempo real
 */
package com.app.vista.iggrafica;

import com.app.modelo.entidades.Parametro;
import com.app.modelo.entidades.Trama;
import com.app.vista.igusuario.Principal;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Muestreo extends javax.swing.JFrame implements SerialPortEventListener {

    private final Principal principal;
    private final String dial = "Dial representado en grados bla bla bla";
    private final String nivel = "nivel representado en grados bla bla bla";
    private final String ter = "termometro representado en grados bla bla bla";
    private SerialPort serialPort;
    private String mensajeAux;
    private String mensaje;

    public Muestreo(Parametro parametro, Principal principal) {
        initComponents();
        initAll();
        icono();
        this.principal = principal;
        mensajeAux = "";
        mensaje = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrando Diales");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                cerrarVentana(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 817, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarVentana(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrarVentana
        // Antes de cerrar la ventana cerrar la conexion
        principal.setVisible(true);
    }//GEN-LAST:event_cerrarVentana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    private void icono() {
        setIconImage(new ImageIcon("src/com/app/imagenes/icon.png").getImage());
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.isRXCHAR()) {
            if (event.getEventValue() > 0) {
                try {
                    String receivedData = serialPort.readString(event.getEventValue());
                } catch (SerialPortException ex) {
                    System.out.println("Error in receiving string from COM-port: " + ex);
                }
            }
        }
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(SerialPort serialPort) {
        this.serialPort = serialPort;
    }

    private void initAll() {
    }

}
