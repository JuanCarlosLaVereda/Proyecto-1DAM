package es.ieslavereda.activities.model;

import java.util.Date;

/**
 * Clase abstracta que representa el contenido general.
 * Puede ser extendida para crear diferentes tipos de contenido, como películas o capítulos de series.
 */
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
    private String url_image;

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
     * La fecha de la última modificación del contenido.
     */

    /**
     * Constructor de la clase Contenido.
     *
     * @param id               El ID del contenido.
     * @param titulo           El título del contenido.
     * @param descripcion      La descripción del contenido.
     * @param URL_image        La URL de la imagen asociada con el contenido.
     * @param actores          Los actores que participan en el contenido.
     * @param puntMedia        La puntuación media del contenido.
     * @param fechaEstreno     La fecha de estreno del contenido.
     * @param duracion_minutos La duración del contenido en minutos.
     * @param director         El director del contenido.
     * @param idGenero         El ID del género al que pertenece el contenido.
     * @param idTarifa         El ID de la tarifa asociada con el contenido.
     */
    public Contenido(int id, String titulo, String descripcion, String URL_image, String actores, float puntMedia, Date fechaEstreno, float duracion_minutos, String director, int idGenero, int idTarifa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_image = URL_image;
        this.actores = actores;
        this.puntMedia = puntMedia;
        this.fechaEstreno = fechaEstreno;
        this.duracion_minutos = duracion_minutos;
        this.director = director;
        this.idGenero = idGenero;
        this.idTarifa = idTarifa;
    }

    /**
     * Obtiene el ID del contenido.
     *
     * @return El ID del contenido.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el título del contenido.
     *
     * @return El título del contenido.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la descripción del contenido.
     *
     * @return La descripción del contenido.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la URL de la imagen asociada con el contenido.
     *
     * @return La URL de la imagen asociada con el contenido.
     */
    public String getUrl_image() {
        return url_image;
    }

    /**
     * Obtiene los actores que participan en el contenido.
     *
     * @return Los actores que participan en el contenido.
     */
    public String getActores() {
        return actores;
    }

    /**
     * Obtiene la puntuación media del contenido.
     *
     * @return La puntuación media del contenido.
     */
    public float getPuntMedia() {
        return puntMedia;
    }

    /**
     * Obtiene la fecha de estreno del contenido.
     *
     * @return La fecha de estreno del contenido.
     */
    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Obtiene la duración del contenido en minutos.
     *
     * @return La duración del contenido en minutos.
     */
    public float getDuracion_minutos() {
        return duracion_minutos;
    }

    /**
     * Obtiene el director del contenido.
     *
     * @return El director del contenido.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Obtiene el ID del género al que pertenece el contenido.
     *
     * @return El ID del género al que pertenece el contenido.
     */
    public int getIdGenero() {
        return idGenero;
    }

    /**
     * Obtiene el ID de la tarifa asociada con el contenido.
     *
     * @return El ID de la tarifa asociada con el contenido.
     */
    public int getIdTarifa() {
        return idTarifa;
    }

    /**
     * Establece el ID del contenido.
     *
     * @param id El nuevo ID del contenido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el título del contenido.
     *
     * @param titulo El nuevo título del contenido.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Establece la descripción del contenido.
     *
     * @param descripcion La nueva descripción del contenido.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la URL de la imagen asociada con el contenido.
     *
     * @param url_image La nueva URL de la imagen asociada con el contenido.
     */
    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    /**
     * Establece los actores que participan en el contenido.
     *
     * @param actores Los nuevos actores que participan en el contenido.
     */
    public void setActores(String actores) {
        this.actores = actores;
    }

    /**
     * Establece la puntuación media del contenido.
     *
     * @param puntMedia La nueva puntuación media del contenido.
     */
    public void setPuntMedia(float puntMedia) {
        this.puntMedia = puntMedia;
    }

    /**
     * Establece la fecha de estreno del contenido.
     *
     * @param fechaEstreno La nueva fecha de estreno del contenido.
     */
    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Establece la duración del contenido en minutos.
     *
     * @param duracion_minutos La nueva duración del contenido en minutos.
     */
    public void setDuracion_minutos(float duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    /**
     * Establece el director del contenido.
     *
     * @param director El nuevo director del contenido.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Establece el ID del género al que pertenece el contenido.
     *
     * @param idGenero El nuevo ID del género al que pertenece el contenido.
     */
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    /**
     * Establece el ID de la tarifa asociada con el contenido.
     *
     * @param idTarifa El nuevo ID de la tarifa asociada con el contenido.
     */
    public void setIdTarifa(int idTarifa) {
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

}

