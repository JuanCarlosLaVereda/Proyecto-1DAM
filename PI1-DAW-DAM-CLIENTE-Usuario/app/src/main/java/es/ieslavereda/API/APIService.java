package es.ieslavereda.API;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * Interfaz que define los métodos para realizar llamadas a una API mediante Retrofit.
 */
interface APIService {

    /**
     * Realiza una solicitud GET a la URL especificada.
     *
     * @param url La URL a la que se realiza la solicitud.
     * @return Una instancia de Call que representa la solicitud HTTP asíncrona.
     */
    @GET
    Call<ResponseBody> getCall(@Url String url);

    /**
     * Realiza una solicitud POST a la URL especificada con los datos proporcionados en el cuerpo.
     *
     * @param url  La URL a la que se realiza la solicitud.
     * @param data Los datos a enviar en el cuerpo de la solicitud.
     * @return Una instancia de Call que representa la solicitud HTTP asíncrona.
     */
    @POST
    Call<ResponseBody> postCall(@Url String url, @Body RequestBody data);

    /**
     * Realiza una solicitud PUT a la URL especificada con los datos proporcionados en el cuerpo.
     *
     * @param url  La URL a la que se realiza la solicitud.
     * @param data Los datos a enviar en el cuerpo de la solicitud.
     * @return Una instancia de Call que representa la solicitud HTTP asíncrona.
     */
    @PUT
    Call<ResponseBody> putCall(@Url String url, @Body RequestBody data);

    /**
     * Realiza una solicitud DELETE a la URL especificada.
     *
     * @param url La URL a la que se realiza la solicitud.
     * @return Una instancia de Call que representa la solicitud HTTP asíncrona.
     */
    @DELETE
    Call<ResponseBody> deleteCall(@Url String url);
}