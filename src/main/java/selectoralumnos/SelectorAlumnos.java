package selectoralumnos;

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

        //Declaramos el objeto de la clase Random
        Random rd = new Random();

        //Creamos las variables necesarias.
        int elegidos, result;
        boolean valiente = true, tareas = true;

        //Creamos en ArrayList para contener la lista de alumnos
        ArrayList<String> alumnado = new ArrayList<>();

        //Rellenamos el ArrayList con los alumnos
        alumnado.add("Clara Isabel Álvarez Aragón");
        alumnado.add("Juan Antonio Barbero Mena");
        alumnado.add("Alberto Collado Araujo");
        alumnado.add("Eduardo Correa Aranda");
        alumnado.add("Guerig Eri Cuchallo Jaldin");
        alumnado.add("Elisabet D'Acosta Almirón");
        alumnado.add("Cristina Delgado Castillo");
        alumnado.add("Erick G");
        alumnado.add("José Ángel Gómez Morillo");
        alumnado.add("Tomás Ariel González Atienza");
        alumnado.add("Aiman Harrar Daoud");
        alumnado.add("Jorge Hernández Puertas");
        alumnado.add("Samuel Jiménez Mazas");
        alumnado.add("Nerea López Sánchez");
        alumnado.add("Maria Juliana Luna Giovanetti");
        alumnado.add("Juan Diego Marín Morale");
        alumnado.add("Adrián Martel Romero");
        alumnado.add("Álvaro Martínez Flores");
        alumnado.add("Fernando Martínez Ortiz");
        alumnado.add("David Mena Jiménez");
        alumnado.add("Pablo Navarro García");
        alumnado.add("Alejandro Neal Chirino");
        alumnado.add("Noelia Pérez González");
        alumnado.add("Antonio Ramírez Navas");
        alumnado.add("Alexey Riazantsev");
        alumnado.add("Darío Rico García");
        alumnado.add("José Antonio Ruiz Jiménez");
        alumnado.add("Jose Ignacio Salcedo Guarde");
        alumnado.add("Victoria Sampalo García");
        alumnado.add("Ismael Shehata Pérez");
        alumnado.add("José Ángel Tierra Vera");
        alumnado.add("Miguel Ángel Victoria Marín");

        //Array para personalizar los botones
        String[] opcion = {"¡Dame mi positivillo!", "Soy un sinvergüenza...", "No está"};

        if (JOptionPane.showConfirmDialog(null, "¿Hay voluntarios?", "Veamos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ánimo valiente.");
        } else {
            do {
                elegidos = rd.nextInt(alumnado.size());
                result = JOptionPane.showOptionDialog(null, "¿Tienes hecha la tarea?\n" + alumnado.get(elegidos).toString(), "Responde", 0, JOptionPane.QUESTION_MESSAGE, null, opcion, "");
                alumnado.remove(elegidos);
            } while (result != 0);

        }

    }

}
