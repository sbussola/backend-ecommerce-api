package br.com.model;

public class Produto  {

    private String nome;
    private String descricao;

    private Double preco;

    private int codigo;

    public Produto(String nome, String descricao, Double preco, int codigo) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.codigo = codigo;


    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
