package es.ieslavereda.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

/**
 * Clase utilitaria para descargar imágenes y mostrarlas en ImageViews.
 */
public class ImageDownloader {

    private static RequestQueue colaPeticiones ;
    private final static String TAG = ImageDownloader.class.getName();

    /**
     * Descarga una imagen de la URL especificada y la muestra en el ImageView utilizando la biblioteca Picasso.
     *
     * @param url       La URL de la imagen a descargar.
     * @param imageView El ImageView donde se mostrará la imagen.
     */
    public static void downloadImage(String url, ImageView imageView){
        Picasso.get().load(url).into(imageView);
    }

    /**
     * Descarga una imagen de la URL especificada y la muestra en el ImageView utilizando la biblioteca Volley.
     * Si ocurre un error al descargar la imagen, se muestra una imagen predeterminada.
     *
     * @param context        El contexto de la aplicación.
     * @param url            La URL de la imagen a descargar.
     * @param imageView      El ImageView donde se mostrará la imagen.
     * @param defaultDrawable El recurso de imagen predeterminado a mostrar en caso de error.
     */
    public static void downloadImage(Context context, String url, ImageView imageView, int defaultDrawable){
        ImageRequest peticion = new ImageRequest(
                url,
                new Response.Listener<Bitmap>() {
                    @Override public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null, // maxWidth, maxHeight, decodeConfig
                new Response.ErrorListener() {
                    @Override public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(defaultDrawable);
                        Log.e(TAG,error.getMessage());
                    }
                }
        );
        getRequestQueue(context).add(peticion);
    }

    /**
     * Obtiene la cola de peticiones Volley.
     *
     * @param context El contexto de la aplicación.
     * @return La cola de peticiones Volley.
     */
    private static RequestQueue getRequestQueue(Context context){
        if(colaPeticiones==null)
            colaPeticiones = Volley.newRequestQueue(context);
        return colaPeticiones;
    }
}
