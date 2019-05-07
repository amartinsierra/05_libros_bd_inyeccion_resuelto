package di;

import javax.inject.Singleton;

import dagger.Component;

import graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto.AgregarActivity;
import graficos.curso.ejercicios.a05_libros_bd_inyeccion_resuelto.ListadoActivity;
import modelo.DBLibros;
@Singleton
@Component(modules = {GestorDependencias.class})
public interface IntefazDependencias {
    void inject(DBLibros libs);
    void inject2(ListadoActivity la);
    void inject3(AgregarActivity aa);
}
