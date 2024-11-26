package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.sql.Date;

import es.ieslavereda.activities.model.Contenido;

/**
 * Clase que representa un capítulo de una serie.
 * Extiende la clase Contenido e implementa la interfaz Serializable.
 */
public class Capitulo extends Contenido implements Serializable {
    /**
     * El ID de la serie a la que pertenece el capítulo.
     */
    private int idSerie;

    /**
     * La temporada a la que pertenece el capítulo.
     */
    private int temporada;

    /**
     * Constructor de la clase Capitulo.
     *
     * @param id              El ID del capítulo.
     * @param titulo          El título del capítulo.
     * @param descripcion     La descripción del capítulo.
     * @param URL_image       La URL de la imagen del capítulo.
     * @param actores         Los actores del capítulo.
     * @param puntMedia       La puntuación media del capítulo.
     * @param fechaEstreno    La fecha de estreno del capítulo.
     * @param duracion_minutos La duración en minutos del capítulo.
     * @param director        El director del capítulo.
     * @param idGenero        El ID del género al que pertenece el capítulo.
     * @param idTarifa        El ID de la tarifa asociada al capítulo.
     */
    public Capitulo(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }

    /**
     * Obtiene la temporada a la que pertenece el capítulo.
     *
     * @return La temporada del capítulo.
     */
    public int getTemporada() {
        return temporada;
    }
}
