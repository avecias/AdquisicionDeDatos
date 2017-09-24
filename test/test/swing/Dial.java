/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.swing;

import com.app.modelo.dial.Termometro;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gvalentin
 */
public class Dial {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("prueba");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setContentPane(panel);
        panel.setPreferredSize(new Dimension(500, 400));
        Termometro termometro = new Termometro();
        panel.add(termometro.crearChart());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        termometro.DATASET.setValue(50);
    }
}
