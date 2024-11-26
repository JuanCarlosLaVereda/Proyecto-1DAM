package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa una película.
 * Extiende la clase Contenido e incluye información específica de una película, como la fecha hasta la cual está disponible.
 */
@Getter
@Setter
@ToString
public class Pelicula extends Contenido {

    /**
     * La fecha hasta la cual la película está disponible.
     */
    private Date disponible_hasta;

    /**
     * Constructor de la clase Pelicula.
     * @param id El ID de la película.
     * @param titulo El título de la película.
     * @param descripcion La descripción de la película.
     * @param URL_image La URL de la imagen asociada a la película.
     * @param actores Los actores que participan en la película.
     * @param puntMedia La puntuación media de la película.
     * @param fechaEstreno La fecha de estreno de la película.
     * @param duracion_minutos La duración de la película en minutos.
     * @param director El director de la película.
     * @param idGenero El ID del género al que pertenece la película.
     * @param idTarifa El ID de la tarifa asociada a la película.
     * @param disponible_hasta La fecha hasta la cual la película está disponible.
     */
    public Pelicula(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, Date disponible_hasta) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.disponible_hasta = disponible_hasta;
    }

    /**
     * Obtiene el tipo de contenido.
     * @return El tipo de contenido, que en este caso es "Pelicula".
     */
    public String getTipo(){
        return "Pelicula";
    }
}
