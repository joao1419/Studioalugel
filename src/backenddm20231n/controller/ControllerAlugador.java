/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Alugador;
import backenddm20231n.model.dao.DaoAlugador;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerAlugador {

    DaoAlugador daoAlu;
    
    public Alugador inserir(Alugador aluEnt) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAlugador();
        Alugador aluSaida = daoAlu.inserir(aluEnt);
        return aluSaida;
    }

    public Alugador alterar(Alugador aluEnt) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAlugador();
        Alugador aluSaida = daoAlu.alterar(aluEnt);
        return aluSaida;
    }

    public Alugador buscar(Alugador aluEnt) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAlugador();
        Alugador aluSaida = daoAlu.buscar(aluEnt);
        return aluSaida;
    }

    public Alugador excluir(Alugador aluEnt) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAlugador();
        Alugador aluSaida = daoAlu.excluir(aluEnt);
        return aluSaida;
    }

    public List<Alugador> listar(Alugador aluEnt) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAlugador();
        List<Alugador> listaAlugador = daoAlu.listar(aluEnt);
        return listaAlugador;


    }
    
}
