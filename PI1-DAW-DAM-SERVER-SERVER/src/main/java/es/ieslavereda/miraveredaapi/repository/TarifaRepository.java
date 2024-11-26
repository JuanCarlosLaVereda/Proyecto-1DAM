package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Tarifa;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz ITarifaRepository y proporciona acceso a los datos de tarifa en la base de datos.
 */
@Repository
public class TarifaRepository implements ITarifaRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    /**
     * Obtiene todas las tarifas de la base de datos.
     * @return Lista de todas las tarifas disponibles en la base de datos.
     * @throws SQLException Si hay un error de SQL.
     */
    @Override
    public List<Tarifa> getTarifas() throws SQLException {
        String query = "SELECT * FROM TARIFA";
        List<Tarifa> tarifas = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                tarifas.add(Tarifa.builder()
                        .codigo(rs.getInt(1))
                        .precio(rs.getFloat(2)).build());
            }
        }
        return tarifas;
    }

    /**
     * Obtiene una tarifa por su identificador.
     * @param id El identificador de la tarifa.
     * @return La tarifa con el identificador dado, o null si no se encuentra ninguna tarifa con ese identificador.
     * @throws SQLException Si hay un error de SQL.
     */
    @Override
    public Tarifa getTarifaById(int id) throws SQLException {
        String query = "SELECT * FROM WHERE ID = ?";
        Tarifa tarifa = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            tarifa = Tarifa.builder()
                    .codigo(rs.getInt(1))
                    .precio(rs.getFloat(2)).build();

        }
        return tarifa;
    }
}
