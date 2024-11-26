package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.LineaFacturaRepository;
import es.ieslavereda.miraveredaapi.repository.model.LineaFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con las líneas de factura.
 */
@Service
public class LineaFacturaService {

    @Autowired
    private LineaFacturaRepository lineaFacturaRepository;

    /**
     * Obtiene las líneas de factura asociadas a un determinado identificador de factura.
     * @param id El identificador de la factura.
     * @return La lista de líneas de factura asociadas al identificador de factura especificado.
     * @throws SQLException Si ocurre un error al obtener las líneas de factura.
     */
    public List<LineaFactura> getLineaFacturasByIdFactura(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturasByIdFactura(id);
    }

    /**
     * Obtiene una línea de factura por su identificador.
     * @param id El identificador de la línea de factura.
     * @return La línea de factura correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener la línea de factura.
     */
    public LineaFactura getLineaFacturaById(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturaById(id);
    }

    /**
     * Obtiene las líneas de factura asociadas a un determinado identificador de carro de compra.
     * @param id El identificador del carro de compra.
     * @return La lista de líneas de factura asociadas al identificador del carro de compra especificado.
     * @throws SQLException Si ocurre un error al obtener las líneas de factura.
     */
    public List<LineaFactura> getLineaFacturasByIdCarro(int id) throws SQLException{
        return lineaFacturaRepository.getLineaFacturasByIdCarro(id);
    }

    /**
     * Elimina una línea de factura por su identificador.
     * @param id El identificador de la línea de factura a eliminar.
     * @return La línea de factura eliminada.
     * @throws SQLException Si ocurre un error al eliminar la línea de factura.
     */
    public LineaFactura deleteLineafacturaById(int id) throws SQLException{
        return lineaFacturaRepository.deleteLineaFactura(id);
    }
}

