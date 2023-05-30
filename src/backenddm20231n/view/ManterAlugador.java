/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerAlugador;
import backenddm20231n.model.bean.Alugador;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterAlugador {

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
        String nome = JOptionPane.showInputDialog("NOME");
        int telefone = Integer.parseInt(JOptionPane.showInputDialog("TELEFONE"));
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        Alugador aluEnt = new Alugador(nome,telefone,cpf);
        ControllerAlugador contAlu = new ControllerAlugador();
        Alugador aluSaida = contAlu.inserir(aluEnt);
        JOptionPane.showMessageDialog(null,aluSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id_Alugador = Integer.parseInt(JOptionPane.showInputDialog("ID_ALUGADOR"));
         String nome = JOptionPane.showInputDialog("NOME");
        int telefone = Integer.parseInt(JOptionPane.showInputDialog("TELEFONE"));
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        Alugador aluEnt = new Alugador(id_Alugador, nome,telefone,cpf);
        ControllerAlugador contAlu = new ControllerAlugador();
        Alugador aluSaida = contAlu.alterar(aluEnt);
        JOptionPane.showMessageDialog(null,aluSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
      int id_Alugador = Integer.parseInt(JOptionPane.showInputDialog("ID_ALUGADOR"));
        Alugador aluEnt = new Alugador(id_Alugador);
        ControllerAlugador contAlu = new ControllerAlugador();
        Alugador aluSaida = contAlu.buscar(aluEnt);
        JOptionPane.showMessageDialog(null,aluSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
       int id_Alugador = Integer.parseInt(JOptionPane.showInputDialog("ID_ALUGADOR"));
        Alugador aluEnt = new Alugador(id_Alugador);
        ControllerAlugador contAlu = new ControllerAlugador();
        Alugador aluSaida = contAlu.excluir(aluEnt);
        JOptionPane.showMessageDialog(null,aluSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Alugador aluEnt = new Alugador(nome);
        ControllerAlugador contAlu = new ControllerAlugador();
        List<Alugador> listaAlugador = contAlu.listar(aluEnt);
        for (Alugador aluSaida : listaAlugador) {
            JOptionPane.showMessageDialog(null,aluSaida.toString());
        }
    }


    
}
