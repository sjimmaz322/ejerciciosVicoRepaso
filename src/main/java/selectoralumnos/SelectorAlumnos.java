package selectoralumnos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author sjimmaz322 <sjimmaz322@g.educaand.es>
 */
public class SelectorAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random rd = new Random();
        int elegidos, decision, result;
        boolean valiente = true, tareas = true;
        ArrayList<String> alumnado = new ArrayList<>();

        String[] alumnos = {"Clara Isabel Álvarez Aragón",
            "Juan Antonio Barbero Mena",
            "Alberto Collado Araujo",
            "Eduardo Correa Aranda",
            "Guerig Eri Cuchallo Jaldin",
            "Elisabet D'Acosta Almirón",
            "Cristina Delgado Castillo",
            "Erick G",
            "José Ángel Gómez Morillo",
            "Tomá Ariel González Atienza",
            "Aiman Harrar Daoud",
            "Jorge Hernández Puertas",
            "Samuel Alejandro Jiménez Mazas",
            "Nerea López Sánchez",
            "Maria Juliana Luna Giovanetti",
            "Juan Diego Marín Morales",
            "Adrián Martel Romero",
            "Álvaro Martínez Flores",
            "Fernándo Martínez Ortiz",
            "David Mena Jiménez",
            "Pablo Navarro García",
            "Alejandro Neal Chirino",
            "Noelia Pérez González",
            "Antonio Ramirez Navas",
            "Alexey Riazantsev",
            "Daría Rico García",
            "José Antonio Ruiz Jiménez",
            "José Ignacio Salcedo Guarde",
            "Victoria Sampalo García",
            "Ismael Shehata Pérez",
            "Jose Ángel Tierra Vera",
            "Miguel Ángel Victoria Marín"};

        for (String alumno : alumnos) {
            alumnado.add(alumno);
        }

        String[] opcion = {"Dame mi positivo", "Soy sinvergüenza"};

        decision = JOptionPane.YES_NO_OPTION;

        if (JOptionPane.showConfirmDialog(null, "¿Hay voluntarios?", "Veamos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ánimo valiente.");
        } else {
            do {
                elegidos = rd.nextInt(alumnos.length - 1);
                result = JOptionPane.showOptionDialog(null, "¿Tienes hecha la tarea?\n" + alumnos[elegidos].toString(), "Responde", 0, JOptionPane.QUESTION_MESSAGE, null, opcion, "");

            } while (result != 0);

        }

    }

}
