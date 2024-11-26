package es.ieslavereda.miraveredaapi.repository.model;

import lombok.*;

import java.sql.Date;

/**
 * Clase que representa un usuario.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Usuario {
    /**
     * El nombre de usuario del usuario.
     */
    private String nombreUsuario;

    /**
     * El nombre del usuario.
     */
    private String nombre;

    /**
     * El apellido del usuario.
     */
    private String apellido;

    /**
     * El correo electrónico del usuario.
     */
    private String email;

    /**
     * La contraseña del usuario.
     */
    private String contrasenya;

    /**
     * El domicilio del usuario.
     */
    private String domicilio;

    /**
     * El código postal del usuario.
     */
    private int CP;

    /**
     * La fecha de nacimiento del usuario.
     */
    private Date fechaNacimiento;

    /**
     * El número de tarjeta del usuario.
     */
    private int num_tarjeta;
    /**
     * Url de la imagen del usuario.
     */
    private String url_imagen;

    /**
     * Compara este objeto con otro para determinar si son iguales.
     * @param object El objeto con el que se va a comparar.
     * @return true si los objetos son iguales (tienen el mismo nombre de usuario), false en caso contrario.
     */
    @Override
    public boolean equals(Object object){
        if (object == null || !(object instanceof Usuario)){
            return false;
        }

        Usuario usuario = (Usuario) object;

        return nombreUsuario.equals(usuario.getNombreUsuario());
    }

    /**
     * Calcula el código hash de este objeto.
     * @return El código hash del objeto basado en su nombre de usuario.
     */
    @Override
    public int hashCode(){
        return nombreUsuario.hashCode();
    }

}
