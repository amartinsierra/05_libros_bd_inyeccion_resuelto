package graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;


//import di.DaggerIntefazDependencias;
import di.DaggerIntefazDependencias;
import di.GestorDependencias;
import modelo.DBLibros;

public class AgregarActivity extends Activity {

    @Inject
    DBLibros db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        //DaggerIntefazDependencias.builder().build().inject3(this);
        DaggerIntefazDependencias.builder().gestorDependencias(new GestorDependencias(this)).build().inject3(this);
    }
    public void guardar(View v){
       // DBLibros db=new DBLibros(this);
        String titulo=((EditText)this.findViewById(R.id.edtTitulo)).getText().toString();
        String precio=((EditText)this.findViewById(R.id.edtPrecio)).getText().toString();
        String autor=((EditText)this.findViewById(R.id.edtAutor)).getText().toString();
        //crear ContentValue
        db.agregarLibro(titulo,autor,Float.parseFloat(precio));
        db.close();
        this.finish();
    }
}
