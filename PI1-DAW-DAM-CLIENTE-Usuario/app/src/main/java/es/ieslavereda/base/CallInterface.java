package es.ieslavereda.base;

/**
 * Interfaz que define los métodos para realizar tareas en segundo plano y en el hilo principal.
 */
public interface CallInterface {

    /**
     * Método para realizar tareas en segundo plano.
     */
    void doInBackground();

    /**
     * Método para realizar tareas en el hilo principal (UI thread).
     */
    void doInUI();

}
