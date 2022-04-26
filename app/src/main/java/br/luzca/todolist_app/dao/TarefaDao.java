package br.luzca.todolist_app.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.luzca.todolist_app.model.Tarefa;

@Dao
public interface TarefaDao {
    @Insert
     void insert(Tarefa t);

    @Delete
    void delete(Tarefa t);

    @Query("select * from tarefa")
    List<Tarefa> getAll();
}
