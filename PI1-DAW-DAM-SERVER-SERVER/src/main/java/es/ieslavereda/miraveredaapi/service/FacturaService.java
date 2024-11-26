package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.FacturaRepository;
import es.ieslavereda.miraveredaapi.repository.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con las facturas.
 */
@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    /**
     * Obtiene la lista de todas las facturas.
     * @return La lista de facturas.
     * @throws SQLException Si ocurre un error al obtener la lista de facturas.
     */
    public List<Factura> getFacturas() throws SQLException{
        return facturaRepository.getFacturas();
    }

    /**
     * Obtiene una factura por su identificador.
     * @param id El identificador de la factura.
     * @return La factura correspondiente al identificador especificado.
     * @throws SQLException Si ocurre un error al obtener la factura.
     */
    public Factura getFacturaById(int id) throws SQLException{
        return facturaRepository.getFacturaById(id);
    }

    /**
     * Obtiene la factura asociada a un usuario por su identificador.
     * @param tag El identificador del usuario.
     * @return La factura asociada al usuario especificado.
     * @throws SQLException Si ocurre un error al obtener la factura.
     */
    public Factura getFacturaByUsuarioId(String tag) throws SQLException{
        return facturaRepository.getFacturaByUsuarioId(tag);
    }

    /**
     * Agrega una nueva factura.
     * @param factura La factura a agregar.
     * @return La factura agregada.
     * @throws SQLException Si ocurre un error al agregar la factura.
     */
    public Factura addFactura(Factura factura) throws SQLException{
        return facturaRepository.addFactura(factura);
    }

    /**
     * Finaliza el pedido asociado a un usuario por su identificador.
     * @param tag El identificador del usuario.
     * @return La factura asociada al pedido finalizado.
     * @throws SQLException Si ocurre un error al finalizar el pedido.
     */
    public Factura finalizarPedido(String tag) throws SQLException{
        return facturaRepository.finalizarPedido(tag);
    }
}

