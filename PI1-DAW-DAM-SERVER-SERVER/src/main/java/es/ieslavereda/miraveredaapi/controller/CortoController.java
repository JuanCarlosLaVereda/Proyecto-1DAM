package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Corto;
import es.ieslavereda.miraveredaapi.service.CortoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión de cortos.
 * Este controlador maneja las solicitudes relacionadas con los cortos de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contenido/corto")
public class CortoController {

    @Autowired
    CortoService cortoService;

    /**
     * Obtiene todos los cortos.
     *
     * @return ResponseEntity con la lista de cortos y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getCortos(){
        try {
            return new ResponseEntity<>(cortoService.getCortos(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene un corto por su ID.
     *
     * @param id el ID del corto.
     * @return ResponseEntity con el corto y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCortoById(@PathVariable("id") int id){
        try {
            Corto corto = (Corto) cortoService.getCortoById(id);
            if (corto == null){
                return new ResponseEntity<>("Corto no encontrado", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(corto, HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Añade un nuevo corto.
     *
     * @param corto el objeto Corto a añadir.
     * @return ResponseEntity con el corto añadido y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addCorto(@RequestBody Corto corto){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(cortoService.addCorto(corto));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Actualiza un corto existente.
     *
     * @param corto el objeto Corto a actualizar.
     * @return ResponseEntity con el corto actualizado y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateCorto(@RequestBody Corto corto){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(cortoService.updateCorto(corto));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene los cortos alquilados por un usuario específico.
     *
     * @param tag el identificador del usuario.
     * @return ResponseEntity con la lista de cortos alquilados y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/alquilados/{tag}")
    public ResponseEntity<?> getCortosAlquilados(@PathVariable("tag") String tag){
        try {
            return new ResponseEntity<>(cortoService.getCortosAlquilados(tag), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
