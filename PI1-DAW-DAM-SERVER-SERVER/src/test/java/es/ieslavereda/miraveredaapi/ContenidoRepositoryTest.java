package es.ieslavereda.miraveredaapi;

import es.ieslavereda.miraveredaapi.repository.ContenidoRepository;
import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContenidoRepositoryTest {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE PELICULA (" +
                    "ID INT PRIMARY KEY, " +
                    "TITULO VARCHAR(255), " +
                    "DESCRIPCION VARCHAR(255), " +
                    "URL_IMAGE VARCHAR(255), " +
                    "ACTORES VARCHAR(255), " +
                    "PUNT_MEDIA FLOAT, " +
                    "FECHA_ESTRENO DATE, " +
                    "DURACION_MINUTOS FLOAT, " +
                    "DIRECTOR VARCHAR(255), " +
                    "ID_GENERO INT, " +
                    "ID_TARIFA INT, " +
                    "DISPONIBLE_HASTA DATE);");

            statement.execute("CREATE TABLE CAPITULO (" +
                    "ID INT PRIMARY KEY, " +
                    "TITULO VARCHAR(255), " +
                    "DESCRIPCION VARCHAR(255), " +
                    "URL_IMAGE VARCHAR(255), " +
                    "ACTORES VARCHAR(255), " +
                    "PUNT_MEDIA FLOAT, " +
                    "FECHA_ESTRENO DATE, " +
                    "DURACION_MINUTOS FLOAT, " +
                    "DIRECTOR VARCHAR(255), " +
                    "ID_GENERO INT, " +
                    "ID_TARIFA INT, " +
                    "ID_SERIE INT, " +
                    "TEMPORADA INT);");

            statement.execute("CREATE TABLE CORTO (" +
                    "ID INT PRIMARY KEY, " +
                    "TITULO VARCHAR(255), " +
                    "DESCRIPCION VARCHAR(255), " +
                    "URL_IMAGE VARCHAR(255), " +
                    "ACTORES VARCHAR(255), " +
                    "PUNT_MEDIA FLOAT, " +
                    "FECHA_ESTRENO DATE, " +
                    "DURACION_MINUTOS FLOAT, " +
                    "DIRECTOR VARCHAR(255), " +
                    "ID_GENERO INT, " +
                    "ID_TARIFA INT);");

            statement.execute("INSERT INTO PELICULA VALUES " +
                    "(1, 'Pelicula 1', 'Descripción 1', 'url1', 'Actores 1', 4.5, '2022-01-01', 120, 'Director 1', 1, 1, '2022-12-31')," +
                    "(2, 'Pelicula 2', 'Descripción 2', 'url2', 'Actores 2', 3.5, '2022-02-02', 150, 'Director 2', 2, 2, '2022-12-31');");

            statement.execute("INSERT INTO CAPITULO VALUES " +
                    "(3, 'Capítulo 1', 'Descripción 1', 'url1', 'Actores 1', 4.0, '2022-03-03', 45, 'Director 1', 1, 1, 1, 1)," +
                    "(4, 'Capítulo 2', 'Descripción 2', 'url2', 'Actores 2', 3.0, '2022-04-04', 60, 'Director 2', 2, 2, 2, 2);");

            statement.execute("INSERT INTO CORTO VALUES " +
                    "(5, 'Corto 1', 'Descripción 1', 'url1', 'Actores 1', 4.0, '2022-05-05', 30, 'Director 1', 1, 1)," +
                    "(6, 'Corto 2', 'Descripción 2', 'url2', 'Actores 2', 3.0, '2022-06-06', 20, 'Director 2', 2, 2);");
        }
    }

    @Test
    void testGetContenidos() throws SQLException {
        List<Contenido> contenidos = contenidoRepository.getContenidos();

        assertEquals(6, contenidos.size());
        assertTrue(contenidos.stream().anyMatch(c -> c instanceof Pelicula));
        assertTrue(contenidos.stream().anyMatch(c -> c instanceof Capitulo));
        assertTrue(contenidos.stream().anyMatch(c -> c instanceof Corto));
    }

    @Test
    void testUpdatePuntuacionById() throws SQLException {
        int id = 1; // ID de un contenido existente en la base de datos de prueba
        String tag = "testUser"; // ID de usuario
        float punt = 4.0f; // Puntuación a asignar al contenido

        int result = contenidoRepository.updatePuntuacionById(id, tag, punt);

        assertEquals(1, result);
    }

    @Test
    void testGetContenidoByIdLineaFactura() throws SQLException {
        int id = 1; // ID de una línea de factura existente en la base de datos de prueba

        Contenido contenido = contenidoRepository.getContenidoByIdLineaFactura(id);

        assertNotNull(contenido);
        assertTrue(contenido instanceof Corto); // Suponiendo que el contenido devuelto debe ser un Corto
    }
}

