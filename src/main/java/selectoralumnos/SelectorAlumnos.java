package selectoralumnos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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

        //Comprobamos si el documento existe, en caso de que no exista lo creamos.
        comprobarDocumento();

        //Elegimos al alumno que saldrá
        elegirAlumno();

    }

    private static void crearDocumento() {
        //Creamos en ArrayList para contener la lista de alumnos
        ArrayList<Alumno> alumnado = new ArrayList<>();

        //Creamos el nombre y la ruta del archivo
        String idFichero = "Alumnos.csv";

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
                flujo.write(alumnado.get(i).getFaltas() + ";");
                flujo.newLine();

            }

            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void comprobarDocumento() {
        String filePath = "Alumnos.csv";

        Path path = Paths.get(filePath);

        boolean existe = Files.exists(path);
        boolean noExiste = Files.notExists(path);

        if (existe) {
            System.out.println("El Archivo ya existe");
        } else {
            System.out.println("El archivo no existe.\n Creando archivo.");
            crearDocumento();
        }
    }

    private static void elegirAlumno() {
        //Declaramos el objeto de la clase Random
        Random rd = new Random();

        //Creamos las variables necesarias.
        int elegidos, result;
        String idFichero = "Alumnos.csv";
        ArrayList<Alumno> alumnado = new ArrayList<>();
        ArrayList<Alumno> alumnosQuitados = new ArrayList<>();
        String[] listado = new String[32];

        //Array para personalizar los botones
        String[] opcion = {"¡Dame mi positivillo!", "Soy un sinvergüenza...", "Desaparecido en combate"};

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");

                alumnado.add(new Alumno(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));

            }
            for (int i = 0; i < alumnado.size(); i++) {
                listado[i] = alumnado.get(i).getNombre();
                
            }

            //if-else con do-while para la selección de quien saldrá y si cumple los requisitos
            if (JOptionPane.showConfirmDialog(null, "¿Hay voluntarios?", "Veamos",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Object valiente = JOptionPane.showInputDialog(null, "¿Quién es el valiente?", "Valiente", JOptionPane.QUESTION_MESSAGE, null, listado, listado);
                JOptionPane.showMessageDialog(null, "Ánimo " + valiente.toString() + ", ya tienes un positivillo");
                for (int i = 0; i < alumnado.size(); i++) {
                    if (alumnado.get(i).getNombre().equalsIgnoreCase(valiente.toString())) {
                        alumnado.get(i).setPositivos(alumnado.get(i).getPositivos() + 1);
                    }

                }
            } else {
                do {
                    elegidos = rd.nextInt(alumnado.size());
                    result = JOptionPane.showOptionDialog(null, "¿Tienes hecha la tarea?\n" + alumnado.get(elegidos).getNombre(), "Responde", 0, JOptionPane.QUESTION_MESSAGE, null, opcion, "");
                    switch (result) {
                        case 0:
                            JOptionPane.showMessageDialog(null, "Muy bien " + alumnado.get(elegidos).getNombre() + ", ganaste un positivillo.");
                            alumnado.get(elegidos).setPositivos(alumnado.get(elegidos).getPositivos() + 1);

                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null, "Mal vamos " + alumnado.get(elegidos).getNombre() + "...");
                            alumnado.get(elegidos).setNegativos(alumnado.get(elegidos).getNegativos() + 1);

                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Pues nada, pasamos a otro.");
                            alumnado.get(elegidos).setFaltas(alumnado.get(elegidos).getFaltas() + 1);

                            break;
                    }
                    alumnosQuitados.add(alumnado.get(elegidos));
                    alumnado.remove(elegidos);
                } while (result != 0);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < alumnosQuitados.size(); i++) {
            alumnado.add(alumnosQuitados.get(i));

        }
        actualizarDocumento(idFichero, alumnado);

    }

    private static void actualizarDocumento(String ruta, ArrayList<Alumno> lista) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {

            flujo.write("Lista de Alumnos" + ";");
            flujo.write("Positivos" + ";");
            flujo.write("Negativos" + ";");
            flujo.write("Faltas");
            flujo.newLine();

            for (int i = 0; i < lista.size(); i++) {
                flujo.write(lista.get(i).getNombre() + ";");
                flujo.write(lista.get(i).getPositivos() + ";");
                flujo.write(lista.get(i).getNegativos() + ";");
                flujo.write(lista.get(i).getFaltas() + ";");
                flujo.newLine();

            }

            flujo.flush();
            System.out.println("Fichero " + ruta + " actualizado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
