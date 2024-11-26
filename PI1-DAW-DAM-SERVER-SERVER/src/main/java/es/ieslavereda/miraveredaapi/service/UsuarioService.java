package es.ieslavereda.miraveredaapi.service;

import es.ieslavereda.miraveredaapi.repository.UsuarioRepository;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase de servicio que gestiona la lógica de negocio relacionada con los usuarios.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene la lista de usuarios.
     * @return La lista de usuarios.
     * @throws SQLException Si ocurre un error al obtener la lista de usuarios.
     */
    public List<Usuario> getUsuarios() throws SQLException {
        return usuarioRepository.getUsuarios();
    }

    /**
     * Elimina un usuario por su tag.
     * @param tag El tag del usuario a eliminar.
     * @return El número de filas afectadas por la eliminación.
     * @throws SQLException Si ocurre un error al eliminar el usuario.
     */
    public int deleteUsuario(String tag) throws SQLException {
        return usuarioRepository.deleteUsuario(tag);
    }

    /**
     * Actualiza la información de un usuario.
     * @param usuario El usuario con la información actualizada.
     * @return El número de filas afectadas por la actualización.
     * @throws SQLException Si ocurre un error al actualizar el usuario.
     */
    public int actualizarUsuario(Usuario usuario) throws SQLException{
        return usuarioRepository.actualizarUsuario(usuario);
    }

    /**
     * Obtiene un usuario por su tag.
     * @param tag El tag del usuario.
     * @return El usuario correspondiente al tag especificado.
     * @throws SQLException Si ocurre un error al obtener el usuario.
     */
    public Usuario getUsuarioByTag(String tag) throws SQLException {
        return usuarioRepository.getUsuarioByTag(tag);
    }

    /**
     * Autentica un usuario por su login y contraseña.
     * @param login El login del usuario.
     * @param password La contraseña del usuario.
     * @return El usuario autenticado.
     * @throws SQLException Si ocurre un error al autenticar el usuario.
     */
    public Usuario authenticateUsuario(String login, String password) throws SQLException{
        return usuarioRepository.authenticateUsuario(login, password);
    }

    /**
     * Agrega un nuevo usuario.
     * @param usuario El usuario a agregar.
     * @return El usuario agregado.
     * @throws SQLException Si ocurre un error al agregar el usuario.
     */
    public Usuario addUsuario(Usuario usuario) throws SQLException{
        return usuarioRepository.addUsuario(usuario);
    }

    /**
     * Cambia la contraseña de un usuario.
     * @param tag El tag del usuario.
     * @param pass La nueva contraseña.
     * @return El número de filas afectadas por el cambio de contraseña.
     * @throws SQLException Si ocurre un error al cambiar la contraseña.
     */
    public int changePassword(String tag, String pass) throws  SQLException{
        return usuarioRepository.changePassword(tag, pass);
    }
}

