/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author joão
 */
public class Instrumento {
    private int idInstrumento;
    private String tipo;
    private String obs;

    public Instrumento(int idInstrumento) {
        this.idInstrumento = idInstrumento;
    }

    public Instrumento(String tipo) {
        this.tipo = tipo;
    }

    public Instrumento(int idInstrumento, String tipo, String obs) {
        this.idInstrumento = idInstrumento;
        this.tipo = tipo;
        this.obs = obs;
    }

    public Instrumento(String tipo, String obs) {
        this.tipo = tipo;
        this.obs = obs;
    }
    
    
    public int getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(int idInstrumento) {
        this.idInstrumento = idInstrumento;
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
        return "Instrumento{" + "idInstrumento=" + idInstrumento + ", tipo=" + tipo + ", obs=" + obs + '}';
    }

 

        
    
    
}
