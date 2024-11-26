package es.ieslavereda.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import es.ieslavereda.API.Connector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase BaseActivity que extiende AppCompatActivity y proporciona funcionalidades comunes para las actividades de la aplicación.
 */
public class BaseActivity extends AppCompatActivity {

    protected Connector connector;
    protected ExecutorService executor = Executors.newSingleThreadExecutor();
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected MyProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connector = Connector.getConector();
        progressBar = new MyProgressBar(this);
    }

    /**
     * Ejecuta una tarea en un hilo de fondo y luego ejecuta otra tarea en el hilo principal.
     *
     * @param callInterface La interfaz que contiene los métodos doInBackground() y doInUI() que representan las tareas a realizar en los hilos de fondo y principal respectivamente.
     */
    protected void executeCall(CallInterface callInterface){
        executor.execute(() -> {
            callInterface.doInBackground();
            handler.post(() -> {
                callInterface.doInUI();
            });
        });
    }


    /**
     * Muestra la barra de progreso.
     */
    public void showProgress(){
        progressBar.show();
    }

    /**
     * Oculta la barra de progreso.
     */
    public void hideProgress(){
        progressBar.hide();
    }


    /**
     * Sobreescribe el método para asociar la barra de progreso al ConstraintLayout o RelativeLayout y así poder centrarla y manipular la visibilidad del resto de componentes del ViewGroup.
     *
     * @param layout El identificador del recurso del diseño de la actividad.
     */
    @Override
    public void setContentView(int layout){
        super.setContentView(layout);
        ViewGroup rootView = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
        progressBar.initControl(rootView);
        hideProgress();
    }

}
