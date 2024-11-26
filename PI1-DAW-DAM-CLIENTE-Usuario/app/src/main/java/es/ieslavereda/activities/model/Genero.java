package es.ieslavereda.activities.model;

/**
 * Clase que representa un género.
 */
public class Genero {
    /**
     * El ID del género.
     */
    private int id;

    /**
     * El tipo de género.
     */
    private String tipo;

    /**
     * Constructor de la clase Genero.
     *
     * @param id   El ID del género.
     * @param tipo El tipo de género.
     */
    public Genero(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    /**
     * Método getter para obtener el ID del género.
     *
     * @return El ID del género.
     */
    public int getId() {
        return id;
    }

    /**
     * Método getter para obtener el tipo de género.
     *
     * @return El tipo de género.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el ID del género.
     *
     * @param id El ID del género.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método setter para establecer el tipo de género.
     *
     * @param tipo El tipo de género.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo ID), false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Genero)) {
            return false;
        }
        Genero genero = (Genero) object;

        return id == genero.getId();
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
     * Retorna una representación en cadena de texto del género.
     *
     * @return Una cadena que representa el género.
     */
    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

}

