package es.ieslavereda.miraveredaapi.repository;

import es.ieslavereda.miraveredaapi.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define los métodos para acceder a los datos de usuario en la base de datos.
 */
public interface IUsuarioRepository {

    /**
     * Obtiene la lista de usuarios.
     *
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    public List<Usuario> getUsuarios() throws SQLException;

    /**
     * Elimina un usuario por su etiqueta.
     *
     * @param tag La etiqueta del usuario a eliminar.
     * @return El número de filas afectadas.
     * @throws SQLException Si ocurre un error al eliminar el usuario.
     */
    public int deleteUsuario(String tag) throws SQLException;

    /**
     * Actualiza la información de un usuario.
     *
     * @param usuario El usuario con la información actualizada.
     * @return El número de filas afectadas.
     * @throws SQLException Si ocurre un error al actualizar el usuario.
     */
    public int actualizarUsuario(Usuario usuario) throws SQLException;

    /**
     * Obtiene un usuario por su etiqueta.
     *
     * @param tag La etiqueta del usuario.
     * @return El usuario correspondiente a la etiqueta especificada.
     * @throws SQLException Si ocurre un error al obtener el usuario.
     */
    public Usuario getUsuarioByTag(String tag) throws SQLException;

    /**
     * Autentica un usuario con su nombre de usuario y contraseña.
     *
     * @param login    El nombre de usuario del usuario.
     * @param password La contraseña del usuario.
     * @return El usuario autenticado, o null si no se encuentra ninguna coincidencia.
     * @throws SQLException Si ocurre un error al autenticar al usuario.
     */
    public Usuario authenticateUsuario(String login, String password) throws SQLException;

    /**
     * Añade un nuevo usuario a la base de datos.
     *
     * @param usuario El usuario a añadir.
     * @return El número de filas afectadas.
     * @throws SQLException Si ocurre un error al añadir el usuario.
     */
    public Usuario addUsuario(Usuario usuario) throws SQLException;

    /**
     * Cambia la contraseña de un usuario.
     *
     * @param tag  La etiqueta del usuario cuya contraseña se cambiará.
     * @param pass La nueva contraseña.
     * @return El número de filas afectadas.
     * @throws SQLException Si ocurre un error al cambiar la contraseña.
     */
    public int changePassword(String tag, String pass) throws SQLException;
}
