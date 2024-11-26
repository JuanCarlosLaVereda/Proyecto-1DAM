package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.SerieRepository;
import es.ieslavereda.miraveredaapi.repository.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con las series.
 */
@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    /**
     * Obtiene todas las series disponibles.
     * @return La lista de series disponibles.
     * @throws SQLException Si ocurre un error al obtener las series.
     */
    public List<Serie> getSeries() throws SQLException{
        return serieRepository.getSeries();
    }

    /**
     * Obtiene una serie por su identificador.
     * @param id El identificador de la serie.
     * @return La serie correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener la serie.
     */
    public Serie getSerieById(int id) throws SQLException{
        return serieRepository.getSerieById(id);
    }

    /**
     * Añade una nueva serie.
     * @param serie La serie a añadir.
     * @return La serie añadida.
     * @throws SQLException Si ocurre un error al añadir la serie.
     */
    public Serie addSerie(Serie serie) throws SQLException{
        return serieRepository.addSerie(serie);
    }

    /**
     * Actualiza una serie existente.
     * @param serie La serie a actualizar.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre un error al actualizar la serie.
     */
    public int updateSerie(Serie serie) throws SQLException{
        return serieRepository.updateSerie(serie);
    }

    /**
     * Elimina una serie por su identificador.
     * @param id El identificador de la serie a eliminar.
     * @return El número de filas afectadas por la eliminación.
     * @throws SQLException Si ocurre un error al eliminar la serie.
     */
    public int deleteSerie(int id) throws SQLException{
        return serieRepository.deleteSerie(id);
    }
}

