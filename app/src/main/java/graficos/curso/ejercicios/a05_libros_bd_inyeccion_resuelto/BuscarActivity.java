package graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import beans.Libro;
import modelo.DBLibros;

public class BuscarActivity extends AppCompatActivity {
    DBLibros db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        db=new DBLibros(this);
    }

    public void buscar(View v){
        EditText edTitulo=this.findViewById(R.id.edTitulo);
        Libro lb=db.buscador(edTitulo.getText().toString());
        String texto;
        if(lb!=null){
            texto="Titulo: "+lb.getTitulo()+"\n"+"Precio: "+lb.getPrecio()+"\n"+"Fecha: "+lb.getFecha();
        }
        else{
            texto="Libro no encontrado ";
        }
        TextView tv=this.findViewById(R.id.tvResultado);
        tv.setText(texto);
    }
}
