package com.example.loginjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNome = findViewById(R.id.ed_loginEmail);
        EditText editTextEmail = findViewById(R.id.ed_emailUser);
        EditText ediTextSenha = findViewById(R.id.ed_senha);
        EditText editTextConfirmSenha = findViewById(R.id.ed_confirmSenha);

        Spinner spinner = findViewById(R.id.spinner_produtos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.itens, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Button btnEnviar = findViewById(R.id.btn_LoginEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextNome.getText().toString().trim().length() > 0 &&
                        editTextEmail.getText().toString().trim().length() > 0) {
                    if (ediTextSenha.getText().toString().trim().length() > 0) {
                        if (ediTextSenha.getText().toString().equals(editTextConfirmSenha.getText().toString())) {
                            try {Usuario usuario = new Usuario(editTextNome.getText().toString(), editTextEmail.getText().
                                        toString(), spinner.getSelectedItem().toString(), ediTextSenha.getText().toString());


/*
                                JsonObject jsonObject = null;
                                JsonArray jsonArray = new JsonArray();
                                JsonFile jsonFile = new JsonFile();
                                jsonObject = jsonFile.convertUserToJsonObject(usuario);
                                JsonObject bigObject = new JsonObject();
                                bigObject.add("id",jsonObject);
                                jsonArray.add(jsonObject);
                                jsonFile.saveFile(v.getContext(),jsonFile.getJsonObject(usuario));

                                //Log.d("Teste Json", jsonObject.toString());

                                Toast.makeText(v.getContext(), "Usuario criado com sucesso", Toast.LENGTH_SHORT).show();
                                jsonArray.add(jsonFile.convertStringToJsonObject(jsonFile.loadFile(v.getContext())));
                                System.out.println("Informação no arquivo"+jsonFile.loadFile(v.getContext()));
                                System.out.println("Retorno da array"+jsonArray.toString());
*/
                                JsonFile jsonFile = new JsonFile();
                                jsonFile.createNewUser(v.getContext(),usuario);

                                Preferencias preferencias = new Preferencias();
                                preferencias.setAllInfo(v.getContext(),usuario);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            //Toast.makeText(v.getContext(), "As senhas são diferentes", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        //Toast.makeText(v.getContext(),"Digite sua senha",Toast.LENGTH_SHORT).show();
                    }}
                else {
                        //Toast.makeText(v.getContext(),"Marque todos os campos",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}