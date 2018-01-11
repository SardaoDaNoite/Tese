package com.example.ricardosousa.tese;

/**
 * Created by Ricardo Sousa on 1/11/2018.
 */

public class Paciente_Info_Lista {
    public int idade;
    public String Nome;
    public String sexo;
    public Paciente_Info_Lista(){
        super();
    }

    public Paciente_Info_Lista(String nome, String sexo, int Idade) {
        super();
        this.Nome = nome;
        this.sexo = sexo;
        this.idade = Idade;
    }
}
