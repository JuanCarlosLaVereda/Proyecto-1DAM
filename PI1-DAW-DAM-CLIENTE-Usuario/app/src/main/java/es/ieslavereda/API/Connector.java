package es.ieslavereda.API;


import es.ieslavereda.base.Parameters;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Clase que actúa como conector entre la API y la lógica de la aplicación.
 */
public class Connector{

    private static Connector connector;
    private static Conversor conversor;
    private static CallMethods callMethodsObject;

    /**
     * Obtiene una instancia de Connector (implementación del patrón Singleton).
     *
     * @return Una instancia de Connector.
     */
    public static Connector getConector(){
        if(connector == null){
            connector = new Connector();
            conversor = Conversor.getConversor();
            callMethodsObject = CallMethods.getCallMethodsObject();
        }
        return connector;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como una lista de objetos del tipo especificado.
     *
     * @param clazz La clase del tipo de objeto esperado en la respuesta.
     * @param path  El camino relativo del recurso en la API.
     * @param <T>   El tipo de objeto esperado en la respuesta.
     * @return Una lista de objetos del tipo especificado, o null si hay un error.
     */
    public <T> List<T> getAsList(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJsonList(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como un objeto del tipo especificado.
     *
     * @param clazz La clase del tipo de objeto esperado en la respuesta.
     * @param path  El camino relativo del recurso en la API.
     * @param <T>   El tipo de objeto esperado en la respuesta.
     * @return Un objeto del tipo especificado, o null si hay un error.
     */
    public <T> T get(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.get(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud POST a la URL especificada con los datos proporcionados y devuelve la respuesta como un objeto del tipo especificado.
     *
     * @param clazz La clase del tipo de objeto esperado en la respuesta.
     * @param data  El objeto de datos a enviar en la solicitud.
     * @param path  El camino relativo del recurso en la API.
     * @param <T>   El tipo de objeto esperado en la respuesta.
     * @return Un objeto del tipo especificado, o null si hay un error.
     */
    public <T> T post(Class<T> clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.post(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados y devuelve la respuesta como un objeto del tipo especificado.
     *
     * @param clazz La clase del tipo de objeto esperado en la respuesta.
     * @param data  El objeto de datos a enviar en la solicitud.
     * @param path  El camino relativo del recurso en la API.
     * @param <T>   El tipo de objeto esperado en la respuesta.
     * @return Un objeto del tipo especificado, o null si hay un error.
     */
    public <T> T put(Class<T> clazz, T data, String path){
        String url = Parameters.URL + path;
        String jsonObject = conversor.toJson(data);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject);
        String jsonResponse = callMethodsObject.put(url, body);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

    /**
     * Realiza una solicitud DELETE a la URL especificada y devuelve la respuesta como un objeto del tipo especificado.
     *
     * @param clazz La clase del tipo de objeto esperado en la respuesta.
     * @param path  El camino relativo del recurso en la API.
     * @param <T>   El tipo de objeto esperado en la respuesta.
     * @return Un objeto del tipo especificado, o null si hay un error.
     */
    public <T> T delete(Class<T> clazz, String path){
        String url = Parameters.URL + path;
        String jsonResponse = callMethodsObject.delete(url);
        if(jsonResponse != null)
            return conversor.fromJson(jsonResponse, clazz);
        return null;
    }

}

