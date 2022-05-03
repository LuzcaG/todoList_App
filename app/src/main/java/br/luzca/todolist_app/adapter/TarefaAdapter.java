package br.luzca.todolist_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.luzca.todolist_app.R;
import br.luzca.todolist_app.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>{

    private List<Tarefa> tarefas;
    private Context context;

    //construtor para receber os valores
    public TarefaAdapter(List<Tarefa> lista, Context contexto){
        this.tarefas = lista;
        this.context = contexto;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infla o layout do adapter
        View view  = LayoutInflater.from(context)
                .inflate(R.layout.adapter_tarefa, parent, false);
        //retorna um novo viewHolder com a view
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        //obtem a tarefa pela position
        Tarefa t = tarefas.get(position);
        holder.tvTitulo.setText(t.getTitulo());
        //se estiver concluida
        if (t.isConcluida()){
            holder.tvStatus.setText("Concluida");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.green));
        }else{
            holder.tvStatus.setText("Aberta");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.yellow));
        }

        //formata a data de Long a String
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvData.setText(formatador.format(t.getDtaPrevista()));
    }

    @Override
    //quantidade de elementos a serem exibidos na lista
    public int getItemCount() {
        if (tarefas != null){
            return  tarefas.size();
        }
        return 0;
    }

    class TarefaViewHolder extends RecyclerView.ViewHolder{
        //variaveis para acessar os componentes do XML
        TextView tvTitulo, tvData, tvStatus;

        public TarefaViewHolder(View view){
            //chama o construtor da sueperclasse
            super(view);
            //passar para as variaveis ,os componentes do XML

            tvTitulo = view.findViewById(R.id.tarefaNametxt);
            tvData = view.findViewById(R.id.dtaConclusaotxt);
            tvStatus = view.findViewById(R.id.StatusTarefatxt);
        }
    }
}
