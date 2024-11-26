package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de contenido en la base de datos.
 */
public interface IContenidoRepository {

    /**
     * Obtiene todos los contenidos almacenados en la base de datos.
     *
     * @return Una lista de todos los contenidos almacenados en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Contenido> getContenidos() throws SQLException;

    /**
     * Obtiene el precio de un contenido por su ID.
     *
     * @param id El ID del contenido.
     * @return El precio del contenido especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public float getPrecio(int id) throws SQLException;

    /**
     * Actualiza la puntuación de un contenido por su ID.
     *
     * @param id El ID del contenido.
     * @param tag El ID del usuario.
     * @param punt La puntuación a añadir.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int updatePuntuacionById(int id, String tag, float punt) throws SQLException;

    /**
     * Elimina un contenido por su ID y tipo.
     *
     * @param id El ID del contenido.
     * @param tipo El tipo de contenido.
     * @return El número de filas afectadas por la eliminación.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public int deleteContenido(int id, String tipo) throws SQLException;

    /**
     * Añade una puntuación a un contenido por su ID y usuario.
     *
     * @param id El ID del contenido.
     * @param tag El ID del usuario.
     * @param punt La puntuación a añadir.
     * @return La puntuación total del contenido después de añadir la nueva puntuación.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public float anyadirPuntuacion(int id, String tag, float punt) throws SQLException;

    /**
     * Obtiene un contenido por el ID de una línea de factura.
     *
     * @param id El ID de la línea de factura.
     * @return El contenido asociado a la línea de factura especificada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Contenido getContenidoByIdLineaFactura(int id) throws SQLException;
}
