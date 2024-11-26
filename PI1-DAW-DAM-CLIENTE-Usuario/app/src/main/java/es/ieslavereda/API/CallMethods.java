package es.ieslavereda.API;


import es.ieslavereda.base.Parameters;

import java.io.IOException;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Clase que encapsula los métodos para realizar llamadas a una API mediante Retrofit.
 *
 * @param <T> Tipo de objeto esperado en la respuesta de las llamadas.
 */
public class CallMethods<T>  {

    private Retrofit retrofit = new Retrofit.Builder().baseUrl(Parameters.URL).build();
    private APIService service = retrofit.create(APIService.class);
    private static CallMethods callMethods;

    /**
     * Obtiene una instancia de CallMethods (implementación del patrón Singleton).
     *
     * @return Una instancia de CallMethods.
     */
    public static CallMethods getCallMethodsObject(){
        if(callMethods == null){
            callMethods = new CallMethods();
        }
        return callMethods;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como una cadena.
     *
     * @param url La URL a la que se realiza la solicitud GET.
     * @return La respuesta del servidor como una cadena, o null si hay un error.
     */
    public String get(String url){
        Call<ResponseBody> call = service.getCall(url);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud GET a la URL especificada y devuelve la respuesta como una cadena.
     *
     * @param url La URL a la que se realiza la solicitud GET.
     * @return La respuesta del servidor como una cadena, o null si hay un error.
     */
    public String post(String url, RequestBody data){
        Call<ResponseBody> call = service.postCall(url, data);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados en el cuerpo y devuelve la respuesta como una cadena.
     *
     * @param url  La URL a la que se realiza la solicitud PUT.
     * @param data Los datos a enviar en el cuerpo de la solicitud.
     * @return La respuesta del servidor como una cadena, o null si hay un error.
     */
    public String put(String url, RequestBody data){
        Call<ResponseBody> call = service.putCall(url, data);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Realiza una solicitud DELETE a la URL especificada y devuelve la respuesta como una cadena.
     *
     * @param url La URL a la que se realiza la solicitud DELETE.
     * @return La respuesta del servidor como una cadena, o null si hay un error.
     */
    public String delete(String url){
        Call<ResponseBody> call = service.deleteCall(url);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
