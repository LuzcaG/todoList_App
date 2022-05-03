package br.luzca.todolist_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import br.luzca.todolist_app.R;
import br.luzca.todolist_app.adapter.TarefaAdapter;
import br.luzca.todolist_app.database.AppDatabase;
import br.luzca.todolist_app.databinding.FragmentPrincipalBinding;
import br.luzca.todolist_app.model.Tarefa;


public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;

    private AppDatabase database;

    private TarefaAdapter adapter;

    private List<Tarefa> tarefas;

    public PrincipalFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPrincipalBinding.inflate(inflater, container,false);
        binding.btaddTarefa.setOnClickListener(v -> {
            NavHostFragment.findNavController(PrincipalFragment.this).
                    navigate(R.id.action_principalFragment_to_cadTarefaFragment);
        });

        return  binding.getRoot();
    }
}