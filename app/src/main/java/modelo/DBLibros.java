package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import beans.Libro;
import di.DaggerIntefazDependencias;
import di.GestorDependencias;


/**
 * Created by antonio on 21/09/2017.
 */

public class DBLibros {
    //Atributos
    private SQLiteDatabase db=null;
    @Inject
    DBLibrosHelper dbhelper;

    //Contexto
    Context context;

    public DBLibros(Context ctx){
        DaggerIntefazDependencias.builder().gestorDependencias(new GestorDependencias(ctx)).build().inject(this);
        this.context=ctx;
        //crea una instancia del helper
        //dbhelper=new DBLibrosHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void agregarLibro(String titulo, String autor, float precio){
        //crea el contentvalues y añade una entrada
        //por cada dato del libro a guardar
        ContentValues initialValues=new ContentValues();
        initialValues.put("titulo", titulo);
        initialValues.put("autor", autor);
        initialValues.put("precio", precio);
        initialValues.put("fecha",new Date().getTime());
        db.insert("libros", null, initialValues);

    }
    public ArrayList<Libro> recuperarLibros(){
        Cursor c= db.query("libros",
                new String[]{"_id", "titulo","precio","fecha"},
                null,
                null,
                null,
                null,
                null
                );
        ArrayList<Libro> libros=new ArrayList<>();
        while(c.moveToNext()){
            libros.add(new Libro(c.getString(1),
                    null,
                    c.getFloat(2),
                    new Date(c.getLong(3))));

        }
        return libros;
    }
    public void eliminarPorTitulo(String titulo){
        db.delete("libros","titulo=?",new String[]{titulo});
        db.close();
    }


    public Libro buscador(String titulo){
        Libro lb=null;
        Cursor c= db.query("libros",
                new String[]{"_id", "titulo","precio","fecha"},
                "titulo like ?",
                new String[]{"%"+titulo+"%"},
                null,
                null,
                null
        );
        if(c.moveToNext()){
            lb=new Libro(c.getString(1),
                    null,
                    c.getFloat(2),
                    new Date(c.getLong(3)));
        }
        return lb;
    }
}
