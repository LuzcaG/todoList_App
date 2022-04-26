package br.luzca.todolist_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import br.luzca.todolist_app.R;
import br.luzca.todolist_app.databinding.ActivityMain3Binding;

public class MainActivity extends AppCompatActivity {
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        //define como content
        setContentView(binding.getRoot());
    }
}