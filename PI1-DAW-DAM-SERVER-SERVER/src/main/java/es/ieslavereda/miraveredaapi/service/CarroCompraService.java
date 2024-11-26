package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.CarroCompraRepository;
import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con el carro de compra.
 */
@Service
public class CarroCompraService {

    @Autowired
    private CarroCompraRepository carroCompraRepository;

    /**
     * Obtiene el carro de compra por su identificador.
     * @param id El identificador del carro de compra.
     * @return El carro de compra correspondiente al identificador dado.
     * @throws SQLException Si ocurre un error al obtener el carro de compra.
     */
    public CarroCompra getCarroCompraById(int id) throws SQLException{
        return carroCompraRepository.getCarroCompraById(id);
    }

    /**
     * Obtiene el carro de compra asociado a un usuario por su identificador de usuario.
     * @param tag El identificador del usuario.
     * @return El carro de compra asociado al usuario especificado.
     * @throws SQLException Si ocurre un error al obtener el carro de compra.
     */
    public CarroCompra getCarroCompraByUsuarioId(String tag) throws SQLException{
        return carroCompraRepository.getCarroCompraByUsuarioId(tag);
    }

    /**
     * Añade una línea de factura al carro de compra de un usuario.
     * @param tag El identificador del usuario.
     * @param id El identificador de la línea de factura.
     * @return El carro de compra actualizado con la línea de factura añadida.
     * @throws SQLException Si ocurre un error al añadir la línea de factura al carro de compra.
     */
    public CarroCompra addLineaFactura(String tag, int id) throws SQLException{
        return carroCompraRepository.addLineaFactura(tag, id);
    }
}

