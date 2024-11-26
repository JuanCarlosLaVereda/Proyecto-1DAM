package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Pelicula;
import es.ieslavereda.miraveredaapi.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de películas.
 * Este controlador maneja las solicitudes relacionadas con las películas de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contenido/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /**
     * Obtiene todas las películas.
     *
     * @return ResponseEntity con la lista de películas y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getPeliculas(){
        try {
            return new ResponseEntity<>(peliculaService.getPeliculas(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene una película por su ID.
     *
     * @param id el ID de la película.
     * @return ResponseEntity con la película y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPeliculaById(@PathVariable("id")int id) {
        try {
            Pelicula pelicula = (Pelicula) peliculaService.getPeliculasById(id);
            if (pelicula == null){
                return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.OK);
            }
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Añade una nueva película.
     *
     * @param pelicula el objeto Pelicula que se va a añadir.
     * @return ResponseEntity con el resultado de la operación y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addPelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(peliculaService.addPelicula(pelicula));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Actualiza una película existente.
     *
     * @param pelicula el objeto Pelicula que se va a actualizar.
     * @return ResponseEntity con el resultado de la operación y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PutMapping("/update")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(peliculaService.updatePelicula(pelicula));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene las películas alquiladas por un usuario.
     *
     * @param tag el identificador del usuario.
     * @return ResponseEntity con la lista de películas alquiladas y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/alquilados/{tag}")
    public ResponseEntity<?> getPeliculasAlquilados(@PathVariable("tag")String tag){
        try {
            return new ResponseEntity<>(peliculaService.getPeliculasAlquiladas(tag), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
