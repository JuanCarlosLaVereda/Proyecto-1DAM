package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa un carro de compra de un usuario.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarroCompra {
    /**
     * El ID del carro de compra.
     */
    private int id;

    /**
     * El ID del usuario al que pertenece el carro de compra.
     */
    private String idUsuario;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof CarroCompra)) {
            return false;
        }
        CarroCompra carroCompra = (CarroCompra) object;

        return carroCompra.getId() == id;
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su ID.
     */
    @Override
    public int hashCode() {
        return id;
    }
}
