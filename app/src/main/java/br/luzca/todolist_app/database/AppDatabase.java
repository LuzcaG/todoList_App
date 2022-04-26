package br.luzca.todolist_app.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.luzca.todolist_app.dao.TarefaDao;
import br.luzca.todolist_app.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //atributo para acessar a database
    private static AppDatabase database;
    public abstract TarefaDao getTarefaDao();


    public static  AppDatabase getDatabase(Context context){
        //verificação se não esta intanciando
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "todolist").build();
        }
        return database;
    }
}
