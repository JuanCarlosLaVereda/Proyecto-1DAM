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
import es.ieslavereda.base.ImageDownloader;

/**
 * Adaptador personalizado para RecyclerView que muestra una lista de productos en el carrito de compras.
 */
public class MiRecyclerViewCarrito extends RecyclerView.Adapter<MiRecyclerViewCarrito.ViewHolder> {

    private List<Contenido> contenidos;
    private Context context;
    private LayoutInflater layoutInflater;

    /**
     * Constructor de la clase.
     *
     * @param contenidos La lista de contenidos a mostrar en el RecyclerView.
     * @param context    El contexto de la aplicación.
     */
    public MiRecyclerViewCarrito(List contenidos, Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contenidos = contenidos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element_carrito,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewNombre.setText(contenidos.get(position).getTitulo());
        holder.textViewPrecio.setText("8 €");
        ImageDownloader.downloadImage(contenidos.get(position).getUrl_image(), holder.imageViewProducto);
    }

    @Override
    public int getItemCount() {
        return contenidos.size();
    }

    /**
     * Clase interna ViewHolder que representa cada elemento de la lista en el RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewPrecio;
        ImageView imageViewProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
            imageViewProducto = itemView.findViewById(R.id.imageViewImagen);
        }
    }
}