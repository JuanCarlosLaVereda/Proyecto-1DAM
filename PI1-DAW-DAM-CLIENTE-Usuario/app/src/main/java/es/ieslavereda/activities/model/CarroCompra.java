package es.ieslavereda.activities.model;

/**
 * Clase que representa un carro de compra de un usuario.
 */
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
     * Constructor de la clase CarroCompra.
     *
     * @param id El ID del carro de compra.
     * @param idUsuario El ID del usuario al que pertenece el carro de compra.
     */
    public CarroCompra(int id, String idUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el ID del carro de compra.
     *
     * @return El ID del carro de compra.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el ID del usuario al que pertenece el carro de compra.
     *
     * @return El ID del usuario al que pertenece el carro de compra.
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del carro de compra.
     *
     * @param id El ID del carro de compra.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el ID del usuario al que pertenece el carro de compra.
     *
     * @param idUsuario El ID del usuario al que pertenece el carro de compra.
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    @Override
    public String toString() {
        return "CarroCompra{" +
                "id=" + id +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
