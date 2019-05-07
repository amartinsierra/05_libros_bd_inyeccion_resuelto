package graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


//la versión 2
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void agregar(View v){
        Intent intent=new Intent(this,AgregarActivity.class);
        this.startActivity(intent);
    }
    public void mostrar(View v){
        Intent intent=new Intent(this,ListadoActivity.class);
        this.startActivity(intent);
    }
}
