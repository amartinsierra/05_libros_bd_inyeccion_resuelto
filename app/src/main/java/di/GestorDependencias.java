package di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import modelo.DBLibros;
import modelo.DBLibrosHelper;

@Module
public class GestorDependencias {
    private static Context app;
    public GestorDependencias(Context app){
        this.app=app;
    }

    @Provides
    public Context getContext(){
        return app;
    }

    @Provides
    public DBLibrosHelper getHelper(Context ctx){
        return new DBLibrosHelper(ctx);
    }

    @Provides
    public DBLibros getDbLibros(Context ctx){
        return new DBLibros(ctx);
    }

}
