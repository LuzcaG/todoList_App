package br.luzca.todolist_app.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.luzca.todolist_app.databinding.FragmentCadSubTarefaBinding;

//classe principal desta tela
public class CadSubTarefaFragment extends Fragment {
    //variavel do binding
    private FragmentCadSubTarefaBinding binding;

    //metodo para criar a visualização do app desta tela
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        //instancia o binding
        binding = FragmentCadSubTarefaBinding.inflate(inflater, container,false);
        //retorna a view(visualização da tela) raiz do binding
        return  binding.getRoot();
    }

}