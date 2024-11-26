package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para la gestión de capítulos.
 * Proporciona métodos para acceder y manipular la información de los capítulos en la base de datos.
 */
@Repository
public class CapituloRepository implements ICapituloRepository{

    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    /**
     * Obtiene todos los capítulos almacenados en la base de datos.
     *
     * @return Una lista de objetos Capitulo que representan todos los capítulos almacenados en la base de datos.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    public static List<Capitulo> getCapitulos() throws SQLException {
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "cap.TEMPORADA, cap.ID_SERIE FROM CONTENIDO c " +
                "JOIN CAPITULO cap ON c.ID = cap.ID_CONT";

        List<Capitulo> capitulos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                capitulos.add(new Capitulo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }


        }
        return capitulos;
    }

    /**
     * Obtiene un capítulo por su ID.
     *
     * @param id El ID del capítulo.
     * @return El objeto Capitulo correspondiente al ID especificado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Capitulo getCapituloById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, c.TITULO, " +
                "c.DESCRIPCION, c.URL_IMAGEN, c.ACTORES, c.PUNT_MEDIA, " +
                "c.FECH_ESTRENO, c.DURACION, c.DIRECTOR, c.ID_GENERO, " +
                "c.ID_TARIFA, cap.TEMPORADA, cap.ID_SERIE FROM CONTENIDO c " +
                "JOIN CAPITULO cap ON c.ID = cap.ID_CONT WHERE cap.ID_CONT = ?";
        Capitulo capitulo = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                capitulo = new Capitulo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13));
            }

        }
        return capitulo;
    }

    /**
     * Obtiene todos los capítulos de una serie específica.
     *
     * @param id El ID de la serie.
     * @return Una lista de objetos Capitulo que representan los capítulos de la serie especificada.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Capitulo> getCapitulosBySerie(int id) throws SQLException {
        String query = "SELECT C.ID,C.TITULO,C.DESCRIPCION,C.URL_IMAGEN,C.ACTORES," +
                "C.PUNT_MEDIA,FECH_ESTRENO,C.DURACION,C.DIRECTOR,C.ID_GENERO,C.ID_TARIFA," +
                "CA.TEMPORADA,CA.ID_SERIE FROM CONTENIDO C JOIN CAPITULO " +
                "CA ON C.ID = CA.ID_CONT AND CA.ID_SERIE = ?";

        List<Capitulo> capitulos = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                capitulos.add(new Capitulo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }

        }
        return capitulos;

    }
    /**
     * Agrega un nuevo capítulo a la base de datos.
     *
     * @param capitulo El capítulo que se va a agregar.
     * @return El capítulo agregado.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public Capitulo addCapitulo(Capitulo capitulo) throws SQLException {
        String query = "{call crear_capitulo(?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            cs.setString(1, capitulo.getTitulo());
            cs.setString(2, capitulo.getDescripcion());
            cs.setString(3, capitulo.getURL_image());
            cs.setString(4, capitulo.getActores());
            cs.setFloat(5, capitulo.getPuntMedia());
            cs.setDate(6, capitulo.getFechaEstreno());
            cs.setFloat(7, capitulo.getDuracion_minutos());
            cs.setString(8, capitulo.getDirector());
            cs.setInt(9, capitulo.getIdGenero());
            cs.setInt(10, capitulo.getIdTarifa());
            cs.setInt(11, capitulo.getTemporada());
            cs.setInt(12, capitulo.getIdSerie());
            int resultado = cs.executeUpdate();
            if (resultado<1){
                return null;
            }
        }
        return capitulo;
    }

    /**
     * Actualiza un capítulo en la base de datos.
     *
     * @param capitulo El capítulo que se va a actualizar.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public int updateCapitulo(Capitulo capitulo) throws SQLException {
        String query = "{?= call  actualizar_capitulo(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);

            cs.setInt(2, capitulo.getId());
            cs.setInt(3, capitulo.getTemporada());
            cs.setInt(4, capitulo.getIdSerie());
            cs.setString(5, capitulo.getTitulo());
            cs.setString(6, capitulo.getDescripcion());
            cs.setString(7, capitulo.getURL_image());
            cs.setString(8, capitulo.getActores());
            cs.setFloat(9, capitulo.getPuntMedia());
            cs.setDate(10, capitulo.getFechaEstreno());
            cs.setFloat(11, capitulo.getDuracion_minutos());
            cs.setString(12, capitulo.getDirector());
            cs.setInt(13, capitulo.getIdGenero());
            cs.setInt(14, capitulo.getIdTarifa());

            resultado = cs.executeUpdate();

        }
        return resultado;
    }

    /**
     * Obtiene los capítulos alquilados por un usuario específico.
     *
     * @param tag El ID del usuario.
     * @return Una lista de capítulos alquilados por el usuario.
     * @throws SQLException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Capitulo> getCapitulosAlquilados(String tag) throws SQLException {
        String query = "SELECT C.ID,C.TITULO,C.DESCRIPCION," +
                "C.URL_IMAGEN,C.ACTORES,C.PUNT_MEDIA,FECH_ESTRENO," +
                "C.DURACION,C.DIRECTOR,C.ID_GENERO,C.ID_TARIFA,CA.TEMPORADA," +
                "CA.ID_SERIE FROM (CONTENIDO C JOIN CAPITULO CA ON C.ID = CA.ID_CONT) " +
                "JOIN ALQUILA A ON C.ID = A.ID_CONTENIDO WHERE ? = A.ID_USUARIO";
        List<Capitulo> capitulos = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                capitulos.add(new Capitulo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getDate(7),
                        rs.getFloat(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12),
                        rs.getInt(13)));
            }
        }
        return capitulos;
    }

}
