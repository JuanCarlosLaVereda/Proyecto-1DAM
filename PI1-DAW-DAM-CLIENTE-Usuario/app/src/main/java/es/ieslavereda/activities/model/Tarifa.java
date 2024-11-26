package es.ieslavereda.activities.model;

/**
 * Clase que representa una tarifa.
 */
public class Tarifa {

    /**
     * El código de la tarifa.
     */
    private int codigo;

    /**
     * El precio de la tarifa.
     */
    private Float precio;

    /**
     * Constructor de la clase Tarifa.
     *
     * @param codigo El código de la tarifa.
     * @param precio El precio de la tarifa.
     */
    public Tarifa(int codigo, Float precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    /**
     * Método getter para obtener el código de la tarifa.
     *
     * @return El código de la tarifa.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método getter para obtener el precio de la tarifa.
     *
     * @return El precio de la tarifa.
     */
    public Float getPrecio() {
        return precio;
    }

    /**
     * Método setter para establecer el código de la tarifa.
     *
     * @param codigo El código de la tarifa.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método setter para establecer el precio de la tarifa.
     *
     * @param precio El precio de la tarifa.
     */
    public void setPrecio(Float precio) {
        this.precio = precio;
    }

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

    /**
     * Retorna una representación en cadena de texto de la tarifa.
     *
     * @return Una cadena que representa la tarifa.
     */
    @Override
    public String toString() {
        return "Tarifa{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }
}

