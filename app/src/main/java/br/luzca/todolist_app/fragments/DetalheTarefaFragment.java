package br.luzca.todolist_app.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;

import br.luzca.todolist_app.databinding.FragmentDetalheTarefaBinding;
import br.luzca.todolist_app.model.Tarefa;


public class DetalheTarefaFragment extends Fragment {
    private Tarefa tarefa;

    private FragmentDetalheTarefaBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalheTarefaBinding.inflate(inflater, container,false);

        if (getArguments() != null){
            tarefa = (Tarefa) getArguments().getSerializable("Tarefa");
            binding.tvContenTitulo.setText(tarefa.getTitulo());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            binding.tvContentdataPrev.setText(formatador.format(tarefa.getDtaPrevista()));
            binding.tvContentDesc.setText(tarefa.getDescricao());

        }

        return  binding.getRoot();
    }

}