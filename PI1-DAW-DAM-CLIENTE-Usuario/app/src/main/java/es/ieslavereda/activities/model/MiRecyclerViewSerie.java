package es.ieslavereda.activities.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.ImageDownloader;

/**
 * Adaptador personalizado para RecyclerView que muestra una lista de series.
 */
public class MiRecyclerViewSerie extends RecyclerView.Adapter<MiRecyclerViewSerie.ViewHolder> {

    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;

    private List<Serie> contenido;

    /**
     * Constructor de la clase.
     *
     * @param context   El contexto de la aplicación.
     * @param contenido La lista de series a mostrar en el RecyclerView.
     */
    public MiRecyclerViewSerie(Context context, List contenido){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contenido = contenido;
    }

    /**
     * Establece el Listener de clics para los elementos del RecyclerView.
     *
     * @param onClickListener El Listener de clics.
     */
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element_series,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Imagen
        ImageDownloader.downloadImage(contenido.get(position).getUrl_image(), holder.imagen);
        //Titulo
        holder.titulo.setText(contenido.get(position).getTitulo());
        //Posicion en lista
        holder.numero.setText((position+1)>10 ? position+1+"" : "0"+position+1+"");
    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }

    /**
     * Clase interna ViewHolder que representa cada elemento de la lista en el RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, numero;
        private ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textViewNombreSerie);
            numero = itemView.findViewById(R.id.textViewNumero);
            imagen = itemView.findViewById(R.id.imagenSerie);
        }
    }
}
