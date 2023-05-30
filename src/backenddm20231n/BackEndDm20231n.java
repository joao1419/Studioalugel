/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n;

import backenddm20231n.view.ManterAlugador;
import backenddm20231n.view.ManterData;
import backenddm20231n.view.ManterEquipamento;
import backenddm20231n.view.ManterStudio;
import backenddm20231n.view.ManterInstrumento;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BackEndDm20231n {

    /**
     * @param args the command line arguments
     */

    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        String msg = "1 - Alugador \n 2 - Data \n 3 - Equipamento \n 4 - Instrumento \n 5 - Studio \n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                ManterAlugador.menu();
                break;
            case 2:
                ManterData.menu();
                break;
            case 3:
                ManterEquipamento.menu();
                break;
            case 4:
                ManterInstrumento.menu();
                break;
            case 5:
                ManterStudio.menu();
                break;                              
            default:
                System.out.println("Opção inválido");
        }
    }
    
}
