package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.util.Date;

/**
 * Clase que representa una línea de factura.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LineaFactura {

    /**
     * El ID de la línea de factura.
     */
    private int id;

    /**
     * El ID del carro de compra asociado con esta línea de factura.
     */
    private int idCarro;

    /**
     * El ID de la factura a la que pertenece esta línea de factura.
     */
    private int idFactura;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof LineaFactura)) {
            return false;
        }

        LineaFactura lineaFactura = (LineaFactura) object;

        return id == lineaFactura.getId();
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
