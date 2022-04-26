package br.luzca.todolist_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.luzca.todolist_app.databinding.FragmentPrincipalBinding;


public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPrincipalBinding.inflate(inflater, container,false);

        return  binding.getRoot();
    }
}