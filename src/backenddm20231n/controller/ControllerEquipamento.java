/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Equipamento;
import backenddm20231n.model.dao.DaoEquipamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerEquipamento {

    DaoEquipamento daoequip;
    
    public Equipamento inserir(Equipamento equipEnt) throws SQLException, ClassNotFoundException {
        daoequip = new DaoEquipamento();
        Equipamento equipSaida = daoequip.inserir(equipEnt);
        return equipSaida;
    }

    public Equipamento alterar(Equipamento equipEnt) throws SQLException, ClassNotFoundException {
        daoequip = new DaoEquipamento();
        Equipamento equipSaida = daoequip.alterar(equipEnt);
        return equipSaida;
    }

    public Equipamento buscar(Equipamento equipEnt) throws SQLException, ClassNotFoundException {
        daoequip = new DaoEquipamento();
        Equipamento equipSaida = daoequip.buscar(equipEnt);
        return equipSaida;
    }

    public Equipamento excluir(Equipamento equipEnt) throws SQLException, ClassNotFoundException {
        daoequip = new DaoEquipamento();
        Equipamento equipSaida = daoequip.excluir(equipEnt);
        return equipSaida;
    }

    public List<Equipamento> listar(Equipamento equipEnt) throws SQLException, ClassNotFoundException {
        daoequip = new DaoEquipamento();
        List<Equipamento> listaEquipamento = daoequip.listar(equipEnt);
        return listaEquipamento;


    }
    
}
