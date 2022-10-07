/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosPrácticas;

import javax.swing.JOptionPane;
import utilidades.Utilidades;

/**
 *
 * @author sajm <sjimmaz322 at sjimmaz322@g.educaand.es>
 */
public class Manguera {

    /*
     Se requiere llenar un tanque que tiene una capacidad de X metros cúbicos.
     Haga un algoritmo que imprima el tiempo que tarda en llenarse dicho tanque con una manguera que tiene una capacidad de Y litros de agua por minuto.
     */
    public static void main(String[] args) {

        //Declaramos e inicializamos las variables y constantes.
        final int LITROSENMCUBICOS = 1000;
        final int SEGUNDOSENDIA = 86400;
        final int SEGUNDOSENHORA = 3600;
        final int SEGUNDOSENMINUTO = 60;

        double litrosMinutoManguera = 0, capacidadTanque = 0, capacidadLitrosTanque, minutosLlenado;
        int segundosLlenado, dias, diasSobrantes, horas, horasSobrantes, minutos, segundos;
        boolean seguir = true;

        //Pedimos los litros por minuto que expulsa la manguera
        do {//Bucle para asegurar que los datos sean correctos
            try {//Control de excepciones
                seguir = true;
                litrosMinutoManguera = Utilidades.stringToDouble(JOptionPane.showInputDialog("¿Cuántos litros por minuto expulsa la manguera?"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca un número correcto");
                seguir = false;
            }
        } while (!seguir);

        //Pedimos la capacidad del tanque
        do {//Bucle para asegurar que los datos sean correctos
            try {//Control de excepciones
                seguir = true;
                capacidadTanque = Utilidades.stringToDouble(JOptionPane.showInputDialog("¿Cuál es la capacidad del tanque en metros cúbicos?"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Introduzca un número correcto");
                seguir = false;
            }
        } while (!seguir);

        //Pasamos metros cúbicos a litros
        capacidadLitrosTanque = capacidadTanque * LITROSENMCUBICOS;
        //Calculamos cuantos minutos tarda en llenarse
        minutosLlenado = capacidadLitrosTanque / litrosMinutoManguera;
        //Pasamos los minutos a segundos y casteamos a int para los cálculos siguientes
        segundosLlenado = (int) (minutosLlenado * 60);

        //Operamos con los segundos que contienen días, horas y minutos
        dias = segundosLlenado / SEGUNDOSENDIA;
        diasSobrantes = segundosLlenado % SEGUNDOSENDIA;
        horas = diasSobrantes / SEGUNDOSENHORA;
        horasSobrantes = diasSobrantes % SEGUNDOSENHORA;
        minutos = horasSobrantes / SEGUNDOSENMINUTO;
        segundos = horasSobrantes % SEGUNDOSENMINUTO;

        //Creamos mensajes diferentes para no mostrar información irrelevante, como que tardamos 0 días.
        String resultadoCompleto = """
                           Para llenar un tanque de %.2f metros cúbicos de capacidad o de %.2f litros de capacidad,
                           si contamos con una manguera que expulse %.2f litros por minuto,
                           tardaremos un total de %d segundos, o lo que es lo mismo:
                           
                           %d - días.
                           %d - horas.
                           %d - minutos.
                           %d - segundos.
                           """.formatted(Math.abs(capacidadTanque), Math.abs(capacidadLitrosTanque), Math.abs(litrosMinutoManguera), Math.abs(segundosLlenado),
                Math.abs(dias), Math.abs(horas), Math.abs(minutos), Math.abs(segundos));

        String resultadoHorasMinutosSegundos = """
                           Para llenar un tanque de %.2f metros cúbicos de capacidad o de %.2f litros de capacidad,
                           si contamos con una manguera que expulse %.2f litros por minuto,
                           tardaremos un total de %d segundos, o lo que es lo mismo:
                           
                           %d - horas.
                           %d - minutos.
                           %d - segundos.
                           """.formatted(Math.abs(capacidadTanque), Math.abs(capacidadLitrosTanque), Math.abs(litrosMinutoManguera), Math.abs(segundosLlenado),
                Math.abs(horas), Math.abs(minutos), Math.abs(segundos));

        String resultadoMinutosSegundos = """
                           Para llenar un tanque de %.2f metros cúbicos de capacidad o de %.2f litros de capacidad,
                           si contamos con una manguera que expulse %.2f litros por minuto,
                           tardaremos un total de %d segundos, o lo que es lo mismo:
                           
                           %d - minutos.
                           %d - segundos.
                           """.formatted(Math.abs(capacidadTanque), Math.abs(capacidadLitrosTanque), Math.abs(litrosMinutoManguera), Math.abs(segundosLlenado),
                Math.abs(minutos), Math.abs(segundos));

        String resultadoSegundos = """
                           Para llenar un tanque de %.2f metros cúbicos de capacidad o de %.2f litros de capacidad,
                           si contamos con una manguera que expulse %.2f litros por minuto,
                           tardaremos un total de %d segundos.
                           
                           """.formatted(Math.abs(capacidadTanque), Math.abs(capacidadLitrosTanque), Math.abs(litrosMinutoManguera), Math.abs(segundosLlenado));

        //Estructura de control para no mostrar información inncesearia
        if (dias != 0) {
            JOptionPane.showMessageDialog(null, resultadoCompleto);
        } else if (dias == 0 && horas != 0) {
            JOptionPane.showMessageDialog(null, resultadoHorasMinutosSegundos);
        } else if (dias == 0 && horas == 0 && minutos != 0) {
            JOptionPane.showMessageDialog(null, resultadoMinutosSegundos);
        } else {
            JOptionPane.showMessageDialog(null, resultadoSegundos);
        }
    }

}
