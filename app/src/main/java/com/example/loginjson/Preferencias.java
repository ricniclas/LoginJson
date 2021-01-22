package com.example.loginjson;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Preferencias {



    public void setInfo(Context context, String key,Object objeto){

        SharedPreferences preferencias = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        try {
            ReturnType(objeto,key,editor);
            editor.apply();
        }catch (Exception exception){Log.e("ERRO",exception.toString());}

    }

    private boolean ReturnType(Object object,String key, SharedPreferences.Editor editor)
    {
        try{
            if(object instanceof Float){
                editor.putFloat(key,(float)object);
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof String){
                editor.putString(key,object.toString());
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof Boolean){
                editor.putBoolean(key,(Boolean) object);
                return true;
            }
        }catch (Exception e){}

        try{
            if(object instanceof Integer){
                editor.putInt(key,(int)object);
                return true;
            }
        }catch (Exception e){}

        return false;
    }

    public String getInfo(Context context, String key){
        SharedPreferences preferencias = context.getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        return preferencias.getString(key,null);
    }


    public void setAllInfo(Context context, Usuario usuario){
        setInfo(context,"nome",usuario.getNome());
        setInfo(context,"email",usuario.getEmail());
        setInfo(context,"produto",usuario.getProduto());
        setInfo(context,"senha",usuario.getSenha());
    }
}
