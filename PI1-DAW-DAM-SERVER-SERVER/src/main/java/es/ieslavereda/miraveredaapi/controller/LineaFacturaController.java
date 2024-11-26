package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.service.LineaFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de líneas de factura.
 * Este controlador maneja las solicitudes relacionadas con las líneas de factura de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lineaFactura")
public class LineaFacturaController {

    @Autowired
    private LineaFacturaService lineaFacturaService;

    /**
     * Obtiene las líneas de factura por el ID de la factura.
     *
     * @param id el ID de la factura.
     * @return ResponseEntity con la lista de líneas de factura y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/&factura={id}")
    public ResponseEntity<?> getFacturasByIdFactura(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(lineaFacturaService.getLineaFacturasByIdFactura(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene una línea de factura por su ID.
     *
     * @param id el ID de la línea de factura.
     * @return ResponseEntity con la línea de factura y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacturaById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(lineaFacturaService.getLineaFacturaById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene las líneas de factura por el ID del carro de compra.
     *
     * @param id el ID del carro de compra.
     * @return ResponseEntity con la lista de líneas de factura y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/&carro={id}")
    public ResponseEntity<?> getLineaFacturasByIdCarro(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(lineaFacturaService.getLineaFacturasByIdCarro(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Elimina una línea de factura por su ID.
     *
     * @param id el ID de la línea de factura.
     * @return ResponseEntity con el resultado de la operación y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLineaFacturaById(@PathVariable("id")int id){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(lineaFacturaService.deleteLineafacturaById(id));
        } catch (SQLException e){
            return Response.response(e);
        }
    }
}
