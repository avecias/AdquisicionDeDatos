/*
Este el jframe se muestran los diales ejecutando cambios
de los sensores casi en tiempo real
 */
package com.app.vista.iggrafica;

import com.app.modelo.conexion.analizador.Analizador;
import com.app.modelo.entidades.Parametro;
import com.app.modelo.entidades.Trama;
import com.app.vista.igusuario.Principal;
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
    private Analizador analizador;

    public Muestreo(Parametro parametro, Principal principal) {
        initComponents();
        initAll();
        icono();
        this.principal = principal;
        mensajeAux = "";
        mensaje = "";
        analizador = new Analizador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
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

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(560, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarVentana(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrarVentana
        // Antes de cerrar la ventana cerrar la conexion
        principal.setVisible(true);
    }//GEN-LAST:event_cerrarVentana


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
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
                    area.append(receivedData);
                    mensajeAux += receivedData;
                    if (receivedData.contains("\n")) {
                        mensaje = mensajeAux;
                        Trama trama = analizador.convertir(mensaje.substring(0, mensaje.length() - 2));
//                        panelChart.getDataset().setValue(trama.getA());
//                        panelChart2.getDataset().setValue(trama.getB());
//                        termometro.getDataset().setValue(trama.getC());
                        mensajeAux = "";
                        System.out.println(trama);
                    }
                }  catch (SerialPortException ex) {
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
