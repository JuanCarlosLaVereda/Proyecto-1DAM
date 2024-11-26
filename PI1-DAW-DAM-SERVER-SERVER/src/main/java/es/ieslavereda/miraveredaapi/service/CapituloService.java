package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CapituloRepository;
import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
/**
 * Servicio que proporciona operaciones relacionadas con los capítulos de las series.
 */
@Service
public class CapituloService {

    @Autowired
    private CapituloRepository capituloRepository;

    /**
     * Obtiene todos los capítulos.
     * @return Una lista de todos los capítulos disponibles.
     * @throws SQLException Si ocurre un error al obtener los capítulos.
     */
    public List<Capitulo> getCapitulos() throws SQLException {
        return CapituloRepository.getCapitulos();
    }

    /**
     * Obtiene un capítulo por su identificador.
     * @param id El identificador del capítulo.
     * @return El capítulo correspondiente al identificador dado.
     * @throws SQLException Si ocurre un error al obtener el capítulo.
     */
    public Capitulo getCapituloByid(int id) throws SQLException {
        return capituloRepository.getCapituloById(id);
    }

    /**
     * Añade un nuevo capítulo.
     * @param capitulo El capítulo que se va a añadir.
     * @return El capítulo añadido.
     * @throws SQLException Si ocurre un error al añadir el capítulo.
     */
    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException{
        return capituloRepository.addCapitulo(capitulo);
    }

    /**
     * Obtiene todos los capítulos de una serie específica.
     * @param id El identificador de la serie.
     * @return Una lista de todos los capítulos de la serie especificada.
     * @throws SQLException Si ocurre un error al obtener los capítulos de la serie.
     */
    public List<Capitulo> getCapitulosBySerie(int id) throws SQLException{
        return capituloRepository.getCapitulosBySerie(id);
    }

    /**
     * Actualiza la información de un capítulo.
     * @param capitulo El capítulo con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre un error al actualizar el capítulo.
     */
    public int updateCapitulo(Capitulo capitulo) throws SQLException{
        return capituloRepository.updateCapitulo(capitulo);
    }

    /**
     * Obtiene todos los capítulos alquilados por un usuario.
     * @param tag El nombre de usuario del usuario que ha alquilado los capítulos.
     * @return Una lista de todos los capítulos alquilados por el usuario especificado.
     * @throws SQLException Si ocurre un error al obtener los capítulos alquilados.
     */
    public List<Capitulo> getCapitulosAlquilados(String tag) throws SQLException{
        return capituloRepository.getCapitulosAlquilados(tag);
    }

}

