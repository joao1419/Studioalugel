/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerStudio;
import backenddm20231n.model.bean.Studio;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author joão
 */
public class ManterStudio {
    
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
                System.out.println("Opcao invÃ¡lida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME:");
        int idAlugador = Integer.parseInt(JOptionPane.showInputDialog("IDALUGADOR"));
        int idInstrumento = Integer.parseInt(JOptionPane.showInputDialog("IDINSTRUMENTO"));
        int idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("IDEQUIPAMENTO"));
        int idData = Integer.parseInt(JOptionPane.showInputDialog("IDDATA"));
        String observacao = JOptionPane.showInputDialog("OBSERVACAO");
        Studio aludatEnt = new Studio(nome,  idAlugador,idInstrumento, idEquipamento,idData,observacao);
        ControllerStudio contaludat = new ControllerStudio();
        Studio aludatSaida = contaludat.inserir(aludatEnt);
        JOptionPane.showMessageDialog(null,aludatSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
         String nome = JOptionPane.showInputDialog("NOME:");
        int idAlugador = Integer.parseInt(JOptionPane.showInputDialog("IDALUGADOR"));
        int idInstrumento = Integer.parseInt(JOptionPane.showInputDialog("IDINSTRUMENTO"));
        int idEquipamento = Integer.parseInt(JOptionPane.showInputDialog("IDEQUIPAMENTO"));
        int idData = Integer.parseInt(JOptionPane.showInputDialog("IDDATA"));
        String observacao = JOptionPane.showInputDialog("OBSERVACAO");
        Studio aludatEnt = new Studio(nome, idAlugador,idInstrumento, idEquipamento,idData,observacao);
        ControllerStudio contaludat = new ControllerStudio();
        Studio aludatSaida = contaludat.alterar(aludatEnt);
        JOptionPane.showMessageDialog(null,aludatSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Studio aludatEnt = new Studio(id);
        ControllerStudio contaludat = new ControllerStudio();
        Studio aludatSaida = contaludat.buscar(aludatEnt);
        JOptionPane.showMessageDialog(null,aludatSaida.toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getAlu().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getEquip().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getInstru().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getDat().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Studio aludatEnt = new Studio(id);
        ControllerStudio contaludat = new ControllerStudio();
        Studio aludatSaida = contaludat.excluir(aludatEnt);
        JOptionPane.showMessageDialog(null,aludatSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("ID");
        Studio aludatEnt = new Studio(nome);
        ControllerStudio contAludat = new ControllerStudio();
        List<Studio> listaAlugadorData = contAludat.listar(aludatEnt);
        for (Studio aludatSaida : listaAlugadorData) {
            JOptionPane.showMessageDialog(null,aludatSaida.toString());
            JOptionPane.showMessageDialog(null,aludatSaida.getAlu().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getEquip().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getInstru().toString());
        JOptionPane.showMessageDialog(null,aludatSaida.getDat().toString());
            
        
        //nome por id trocar depois
        }
    }
    
}
