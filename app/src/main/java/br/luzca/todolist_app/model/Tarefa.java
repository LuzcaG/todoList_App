package br.luzca.todolist_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Tarefa implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private  long idtarefa;
    private String titulo;
    private String descricao;
    private long dtacriacao;
    private long dtaPrevista;
    private long dtaFinalizada;


    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getDtacriacao() {
        return dtacriacao;
    }

    public void setDtacriacao(long dtacriacao) {
        this.dtacriacao = dtacriacao;
    }

    public long getDtaPrevista() {
        return dtaPrevista;
    }

    public void setDtaPrevista(long dtaPrevista) {
        this.dtaPrevista = dtaPrevista;
    }

    public long getDtaFinalizada() {
        return dtaFinalizada;
    }

    public void setDtaFinalizada(long dtaFinalizada) {
        this.dtaFinalizada = dtaFinalizada;
    }

    public long getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(long idtarefa) {
        this.idtarefa = idtarefa;
    }

    //verifica se a tarefa esta concluida
    public boolean isConcluida(){
        return  dtaFinalizada != 0;
    }
}
