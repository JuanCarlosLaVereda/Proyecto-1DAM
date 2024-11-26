package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase abstracta que representa el contenido general.
 * Puede ser extendida para crear diferentes tipos de contenido, como películas o capítulos de series.
 */
@Getter
@Setter
@ToString
public abstract class Contenido {

    /**
     * El ID del contenido.
     */
    private int id;

    /**
     * El título del contenido.
     */
    private String titulo;

    /**
     * La descripción del contenido.
     */
    private String descripcion;

    /**
     * La URL de la imagen asociada con el contenido.
     */
    private String URL_image;

    /**
     * Los actores que participan en el contenido.
     */
    private String actores;

    /**
     * La puntuación media del contenido.
     */
    private float puntMedia;

    /**
     * La fecha de estreno del contenido.
     */
    private Date fechaEstreno;

    /**
     * La duración del contenido en minutos.
     */
    private float duracion_minutos;

    /**
     * El director del contenido.
     */
    private String director;

    /**
     * El ID del género al que pertenece el contenido.
     */
    private int idGenero;

    /**
     * El ID de la tarifa asociada con el contenido.
     */
    private int idTarifa;

    /**
     * Constructor para inicializar un objeto Contenido con sus atributos.
     * @param id              El ID del contenido.
     * @param titulo          El título del contenido.
     * @param descripcion     La descripción del contenido.
     * @param URL_image       La URL de la imagen asociada con el contenido.
     * @param actores         Los actores que participan en el contenido.
     * @param puntMedia       La puntuación media del contenido.
     * @param fechaEstreno    La fecha de estreno del contenido.
     * @param duracion_minutos La duración del contenido en minutos.
     * @param director        El director del contenido.
     * @param idGenero        El ID del género al que pertenece el contenido.
     * @param idTarifa        El ID de la tarifa asociada con el contenido.
     */
    public Contenido(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.URL_image = URL_image;
        this.actores = actores;
        this.puntMedia = puntMedia;
        this.fechaEstreno = fechaEstreno;
        this.duracion_minutos = duracion_minutos;
        this.director = director;
        this.idGenero = idGenero;
        this.idTarifa = idTarifa;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Contenido)) {
            return false;
        }
        Contenido contenido = (Contenido) object;

        return id == contenido.getId();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Devuelve el tipo de contenido.
     * @return El tipo de contenido como una cadena de caracteres.
     */
    public abstract String getTipo();

}
