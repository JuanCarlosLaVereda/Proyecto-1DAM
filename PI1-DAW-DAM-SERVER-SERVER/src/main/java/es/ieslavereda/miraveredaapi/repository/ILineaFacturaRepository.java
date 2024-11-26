package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de línea de factura en la base de datos.
 */
public interface ILineaFacturaRepository {

    /**
     * Obtiene una lista de todas las líneas de factura asociadas a una factura específica.
     *
     * @param id El ID de la factura.
     * @return Lista de líneas de factura asociadas a la factura especificada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<LineaFactura> getLineaFacturasByIdFactura(int id) throws SQLException;

    /**
     * Obtiene una línea de factura por su ID.
     *
     * @param id El ID de la línea de factura.
     * @return La línea de factura correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public LineaFactura getLineaFacturaById(int id) throws SQLException;

    /**
     * Obtiene una lista de todas las líneas de factura asociadas a un carro de compra específico.
     *
     * @param id El ID del carro de compra.
     * @return Lista de líneas de factura asociadas al carro de compra especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public List<LineaFactura> getLineaFacturasByIdCarro(int id) throws SQLException;

    /**
     * Elimina una línea de factura por su ID.
     *
     * @param id El ID de la línea de factura a eliminar.
     * @return La línea de factura eliminada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public LineaFactura deleteLineaFactura(int id) throws SQLException;
}
