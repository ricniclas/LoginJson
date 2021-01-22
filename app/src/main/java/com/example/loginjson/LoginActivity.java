package com.example.loginjson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        JsonFile jsonFile = new JsonFile();
        try {
            JsonObject jsonObject = new Gson().fromJson(jsonFile.loadFile(this), JsonObject.class);
            System.out.println("Conteúdo no banco de dados: "+jsonObject.toString());
        }catch (Exception exception){
            exception.printStackTrace();
            System.out.println("Não há arquivo salvo");
        }

        EditText edEmail = findViewById(R.id.ed_loginEmail);
        EditText edSenha = findViewById(R.id.ed_LoginSenha);
        Button btnEnviar = findViewById(R.id.btn_LoginEnviar);
        TextView tvCriarUser = findViewById(R.id.vt_CriarUser);

        Preferencias preferencias = new Preferencias();
        try {
            edEmail.setText(preferencias.getInfo(this,"email"));
        }catch (Exception exception){
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvCriarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateActivity.class));
            }
        });
    }
}