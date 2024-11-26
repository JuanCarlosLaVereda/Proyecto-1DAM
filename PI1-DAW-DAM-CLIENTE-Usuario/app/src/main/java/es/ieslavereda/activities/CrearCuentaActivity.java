package es.ieslavereda.activities;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;

import es.ieslavereda.activities.model.usuario.Usuario;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;

/**
 * Actividad para crear una nueva cuenta de usuario.
 * Esta actividad permite que los usuarios creen una nueva cuenta proporcionando su información básica como nombre de usuario, contraseña, email, nombre y apellido.
 * Al hacer clic en el botón "Crear cuenta", se verifica la coincidencia de contraseñas y se comprueba si el nombre de usuario ya existe.
 * Si el nombre de usuario no existe y las contraseñas coinciden, se crea la cuenta de usuario y se redirige a la actividad anterior.
 * Si el nombre de usuario ya existe, se muestra un mensaje de error.
 * Si las contraseñas no coinciden, se muestra un mensaje de error.
 */
public class CrearCuentaActivity extends BaseActivity implements CallInterface {

    private EditText nombreUsuario, contrasenya, confirmarContrasenya, email, nombre, apellido;
    private Button crearCuenta;
    private Button cancelar;

    private Usuario login;
    private Usuario usuario;

    /**
     * Método llamado cuando se crea la actividad.
     * Se inicializan las vistas y se configuran los listeners de los botones.
     *
     * @param savedInstanceState Información de estado anterior de la actividad, si está disponible.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        nombreUsuario = findViewById(R.id.editTextUsuarioReiniciarContrasenya);
        contrasenya = findViewById(R.id.editTextNuevaContrasenyaReiniciarContrasenya);
        confirmarContrasenya = findViewById(R.id.editTextNuevaContrasenyaConfirmacionReiniciarContrasenya);
        email = findViewById(R.id.editTextEmail);
        nombre = findViewById(R.id.editTextNombreCrear);
        apellido = findViewById(R.id.editTextApellidoCrear);
        crearCuenta = findViewById(R.id.buttonConfirmarReiniciarContrasenya);
        cancelar = findViewById(R.id.cancelarReiniciarContrasenya);



        

        crearCuenta.setOnClickListener(view -> {
            if (contrasenya.getText().toString().equals(confirmarContrasenya.getText().toString())) {
                executeCall(new CallInterface() {
                    @Override
                    public void doInBackground() {
                        login = Connector.getConector().get(Usuario.class, "usuario/login/&user=" + nombreUsuario.getText().toString() + "&password=" + contrasenya.getText().toString());
                    }

                    @Override
                    public void doInUI() {
                        if (login!=null){
                            Toast.makeText(getBaseContext(), "El usuario ya existe", Toast.LENGTH_SHORT).show();
                        } else {
                            login = new Usuario(nombreUsuario.getText().toString(),
                                    nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    email.getText().toString(),
                                    contrasenya.getText().toString(), null, 0, 0, null, null);
                            executeCall(new CallInterface() {
                                @Override
                                public void doInBackground() {
                                    usuario = Connector.getConector().post(Usuario.class, login, "usuario/add");
                                }

                                @Override
                                public void doInUI() {
                                    setResult(RESULT_OK);
                                    finish();
                                }
                            });
                            setResult(RESULT_OK);
                            finish();
                        }

                    }
                });
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        });

        cancelar.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

    /**
     * Método de interfaz sin implementación en esta clase.
     */
    @Override
    public void doInBackground() {

    }

    /**
     * Método de interfaz sin implementación en esta clase.
     */
    @Override
    public void doInUI() {

    }
}
