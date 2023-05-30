/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.bean;


/**
 *
 * @author User
 */
public class Alugador {
    private int idAlugador;
    private String nome;
    private int telefone;
    private int cpf;

    public Alugador(int idAlugador) {
        this.idAlugador = idAlugador;
    }

    public Alugador(String nome) {
        this.nome = nome;
    }

    public Alugador(int idAlugador, String nome, int telefone, int cpf) {
        this.idAlugador = idAlugador;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Alugador(String nome, int telefone, int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getIdAlugador() {
        return idAlugador;
    }

    public void setIdAlugador(int idAlugador) {
        this.idAlugador = idAlugador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Alugador{" + "idAlugador=" + idAlugador + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
   
}
