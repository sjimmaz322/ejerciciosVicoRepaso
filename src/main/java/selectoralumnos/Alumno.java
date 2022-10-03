/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectoralumnos;

import java.util.Objects;

/**
 *
 * @author sajm <sjimmaz322 at sjimmaz322@g.educaand.es>
 */
public class Alumno {

    private String nombre, apellido;
    private int positivos, negativos, faltas;

    public Alumno(String nombre, String apellido, int positivos, int negativos, int faltas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.positivos = positivos;
        this.negativos = negativos;
        this.faltas = faltas;
    }

    public Alumno() {
        this.nombre = "";
        this.apellido = "";
        this.positivos = 0;
        this.negativos = 0;
        this.faltas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPositivos() {
        return positivos;
    }

    public void setPositivos(int positivos) {
        this.positivos = positivos;
    }

    public int getNegativos() {
        return negativos;
    }

    public void setNegativos(int negativos) {
        this.negativos = negativos;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.apellido);
        hash = 97 * hash + this.positivos;
        hash = 97 * hash + this.negativos;
        hash = 97 * hash + this.faltas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }

    @Override
    public String toString() {
        return "El alumno " + nombre + " " + apellido + " tiene " + positivos + " positivos, " + negativos + " y " + faltas + " faltas de asistencia registradas";
    }

}
