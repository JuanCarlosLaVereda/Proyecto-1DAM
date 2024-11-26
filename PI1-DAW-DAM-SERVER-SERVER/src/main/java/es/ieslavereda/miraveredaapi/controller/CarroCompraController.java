package es.ieslavereda.miraveredaapi.controller;

import es.ieslavereda.miraveredaapi.repository.model.CarroCompra;
import es.ieslavereda.miraveredaapi.service.CarroCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para la gestión del carro de la compra.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carro")
public class CarroCompraController {

    @Autowired
    private CarroCompraService carroCompraService;

    /**
     * Obtiene un carro de la compra por su ID.
     *
     * @param id el ID del carro de la compra.
     * @return ResponseEntity con el carro de la compra y el estado HTTP OK si se encuentra, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarroCompraById(@PathVariable("id") int id) {
        try {
            return new ResponseEntity<>(carroCompraService.getCarroCompraById(id), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Obtiene un carro de la compra por el ID de usuario.
     *
     * @param tag el ID del usuario.
     * @return ResponseEntity con el carro de la compra y el estado HTTP OK si se encuentra, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @GetMapping("/&user={tag}")
    public ResponseEntity<?> getCarroCompraByUsuarioId(@PathVariable("tag") String tag) {
        try {
            return new ResponseEntity<>(carroCompraService.getCarroCompraByUsuarioId(tag), HttpStatus.OK);
        } catch (SQLException e) {
            return Response.response(e);
        }
    }

    /**
     * Añade una línea de factura al carro de la compra de un usuario.
     *
     * @param tag el ID del usuario.
     * @param id el ID del contenido.
     * @return ResponseEntity con la línea de factura añadida y el estado HTTP OK si tiene éxito, o un mensaje de error y el estado HTTP correspondiente si falla.
     */
    @PostMapping("/addLinea/&user={tag}&idCont={id}")
    public ResponseEntity<?> addLineaFactura(@PathVariable("tag") String tag, @PathVariable("id") int id) {
        try {
            return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(carroCompraService.addLineaFactura(tag, id));
        } catch (SQLException e) {
            return Response.response(e);
        }
    }
}
