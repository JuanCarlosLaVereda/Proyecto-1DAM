package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa una serie.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Serie {

    /**
     * El ID de la serie.
     */
    private int id;

    /**
     * La fecha hasta la cual la serie está disponible.
     */
    private Date disponible_hasta;

    /**
     * El título de la serie.
     */
    private String titulo;

    /**
     * La descripción de la serie.
     */
    private String descripcion;

    private String url_image;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Serie)) {
            return false;
        }
        Serie serie = (Serie) object;

        return id == serie.getId();
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
