package es.ieslavereda.activities.model;

/**
 * Clase que representa una línea de factura.
 */
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
     * Constructor de la clase LineaFactura.
     *
     * @param id        El ID de la línea de factura.
     * @param idCarro   El ID del carro de compra asociado con esta línea de factura.
     * @param idFactura El ID de la factura a la que pertenece esta línea de factura.
     */
    public LineaFactura(int id, int idCarro, int idFactura) {
        this.id = id;
        this.idCarro = idCarro;
        this.idFactura = idFactura;
    }

    /**
     * Método getter para obtener el ID de la línea de factura.
     *
     * @return El ID de la línea de factura.
     */
    public int getId() {
        return id;
    }

    /**
     * Método getter para obtener el ID del carro de compra asociado con esta línea de factura.
     *
     * @return El ID del carro de compra asociado con esta línea de factura.
     */
    public int getIdCarro() {
        return idCarro;
    }

    /**
     * Método getter para obtener el ID de la factura a la que pertenece esta línea de factura.
     *
     * @return El ID de la factura a la que pertenece esta línea de factura.
     */
    public int getIdFactura() {
        return idFactura;
    }

    /**
     * Método setter para establecer el ID de la línea de factura.
     *
     * @param id El ID de la línea de factura.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método setter para establecer el ID del carro de compra asociado con esta línea de factura.
     *
     * @param idCarro El ID del carro de compra asociado con esta línea de factura.
     */
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    /**
     * Método setter para establecer el ID de la factura a la que pertenece esta línea de factura.
     *
     * @param idFactura El ID de la factura a la que pertenece esta línea de factura.
     */
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

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

    /**
     * Retorna una representación en cadena de texto de la línea de factura.
     *
     * @return Una cadena que representa la línea de factura.
     */
    @Override
    public String toString() {
        return "LineaFactura{" +
                "id=" + id +
                ", idCarro=" + idCarro +
                ", idFactura=" + idFactura +
                '}';
    }
}

