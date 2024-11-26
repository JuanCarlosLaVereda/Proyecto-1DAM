package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.TarifaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con las tarifas.
 */
@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    /**
     * Obtiene todas las tarifas disponibles.
     * @return La lista de tarifas disponibles.
     * @throws SQLException Si ocurre un error al obtener las tarifas.
     */
    public List<Tarifa> getTarifas() throws SQLException{
        return tarifaRepository.getTarifas();
    }

    /**
     * Obtiene una tarifa por su identificador.
     * @param id El identificador de la tarifa.
     * @return La tarifa correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener la tarifa.
     */
    public Tarifa getTarifaById(int id) throws SQLException{
        return tarifaRepository.getTarifaById(id);
    }
}

