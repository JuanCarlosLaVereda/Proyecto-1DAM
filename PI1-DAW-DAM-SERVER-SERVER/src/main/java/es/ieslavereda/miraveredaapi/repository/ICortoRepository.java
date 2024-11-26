package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Corto;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de cortometrajes en la base de datos.
 */
public interface ICortoRepository {

    /**
     * Obtiene un cortometraje por su ID.
     *
     * @param id El ID del cortometraje.
     * @return El cortometraje correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Corto getCortoById(int id) throws SQLException;

    /**
     * Añade un nuevo cortometraje a la base de datos.
     *
     * @param corto El cortometraje a añadir.
     * @return El cortometraje añadido.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Corto addCorto(Corto corto) throws SQLException;

    /**
     * Actualiza un cortometraje existente en la base de datos.
     *
     * @param corto El cortometraje actualizado.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int updateCorto(Corto corto) throws SQLException;

    /**
     * Obtiene una lista de cortometrajes alquilados por un usuario específico.
     *
     * @param tag El ID del usuario.
     * @return Una lista de cortometrajes alquilados por el usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Corto> getCortosAlquilados(String tag) throws SQLException;
}
