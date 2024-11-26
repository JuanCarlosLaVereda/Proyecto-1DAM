package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de géneros.
 * Este controlador maneja las solicitudes relacionadas con los géneros de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    /**
     * Obtiene todos los géneros.
     *
     * @return ResponseEntity con la lista de géneros y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getGeneros(){
        try {
            return new ResponseEntity<>(generoService.getGeneros(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene un género por su ID.
     *
     * @param id el ID del género.
     * @return ResponseEntity con el género y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/id")
    public ResponseEntity<?> getGeneroById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(generoService.getGeneroById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
