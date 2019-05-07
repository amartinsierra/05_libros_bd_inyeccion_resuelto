package graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import adaptadores.AdaptadorLista;
import beans.Libro;

//import di.DaggerIntefazDependencias;
import di.DaggerIntefazDependencias;
import di.GestorDependencias;
import modelo.DBLibros;

public class ListadoActivity extends Activity {
    String titulo;
    ListView ls;
    @Inject
    DBLibros db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        ls= (this.findViewById(R.id.lstLibros));
        DaggerIntefazDependencias.builder().gestorDependencias(new GestorDependencias(this)).build().inject2(this);
        //DaggerIntefazDependencias.builder().build().inject2(this);
        cargarLista();
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv=view.findViewById(R.id.tvTitulo);
                titulo=tv.getText().toString();
                AlertDialog.Builder dlg=new AlertDialog.Builder(ListadoActivity.this);
                dlg.setMessage("¿Desea eliminar a "+titulo);
                dlg.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBLibros db=new DBLibros(ListadoActivity.this);
                        db.eliminarPorTitulo(titulo);
                        cargarLista();
                    }
                });
                dlg.setNegativeButton(android.R.string.no,null);
                dlg.show();

            }
        });
    }
    private void cargarLista(){
        //DBLibros db = new DBLibros(this);
        ArrayList<Libro> libros= db.recuperarLibros();
        //creamos una instancia del adaptador personalizado
        //y lo asignamos al ListView
        AdaptadorLista adapter=new AdaptadorLista(this,libros);
        ls.setAdapter(adapter);
    }
    public void salir(View v){
        this.finish();
    }
}
