package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.Factura;
import es.ieslavereda.miraveredaapi.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


/**
 * Controlador para la gestión de facturas.
 * Este controlador maneja las solicitudes relacionadas con las facturas de la aplicación.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    /**
     * Obtiene todas las facturas.
     *
     * @return ResponseEntity con la lista de facturas y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/")
    public ResponseEntity<?> getFacturas(){
        try {
            return new ResponseEntity<>(facturaService.getFacturas(), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene una factura por su ID.
     *
     * @param id el ID de la factura.
     * @return ResponseEntity con la factura y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacturaById(@PathVariable("id") int id){
        try {
            return new ResponseEntity<>(facturaService.getFacturaById(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Obtiene las facturas por el ID del usuario.
     *
     * @param id el ID del usuario.
     * @return ResponseEntity con la lista de facturas y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/&user={id}")
    public ResponseEntity<?> getFacturasByUsuarioId(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(facturaService.getFacturaByUsuarioId(id), HttpStatus.OK);
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Añade una nueva factura.
     *
     * @param factura el objeto Factura a añadir.
     * @return ResponseEntity con la factura añadida y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addFactura(@RequestBody Factura factura){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(facturaService.addFactura(factura));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

    /**
     * Finaliza el pedido de un usuario específico.
     *
     * @param tag el identificador del usuario.
     * @return ResponseEntity con el estado del pedido finalizado y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PutMapping("/finalizar/{tag}")
    public ResponseEntity<?> finalizarPedido(@PathVariable("tag") String tag){
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(facturaService.finalizarPedido(tag));
        } catch (SQLException e){
            return Response.response(e);
        }
    }

}
