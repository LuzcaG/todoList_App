package br.luzca.todolist_app.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

        database = AppDatabase.getDatabase(getActivity());

        //define o layout manager do recycle View
        binding.recyclerTarefas.setLayoutManager(new LinearLayoutManager(getContext()));

        //executa a
        new ReadTarefa().execute();

        return  binding.getRoot();
    }
    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>>{

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {
            //guarda na variavel tarefas, as tarefas do BD
            tarefas  = database.getTarefaDao().getAll();
            return  tarefas;

        }

        @Override
        protected void onPostExecute(List<Tarefa> tarefas) {

            adapter = new TarefaAdapter(tarefas, getActivity(), listenerTarefa);

            binding.recyclerTarefas.setAdapter(adapter);
        }
        //implementação da interface OnTarefaClickListener
        private TarefaAdapter.OnTarefaClickListener listenerTarefa = (view, tarefa) -> {
            Bundle bundle = new Bundle();

            bundle.putSerializable("Tarefa", tarefa);

            NavHostFragment.findNavController(PrincipalFragment.this).
                    navigate(R.id.action_principalFragment_to_detalheTarefaFragment, bundle);
        };

    }
}