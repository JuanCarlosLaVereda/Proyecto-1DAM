package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de los capítulos en la base de datos.
 */
public interface ICapituloRepository {
    /**
     * Obtiene un capítulo por su ID.
     *
     * @param id El ID del capítulo.
     * @return El capítulo correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Contenido getCapituloById(int id) throws SQLException;

    /**
     * Obtiene una lista de capítulos por el ID de la serie a la que pertenecen.
     *
     * @param id El ID de la serie.
     * @return Una lista de capítulos de la serie especificada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Capitulo> getCapitulosBySerie(int id) throws SQLException;

    /**
     * Agrega un nuevo capítulo a la base de datos.
     *
     * @param capitulo El capítulo a agregar.
     * @return El capítulo agregado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException;

    /**
     * Actualiza la información de un capítulo en la base de datos.
     *
     * @param capitulo El capítulo con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int updateCapitulo(Capitulo capitulo) throws SQLException;

    /**
     * Obtiene una lista de capítulos alquilados por un usuario específico.
     *
     * @param tag El ID del usuario.
     * @return Una lista de capítulos alquilados por el usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Capitulo> getCapitulosAlquilados(String tag) throws SQLException;
}
