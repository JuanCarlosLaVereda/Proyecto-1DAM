package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa una tarifa.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Tarifa {

    /**
     * El código de la tarifa.
     */
    private int codigo;

    /**
     * El precio de la tarifa.
     */
    private float precio;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo código de tarifa), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Tarifa)) {
            return false;
        }

        Tarifa tarifa = (Tarifa) object;
        return codigo == tarifa.getCodigo();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su código.
     */
    @Override
    public int hashCode() {
        return codigo;
    }
}
