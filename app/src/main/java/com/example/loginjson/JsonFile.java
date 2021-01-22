package com.example.loginjson;

import android.content.Context;
import android.os.Debug;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

public class JsonFile {
    private static final String FILE_NAME="dadosJson.txt";

    public String getJsonObject(Usuario usuario){
        Gson gson = new Gson();
        String json = gson.toJson(usuario);
        return json;
    }



    public void createNewUser(Context context, Usuario usuario){
        JsonObject jsonObject = null;
        JsonArray jsonArray = new JsonArray();
        JsonFile jsonFile = new JsonFile();
        try {
            String jsonAtual = loadFile(context);
            Toast.makeText(context,"Encontrou arquivo",Toast.LENGTH_LONG).show();
            jsonObject = convertStringToJsonObject(jsonAtual);
            JsonObject addJsonObject = convertUserToJsonObject(usuario);


            jsonArray.add(jsonObject);
            jsonArray.add(addJsonObject);
            jsonFile.saveFile(context,jsonArray.toString());
            System.out.println("Conteúdo do arquivo: "+jsonArray.toString());
        } catch (Exception exception) {
            exception.printStackTrace();

            Toast.makeText(context,"Não encontrou arquivo",Toast.LENGTH_LONG).show();
            jsonObject = convertUserToJsonObject(usuario);
            jsonArray.add(jsonObject);
            jsonFile.saveFile(context,jsonArray.toString());
            System.out.println("Conteúdo do arquivo: "+jsonArray.toString());
        }
    }

    public JsonObject convertUserToJsonObject (Usuario usuario){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nome",usuario.getNome());
        jsonObject.addProperty("email",usuario.getEmail());
        jsonObject.addProperty("produto",usuario.getProduto());
        jsonObject.addProperty("email",usuario.getSenha());
        JsonArray bigObject = new JsonArray();
        bigObject.add(bigObject);

        return jsonObject;
    }

    public JsonObject convertStringToJsonObject(String texto){
        JsonObject jsonObject = new Gson().fromJson(texto, JsonObject.class);
    return jsonObject;
    }

public void saveFile(Context context,String content){

    FileOutputStream fos = null;
    try{
        fos = context.openFileOutput(FILE_NAME,MODE_PRIVATE);
        fos.write(content.getBytes());
        Toast.makeText(context,"Salvou em: " +context.getFilesDir()
                + "/"+ FILE_NAME,Toast.LENGTH_LONG).show();
    }
    catch (Exception ex){

    }finally {
        if(fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

public String loadFile(Context context){
    FileInputStream fis = null;
    try {
        fis = context.openFileInput(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String text;

        while ((text = br.readLine()) != null){
            sb.append(text).append("\n");
        }

        return sb.toString();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        if (fis != null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return null;
}

}