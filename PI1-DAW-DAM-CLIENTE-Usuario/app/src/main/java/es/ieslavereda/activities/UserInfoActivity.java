package es.ieslavereda.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import es.ieslavereda.API.Connector;
import es.ieslavereda.activities.model.usuario.Usuario;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.base.ImageDownloader;

/**
 * Clase UserInfoActivity que extiende de BaseActivity e implementa la interfaz CallInterface.
 * Esta actividad permite a los usuarios ver y actualizar su información personal.
 */
public class UserInfoActivity extends BaseActivity implements CallInterface {

    private ImageView imageViewUsuario;
    private TextView textViewNombreUsuario;
    private EditText editTextContrasenya;
    private EditText editTextEmail;
    private EditText editTextNombre;
    private EditText editTextApellidos;
    private EditText editTextFechaNac;
    private EditText editTextDomicilio;
    private EditText editTextTarjeta;
    private EditText editTextUrlImage;
    private String tagUsuario;
    private Button buttonActualizarUsuario;
    private Usuario usuarioLogeado;

    /**
     * Método llamado cuando se crea la actividad.
     * Inicializa los componentes de la UI y configura el botón de actualización.
     *
     * @param savedInstanceState Si la actividad se vuelve a crear desde un estado previamente guardado,
     *                           este parámetro contiene los datos más recientes proporcionados.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usuario);

        imageViewUsuario = findViewById(R.id.imageViewUsuario);
        textViewNombreUsuario = findViewById(R.id.textViewUsuarioNombreUsuario);
        editTextContrasenya = findViewById(R.id.editTextTextPassword);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextFechaNac = findViewById(R.id.editTextFechaNacimiento);
        editTextDomicilio = findViewById(R.id.editTextDomicilio);
        editTextTarjeta = findViewById(R.id.editTextTarjeta);
        editTextUrlImage = findViewById(R.id.editTextUrlImagen);
        buttonActualizarUsuario = findViewById(R.id.buttonActualizarUsuario);

        buttonActualizarUsuario.setOnClickListener(view -> {
            executeCall(new CallInterface() {
                @Override
                public void doInBackground() {
                    String nombreUsuario = editTextNombre.getText().toString();
                    String contraUsuario = editTextContrasenya.getText().toString();
                    String emailUsuario = editTextEmail.getText().toString();
                    String apellidosUsuario = editTextApellidos.getText().toString();
                    Date fechaNacUsuario = new Date(editTextFechaNac.getText().toString());
                    String domicilioUsuario = editTextDomicilio.getText().toString();
                    int tarjetaUsuario = Integer.parseInt(editTextTarjeta.getText().toString());
                    int cpUsuario = usuarioLogeado.getCP();
                    String urlImagenUsuario = editTextUrlImage.getText().toString();

                    Usuario usuarioActualizado = new Usuario(usuarioLogeado.getNombreUsuario(),nombreUsuario,
                    apellidosUsuario,emailUsuario,contraUsuario,domicilioUsuario,cpUsuario,tarjetaUsuario,fechaNacUsuario,urlImagenUsuario);
                    usuarioLogeado = Connector.getConector().put(Usuario.class,usuarioActualizado,"usuario/update");
                }

                @Override
                public void doInUI() {

                }
            });

            doInBackground();
        });

    }

    /**
     * Método llamado para ejecutar tareas en segundo plano.
     * Este método obtiene la información del usuario desde el servidor y actualiza la UI con los datos obtenidos.
     */
    @Override
    public void doInBackground() {
        tagUsuario = getIntent().getExtras().getString("tag_usuario");
        usuarioLogeado = Connector.getConector().get(Usuario.class,"usuario/"+tagUsuario);
        ImageDownloader.downloadImage(usuarioLogeado.getUrl_imagen(),imageViewUsuario);
        textViewNombreUsuario.setText(usuarioLogeado.getNombreUsuario());
        editTextContrasenya.setText(usuarioLogeado.getContrasenya());
        editTextEmail.setText(usuarioLogeado.getEmail());
        editTextNombre.setText(usuarioLogeado.getNombre());
        editTextApellidos.setText(usuarioLogeado.getApellido());
        editTextFechaNac.setText(usuarioLogeado.getFechaNacimiento().toString());
        editTextDomicilio.setText(usuarioLogeado.getDomicilio());
        editTextTarjeta.setText(usuarioLogeado.getNum_tarjeta());
        editTextUrlImage.setText(usuarioLogeado.getUrl_imagen());
    }

    /**
     * Método llamado para ejecutar tareas en la UI.
     * Actualmente no se usa en esta implementación.
     */
    @Override
    public void doInUI() {

    }
}
