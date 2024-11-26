package es.ieslavereda.API;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Clase que proporciona métodos para convertir objetos Java en formato JSON y viceversa utilizando la biblioteca Gson.
 */
public class Conversor {
    private static Gson gson;
    private static Conversor conversor;


    /**
     * Obtiene una instancia del Conversor (implementación del patrón Singleton).
     *
     * @return Una instancia del Conversor.
     */
    public  static Conversor getConversor() {
        if (conversor==null) {
            gson = new Gson();
            conversor=new Conversor();
        }
        return conversor;
    }

    /**
     * Convierte un objeto Java en formato JSON.
     *
     * @param data El objeto Java a convertir.
     * @param <T>  El tipo de objeto.
     * @return El objeto convertido en formato JSON.
     */
    public <T> String toJson(T data){
        String json = gson.toJson(data);
        return json;
    }

    /**
     * Convierte una lista de objetos Java en formato JSON.
     *
     * @param data La lista de objetos Java a convertir.
     * @param <T>  El tipo de objeto.
     * @return La lista de objetos convertida en formato JSON.
     */
    public <T> String toJson(List<T> data){
        String json = gson.toJson(data);
        return json;
    }

    /**
     * Convierte una cadena JSON en un objeto Java del tipo especificado.
     *
     * @param json  La cadena JSON a convertir.
     * @param clazz La clase del tipo de objeto Java.
     * @param <T>   El tipo de objeto.
     * @return El objeto Java convertido.
     */
    public <T> T fromJson(String json, Class<T> clazz){
        T object = gson.fromJson(json, clazz);
        return object;
    }

    /**
     * Convierte una cadena JSON en una lista de objetos Java del tipo especificado.
     *
     * @param json  La cadena JSON a convertir.
     * @param clazz La clase del tipo de objeto Java.
     * @param <T>   El tipo de objeto.
     * @return La lista de objetos Java convertida.
     */
    public <T> List<T> fromJsonList(String json, Class<T> clazz){
        Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
        List<T> object = gson.fromJson(json, typeOfT);
        return object;
    }

}
