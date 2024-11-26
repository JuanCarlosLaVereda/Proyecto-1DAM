package es.ieslavereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.usuario.Usuario;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;


/**
 * Actividad principal con 3 opciones: iniciar sesión, crear cuenta y reiniciar contraseña.
 * Esta actividad muestra campos para que los usuarios ingresen su nombre de usuario y contraseña.
 * Los usuarios pueden iniciar sesión, crear una nueva cuenta o reiniciar su contraseña.
 * Si se inicia sesión correctamente, se redirige a la actividad de contenido.
 */
public class MainActivity extends BaseActivity implements CallInterface {

    private EditText usuario, contrasenya;
    private Button iniciarSesion, crearCuenta, reiniciarContrasenya;
    private String autenticar;
    private Usuario usuarioGuardado;

    /**
     * Método llamado cuando se crea la actividad.
     * Se inicializan las vistas y se configuran los listeners de los botones.
     *
     * @param savedInstanceState Información de estado anterior de la actividad, si está disponible.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario = findViewById(R.id.editTextUsuario);
        contrasenya = findViewById(R.id.editTextContrasenya);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        crearCuenta = findViewById(R.id.buttonCrearCuenta);
        reiniciarContrasenya = findViewById(R.id.buttonReiniciarContrasenya);

        //usuario.setText("root");
        //contrasenya.setText("root");



        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {

                Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Creación de cuenta cancelada", Toast.LENGTH_SHORT).show();
            }
        });
        crearCuenta.setOnClickListener(view -> {
            Intent intent = new Intent(this, CrearCuentaActivity.class);
            resultLauncher.launch(intent);
        });

        reiniciarContrasenya.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReiniciarContrasenyaActivity.class);
            startActivity(intent);
        });

        iniciarSesion.setOnClickListener(view -> {
            executeCall(new CallInterface() {
                @Override
                public void doInBackground() {
                    usuarioGuardado = Connector.getConector().get(Usuario.class, "usuario/login/&user="+usuario.getText().toString()+"&password="+contrasenya.getText().toString());
                }

                @Override
                public void doInUI() {

                }
            });
           if (usuarioGuardado!=null) {
               Intent intent = new Intent(this, ContenidoActivity.class);
               intent.putExtra("UsuarioPath", usuarioGuardado.getNombreUsuario());
               startActivity(intent);
               Toast.makeText(this, "Sesión iniciada como '" + usuario.getText() + "'", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
           }
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