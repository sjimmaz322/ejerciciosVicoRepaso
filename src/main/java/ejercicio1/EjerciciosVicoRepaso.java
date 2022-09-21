/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sajm
 */
public class EjerciciosVicoRepaso {

    public static void main(String[] args) {

        //Creamos un ArrayList para guardar las llamadas
        ArrayList<Llamada> listadoLlamadas = new ArrayList<Llamada>();

        int elección = JOptionPane.YES_NO_OPTION;

        if (JOptionPane.showConfirmDialog(null, "¿Desea registrar una llamada?", "Registro Llamadas",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option
            JOptionPane.showMessageDialog(null, "Añadamos una llamada");

        } else {
            // no option
            JOptionPane.showMessageDialog(null, "Entonces nada");
        }

    }
}
