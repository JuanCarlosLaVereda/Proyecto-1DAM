package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Capitulo;
import es.ieslavereda.miraveredaapi.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador REST para gestionar capítulos de contenido.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contenido/capitulo")
public class CapituloController {

    @Autowired
    private CapituloService capituloService;

    /**
     * Obtiene todos los capítulos.
     *
     * @return ResponseEntity con la lista de capítulos y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getCapitulos() {
        try {
            return new ResponseEntity<>(capituloService.getCapitulos(), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Obtiene un capítulo por su ID.
     *
     * @param id el ID del capítulo a obtener.
     * @return ResponseEntity con el capítulo y el estado HTTP OK si se encuentra, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCapituloById(@PathVariable("id") int id) {
        try {
            Capitulo capitulo = (Capitulo) capituloService.getCapituloByid(id);
            if (capitulo == null) {
                return new ResponseEntity<>("Capitulo no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(capitulo, HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Añade un nuevo capítulo.
     *
     * @param capitulo el capítulo a añadir.
     * @return ResponseEntity con el capítulo añadido y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addCapitulo(@RequestBody Capitulo capitulo) {
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(capituloService.addCapitulo(capitulo));
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Obtiene los capítulos de una serie por el ID de la serie.
     *
     * @param id el ID de la serie.
     * @return ResponseEntity con la lista de capítulos y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/&serie={id}")
    public ResponseEntity<?> getCapitulosBySerie(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(capituloService.getCapitulosBySerie(id), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Actualiza un capítulo existente.
     *
     * @param capitulo el capítulo a actualizar.
     * @return ResponseEntity con el capítulo actualizado y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateCapitulo(@RequestBody Capitulo capitulo) {
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(capituloService.updateCapitulo(capitulo));
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Obtiene los capítulos alquilados por una etiqueta de usuario.
     *
     * @param tag la etiqueta del usuario.
     * @return ResponseEntity con la lista de capítulos alquilados y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/alquilados/{tag}")
    public ResponseEntity<?> getCapitulosAlquilados(@PathVariable("tag") String tag) {
        try {
            return new ResponseEntity<>(capituloService.getCapitulosAlquilados(tag), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

}
