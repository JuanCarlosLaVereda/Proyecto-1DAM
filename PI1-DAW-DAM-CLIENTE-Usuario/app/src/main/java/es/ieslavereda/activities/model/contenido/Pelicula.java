package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.util.Date;

import es.ieslavereda.activities.model.Contenido;

/**
 * Clase que representa una película.
 * Extiende la clase Contenido e implementa la interfaz Serializable.
 */
public class Pelicula extends Contenido implements Serializable {
    /**
     * La fecha hasta la cual la película está disponible.
     */
    private Date disponible_hasta;

    /**
     * Constructor de la clase Pelicula.
     *
     * @param id              El ID de la película.
     * @param titulo          El título de la película.
     * @param descripcion     La descripción de la película.
     * @param URL_image       La URL de la imagen de la película.
     * @param actores         Los actores de la película.
     * @param puntMedia       La puntuación media de la película.
     * @param fechaEstreno    La fecha de estreno de la película.
     * @param duracion_minutos La duración en minutos de la película.
     * @param director        El director de la película.
     * @param idGenero        El ID del género al que pertenece la película.
     * @param idTarifa        El ID de la tarifa asociada a la película.
     * @param disponible_hasta La fecha hasta la cual la película está disponible.
     */
    public Pelicula(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, Date disponible_hasta) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.disponible_hasta = disponible_hasta;
    }

    /**
     * Obtiene la fecha hasta la cual la película está disponible.
     *
     * @return La fecha hasta la cual la película está disponible.
     */
    public Date getDisponible_hasta() {
        return disponible_hasta;
    }

    /**
     * Establece la fecha hasta la cual la película está disponible.
     *
     * @param disponible_hasta La fecha hasta la cual la película está disponible.
     */
    public void setDisponible_hasta(Date disponible_hasta) {
        this.disponible_hasta = disponible_hasta;
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación en cadena del objeto Pelicula.
     *
     * @return Una cadena que representa el objeto Pelicula.
     */
    @Override
    public String toString() {
        return "Pelicula{" +
                "disponible_hasta=" + disponible_hasta +
                '}';
    }
}
