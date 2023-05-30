/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author joão
 */
public class Data {
    private int idData;
    private String data;
    private String periodo;

    public Data(int idData) {
        this.idData = idData;
    }

    public Data(String data) {
        this.data = data;
    }

    public Data(int idData, String data, String periodo) {
        this.idData = idData;
        this.data = data;
        this.periodo = periodo;
    }

    public Data(String data, String periodo) {
        this.data = data;
        this.periodo = periodo;
    }

    public int getIdData() {
        return idData;
    }

    public void setIdData(int idData) {
        this.idData = idData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Data{" + "idData=" + idData + ", data=" + data + ", periodo=" + periodo + '}';
    }

    
    

    
}
