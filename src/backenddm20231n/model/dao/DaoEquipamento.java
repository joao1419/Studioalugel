/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Equipamento;
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
 * @author User
 */
public class DaoEquipamento {

private final Connection c;
    
    public DaoEquipamento() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Equipamento excluir(Equipamento equipEnt) throws SQLException{
        String sql = "delete from Equipamento WHERE idEquipamento = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,equipEnt.getIdEquipamento());
  
        stmt.execute();
        stmt.close();
        c.close();
        return equipEnt;
    }
    
    public Equipamento buscar(Equipamento equipEnt) throws SQLException{
        String sql = "select * from Equipamento WHERE idEquipamento = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
   
            stmt.setInt(1,equipEnt.getIdEquipamento());

            ResultSet rs = stmt.executeQuery();
           Equipamento equipSaida = null;
            while (rs.next()) {      

                equipSaida = new Equipamento(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));

            }
            stmt.close();
        return equipSaida;
   }

    public Equipamento inserir(Equipamento equipEnt) throws SQLException{
        String sql = "insert into Equipamento" + " (tipo, obs)" + " values (?,?)";

        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        stmt.setString(1,equipEnt.getTipo());
        stmt.setString(2,equipEnt.getObs());

   
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idEquipamento = rs.getInt(1);
            equipEnt.setIdEquipamento(idEquipamento);
        }
        stmt.close();
        return equipEnt;
    }

    public Equipamento alterar(Equipamento equipEnt) throws SQLException{
        String sql = "UPDATE Equipamento SET idEquipamento = ?, tipo = ? WHERE observacao = ?";
    
        PreparedStatement stmt = c.prepareStatement(sql);
 
        stmt.setString(1,equipEnt.getTipo());
        stmt.setString(2,equipEnt.getObs());
        stmt.setInt(3,equipEnt.getIdEquipamento());
        
        
        

    
        stmt.execute();
        stmt.close();
        return equipEnt;
    }

   public List<Equipamento> listar(Equipamento equipEnt) throws SQLException{
      

        List<Equipamento> listaequips = new ArrayList<>();
        
        String sql = "select * from equipamento where tipo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
     
        stmt.setString(1,"%" + equipEnt.getTipo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Equipamento equip = new Equipamento(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
            // adiciona o usu à lista de usus
            listaequips.add(equip);
        }
        
        rs.close();
        stmt.close();
        return listaequips;
   
   }

    
}
