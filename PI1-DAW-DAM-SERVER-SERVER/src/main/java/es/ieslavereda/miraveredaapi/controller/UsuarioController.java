package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import es.ieslavereda.miraveredaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión de usuarios.
 * Este controlador maneja las solicitudes relacionadas con los usuarios de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; // Servicio para la gestión de usuarios

    /**
     * Obtiene la lista de usuarios.
     *
     * @return Una ResponseEntity que contiene la lista de usuarios si la operación es exitosa, o un código de error si ocurre una excepción SQL.
     */
    @GetMapping("/")
    public ResponseEntity<?> getUsuarios() {
        try {
            return new ResponseEntity<>(usuarioService.getUsuarios(), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Elimina un usuario por su tag.
     *
     * @param tag El tag del usuario a eliminar.
     * @return Una ResponseEntity que contiene un mensaje de éxito si el usuario se elimina correctamente, o un mensaje de error si el usuario no se encuentra.
     */
    @DeleteMapping("/delete/{tag}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("tag") String tag) {
        try {
            int resultado = usuarioService.deleteUsuario(tag);
            if (resultado < 0) {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(resultado);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario El objeto Usuario con los datos actualizados.
     * @return Una ResponseEntity que contiene un mensaje de éxito si el usuario se actualiza correctamente, o un mensaje de error si el usuario no se encuentra.
     */
    @PutMapping("/update")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        try {
            int resultado = usuarioService.actualizarUsuario(usuario);
            if (resultado < 1) {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(resultado);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Obtiene un usuario por su tag.
     *
     * @param tag El tag del usuario a obtener.
     * @return Una ResponseEntity que contiene el usuario si se encuentra, o un mensaje de error si el usuario no se encuentra.
     */
    @GetMapping("/{tag}")
    public ResponseEntity<?> getUsuarioByTag(@PathVariable("tag") String tag) {
        try {
            Usuario usuario = usuarioService.getUsuarioByTag(tag);
            if (usuario == null) {
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Autentica un usuario por su login y contraseña.
     *
     * @param login    El login del usuario.
     * @param password La contraseña del usuario.
     * @return Una ResponseEntity que contiene el usuario autenticado si es válido, o un mensaje de error si la autenticación falla.
     */
    @GetMapping("/login/&user={tag}&password={pass}")
    public ResponseEntity<?> authenticateUsuario(@PathVariable("tag") String login, @PathVariable("pass") String password) {
        try {
            return new ResponseEntity<>(usuarioService.authenticateUsuario(login, password), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Agrega un nuevo usuario.
     *
     * @param usuario El objeto Usuario a agregar.
     * @return Una ResponseEntity que contiene el usuario agregado si la operación es exitosa, o un mensaje de error si ocurre una excepción SQL.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(usuarioService.addUsuario(usuario));
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Cambia la contraseña de un usuario.
     *
     * @param tag  El tag del usuario cuya contraseña se cambiará.
     * @param pass La nueva contraseña.
     * @return Una ResponseEntity que contiene un mensaje de éxito si la contraseña se cambia correctamente, o un mensaje de error si ocurre una excepción SQL.
     */
    @PutMapping("/changePassword/&tag={tag}&pass={pass}")
    public ResponseEntity<?> changePassword(@PathVariable("tag") String tag, @PathVariable("pass") String pass) {
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(usuarioService.changePassword(tag, pass));
        } catch (SQLException e) {
            return Response.response(e);
        }
    }
}
