package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.PeliculaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con las películas.
 */
@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    /**
     * Obtiene todas las películas disponibles.
     * @return La lista de películas disponibles.
     * @throws SQLException Si ocurre un error al obtener las películas.
     */
    public List<Pelicula> getPeliculas() throws SQLException{
        return PeliculaRepository.getPeliculas();
    }

    /**
     * Obtiene una película por su identificador.
     * @param id El identificador de la película.
     * @return La película correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener la película.
     */
    public Pelicula getPeliculasById(int id) throws SQLException{
        return peliculaRepository.getPeliculaById(id);
    }

    /**
     * Añade una nueva película.
     * @param pelicula La película a añadir.
     * @return La película añadida.
     * @throws SQLException Si ocurre un error al añadir la película.
     */
    public Pelicula addPelicula(Pelicula pelicula) throws SQLException{
        return peliculaRepository.addPelicula(pelicula);
    }

    /**
     * Actualiza una película existente.
     * @param pelicula La película a actualizar.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre un error al actualizar la película.
     */
    public int updatePelicula(Pelicula pelicula) throws SQLException{
        return peliculaRepository.updatePelicula(pelicula);
    }

    /**
     * Obtiene todas las películas alquiladas por un usuario.
     * @param tag El identificador del usuario.
     * @return La lista de películas alquiladas por el usuario.
     * @throws SQLException Si ocurre un error al obtener las películas alquiladas.
     */
    public List<Pelicula> getPeliculasAlquiladas(String tag) throws SQLException{
        return peliculaRepository.getPeliculasAlquiladas(tag);
    }
}

