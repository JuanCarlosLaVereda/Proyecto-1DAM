package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa un cortometraje.
 * Extiende la clase Contenido e incluye información específica de un cortometraje.
 */
@Getter
@Setter
@ToString
public class Corto extends Contenido{

    /**
     * Constructor de la clase Corto.
     * @param id El ID del cortometraje.
     * @param titulo El título del cortometraje.
     * @param descripcion La descripción del cortometraje.
     * @param URL_image La URL de la imagen asociada al cortometraje.
     * @param actores Los actores que participan en el cortometraje.
     * @param puntMedia La puntuación media del cortometraje.
     * @param fechaEstreno La fecha de estreno del cortometraje.
     * @param duracion_minutos La duración del cortometraje en minutos.
     * @param director El director del cortometraje.
     * @param idGenero El ID del género al que pertenece el cortometraje.
     * @param idTarifa El ID de la tarifa asociada al cortometraje.
     */
    public Corto(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }

    /**
     * Obtiene el tipo de contenido.
     * @return El tipo de contenido, que en este caso es "Corto".
     */
    public String getTipo(){
        return "Corto";
    }
}
