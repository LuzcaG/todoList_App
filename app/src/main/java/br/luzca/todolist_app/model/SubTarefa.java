package br.luzca.todolist_app.model;

public class SubTarefa {
    private Long idSubTarefa;
    private String descricao;
    private String foto;
    private boolean concluida;
    private Long idtarefa;

    public Long getIdSubTarefa() {
        return idSubTarefa;
    }

    public void setIdSubTarefa(Long idSubTarefa) {
        this.idSubTarefa = idSubTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Long getIdtarefa() {
        return idtarefa;
    }

    public void setIdtarefa(Long idtarefa) {
        this.idtarefa = idtarefa;
    }
}
