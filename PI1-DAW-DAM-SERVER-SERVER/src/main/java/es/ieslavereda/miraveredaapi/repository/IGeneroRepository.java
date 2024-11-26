package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Genero;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de género en la base de datos.
 */
public interface IGeneroRepository {

    /**
     * Obtiene una lista de todos los géneros.
     *
     * @return Lista de todos los géneros almacenados en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Genero> getGeneros() throws SQLException;

    /**
     * Obtiene un género por su ID.
     *
     * @param id El ID del género.
     * @return El género correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Genero getGeneroById(int id) throws SQLException;
}
