package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.OracleDataSourceDB;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import oracle.jdbc.datasource.impl.OracleDataSource;
import oracle.jdbc.proxy.annotation.Pre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para acceder a las películas en la base de datos.
 */
@Repository
public class PeliculaRepository implements IPeliculaRepository{

    /**
     * Fuente de datos para acceder a la base de datos Oracle.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;

    /**
     * Obtiene todas las películas de la base de datos.
     * @return Lista de películas.
     * @throws SQLException Si hay un error de SQL.
     */
    public static List<Pelicula> getPeliculas() throws SQLException{
        OracleDataSource dataSource = OracleDataSourceDB.getOracleDataSource();

        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "p.DISPONIBLE_HASTA FROM CONTENIDO c JOIN PELICULA p ON c.ID = p.ID_CONT";

        List<Pelicula> peliculas = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                peliculas.add(new Pelicula(rs.getInt(1),
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
                        rs.getDate(12)));
            }

        }
        return peliculas;
    }

    @Override
    public Pelicula getPeliculaById(int id) throws SQLException {
        String query = "SELECT c.ID AS ID_CONTENIDO, " +
                "c.TITULO, c.DESCRIPCION, c.URL_IMAGEN, " +
                "c.ACTORES, c.PUNT_MEDIA, c.FECH_ESTRENO, " +
                "c.DURACION, c.DIRECTOR, c.ID_GENERO, c.ID_TARIFA, " +
                "p.DISPONIBLE_HASTA FROM CONTENIDO c " +
                "JOIN PELICULA p ON c.ID = p.ID_CONT WHERE p.ID_CONT = ?";

        Pelicula pelicula = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                pelicula = new Pelicula(rs.getInt(1),
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
                        rs.getDate(12));
            }
        }
        return pelicula;
    }

    /**
     * Añade una nueva película a la base de datos.
     * @param pelicula La película que se va a añadir.
     * @return La película añadida si la inserción fue exitosa, de lo contrario null.
     * @throws SQLException Si hay un error de SQL.
     */
    @Override
    public Pelicula addPelicula(Pelicula pelicula) throws SQLException {
        String query = "{call crear_pelicula(?,?,?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){

            cs.setString(1, pelicula.getTitulo());
            cs.setString(2, pelicula.getDescripcion());
            cs.setString(3, pelicula.getURL_image());
            cs.setString(4, pelicula.getActores());
            cs.setFloat(5, pelicula.getPuntMedia());
            cs.setDate(6, pelicula.getFechaEstreno());
            cs.setFloat(7, pelicula.getDuracion_minutos());
            cs.setString(8, pelicula.getDirector());
            cs.setInt(9, pelicula.getIdGenero());
            cs.setInt(10, pelicula.getIdTarifa());
            cs.setDate(11, pelicula.getDisponible_hasta());

            if (cs.executeUpdate()<1){
                pelicula = null;
            }
        }
        return pelicula;
    }

    /**
     * Actualiza una película en la base de datos.
     * @param pelicula La película actualizada.
     * @return El número de filas actualizadas en la base de datos.
     * @throws SQLException Si hay un error de SQL.
     */
    @Override
    public int updatePelicula(Pelicula pelicula) throws SQLException {
        String query = "{?= call actualizar_pelicula(?,?,?,?,?,?,?,?,?,?,?,?)}";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, pelicula.getId());
            cs.setDate(3, pelicula.getDisponible_hasta());
            cs.setString(4, pelicula.getTitulo());
            cs.setString(5, pelicula.getDescripcion());
            cs.setString(6, pelicula.getURL_image());
            cs.setString(7, pelicula.getActores());
            cs.setFloat(8, pelicula.getPuntMedia());
            cs.setDate(9, pelicula.getFechaEstreno());
            cs.setFloat(10, pelicula.getDuracion_minutos());
            cs.setString(11, pelicula.getDirector());
            cs.setInt(12, pelicula.getIdGenero());
            cs.setInt(13, pelicula.getIdTarifa());

            resultado = cs.executeUpdate();
        }
        return resultado;
    }

    /**
     * Obtiene todas las películas alquiladas por un usuario.
     * @param tag El identificador del usuario.
     * @return Lista de películas alquiladas por el usuario.
     * @throws SQLException Si hay un error de SQL.
     */
    @Override
    public List<Pelicula> getPeliculasAlquiladas(String tag) throws SQLException {
        String query = "SELECT C.ID,C.TITULO,C.DESCRIPCION," +
                "C.URL_IMAGEN,C.ACTORES,C.PUNT_MEDIA,FECH_ESTRENO," +
                "C.DURACION,C.DIRECTOR,C.ID_GENERO,C.ID_TARIFA," +
                "P.DISPONIBLE_HASTA FROM (CONTENIDO C JOIN PELICULA P ON C.ID = P.ID_CONT) " +
                "JOIN ALQUILA A ON C.ID = A.ID_CONTENIDO WHERE ? = A.ID_USUARIO";
        List<Pelicula> peliculas = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                peliculas.add(new Pelicula(rs.getInt(1),
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
                        rs.getDate(12)));
            }
        }
        return peliculas;
    }


}
