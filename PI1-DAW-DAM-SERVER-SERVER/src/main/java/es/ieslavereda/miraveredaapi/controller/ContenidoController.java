package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Contenido;
import es.ieslavereda.miraveredaapi.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión del contenido.
 * Este controlador maneja las solicitudes relacionadas con el contenido de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    /**
     * Obtiene todos los contenidos.
     *
     * @return ResponseEntity con la lista de contenidos y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getContenido() {
        try {
            return new ResponseEntity<>(contenidoService.getContenido(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene el precio de un contenido por su ID.
     *
     * @param id el ID del contenido.
     * @return ResponseEntity con el precio del contenido y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/precio/{id}")
    public ResponseEntity<?> getPrecio(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(contenidoService.getPrecio(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Actualiza la puntuación de un contenido por su ID.
     *
     * @param id el ID del contenido.
     * @param punt la nueva puntuación del contenido.
     * @param tag el ID del usuario que puntúa el contenido.
     * @return ResponseEntity con la respuesta del servicio y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PutMapping("/update/puntuacion/&id={id}&punt={punt}&user={tag}")
    public ResponseEntity<?> updatePuntuacionById(@PathVariable("id") int id, @PathVariable("punt") float punt, @PathVariable("tag")String tag){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.updatePuntuacionById(id, tag, punt));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Elimina un contenido por su ID y tipo.
     *
     * @param id el ID del contenido.
     * @param tipo el tipo de contenido.
     * @return ResponseEntity con la respuesta del servicio y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @DeleteMapping("/delete/&id={id}&tipo={tipo}")
    public ResponseEntity<?> deleteContenido(@PathVariable("id")int id, @PathVariable("tipo")String tipo){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.deleteContenido(id, tipo));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Añade una puntuación a un contenido.
     *
     * @param id el ID del contenido.
     * @param tag el ID del usuario que puntúa el contenido.
     * @param punt la puntuación a añadir.
     * @return ResponseEntity con la respuesta del servicio y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/add/puntacion/&id={id}&user={tag}&punt={punt}")
    public ResponseEntity<?> anyadirPuntuacion(@PathVariable("id")int id, @PathVariable("tag")String tag, @PathVariable("punt")float punt){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.anyadirPuntuacion(id, tag, punt));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene el contenido por el ID de la línea de factura.
     *
     * @param id el ID de la línea de factura.
     * @return ResponseEntity con el contenido y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/lineaFactura/{id}")
    public ResponseEntity<?> getContenidoByIdLinea(@PathVariable("id") int id){
        try{
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(contenidoService.getContenidoByIdLinea(id));
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
