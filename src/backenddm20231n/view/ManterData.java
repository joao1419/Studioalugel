/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerData;
import backenddm20231n.model.bean.Data;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterData {

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
        String data = JOptionPane.showInputDialog("DATA");
        String periodo = JOptionPane.showInputDialog("PERIODO");
        Data datEnt = new Data(data,periodo);
        ControllerData contDat = new ControllerData();
        Data datSaida = contDat.inserir(datEnt);
        JOptionPane.showMessageDialog(null,datSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int idData = Integer.parseInt(JOptionPane.showInputDialog("IDDATA"));
         String data = JOptionPane.showInputDialog("DATA");
        String periodo = JOptionPane.showInputDialog("PERIODO");
        Data datEnt = new Data(idData, data,periodo);
        ControllerData contDat = new ControllerData();
        Data datSaida = contDat.alterar(datEnt);
        JOptionPane.showMessageDialog(null,datSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int idData = Integer.parseInt(JOptionPane.showInputDialog("IDDATA"));
        Data datEnt = new Data(idData);
        ControllerData contDat = new ControllerData();
        Data datSaida = contDat.buscar(datEnt);
        JOptionPane.showMessageDialog(null,datSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int idData = Integer.parseInt(JOptionPane.showInputDialog("IDDATA"));
        Data datEnt = new Data (idData);
        ControllerData contDat = new ControllerData();
        Data datSaida = contDat.excluir(datEnt);
        JOptionPane.showMessageDialog(null,datSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String data = JOptionPane.showInputDialog("DATA");
        Data datEnt = new Data(data);
        ControllerData contDat = new ControllerData();
        List<Data> listaData = contDat.listar(datEnt);
        for (Data datSaida : listaData) {
            JOptionPane.showMessageDialog(null,datSaida.toString());
        }
    }


    
}
