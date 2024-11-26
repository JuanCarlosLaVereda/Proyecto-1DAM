package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que implementa la interfaz IUsuarioRepository y proporciona acceso a los datos de usuario en la base de datos.
 */
@Repository
public class UsuarioRepository implements IUsuarioRepository{

    /**
     * Fuente de datos Oracle que se utilizará para acceder a la base de datos.
     */
    @Autowired
    @Qualifier("BBDD")
    private OracleDataSource dataSource;


    /**
     * Obtiene la lista de usuarios.
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    @Override
    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                usuarios.add(Usuario.builder()
                        .nombreUsuario(rs.getString(1))
                        .contrasenya(rs.getString(2))
                        .domicilio(rs.getString(3))
                        .CP(rs.getInt(4))
                        .email(rs.getString(5))
                        .fechaNacimiento(rs.getDate(6))
                        .nombre(rs.getString(7))
                        .apellido(rs.getString(8))
                        .num_tarjeta(rs.getInt(9))
                        .url_imagen(rs.getString(11)).build());
            }
        }
        return usuarios;
    }

    /**
     * Autentica un usuario basado en su nombre de usuario y contraseña.
     * @param login Nombre de usuario del usuario.
     * @param passwd Contraseña del usuario.
     * @return El usuario autenticado si las credenciales son válidas, de lo contrario null.
     * @throws SQLException Si ocurre un error durante la autenticación.
     */
    @Override
    public Usuario authenticateUsuario(String login, String passwd) throws SQLException{
        Usuario usuario = null;
        String query = "SELECT COUNT(*) FROM USUARIO WHERE TAG_USUARIO = ?" + " AND CONTRASENYA = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);){
            ps.setString(1, login);
            ps.setString(2, passwd);
            ResultSet resultSet = ps.executeQuery();

            resultSet.next();
            if (resultSet.getInt(1)>0){
                usuario = getUsuarioByTag(login);
                usuario.setContrasenya(null);
            }
        }
        return usuario;
    }

    /**
     * Añade un nuevo usuario a la base de datos.
     * @param usuario El usuario que se va a añadir.
     * @return El usuario añadido si la inserción fue exitosa, de lo contrario null.
     * @throws SQLException Si ocurre un error durante la inserción del usuario.
     */
    @Override
    public Usuario addUsuario(Usuario usuario) throws SQLException {
        String query = "{call crear_usuario(?,?,?,?,?,?,?,?,?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.setString(1, usuario.getNombreUsuario());
            cs.setString(2, usuario.getContrasenya());
            cs.setString(3, usuario.getDomicilio());
            cs.setInt(4, usuario.getCP());
            cs.setString(5, usuario.getEmail());
            cs.setDate(6, usuario.getFechaNacimiento());
            cs.setString(7, usuario.getNombre());
            cs.setString(8, usuario.getApellido());
            cs.setInt(9, usuario.getNum_tarjeta());

            if (cs.executeUpdate() < 1){
                usuario = null;
            }
        }
        return usuario;
    }
    @Override
    public int changePassword(String tag, String pass) throws SQLException {
        /**
         * Cambia la contraseña de un usuario.
         * @param tag El nombre de usuario del usuario cuya contraseña se va a cambiar.
         * @param pass La nueva contraseña.
         * @return El número de filas afectadas por el cambio de contraseña.
         * @throws SQLException Si hay un error al cambiar la contraseña.
         */
        String query = "SELECT COUNT(*) FROM USUARIO WHERE TAG_USUARIO = ?";
        int resultado = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);
            ResultSet rs = ps.executeQuery();

            rs.next();
            if (rs.getInt(1)>0){
                resultado = actualizarUsuario(Usuario.builder().nombreUsuario(tag).contrasenya(pass).build());
            }
        }
        return resultado;
    }

    @Override
    public int deleteUsuario(String tag) throws SQLException {
        /**
         * Elimina un usuario de la base de datos.
         * @param tag El nombre de usuario del usuario que se va a eliminar.
         * @return El resultado de la operación de eliminación.
         * @throws SQLException Si hay un error al eliminar el usuario.
         */
        int resultado = 0;
        String query = "{? = call eliminar_usuario(?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, tag);
            cs.execute();

            resultado = cs.getInt(1);
        }
        return resultado;
    }

    @Override
    public int actualizarUsuario(Usuario usuario) throws SQLException {
        /**
         * Actualiza la información de un usuario en la base de datos.
         * @param usuario El usuario con la información actualizada.
         * @return El número de filas afectadas por la actualización.
         * @throws SQLException Si hay un error al actualizar la información del usuario.
         */
        int resultado = 0;
        String query = "{?= call actualizar_usuario(?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
             CallableStatement cs = connection.prepareCall(query)){
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, usuario.getNombreUsuario());
            cs.setString(3, usuario.getContrasenya());
            cs.setString(4, usuario.getDomicilio());
            cs.setInt(5, usuario.getCP());
            cs.setString(6, usuario.getEmail());
            cs.setDate(7, usuario.getFechaNacimiento());
            cs.setString(8, usuario.getNombre());
            cs.setString(9, usuario.getApellido());
            cs.setInt(10, usuario.getNum_tarjeta());

            resultado = cs.executeUpdate();
        }
        return resultado;
    }

    @Override
    public Usuario getUsuarioByTag(String tag) throws SQLException {
        /**
         * Obtiene un usuario por su nombre de usuario.
         * @param tag El nombre de usuario del usuario que se va a buscar.
         * @return El usuario correspondiente al nombre de usuario dado.
         * @throws SQLException Si hay un error al obtener el usuario.
         */
        Usuario usuario = new Usuario();
        String query = "SELECT * FROM USUARIO WHERE TAG_USUARIO = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, tag);

            ResultSet rs = ps.executeQuery();
            rs.next();
            usuario.setNombreUsuario(rs.getString(1));
            usuario.setContrasenya(rs.getString(2));
            usuario.setDomicilio(rs.getString(3));
            usuario.setCP(rs.getInt(4));
            usuario.setEmail(rs.getString(5));
            usuario.setFechaNacimiento(rs.getDate(6));
            usuario.setNombre(rs.getString(7));
            usuario.setApellido(rs.getString(8));
            usuario.setNum_tarjeta(rs.getInt(9));
            usuario.setUrl_imagen(rs.getString(11));

        }
        return usuario;
    }



}
