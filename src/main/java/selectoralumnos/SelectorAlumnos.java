package selectoralumnos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        //Creamos el nombre y la ruta del archivo
        String idFichero = "Alumnos.csv";

        //Creamos en ArrayList para contener la lista de alumnos
        ArrayList<Alumno> alumnado = new ArrayList<>();

        //Rellenamos el ArrayList con los alumnos
        alumnado.add(new Alumno("Clara Isabel Álvarez Aragón", 0, 0, 0));
        alumnado.add(new Alumno("Juan Antonio Barbero Mena", 0, 0, 0));
        alumnado.add(new Alumno("Alberto Collado Araujo", 0, 0, 0));
        alumnado.add(new Alumno("Eduardo Correa Aranda", 0, 0, 0));
        alumnado.add(new Alumno("Guerig Eri Cuchallo Jaldin", 0, 0, 0));
        alumnado.add(new Alumno("Elisabet D'Acosta Almirón", 0, 0, 0));
        alumnado.add(new Alumno("Cristina Delgado Castillo", 0, 0, 0));
        alumnado.add(new Alumno("Erick G", 0, 0, 0));
        alumnado.add(new Alumno("José Ángel Gómez Morillo", 0, 0, 0));
        alumnado.add(new Alumno("Tomás Ariel González Atienza", 0, 0, 0));
        alumnado.add(new Alumno("Aiman Harrar Daoud", 0, 0, 0));
        alumnado.add(new Alumno("Jorge Hernández Puertas", 0, 0, 0));
        alumnado.add(new Alumno("Samuel Jiménez Mazas", 0, 0, 0));
        alumnado.add(new Alumno("Nerea López Sánchez", 0, 0, 0));
        alumnado.add(new Alumno("Maria Juliana Luna Giovanetti", 0, 0, 0));
        alumnado.add(new Alumno("Juan Diego Marín Morale", 0, 0, 0));
        alumnado.add(new Alumno("Adrián Martel Romero", 0, 0, 0));
        alumnado.add(new Alumno("Álvaro Martínez Flores", 0, 0, 0));
        alumnado.add(new Alumno("Fernando Martínez Ortiz", 0, 0, 0));
        alumnado.add(new Alumno("David Mena Jiménez", 0, 0, 0));
        alumnado.add(new Alumno("Pablo Navarro García", 0, 0, 0));
        alumnado.add(new Alumno("Alejandro Neal Chirino", 0, 0, 0));
        alumnado.add(new Alumno("Noelia Pérez González", 0, 0, 0));
        alumnado.add(new Alumno("Antonio Ramírez Navas", 0, 0, 0));
        alumnado.add(new Alumno("Alexey Riazantsev", 0, 0, 0));
        alumnado.add(new Alumno("Darío Rico García", 0, 0, 0));
        alumnado.add(new Alumno("José Antonio Ruiz Jiménez", 0, 0, 0));
        alumnado.add(new Alumno("Jose Ignacio Salcedo Guarde", 0, 0, 0));
        alumnado.add(new Alumno("Victoria Sampalo García", 0, 0, 0));
        alumnado.add(new Alumno("Ismael Shehata Pérez", 0, 0, 0));
        alumnado.add(new Alumno("José Ángel Tierra Vera", 0, 0, 0));
        alumnado.add(new Alumno("Miguel Ángel Victoria Marín", 0, 0, 0));

        //Rellenamos el csv con los datos de los alumnos
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write("Lista de Alumnos" + ";");
            flujo.write("Positivos" + ";");
            flujo.write("Negativos" + ";");
            flujo.write("Faltas");
            flujo.newLine();

            for (int i = 0; i < alumnado.size(); i++) {
                flujo.write(alumnado.get(i).getNombre() + ";");
                flujo.write(alumnado.get(i).getPositivos() + ";");
                flujo.write(alumnado.get(i).getNegativos() + ";");
                flujo.write(alumnado.get(i).getFaltas());
                flujo.newLine();

            }

            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Array para personalizar los botones
        String[] opcion = {"¡Dame mi positivillo!", "Soy un sinvergüenza...", "Desaparecido en combate"};

        //if-else con do-while para la selección de quien saldrá y si cumple los requisitos
        if (JOptionPane.showConfirmDialog(null, "¿Hay voluntarios?", "Veamos",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Ánimo valiente.");
        } else {
            do {
                elegidos = rd.nextInt(alumnado.size());
                result = JOptionPane.showOptionDialog(null, "¿Tienes hecha la tarea?\n" + alumnado.get(elegidos).getNombre(), "Responde", 0, JOptionPane.QUESTION_MESSAGE, null, opcion, "");
                switch (result) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "Muy bien " + alumnado.get(elegidos).getNombre() + ", ganaste un positivillo.");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Mal vamos " + alumnado.get(elegidos).getNombre() + "...");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Pues nada, pasamos a otro.");
                        break;
                }
                alumnado.remove(elegidos);
            } while (result != 0);

        }

    }

}
