/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Alugador;
import backenddm20231n.model.bean.Data;
import backenddm20231n.model.bean.Equipamento;
import backenddm20231n.model.bean.Instrumento;
import backenddm20231n.model.bean.Studio;
import backenddm20231n.model.dao.DaoStudio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joão
 */
public class ControllerStudio {
    ControllerInstrumento contInstru;
    ControllerEquipamento contEquip;
      ControllerAlugador contAlu;
    ControllerData contDat;
    DaoStudio daoAludat;
    
    public Studio inserir(Studio aludatEnt) throws SQLException, ClassNotFoundException {
        daoAludat = new DaoStudio();
        aludatEnt = daoAludat.inserir(aludatEnt);
        return aludatEnt;
    }

    public Studio alterar(Studio aludatEnt) throws SQLException, ClassNotFoundException {
        daoAludat = new DaoStudio();
        aludatEnt = daoAludat.alterar(aludatEnt);
        return aludatEnt;
    }

    public List<Studio> listar(Studio aludatEnt) throws SQLException, ClassNotFoundException {
        daoAludat = new DaoStudio();
        List<Studio> listaAludatRetornoAux = daoAludat.listar(aludatEnt);
        List<Studio> listaAludatRetorno = new ArrayList<>();
               
        for(Studio aludat : listaAludatRetornoAux) {        
            listaAludatRetorno.add(buscar(aludat));
        }

        return listaAludatRetorno;
    }

    public Studio excluir(Studio aludatEnt) throws SQLException, ClassNotFoundException {
        daoAludat = new DaoStudio();
       aludatEnt = daoAludat.excluir(aludatEnt);
        return aludatEnt;
    }

    public Studio buscar(Studio aludatEnt) throws SQLException, ClassNotFoundException {

        daoAludat = new DaoStudio();
        Studio aludatSaida = daoAludat.buscar(aludatEnt);

        Alugador aluEnt = new Alugador(aludatSaida.getIdAlugador());
        contAlu = new ControllerAlugador();
        aludatSaida.setAlu(contAlu.buscar(aluEnt));
        
        Data dat = new Data(aludatSaida.getIdData());
        contDat = new ControllerData();
        aludatSaida.setDat(contDat.buscar(dat));

        Instrumento instru = new Instrumento(aludatSaida.getIdInstrumento());
        contInstru = new ControllerInstrumento();
        aludatSaida.setInstru(contInstru.buscar(instru));
        
        Equipamento equip = new Equipamento(aludatSaida.getIdEquipamento());
        contEquip = new ControllerEquipamento();
        aludatSaida.setEquip(contEquip.buscar(equip));
        
        return aludatSaida;
    }
   
    
}
