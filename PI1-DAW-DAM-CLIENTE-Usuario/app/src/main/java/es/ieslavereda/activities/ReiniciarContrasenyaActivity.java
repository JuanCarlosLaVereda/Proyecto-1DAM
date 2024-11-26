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
 * Actividad para reiniciar la contraseña de un usuario existente.
 * Esta actividad permite que un usuario ingrese su nombre de usuario y una nueva contraseña.
 * La nueva contraseña se verifica al confirmarla y se actualiza en la base de datos si el usuario existe.
 */
public class ReiniciarContrasenyaActivity extends BaseActivity implements CallInterface {

    private EditText nombreUsuario;
    private EditText contrasenya;
    private EditText confirmarContrasenya;
    private Button reiniciarContrasenya;
    private Button cancelar;
    private int comprobado;

    /**
     * Método llamado cuando se crea la actividad.
     * Se inicializan las vistas y se configuran los listeners de los botones.
     *
     * @param savedInstanceState Información de estado anterior de la actividad, si está disponible.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reiniciar_contrasenya);

        nombreUsuario = findViewById(R.id.editTextUsuarioReiniciarContrasenya);
        contrasenya = findViewById(R.id.editTextNuevaContrasenyaReiniciarContrasenya);
        confirmarContrasenya = findViewById(R.id.editTextNuevaContrasenyaConfirmacionReiniciarContrasenya);
        reiniciarContrasenya = findViewById(R.id.buttonConfirmarReiniciarContrasenya);
        cancelar = findViewById(R.id.cancelarReiniciarContrasenya);


        cancelar.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        reiniciarContrasenya.setOnClickListener(view ->  {
            if (contrasenya.getText().toString().equals(confirmarContrasenya.getText().toString())){
                executeCall(new CallInterface() {
                    @Override
                    public void doInBackground() {
                        comprobado = Connector.getConector().put(Integer.class, null, "usuario/changePassword/&tag="+nombreUsuario.getText().toString() + "&pass=" + contrasenya.getText().toString());
                    }

                    @Override
                    public void doInUI() {
                        if(comprobado>0){
                            setResult(RESULT_OK);
                            Toast.makeText(getBaseContext(), "Contraseña reiniciada", Toast.LENGTH_SHORT).show();
                            finish();
                        } else{
                            Toast.makeText(getBaseContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }else {
                Toast.makeText(this, "La contraseñas no coinciden", Toast.LENGTH_SHORT).show();
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
