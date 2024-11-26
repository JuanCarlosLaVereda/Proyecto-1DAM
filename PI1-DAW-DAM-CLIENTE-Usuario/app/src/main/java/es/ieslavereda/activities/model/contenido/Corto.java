package es.ieslavereda.activities.model.contenido;

import java.io.Serializable;
import java.util.Date;

import es.ieslavereda.activities.model.Contenido;

/**
 * Clase que representa un cortometraje.
 * Extiende la clase Contenido e implementa la interfaz Serializable.
 */
public class Corto extends Contenido implements Serializable {

    /**
     * Constructor de la clase Corto.
     *
     * @param id              El ID del cortometraje.
     * @param titulo          El título del cortometraje.
     * @param descripcion     La descripción del cortometraje.
     * @param URL_image       La URL de la imagen del cortometraje.
     * @param actores         Los actores del cortometraje.
     * @param puntMedia       La puntuación media del cortometraje.
     * @param fechaEstreno    La fecha de estreno del cortometraje.
     * @param duracion_minutos La duración en minutos del cortometraje.
     * @param director        El director del cortometraje.
     * @param idGenero        El ID del género al que pertenece el cortometraje.
     * @param idTarifa        El ID de la tarifa asociada al cortometraje.
     */
    public Corto(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        super(id, titulo, descripcion, URL_image, actores, puntMedia, fechaEstreno, duracion_minutos, director, idGenero, idTarifa);
    }

    /**
     * Sobrescribe el método toString para proporcionar una representación en cadena del objeto Corto.
     *
     * @return Una cadena que representa el objeto Corto.
     */
    @Override
    public String toString() {
        return "Corto{}";
    }
}
