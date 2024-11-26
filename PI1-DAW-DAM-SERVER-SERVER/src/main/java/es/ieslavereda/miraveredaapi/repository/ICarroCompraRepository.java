package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;

import java.sql.SQLException;

/**
 * Interfaz que define los métodos para acceder a los datos del carro de compra en la base de datos.
 */
public interface ICarroCompraRepository {

    /**
     * Obtiene el carro de compra por su ID.
     *
     * @param id El ID del carro de compra.
     * @return El carro de compra correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public CarroCompra getCarroCompraById(int id) throws SQLException;

    /**
     * Obtiene el carro de compra por el ID del usuario.
     *
     * @param tag El ID del usuario.
     * @return El carro de compra correspondiente al usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public CarroCompra getCarroCompraByUsuarioId(String tag) throws SQLException;

    /**
     * Agrega una línea de factura al carro de compra.
     *
     * @param tag El ID del usuario.
     * @param id El ID de la línea de factura.
     * @return El carro de compra actualizado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public CarroCompra addLineaFactura(String tag, int id) throws SQLException;
}
