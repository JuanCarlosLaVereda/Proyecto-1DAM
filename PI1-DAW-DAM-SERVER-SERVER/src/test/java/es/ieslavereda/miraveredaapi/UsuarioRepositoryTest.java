package es.ieslavereda.miraveredaapi;

import es.ieslavereda.miraveredaapi.repository.UsuarioRepository;
import es.ieslavereda.miraveredaapi.repository.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE ALIAS actualizar_usuario FOR \"es.ieslavereda.miraveredaapi.repository.UsuarioRepositoryTest.actualizarUsuarioAlias\";");
            statement.execute("CREATE TABLE USUARIO (" +
                    "NOMBRE_USUARIO VARCHAR(255) PRIMARY KEY," +
                    "NOMBRE VARCHAR(255)," +
                    "APELLIDO VARCHAR(255)," +
                    "EMAIL VARCHAR(255)," +
                    "CONTRASENYA VARCHAR(255)," +
                    "DOMICILIO VARCHAR(255)," +
                    "CP INT," +
                    "FECHA_NACIMIENTO DATE," +
                    "NUM_TARJETA INT," +
                    "URL_IMAGEN VARCHAR(255));");
            statement.execute("INSERT INTO USUARIO (NOMBRE_USUARIO, NOMBRE, APELLIDO, EMAIL, CONTRASENYA, DOMICILIO, CP, FECHA_NACIMIENTO, NUM_TARJETA, URL_IMAGEN) VALUES " +
                    "('validUser', 'Nombre', 'Apellido', 'email@example.com', 'validPass', 'Domicilio', 12345, '1990-01-01', 1234567890, 'http://imagen.com');");
        }
    }

    public static int actualizarUsuarioAlias(String nombreUsuario, String contrasenya, String domicilio, int CP, String email, Date fechaNacimiento, String nombre, String apellido, int num_tarjeta) {
        return 1; // Simula una actualización exitosa en la base de datos
    }

    @Test
    void testAuthenticateUsuario_ValidCredentials() throws SQLException {
        Usuario result = usuarioRepository.authenticateUsuario("validUser", "validPass");

        assertNotNull(result);
        assertEquals("validUser", result.getNombreUsuario());
        assertNull(result.getContrasenya());
    }

    @Test
    void testAuthenticateUsuario_InvalidCredentials() throws SQLException {
        Usuario result = usuarioRepository.authenticateUsuario("invalidUser", "invalidPass");

        assertNull(result);
    }

    @Test
    void testAuthenticateUsuario_SQLException() {
        assertThrows(SQLException.class, () -> {
            usuarioRepository.authenticateUsuario(null, null);
        });
    }

    @Test
    void testActualizarUsuario() throws SQLException {
        Usuario usuario = Usuario.builder()
                .nombreUsuario("validUser")
                .contrasenya("newPass")
                .domicilio("New Domicilio")
                .CP(54321)
                .email("newemail@example.com")
                .fechaNacimiento(Date.valueOf("20/11/2011"))
                .nombre("Nuevo Nombre")
                .apellido("Nuevo Apellido")
                .num_tarjeta(987654321)
                .build();

        int result = usuarioRepository.actualizarUsuario(usuario);

        assertEquals(1, result);
    }
}
