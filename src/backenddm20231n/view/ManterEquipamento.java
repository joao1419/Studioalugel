/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerEquipamento;
import backenddm20231n.model.bean.Equipamento;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterEquipamento {

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        String tipo = JOptionPane.showInputDialog("TIPO");
        String obs = JOptionPane.showInputDialog("OBS");
        Equipamento equipEnt = new Equipamento(tipo,obs);
        ControllerEquipamento contEquip = new ControllerEquipamento();
        Equipamento equipSaida = contEquip.inserir(equipEnt);
        JOptionPane.showMessageDialog(null,equipSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("IDEQUIPAMENTO"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String obs = JOptionPane.showInputDialog("OBS");
        Equipamento equipEnt = new Equipamento(idEquipamento, tipo,obs);
        ControllerEquipamento contEquip = new ControllerEquipamento();
        Equipamento equipSaida = contEquip.alterar(equipEnt);
        JOptionPane.showMessageDialog(null,equipSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("IDEQUIPAMENTO"));
        Equipamento equipEnt = new Equipamento(idEquipamento);
        ControllerEquipamento contEquip = new ControllerEquipamento();
        Equipamento equipSaida = contEquip.buscar(equipEnt);
        JOptionPane.showMessageDialog(null,equipSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("IDEQUIPAMENTO"));
        Equipamento equipEnt = new Equipamento (idEquipamento);
        ControllerEquipamento contEquip = new ControllerEquipamento();
        Equipamento equipSaida = contEquip.excluir(equipEnt);
        JOptionPane.showMessageDialog(null,equipSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String tipo = JOptionPane.showInputDialog("TIPO");
        Equipamento equipEnt = new Equipamento(tipo);
        ControllerEquipamento contEquip = new ControllerEquipamento();
        List<Equipamento> listaEquipamento = contEquip.listar(equipEnt);
        for (Equipamento equipSaida : listaEquipamento) {
            JOptionPane.showMessageDialog(null,equipSaida.toString());
        }
    }


    
}
