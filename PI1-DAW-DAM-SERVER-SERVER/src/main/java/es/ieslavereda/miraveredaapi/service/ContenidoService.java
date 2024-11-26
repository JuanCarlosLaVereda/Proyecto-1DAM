package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.ContenidoRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el contenido.
 */
@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    /**
     * Obtiene la lista de todos los contenidos disponibles.
     * @return La lista de contenidos disponibles.
     * @throws SQLException Si ocurre un error al obtener la lista de contenidos.
     */
    public List<Contenido> getContenido() throws SQLException{
        return contenidoRepository.getContenidos();
    }

    /**
     * Obtiene el precio de un contenido por su identificador.
     * @param id El identificador del contenido.
     * @return El precio del contenido especificado.
     * @throws SQLException Si ocurre un error al obtener el precio del contenido.
     */
    public float getPrecio(int id) throws SQLException{
        return contenidoRepository.getPrecio(id);
    }

    /**
     * Actualiza la puntuación de un contenido por su identificador.
     * @param id El identificador del contenido.
     * @param tag El identificador del usuario que realiza la valoración.
     * @param punt La nueva puntuación a asignar al contenido.
     * @return El número de filas afectadas por la operación de actualización.
     * @throws SQLException Si ocurre un error al actualizar la puntuación del contenido.
     */
    public int updatePuntuacionById(int id, String tag, float punt) throws  SQLException{
        return contenidoRepository.updatePuntuacionById(id, tag, punt);
    }

    /**
     * Elimina un contenido por su identificador y tipo.
     * @param id El identificador del contenido a eliminar.
     * @param tipo El tipo de contenido a eliminar (por ejemplo, "pelicula", "serie", etc.).
     * @return El número de filas afectadas por la operación de eliminación.
     * @throws SQLException Si ocurre un error al eliminar el contenido.
     */
    public int deleteContenido(int id, String tipo) throws SQLException{
        return contenidoRepository.deleteContenido(id, tipo);
    }

    /**
     * Añade una nueva puntuación a un contenido por su identificador.
     * @param id El identificador del contenido.
     * @param tag El identificador del usuario que realiza la valoración.
     * @param punt La puntuación a añadir al contenido.
     * @return La nueva puntuación total del contenido después de la adición.
     * @throws SQLException Si ocurre un error al añadir la puntuación al contenido.
     */
    public float anyadirPuntuacion(int id, String tag, float punt) throws SQLException{
        return contenidoRepository.anyadirPuntuacion(id,tag,punt);
    }

    /**
     * Obtiene el contenido asociado a una línea de factura por su identificador.
     * @param id El identificador de la línea de factura.
     * @return El contenido asociado a la línea de factura especificada.
     * @throws SQLException Si ocurre un error al obtener el contenido.
     */
    public Contenido getContenidoByIdLinea(int id) throws SQLException{
        return contenidoRepository.getContenidoByIdLineaFactura(id);
    }
}

