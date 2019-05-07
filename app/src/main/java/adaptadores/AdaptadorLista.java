package adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import beans.Libro;
import graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto.R;


/**
 * Created by antonio on 21/09/2017.
 */

public class AdaptadorLista extends BaseAdapter {
    private Context ctx;
    private List<Libro> libros;
    LayoutInflater inflater;
    public AdaptadorLista(Context ctx, List<Libro> libros){
        this.ctx=ctx;
        this.libros=libros;
        inflater= LayoutInflater.from(ctx);

    }


    @Override
    public int getCount() {
        return libros.size();
    }

    @Override
    public Object getItem(int i) {
        return libros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Libro l=libros.get(i);
        //asigna al View que representa cada posiciÃ³n de la lista la plantilla
        //que define cada elemento de una fila
        view= inflater.inflate(R.layout.fila, null);
        TextView tTitulo=view.findViewById(R.id.tvTitulo);
        tTitulo.setText(l.getTitulo());
        TextView tPrecio=view.findViewById(R.id.tvPrecio);
        tPrecio.setText(l.getPrecio()+"");
        TextView tFecha=view.findViewById(R.id.tvFecha);
        //formateado de fecha
        DateFormat df=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM, new Locale("es"));
        tFecha.setText(df.format(l.getFecha()));
        return view;
    }
}
