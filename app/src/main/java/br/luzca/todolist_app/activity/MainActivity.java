package br.luzca.todolist_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;

import br.luzca.todolist_app.R;
import br.luzca.todolist_app.databinding.ActivityMain3Binding;

public class MainActivity extends AppCompatActivity {
    private ActivityMain3Binding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        //define como content
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
         ||super.onSupportNavigateUp();
    }
}