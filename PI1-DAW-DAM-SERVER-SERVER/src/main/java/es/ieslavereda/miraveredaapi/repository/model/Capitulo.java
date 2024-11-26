package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa un capítulo de una serie.
 * Extiende la clase Contenido e incluye información específica de un capítulo, como el ID de la serie y la temporada.
 */
@Getter
@Setter
@ToString
public class Capitulo extends Contenido {

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
     * @param idGenero        El ID del género del capítulo.
     * @param idTarifa        El ID de la tarifa del capítulo.
     * @param idSerie         El ID de la serie a la que pertenece el capítulo.
     * @param temporada       La temporada a la que pertenece el capítulo.
     */
    public Capitulo(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa, int idSerie, int temporada) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
        this.idSerie = idSerie;
        this.temporada = temporada;
    }

    /**
     * Obtiene el tipo de contenido, en este caso, "Capitulo".
     *
     * @return El tipo de contenido.
     */
    public String getTipo(){
        return "Capitulo";
    }
}
