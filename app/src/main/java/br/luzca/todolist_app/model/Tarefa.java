package br.luzca.todolist_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    private  Long idtarefa;
    private String titulo;
    private String descricao;
    private Long dtacriacao;
    private Long dtaPrevista;
    private Long dtaFinalizada;


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

    public Long getDtacriacao() {
        return dtacriacao;
    }

    public void setDtacriacao(Long dtacriacao) {
        this.dtacriacao = dtacriacao;
    }

    public Long getDtaPrevista() {
        return dtaPrevista;
    }

    public void setDtaPrevista(Long dtaPrevista) {
        this.dtaPrevista = dtaPrevista;
    }

    public Long getDtaFinalizada() {
        return dtaFinalizada;
    }

    public void setDtaFinalizada(Long dtaFinalizada) {
        this.dtaFinalizada = dtaFinalizada;
    }

    public Long getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(Long idtarefa) {
        this.idtarefa = idtarefa;
    }
}
