/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author joão
 */
public class Equipamento {
    private int idEquipamento;
    private String tipo;
    private String obs;

    public Equipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Equipamento(String tipo) {
        this.tipo = tipo;
    }

    public Equipamento(int idEquipamento, String tipo, String obs) {
        this.idEquipamento = idEquipamento;
        this.tipo = tipo;
        this.obs = obs;
    }

    public Equipamento(String tipo, String obs) {
        this.tipo = tipo;
        this.obs = obs;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Equipamento{" + "idEquipamento=" + idEquipamento + ", tipo=" + tipo + ", obs=" + obs + '}';
    }

    

}
