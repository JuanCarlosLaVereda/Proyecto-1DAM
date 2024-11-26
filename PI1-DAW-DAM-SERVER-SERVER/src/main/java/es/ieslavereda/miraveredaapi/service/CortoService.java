package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CortoRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con los cortometrajes.
 */
@Service
public class CortoService {

    @Autowired
    CortoRepository cortoRepository;

    /**
     * Obtiene la lista de todos los cortometrajes.
     * @return La lista de cortometrajes.
     * @throws SQLException Si ocurre un error al obtener la lista de cortometrajes.
     */
    public List<Corto> getCortos() throws SQLException {
        return CortoRepository.getCortos();
    }

    /**
     * Obtiene un cortometraje por su identificador.
     * @param id El identificador del cortometraje.
     * @return El cortometraje correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener el cortometraje.
     */
    public Corto getCortoById(int id) throws SQLException {
        return cortoRepository.getCortoById(id);
    }

    /**
     * Agrega un nuevo cortometraje.
     * @param corto El cortometraje a agregar.
     * @return El cortometraje agregado.
     * @throws SQLException Si ocurre un error al agregar el cortometraje.
     */
    public Corto addCorto(Corto corto) throws SQLException {
        return cortoRepository.addCorto(corto);
    }

    /**
     * Actualiza un cortometraje existente.
     * @param corto El cortometraje a actualizar.
     * @return El número de filas afectadas por la operación de actualización.
     * @throws SQLException Si ocurre un error al actualizar el cortometraje.
     */
    public int updateCorto(Corto corto) throws SQLException{
        return cortoRepository.updateCorto(corto);
    }

    /**
     * Obtiene la lista de cortometrajes alquilados por un usuario.
     * @param tag El identificador del usuario.
     * @return La lista de cortometrajes alquilados por el usuario especificado.
     * @throws SQLException Si ocurre un error al obtener la lista de cortometrajes alquilados.
     */
    public List<Corto> getCortosAlquilados(String tag) throws SQLException{
        return cortoRepository.getCortosAlquilados(tag);
    }
}

