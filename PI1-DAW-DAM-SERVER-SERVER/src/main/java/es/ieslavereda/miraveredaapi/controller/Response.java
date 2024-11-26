package es.ieslavereda.miraveredaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase de utilidad para generar respuestas de error en caso de excepciones SQLException.
 */
public class Response {

    /**
     * Genera una ResponseEntity con los detalles de la excepción SQLException.
     *
     * @param e la excepción SQLException.
     * @return ResponseEntity con los detalles de la excepción y el estado HTTP INTERNAL_SERVER_ERROR.
     */
    public static ResponseEntity<?> response(SQLException e){
        Map<String,Object> response = new HashMap<>();
        response.put("code", e.getErrorCode());
        response.put("message",e.getMessage());
        response.put("sqlstate",e.getSQLState());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
