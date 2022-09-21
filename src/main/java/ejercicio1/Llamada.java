package ejercicio1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author sajm
 */
public class Llamada {

    private String id, numeroOrigen, numeroDestino;
    private LocalDateTime fechaHoraInicio, fechaHoraFin;

    public Llamada() {
        String id = "";
        String numeroOrigen = "";
        String numeroDestino = "";
        LocalDateTime fechaHOraInicio = LocalDateTime.now();
        LocalDateTime ferchaHoraFin = LocalDateTime.now();

    }

    public Llamada(String id, String numeroOrigen, String numeroDestino, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.id = id;
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(String numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.numeroOrigen);
        hash = 83 * hash + Objects.hashCode(this.numeroDestino);
        hash = 83 * hash + Objects.hashCode(this.fechaHoraInicio);
        hash = 83 * hash + Objects.hashCode(this.fechaHoraFin);
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
        final Llamada other = (Llamada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.numeroOrigen, other.numeroOrigen)) {
            return false;
        }
        if (!Objects.equals(this.numeroDestino, other.numeroDestino)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraInicio, other.fechaHoraInicio)) {
            return false;
        }
        return Objects.equals(this.fechaHoraFin, other.fechaHoraFin);
    }

    @Override
    public String toString() {
        return "Llamada con id: " + id
                + ", con número de origen: " + numeroOrigen
                + ", con número de destino: " + numeroDestino
                + ", iniciada en: " + fechaHoraInicio
                + " y finalizada en :" + fechaHoraFin + ".";
    }

}
