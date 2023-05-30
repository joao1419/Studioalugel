/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Studio;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joão
 */
public class DaoStudio {
    
    private final Connection c;
    
    public DaoStudio() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Studio excluir(Studio aludatEnt) throws SQLException{
        String sql = "delete from studio WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,aludatEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return aludatEnt;
    }
    
    public Studio buscar(Studio aludatEnt) throws SQLException{
        String sql = "select * from studio WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

            stmt.setInt(1,aludatEnt.getId());

            ResultSet rs = stmt.executeQuery();
            Studio aludatSaida = null;
            while (rs.next()) {      

                aludatSaida = new Studio(
                    
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7)
                );

            }
            stmt.close();
        return aludatSaida;
   }

    public Studio inserir(Studio aludatEnt) throws SQLException{
        String sql = "insert into studio" + " (id, nome, idAlugador, idInstrumento, idEquipamento, idData, observacao)" + " values (?,?,?,?,?,?,?)";

        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        stmt.setInt(1,aludatEnt.getId());
        stmt.setString(2,aludatEnt.getNome());
        stmt.setInt(3,aludatEnt.getIdAlugador());
        stmt.setInt(4,aludatEnt.getIdInstrumento());
        stmt.setInt(5,aludatEnt.getIdEquipamento());
        stmt.setInt(6,aludatEnt.getIdData());
        stmt.setString(7,aludatEnt.getObservacao());

 
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
           aludatEnt.setId(id);
        }
        stmt.close();
        return aludatEnt;
    }

    public Studio alterar(Studio aludatEnt) throws SQLException{
        String sql = "UPDATE studio SET nome = ?, idAligador = ?, idInstrumento = ?, idEquipamento = ?, idData = ?, observacao = ? WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1,aludatEnt.getNome());
        stmt.setInt(2,aludatEnt.getIdAlugador());
        stmt.setInt(3,aludatEnt.getIdInstrumento());
        stmt.setInt(4,aludatEnt.getIdEquipamento());
        stmt.setInt(5,aludatEnt.getIdData());
        stmt.setString(6,aludatEnt.getObservacao());
        stmt.setInt(7,aludatEnt.getId());


        stmt.execute();
        stmt.close();
        return aludatEnt;
    }

   public List<Studio> listar(Studio aludatEnt) throws SQLException{


        List<Studio> peslogs = new ArrayList<>();
        
        String sql = "select * from studio where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + aludatEnt.getNome()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      

            Studio peslog = new Studio(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getInt(6),
                rs.getString(7));
  
            peslogs.add(peslog);
        }
        
        rs.close();
        stmt.close();
        return peslogs;
   
   }

}
