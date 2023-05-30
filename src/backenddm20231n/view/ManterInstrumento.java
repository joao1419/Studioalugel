/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerInstrumento;
import backenddm20231n.model.bean.Instrumento;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterInstrumento {

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
        Instrumento instruEnt = new Instrumento(tipo,obs);
        ControllerInstrumento contInstru = new ControllerInstrumento();
        Instrumento instruSaida = contInstru.inserir(instruEnt);
        JOptionPane.showMessageDialog(null,instruSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int idInstrumento = Integer.parseInt(JOptionPane.showInputDialog("IDINSTRUMENTO"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String obs = JOptionPane.showInputDialog("OBS");
        Instrumento instruEnt = new Instrumento(idInstrumento, tipo,obs);
        ControllerInstrumento contInstru = new ControllerInstrumento();
        Instrumento instruSaida = contInstru.alterar(instruEnt);
        JOptionPane.showMessageDialog(null,instruSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int idInstrumento = Integer.parseInt(JOptionPane.showInputDialog("IDINSTRUMENTO"));
        Instrumento instruEnt = new Instrumento(idInstrumento);
        ControllerInstrumento contInstru = new ControllerInstrumento();
        Instrumento instruSaida = contInstru.buscar(instruEnt);
        JOptionPane.showMessageDialog(null,instruSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int idInstrumento = Integer.parseInt(JOptionPane.showInputDialog("IDINSTRUMENTO"));
        Instrumento instruEnt = new Instrumento (idInstrumento);
        ControllerInstrumento contInstru = new ControllerInstrumento();
        Instrumento instruSaida = contInstru.excluir(instruEnt);
        JOptionPane.showMessageDialog(null,instruSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String tipo = JOptionPane.showInputDialog("TIPO");
        Instrumento instruEnt = new Instrumento(tipo);
        ControllerInstrumento contInstru = new ControllerInstrumento();
        List<Instrumento> listaInstrumento = contInstru.listar(instruEnt);
        for (Instrumento instruSaida : listaInstrumento) {
            JOptionPane.showMessageDialog(null,instruSaida.toString());
        }
    }


    
}
