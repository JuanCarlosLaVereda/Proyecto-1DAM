package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Factura;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de facturas en la base de datos.
 */
public interface IFacturaRepository {

   /**
    * Obtiene una lista de todas las facturas.
    *
    * @return Lista de todas las facturas almacenadas en la base de datos.
    * @throws SQLException Si ocurre algún error al acceder a la base de datos.
    */
   public List<Factura> getFacturas() throws SQLException;

   /**
    * Obtiene una factura por su ID.
    *
    * @param id El ID de la factura.
    * @return La factura correspondiente al ID especificado.
    * @throws SQLException Si ocurre algún error al acceder a la base de datos.
    */
   public Factura getFacturaById(int id) throws SQLException;

   /**
    * Obtiene una factura por el ID de usuario.
    *
    * @param tag El ID del usuario.
    * @return La factura correspondiente al ID de usuario especificado.
    * @throws SQLException Si ocurre algún error al acceder a la base de datos.
    */
   public Factura getFacturaByUsuarioId(String tag) throws SQLException;

   /**
    * Agrega una nueva factura a la base de datos.
    *
    * @param factura La factura a agregar.
    * @return La factura agregada.
    * @throws SQLException Si ocurre algún error al acceder a la base de datos.
    */
   public Factura addFactura(Factura factura) throws SQLException;

   /**
    * Finaliza un pedido y genera la factura correspondiente para un usuario.
    *
    * @param tag El ID del usuario para el cual se finaliza el pedido.
    * @return La factura generada para el pedido del usuario especificado.
    * @throws SQLException Si ocurre algún error al acceder a la base de datos.
    */
   public Factura finalizarPedido(String tag) throws SQLException;

}
