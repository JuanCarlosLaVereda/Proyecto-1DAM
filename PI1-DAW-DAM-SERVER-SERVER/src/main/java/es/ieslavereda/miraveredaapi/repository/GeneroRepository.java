package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Genero;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IGeneroRepository y proporciona acceso a los datos de género en la base de datos.
 */
@Repository
public class GeneroRepository implements IGeneroRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    /**
     * Obtiene todos los géneros almacenados en la base de datos.
     *
     * @return Una lista de todos los géneros almacenados en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Genero> getGeneros() throws SQLException {
        String query = "SELECT * FROM GENERO";
        List<Genero> generos = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                generos.add(Genero.builder().id(rs.getInt(1))
                        .tipo(rs.getString(2)).build());
            }
        }
        return generos;
    }

    /**
     * Obtiene un género por su ID.
     *
     * @param id El ID del género.
     * @return El género correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Genero getGeneroById(int id) throws SQLException {
        String query = "SELECT * FROM GENERO WHERE ID = ?";
        Genero genero = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            genero.setId(rs.getInt(1));
            genero.setTipo(rs.getString(2));
        }
        return genero;
    }
}
