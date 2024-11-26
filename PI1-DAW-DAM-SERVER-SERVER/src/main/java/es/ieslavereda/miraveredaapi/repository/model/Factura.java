package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa una factura.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Factura {

    /**
     * El número de la factura.
     */
    private int numero;

    /**
     * La fecha de emisión de la factura.
     */
    private Date fecha;

    /**
     * El importe base de la factura, sin incluir el IVA.
     */
    private Double importe_base;

    /**
     * El importe del IVA de la factura.
     */
    private Double importe_IVA;

    /**
     * El ID del usuario al que pertenece la factura.
     */
    private String idUsuario;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo número de factura), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Factura)) {
            return false;
        }

        Factura factura = (Factura) object;

        return numero == factura.getNumero();
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su número de factura.
     */
    @Override
    public int hashCode() {
        return numero;
    }
}
