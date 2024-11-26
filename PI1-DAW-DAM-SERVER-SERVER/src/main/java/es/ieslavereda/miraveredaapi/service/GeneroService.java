package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.GeneroRepository;
import es.ieslavereda.miraveredaapi.repository.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con los géneros.
 */
@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    /**
     * Obtiene la lista de todos los géneros.
     * @return La lista de géneros.
     * @throws SQLException Si ocurre un error al obtener la lista de géneros.
     */
    public List<Genero> getGeneros() throws SQLException{
        return generoRepository.getGeneros();
    }

    /**
     * Obtiene un género por su identificador.
     * @param id El identificador del género.
     * @return El género correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener el género.
     */
    public Genero getGeneroById(int id) throws SQLException{
        return generoRepository.getGeneroById(id);
    }
}

