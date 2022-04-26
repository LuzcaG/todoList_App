package br.luzca.todolist_app.fragments;


import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import br.luzca.todolist_app.R;
import br.luzca.todolist_app.database.AppDatabase;
import br.luzca.todolist_app.databinding.FragmentCadTarefaBinding;
import br.luzca.todolist_app.model.Tarefa;


public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    DatePickerDialog datePicker;
    int year, month, day;
    Calendar dataAtual;
    String dataEscolhida = "";

    AppDatabase database;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentCadTarefaBinding.inflate(inflater, container, false);
        database = AppDatabase.getDatabase(getActivity());
        dataAtual = Calendar.getInstance();

        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        datePicker = new DatePickerDialog(getContext(), (view, ano, mes, dia) -> {
            year = ano;
            month = mes;
            day = dia;
            dataEscolhida = String.format("%02d/%02d/%04d", day, month + 1, year);
            binding.btData.setText(dataEscolhida);
        }, year, month, day);

        binding.btData.setOnClickListener(v -> {
            //abre o datepicke
            datePicker.show();
        });
        binding.btSalvar.setOnClickListener(v -> {
            if (binding.edTitulo.getText().toString().isEmpty()) {
                binding.edTitulo.setError(getString(R.string.msgTitulo));
                binding.edTitulo.requestFocus();
            } else if (binding.edDescTarefa.getText().toString().isEmpty()) {
                binding.edDescTarefa.setError(getString(R.string.msgDescTarefa));
                binding.edDescTarefa.requestFocus();
            } else if (dataEscolhida.isEmpty()) {
                Toast.makeText(getActivity().getBaseContext(), R.string.msgData,
                        Toast.LENGTH_SHORT).show();
            } else {
                Tarefa tarefa  = new Tarefa();

                tarefa.setTitulo(binding.edTitulo.getText().toString());
                tarefa.setDescricao(binding.edDescTarefa.getText().toString());
                Calendar dataRealizacao = Calendar.getInstance();
                dataRealizacao.set(year,month,day);

                tarefa.setDtaPrevista(dataRealizacao.getTimeInMillis());

                Calendar datatAtual = Calendar.getInstance();
                tarefa.setDtacriacao(datatAtual.getTimeInMillis());



                new InsertTarefa().execute(tarefa);
            }

        });
        return binding.getRoot();

    }

    //classe pare a task de inserir Tarefa
    private  class  InsertTarefa extends AsyncTask<Tarefa, Void, String> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            Log.w("passou por aqui", "no onPreExecute" );
        }

        @Override
        protected String doInBackground(Tarefa... tarefas) {
            Log.w("Passou por aqui", "no doInBackground");

            Tarefa t = tarefas[0];
            try {
                database.getTarefaDao().insert(t);
                return "ok";
            }catch (Exception e){
                e.printStackTrace();
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String msg) {
            if (msg.equals("ok")){
                Log.w("RESULTADO", "IUPIIIIIII");
                Toast.makeText(getContext(),"salvo com sucesso!!!", Toast.LENGTH_SHORT).show();
            }else{
                Log.w("RESULTADO", msg);
                Toast.makeText(getContext(),"salvo com fracasso!!!"+ msg, Toast.LENGTH_SHORT).show();
            }
            Log.w("passou por aqui", " no onPostExecute");
        }
    }

}