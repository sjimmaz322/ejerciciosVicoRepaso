package ejerciciollamadas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author sajm
 */
public class Llamada {

    private String id, numeroOrigen, numeroDestino;
    private LocalDateTime fechaHoraInicio, fechaHoraFin;
    private long duracion;

    public Llamada() {
        String id = "";
        String numeroOrigen = "";
        String numeroDestino = "";
        LocalDateTime fechaHoraInicio = LocalDateTime.now();
        LocalDateTime ferchaHoraFin = LocalDateTime.now();
        long duracion = 0L;

    }

    public Llamada(String id, String numeroOrigen, String numeroDestino, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, long duracion) {
        this.id = id;
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.duracion = duracion;

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

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.numeroOrigen);
        hash = 53 * hash + Objects.hashCode(this.numeroDestino);
        hash = 53 * hash + Objects.hashCode(this.fechaHoraInicio);
        hash = 53 * hash + Objects.hashCode(this.fechaHoraFin);
        hash = 53 * hash + (int) (this.duracion ^ (this.duracion >>> 32));
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
        if (this.duracion != other.duracion) {
            return false;
        }
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
                + " y finalizada en :" + fechaHoraFin
                + " con una duración de " + duracion + " segundos.";
    }

}
