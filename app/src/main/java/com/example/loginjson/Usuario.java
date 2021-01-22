package com.example.loginjson;

import android.util.Log;
import android.widget.Toast;

public class Usuario {
    private String nome;
    private String email;
    private String produto;
    private String senha;

    public Usuario(String nome, String email,String produto,String senha){
        this.nome = nome;
        this.email = email;
        this.produto = produto;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return  email;
    }

    public String getProduto(){
        return produto;
    }

    public String getSenha (){return senha;}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public  void setProduto(String produto){
        this.produto = produto;
    }

    public void setSenha(String senha) {this.senha = senha;}

}
