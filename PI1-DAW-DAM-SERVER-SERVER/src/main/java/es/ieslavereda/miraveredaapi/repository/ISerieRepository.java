package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Serie;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de serie en la base de datos.
 */
public interface ISerieRepository {

    /**
     * Obtiene una serie por su ID.
     *
     * @param id El ID de la serie.
     * @return La serie correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Serie getSerieById(int id) throws SQLException;

    /**
     * Obtiene una lista de todas las series en la base de datos.
     *
     * @return Lista de todas las series.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Serie> getSeries() throws SQLException;

    /**
     * Agrega una nueva serie a la base de datos.
     *
     * @param serie La serie a agregar.
     * @return La serie agregada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Serie addSerie(Serie serie) throws SQLException;

    /**
     * Actualiza la información de una serie en la base de datos.
     *
     * @param serie La serie con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int updateSerie(Serie serie) throws SQLException;

    /**
     * Elimina una serie de la base de datos por su ID.
     *
     * @param id El ID de la serie a eliminar.
     * @return El número de filas afectadas por la eliminación.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int deleteSerie(int id) throws SQLException;
}
