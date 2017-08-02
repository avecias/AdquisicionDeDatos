/*
Conectar con el puerto serial por medio de la api JSSC
 */
package com.app.controlador.usuario;

import com.app.modelo.conexion.serial.ConexionSerial;
import com.app.modelo.conexion.serial.ConexionSerialImple;
import com.app.modelo.entidades.Parametro;
import com.app.vista.iggrafica.Muestreo;
import com.app.vista.igusuario.Principal;
import javax.swing.JOptionPane;
import jssc.SerialPortException;

public class ConectarPuerto {

    public void hacer(Parametro parametro, Principal principal) {
        try {
            Muestreo muestreo = new Muestreo(parametro, principal);
            // Establecer los parametro de la conexion
            int baudios = Integer.valueOf(String.valueOf(principal.getComboBaudios().getSelectedItem()));
            int datos = Integer.valueOf(String.valueOf(principal.getComboDatos().getSelectedItem()));
            int paridad = Integer.valueOf(String.valueOf(principal.getComboParidad().getSelectedIndex()));
            int paro = Integer.valueOf(String.valueOf(principal.getComboParo().getSelectedItem()));
            String puerto = String.valueOf(principal.getComboPuertos().getSelectedItem());
            Parametro parametros = new Parametro(puerto, baudios, datos, paro, paridad);
            ConexionSerial conexionSerial = new ConexionSerialImple(parametros);
            conexionSerial.abrir(muestreo);
            // Subir a la session
            principal.setVisible(false);
            principal.dispose();
            muestreo.setSerialPort(((ConexionSerialImple)conexionSerial).getSerialPort());
            muestreo.setVisible(true);
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog(principal, "Error al comunicar con arduino", "Error en arduino", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al conectar con el puerto serial " + ex);
        }
    }
}
