package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Factura;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IFacturaRepository y proporciona acceso a los datos de factura en la base de datos.
 */
@Repository
public class FacturaRepository implements IFacturaRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    /**
     * Obtiene todas las facturas almacenadas en la base de datos.
     *
     * @return Una lista de todas las facturas almacenadas en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Factura> getFacturas() throws SQLException {
        String query = "SELECT * FROM FACTURA";
        List<Factura> facturas = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                facturas.add(Factura.builder().numero(rs.getInt(1))
                        .fecha(rs.getDate(2))
                        .importe_base(rs.getDouble(3))
                        .importe_IVA(rs.getDouble(4))
                        .idUsuario(rs.getString(5)).build());
            }

        }
        return facturas;
    }

    /**
     * Obtiene una factura por su ID.
     *
     * @param id El ID de la factura.
     * @return La factura correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Factura getFacturaById(int id) throws SQLException {
        String query = "SELECT * FROM FACTURA WHERE NUMERO = ?";
        Factura factura = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            factura = Factura.builder().numero(rs.getInt(1))
                    .fecha(rs.getDate(2))
                    .importe_base(rs.getDouble(3))
                    .importe_IVA(rs.getDouble(4))
                    .idUsuario(rs.getString(5)).build();

        }
        return factura;
    }

    /**
     * Obtiene una factura por el ID de usuario.
     *
     * @param tag El ID de usuario.
     * @return La factura correspondiente al ID de usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Factura getFacturaByUsuarioId(String tag) throws SQLException {
        String query = "SELECT * FROM FACTURA WHERE ID_USUARIO = ?";
        Factura factura = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);

            ResultSet rs = ps.executeQuery();
            rs.next();
            factura = Factura.builder().numero(rs.getInt(1))
                    .fecha(rs.getDate(2))
                    .importe_base(rs.getDouble(3))
                    .importe_IVA(rs.getDouble(4))
                    .idUsuario(rs.getString(5)).build();
        }
        return factura;
    }

    /**
     * Agrega una nueva factura a la base de datos.
     *
     * @param factura La factura que se va a añadir.
     * @return La factura añadida.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Factura addFactura(Factura factura) throws SQLException {
        String query = "{call crear_factura(?)}";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, factura.getIdUsuario());

            if (cs.executeUpdate()<1){
                factura = null;
            }
        }
        return factura;
    }

    /**
     * Finaliza un pedido y obtiene la factura correspondiente al ID de usuario.
     *
     * @param tag El ID de usuario.
     * @return La factura correspondiente al ID de usuario especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Factura finalizarPedido(String tag) throws SQLException {
        String query = "{call finalizar_pedido(?)}";
        Factura factura = null;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, tag);
            cs.executeUpdate();
            factura = getFacturaByUsuarioId(tag);
        }
        return factura;
    }
}
