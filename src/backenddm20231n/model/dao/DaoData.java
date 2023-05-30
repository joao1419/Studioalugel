/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Data;
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
public class DaoData {

private final Connection c;
    
    public DaoData() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Data excluir(Data datEnt) throws SQLException{
        String sql = "delete from data WHERE idData = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,datEnt.getIdData());

        stmt.execute();
        stmt.close();
        c.close();
        return datEnt;
    }
    
    public Data buscar(Data datEnt) throws SQLException{
        String sql = "select * from data WHERE idData = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

            stmt.setInt(1,datEnt.getIdData());
  
            ResultSet rs = stmt.executeQuery();
            Data datSaida = null;
            while (rs.next()) {      

                datSaida = new Data(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));

            }
            stmt.close();
        return datSaida;
   }

    public Data inserir(Data datEnt) throws SQLException{
        String sql = "insert into data" + " (data, periodo)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,datEnt.getData());
        stmt.setString(2,datEnt.getPeriodo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idData = rs.getInt(1);
            datEnt.setIdData(idData);
        }
        stmt.close();
        return datEnt;
    }

    public Data alterar(Data datEnt) throws SQLException{
        String sql = "UPDATE data SET data = ?, periodo = ? WHERE idData = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1,datEnt.getData());
        stmt.setString(2,datEnt.getPeriodo());
        stmt.setInt(3,datEnt.getIdData());
        
        
        

        // executa
        stmt.execute();
        stmt.close();
        return datEnt;
    }

   public List<Data> listar(Data datEnt) throws SQLException{


        List<Data> listadats = new ArrayList<>();
        
        String sql = "select * from data where data like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
   
        stmt.setString(1,"%" + datEnt.getData() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      

            Data dat = new Data(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
  
            listadats.add(dat);
        }
        
        rs.close();
        stmt.close();
        return listadats;
   
   }

    
}
