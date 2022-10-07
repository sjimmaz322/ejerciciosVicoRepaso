/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author sajm
 */
public class EjercicioLlamadas {

    public static void main(String[] args) {

        //Creamos un ArrayList para guardar las llamadas
        ArrayList<Llamada> listadoLlamadas = new ArrayList<Llamada>();

        int eleccion;

        do {
            eleccion = JOptionPane.YES_NO_OPTION;

            if (JOptionPane.showConfirmDialog(null, "¿Desea registrar una llamada?", "Registro Llamadas",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //Código para elección de si

                Llamada llamada = rellenarLlamada();

                listadoLlamadas.add(llamada);

            } else {
                String[] options = {"Consola", "Pantalla"};
                //Código para elección de no
                int eleccion2 = JOptionPane.showOptionDialog(null, "Seleccione como desea ver la información", "Seleccione", 0, JOptionPane.QUESTION_MESSAGE, null, options, "");
                eleccion = 1;
                //Ordenamos las llamadas por duración de menor a mayor
                ordenarLlamadas(listadoLlamadas);

                switch (eleccion2) {
                    case 0:
                        for (Llamada listado : listadoLlamadas) {
                            System.out.println(listado.toString());
                        }

                        break;
                    case 1:
                        for (Llamada listado : listadoLlamadas) {
                            JOptionPane.showMessageDialog(null, listado.toString());
                        }
                        break;
                }

            }
        } while (eleccion == 0);

    }

    private static Llamada rellenarLlamada() {

        Llamada aux = new Llamada();

        int anio, mes, dia, horas, minutos;

        aux.setId(JOptionPane.showInputDialog("Introduzca el identificador de la llamada (Sus iniciales) por favor"));
        do {
            try {
                aux.setNumeroOrigen(JOptionPane.showInputDialog("Introduzca el número desde el que está llamando por favor"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "El campo no puede ser dejado en blanco.");
            }
        } while (aux.getNumeroOrigen().length() != 9);
        do {
            aux.setNumeroDestino(JOptionPane.showInputDialog("Introduzca el número al que ha llamado por favor"));
        } while (aux.getNumeroDestino().length() != 9);

        do {
            anio = stringToInt(JOptionPane.showInputDialog("Introduzca el año en el que se realizó la llamada"));
            if (!(anio >= 1855 && anio <= LocalDateTime.now().getYear())) {
                JOptionPane.showMessageDialog(null, "Introduza un año entre la creación del teléfono y el año actual");
            }
        } while (!(anio >= 1855 && anio <= LocalDateTime.now().getYear()));

        do {
            mes = stringToInt(JOptionPane.showInputDialog("Introduzca el mes en el que se realizó la llamada"));
            if (!(mes >= 1 && mes <= 12)) {
                JOptionPane.showMessageDialog(null, "Los meses van del 1 al 12");
            }
        } while (!(mes >= 1 && mes <= 12));

        do {
            dia = stringToInt(JOptionPane.showInputDialog("Introduzca el día en el que se realizó la llamada"));
            if ((!(dia >= 1 && dia <= 31))) {
                JOptionPane.showMessageDialog(null, "Los días pueden ir desde el 1 al 31");
            }
        } while (!(dia >= 1 && dia <= 31));

        do {
            horas = stringToInt(JOptionPane.showInputDialog("Introduzca la hora en la que se realizó la llamada"));
            if (!(horas >= 0 && horas <= 23)) {
                JOptionPane.showMessageDialog(null, "Las horas pueden ir de 0 a 23");
            }
        } while (!(horas >= 0 && horas <= 23));

        do {
            minutos = stringToInt(JOptionPane.showInputDialog("Introduzca el minuto en el que se realizó la llamada"));
            if (!(minutos >= 0 && minutos <= 59)) {
                JOptionPane.showMessageDialog(null, "Los minutos pueden ir de 0 a 59");
            }
        } while (!(minutos >= 0 && minutos <= 59));

        aux.setFechaHoraInicio(LocalDateTime.of(LocalDate.of(anio, mes, dia), LocalTime.of(horas, minutos)));

        do {
            anio = stringToInt(JOptionPane.showInputDialog("Introduzca el año en el que finalizó la llamada"));
            if (!(anio >= 1855 && anio <= LocalDateTime.now().getYear())) {
                JOptionPane.showMessageDialog(null, "Introduza un año entre la creación del teléfono y el año actual");
            }
        } while (!(anio >= 1855 && anio <= LocalDateTime.now().getYear()));

        do {
            mes = stringToInt(JOptionPane.showInputDialog("Introduzca el mes en el que finalizó la llamada"));
            if (!(mes >= 1 && mes <= 12)) {
                JOptionPane.showMessageDialog(null, "Los meses van del 1 al 12");
            }
        } while (!(mes >= 1 && mes <= 12));

        do {
            dia = stringToInt(JOptionPane.showInputDialog("Introduzca el día en el que finalizó la llamada"));
            if ((!(dia >= 1 && dia <= 31))) {
                JOptionPane.showMessageDialog(null, "Los días pueden ir desde el 1 al 31");
            }
        } while (!(dia >= 1 && dia <= 31));

        do {
            horas = stringToInt(JOptionPane.showInputDialog("Introduzca la hora en la que finalizó la llamada"));
            if (!(horas >= 0 && horas <= 23)) {
                JOptionPane.showMessageDialog(null, "Las horas pueden ir de 0 a 23");
            }
        } while (!(horas >= 0 && horas <= 23));

        do {
            minutos = stringToInt(JOptionPane.showInputDialog("Introduzca el minuto en el que finalizó la llamada"));
            if (!(minutos >= 0 && minutos <= 59)) {
                JOptionPane.showMessageDialog(null, "Los minutos pueden ir de 0 a 59");
            }
        } while (!(minutos >= 0 && minutos <= 59));

        aux.setFechaHoraFin(LocalDateTime.of(anio, mes, dia, horas, minutos));

        long diferencia = Duration.between(aux.getFechaHoraInicio(), aux.getFechaHoraFin()).toMinutes();
        aux.setDuracion(diferencia);

        return aux;
    }

    private static int stringToInt(String aux) {
        int num = Integer.parseInt(aux);
        return num;
    }

    private static ArrayList<Llamada> ordenarLlamadas(ArrayList<Llamada> aux) {

        Collections.sort(aux, new Comparator<Llamada>() {
            @Override
            public int compare(Llamada l1, Llamada l2) {
                return (int) l1.getDuracion() - (int) l2.getDuracion();
            }
        });
        return aux;

    }
}
