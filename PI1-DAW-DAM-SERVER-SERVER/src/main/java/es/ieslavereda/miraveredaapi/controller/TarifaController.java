package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión de tarifas.
 * Este controlador maneja las solicitudes relacionadas con las tarifas de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tarifa")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    /**
     * Obtiene todas las tarifas.
     *
     * @return ResponseEntity con la lista de tarifas y el estado HTTP OK.
     */
    @GetMapping("/")
    public ResponseEntity<?> getTarifas(){
        try {
            return new ResponseEntity<>(tarifaService.getTarifas(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene una tarifa por su ID.
     *
     * @param id el ID de la tarifa.
     * @return ResponseEntity con la tarifa encontrada y el estado HTTP OK, o un mensaje de error y el estado HTTP correspondiente.
     */
    @GetMapping("/id")
    public ResponseEntity<?> getTarifaById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(tarifaService.getTarifaById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
