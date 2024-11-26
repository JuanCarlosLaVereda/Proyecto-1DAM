package es.ieslavereda.activities.model.usuario;

import java.util.Date;

/**
 * Clase que representa a un usuario.
 */
public class Usuario {
    private String nombreUsuario, nombre, apellido, email, contrasenya, domicilio;
    private int CP, num_tarjeta;
    private Date fechaNacimiento;
    private String url_imagen;

    /**
     * Constructor de la clase Usuario.
     *
     * @param nombreUsuario  El nombre de usuario.
     * @param nombre         El nombre del usuario.
     * @param apellido       El apellido del usuario.
     * @param email          El correo electrónico del usuario.
     * @param contrasenya    La contraseña del usuario.
     * @param domicilio      El domicilio del usuario.
     * @param CP             El código postal del usuario.
     * @param num_tarjeta    El número de tarjeta del usuario.
     * @param fechaNacimiento La fecha de nacimiento del usuario.
     * @param url_imagen     La URL de la imagen de perfil del usuario.
     */
    public Usuario(String nombreUsuario, String nombre, String apellido, String email, String contrasenya, String domicilio, int CP, int num_tarjeta, Date fechaNacimiento, String url_imagen) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenya = contrasenya;
        this.domicilio = domicilio;
        this.CP = CP;
        this.num_tarjeta = num_tarjeta;
        this.fechaNacimiento = fechaNacimiento;
        this.url_imagen = url_imagen;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Obtiene el domicilio del usuario.
     *
     * @return El domicilio del usuario.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Obtiene el código postal del usuario.
     *
     * @return El código postal del usuario.
     */
    public int getCP() {
        return CP;
    }

    /**
     * Obtiene el número de tarjeta del usuario.
     *
     * @return El número de tarjeta del usuario.
     */
    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return La fecha de nacimiento del usuario.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene la URL de la imagen de perfil del usuario.
     *
     * @return La URL de la imagen de perfil del usuario.
     */
    public String getUrl_imagen() {
        return url_imagen;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario a establecer.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El apellido del usuario a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario a establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasenya La contraseña del usuario a establecer.
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * Establece el domicilio del usuario.
     *
     * @param domicilio El domicilio del usuario a establecer.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Establece el código postal del usuario.
     *
     * @param CP El código postal del usuario a establecer.
     */
    public void setCP(int CP) {
        this.CP = CP;
    }

    /**
     * Establece el número de tarjeta del usuario.
     *
     * @param num_tarjeta El número de tarjeta del usuario a establecer.
     */
    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento La fecha de nacimiento del usuario a establecer.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece la URL de la imagen de perfil del usuario.
     *
     * @param url_imagen La URL de la imagen de perfil del usuario a establecer.
     */
    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
