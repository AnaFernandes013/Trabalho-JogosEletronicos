package br.edu.ifsp;

import java.io.Serializable;
//primeiro java bean
public class Tarefa implements Serializable {

    private static int id_atual = 0; // é uma classe, nao objeto
    private String nome;
    private String desc;
    private int id;

    public Tarefa(){
        this.id = ++id_atual;

    }

    public Tarefa(String nome, String desc){
        this(); // pra chamar o construtor de cima
        this.nome =nome;
        this.desc = desc;

    }


    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public static void setId_atual(int id_atual) {
        Tarefa.id_atual = id_atual;
    }
}
