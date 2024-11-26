package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Tarifa;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de tarifa en la base de datos.
 */
public interface ITarifaRepository {

    /**
     * Obtiene todas las tarifas disponibles.
     *
     * @return Una lista de todas las tarifas disponibles en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<Tarifa> getTarifas() throws SQLException;

    /**
     * Obtiene una tarifa por su ID.
     *
     * @param id El ID de la tarifa.
     * @return La tarifa correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public Tarifa getTarifaById(int id) throws SQLException;
}
