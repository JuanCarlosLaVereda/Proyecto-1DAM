package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que proporciona acceso a los datos de cortometrajes en la base de datos.
 */
@Repository
public class CortoRepository implements ICortoRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    /**
     * Obtiene todos los cortometrajes de la base de datos.
     *
     * @return Una lista de cortometrajes.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public static List<Corto> getCortos() throws SQLException {
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, c.TITULO, c.DESCRIPCION, " +
                "c.URL_IMAGEN, c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA FROM CONTENIDO c " +
                "JOIN CORTO co ON c.ID = co.ID_CONT";

        List<Corto> cortos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                cortos.add(new Corto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        }
        return cortos;
    }

    /**
     * Obtiene un cortometraje por su ID.
     *
     * @param id El ID del cortometraje.
     * @return El cortometraje correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Corto getCortoById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "corto.ID_CONT FROM CONTENIDO c " +
                "JOIN CORTO corto ON c.ID = corto.ID_CONT WHERE corto.ID_CONT = ?";
        Corto corto = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                corto = new Corto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11));

            }

        }
        return corto;
    }

    /**
     * Añade un nuevo cortometraje a la base de datos.
     *
     * @param corto El cortometraje que se va a añadir.
     * @return El cortometraje añadido.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Corto addCorto(Corto corto) throws SQLException{
        String query = "{call crear_corto(?,?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            cs.setString(1, corto.getTitulo());
            cs.setString(2, corto.getDescripcion());
            cs.setString(3, corto.getURL_image());
            cs.setString(4, corto.getActores());
            cs.setFloat(5, corto.getPuntMedia());
            cs.setDate(6, corto.getFechaEstreno());
            cs.setFloat(7, corto.getDuracion_minutos());
            cs.setString(8, corto.getDirector());
            cs.setInt(9, corto.getIdGenero());
            cs.setInt(10, corto.getIdTarifa());

            if (cs.executeUpdate() < 1){
                corto = null;
            }

        }
        return corto;
    }

    /**
     * Actualiza la información de un cortometraje en la base de datos.
     *
     * @param corto El cortometraje con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public int updateCorto(Corto corto) throws SQLException {
        String query = "{?= call actualizar_corto(?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, corto.getId());
            cs.setString(3, corto.getTitulo());
            cs.setString(4, corto.getDescripcion());
            cs.setString(5, corto.getURL_image());
            cs.setString(6, corto.getActores());
            cs.setFloat(7, corto.getPuntMedia());
            cs.setDate(8 ,corto.getFechaEstreno());
            cs.setFloat(9, corto.getDuracion_minutos());
            cs.setString(10, corto.getDirector());
            cs.setInt(11, corto.getIdGenero());
            cs.setInt(12, corto.getIdTarifa());

            resultado = cs.executeUpdate();
        }
        return resultado;
    }

    /**
     * Obtiene los cortometrajes alquilados por un usuario.
     *
     * @param tag El ID del usuario.
     * @return Una lista de cortometrajes alquilados por el usuario.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Corto> getCortosAlquilados(String tag) throws SQLException {
        String query = "SELECT C.ID,C.TITULO,C.DESCRIPCION," +
                "C.URL_IMAGEN,C.ACTORES,C.PUNT_MEDIA,FECH_ESTRENO," +
                "C.DURACION,C.DIRECTOR,C.ID_GENERO,C.ID_TARIFA FROM (CONTENIDO " +
                "C JOIN CORTO CO ON CO.ID_CONT = C.ID) JOIN ALQUILA A " +
                "ON C.ID = A.ID_CONTENIDO WHERE ? = A.ID_USUARIO";
        List<Corto> cortos = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                cortos.add(new Corto(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11)));
            }
        }
        return cortos;
    }


}
