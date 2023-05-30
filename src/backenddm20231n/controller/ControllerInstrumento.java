/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Instrumento;
import backenddm20231n.model.dao.DaoInstrumento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerInstrumento {

    DaoInstrumento daoinstru;
    
    public Instrumento inserir(Instrumento instruEnt) throws SQLException, ClassNotFoundException {
        daoinstru = new DaoInstrumento();
        Instrumento instruSaida = daoinstru.inserir(instruEnt);
        return instruSaida;
    }

    public Instrumento alterar(Instrumento instruEnt) throws SQLException, ClassNotFoundException {
        daoinstru = new DaoInstrumento();
        Instrumento instruSaida = daoinstru.alterar(instruEnt);
        return instruSaida;
    }

    public Instrumento buscar(Instrumento instruEnt) throws SQLException, ClassNotFoundException {
        daoinstru = new DaoInstrumento();
        Instrumento instruSaida = daoinstru.buscar(instruEnt);
        return instruSaida;
    }

    public Instrumento excluir(Instrumento instruEnt) throws SQLException, ClassNotFoundException {
        daoinstru = new DaoInstrumento();
        Instrumento instruSaida = daoinstru.excluir(instruEnt);
        return instruSaida;
    }

    public List<Instrumento> listar(Instrumento instruEnt) throws SQLException, ClassNotFoundException {
        daoinstru = new DaoInstrumento();
        List<Instrumento> listaInstrumento = daoinstru.listar(instruEnt);
        return listaInstrumento;


    }
    
}
