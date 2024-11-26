package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Serie;
import es.ieslavereda.miraveredaapi.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión de series.
 * Este controlador maneja las solicitudes relacionadas con las series de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/serie")
public class SerieController {

    @Autowired
    private SerieService serieService;

    /**
     * Obtiene todas las series.
     *
     * @return ResponseEntity con la lista de series y el estado HTTP OK.
     */
    @GetMapping("/")
    public ResponseEntity<?> getSeries(){
        try {
            return new ResponseEntity<>(serieService.getSeries(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene una serie por su ID.
     *
     * @param id el ID de la serie.
     * @return ResponseEntity con la serie encontrada y el estado HTTP OK, o un mensaje de error y el estado HTTP correspondiente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getSerieById(@PathVariable("id")int id){
        try {
            return new ResponseEntity<>(serieService.getSerieById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Añade una nueva serie.
     *
     * @param serie la serie a añadir.
     * @return ResponseEntity con la serie añadida y el estado HTTP OK, o un mensaje de error y el estado HTTP correspondiente.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addSerie(@RequestBody Serie serie){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.addSerie(serie));
        }catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Actualiza una serie existente.
     *
     * @param serie la serie a actualizar.
     * @return ResponseEntity con la serie actualizada y el estado HTTP OK, o un mensaje de error y el estado HTTP correspondiente.
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateSerie(@RequestBody Serie serie){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.updateSerie(serie));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Elimina una serie por su ID.
     *
     * @param id el ID de la serie a eliminar.
     * @return ResponseEntity con el resultado de la eliminación y el estado HTTP OK, o un mensaje de error y el estado HTTP correspondiente.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSerie(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(serieService.deleteSerie(id));
        }catch (SQLException e){
            return Response.response(e);
        }
    }
}
