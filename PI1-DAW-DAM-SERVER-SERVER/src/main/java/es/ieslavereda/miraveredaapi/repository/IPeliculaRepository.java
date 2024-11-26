package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Pelicula;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de película en la base de datos.
 */
public interface IPeliculaRepository {

    /**
     * Obtiene una película por su ID.
     *
     * @param id El ID de la película.
     * @return La película correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Pelicula getPeliculaById(int id) throws SQLException;

    /**
     * Agrega una nueva película a la base de datos.
     *
     * @param pelicula La película a agregar.
     * @return La película agregada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Pelicula addPelicula(Pelicula pelicula) throws SQLException;

    /**
     * Actualiza la información de una película en la base de datos.
     *
     * @param pelicula La película con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int updatePelicula(Pelicula pelicula) throws SQLException;

    /**
     * Obtiene una lista de todas las películas alquiladas por un usuario específico.
     *
     * @param tag El ID del usuario.
     * @return Lista de películas alquiladas por el usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Pelicula> getPeliculasAlquiladas(String tag) throws SQLException;
}
