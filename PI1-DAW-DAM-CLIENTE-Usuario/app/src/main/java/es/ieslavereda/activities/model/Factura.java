package es.ieslavereda.activities.model;

import java.util.Date;

/**
 * Clase que representa una factura.
 */
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
     * Constructor de la clase Factura.
     *
     * @param numero      El número de la factura.
     * @param fecha       La fecha de emisión de la factura.
     * @param importe_base El importe base de la factura.
     * @param importe_IVA El importe del IVA de la factura.
     * @param idUsuario   El ID del usuario al que pertenece la factura.
     */
    public Factura(int numero, Date fecha, Double importe_base, Double importe_IVA, String idUsuario) {
        this.numero = numero;
        this.fecha = fecha;
        this.importe_base = importe_base;
        this.importe_IVA = importe_IVA;
        this.idUsuario = idUsuario;
    }

    /**
     * Método getter para obtener el número de la factura.
     *
     * @return El número de la factura.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método getter para obtener la fecha de emisión de la factura.
     *
     * @return La fecha de emisión de la factura.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método getter para obtener el importe base de la factura.
     *
     * @return El importe base de la factura.
     */
    public Double getImporte_base() {
        return importe_base;
    }

    /**
     * Método getter para obtener el importe del IVA de la factura.
     *
     * @return El importe del IVA de la factura.
     */
    public Double getImporte_IVA() {
        return importe_IVA;
    }

    /**
     * Método getter para obtener el ID del usuario al que pertenece la factura.
     *
     * @return El ID del usuario al que pertenece la factura.
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Método setter para establecer el número de la factura.
     *
     * @param numero El número de la factura.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método setter para establecer la fecha de emisión de la factura.
     *
     * @param fecha La fecha de emisión de la factura.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método setter para establecer el importe base de la factura.
     *
     * @param importe_base El importe base de la factura.
     */
    public void setImporte_base(Double importe_base) {
        this.importe_base = importe_base;
    }

    /**
     * Método setter para establecer el importe del IVA de la factura.
     *
     * @param importe_IVA El importe del IVA de la factura.
     */
    public void setImporte_IVA(Double importe_IVA) {
        this.importe_IVA = importe_IVA;
    }

    /**
     * Método setter para establecer el ID del usuario al que pertenece la factura.
     *
     * @param idUsuario El ID del usuario al que pertenece la factura.
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    /**
     * Retorna una representación en cadena de texto de la factura.
     *
     * @return Una cadena que representa la factura.
     */
    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", importe_base=" + importe_base +
                ", importe_IVA=" + importe_IVA +
                ", idUsuario=" + idUsuario +
                '}';
    }
}

