package com.example.integrador_crud_pos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.integrador_crud_pos.R;
import com.example.integrador_crud_pos.dto.UserDTO;
import com.example.integrador_crud_pos.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    private static final String TAG = "CadastroActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void salvar(View view) {
        String email = ((EditText)findViewById(R.id.et_cadastro_email)).getText().toString();
        String nome  = ((EditText)findViewById(R.id.et_cadastro_nome)).getText().toString();
        String senha = ((EditText)findViewById(R.id.et_cadastro_senha)).getText().toString();
        String telefone = ((EditText)findViewById(R.id.et_cadastro_telefone)).getText().toString();

        UserDTO userDTO = new UserDTO(email, nome, senha, telefone);

        RetrofitService.getServico(this).cadastrarUsuario(userDTO).enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso com ID = "+response.body().getId(), Toast.LENGTH_SHORT).show(); //ctrl+j começa da digitar e ele completa com o template

                Log.d(TAG, "OnResponse: "+response.raw().body());
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {
                Log.d(TAG, "OnFailure: "+ t.getMessage());

            }
        });
    }

}
