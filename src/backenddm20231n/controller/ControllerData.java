/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Data;
import backenddm20231n.model.dao.DaoData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerData {

    DaoData daoDat;
    
    public Data inserir(Data datEnt) throws SQLException, ClassNotFoundException {
        daoDat = new DaoData();
        Data datSaida = daoDat.inserir(datEnt);
        return datSaida;
    }

    public Data alterar(Data datEnt) throws SQLException, ClassNotFoundException {
        daoDat = new DaoData();
        Data datSaida = daoDat.alterar(datEnt);
        return datSaida;
    }

    public Data buscar(Data datEnt) throws SQLException, ClassNotFoundException {
        daoDat = new DaoData();
        Data datSaida = daoDat.buscar(datEnt);
        return datSaida;
    }

    public Data excluir(Data datEnt) throws SQLException, ClassNotFoundException {
        daoDat = new DaoData();
        Data datSaida = daoDat.excluir(datEnt);
        return datSaida;
    }

    public List<Data> listar(Data datEnt) throws SQLException, ClassNotFoundException {
        daoDat = new DaoData();
        List<Data> listaData = daoDat.listar(datEnt);
        return listaData;


    }
    
}
