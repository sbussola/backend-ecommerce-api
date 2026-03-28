package br.com.model;

import java.util.ArrayList;
import java.util.List;




public class Catalago {

    List<Produto> produtos =  new ArrayList<>();

    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
