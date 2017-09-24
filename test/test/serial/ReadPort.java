/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.serial;

import com.app.modelo.conexion.serial.ConexionSerialImple;


/**
 *
 * @author gvalentin
 */
public class ReadPort {
    
    public static void main(String[] args) {
        Object[] puertosDisponibles = ConexionSerialImple.puertosDisponibles();
        for (Object puertosDisponible : puertosDisponibles) {
            System.out.println(puertosDisponible);
        }
    }
}
