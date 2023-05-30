/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Instrumento;
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
public class DaoInstrumento {

private final Connection c;
    
    public DaoInstrumento() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Instrumento excluir(Instrumento instruEnt) throws SQLException{
        String sql = "delete from Instrumento WHERE idInstrumento = ?";
  
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,instruEnt.getIdInstrumento());

        stmt.execute();
        stmt.close();
        c.close();
        return instruEnt;
    }
    
    public Instrumento buscar(Instrumento instruEnt) throws SQLException{
        String sql = "select * from Instrumento WHERE idInstrumento = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
      
            stmt.setInt(1,instruEnt.getIdInstrumento());
    
            ResultSet rs = stmt.executeQuery();
           Instrumento instruSaida = null;
            while (rs.next()) {      
      
                instruSaida = new Instrumento(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
       
            }
            stmt.close();
        return instruSaida;
   }

    public Instrumento inserir(Instrumento instruEnt) throws SQLException{
        String sql = "insert into Instrumento" + " (tipo, obs)" + " values (?,?)";
    
      
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

     
        stmt.setString(1,instruEnt.getTipo());
        stmt.setString(2,instruEnt.getObs());

    
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idInstrumento = rs.getInt(1);
            instruEnt.setIdInstrumento(idInstrumento);
        }
        stmt.close();
        return instruEnt;
    }

    public Instrumento alterar(Instrumento instruEnt) throws SQLException{
        String sql = "UPDATE Instrumento SET idInstrumento = ?, tipo = ? WHERE obs = ?";
  
        PreparedStatement stmt = c.prepareStatement(sql);
   
        stmt.setString(1,instruEnt.getTipo());
        stmt.setString(2,instruEnt.getObs());
        stmt.setInt(3,instruEnt.getIdInstrumento());
        
        
        

      
        stmt.execute();
        stmt.close();
        return instruEnt;
    }

   public List<Instrumento> listar(Instrumento instruEnt) throws SQLException{
     

        List<Instrumento> listainstrus = new ArrayList<>();
        
        String sql = "select * from Instrumento where tipo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
       
        stmt.setString(1,"%" + instruEnt.getTipo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            
            Instrumento instru = new Instrumento(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
            
            listainstrus.add(instru);
        }
        
        rs.close();
        stmt.close();
        return listainstrus;
   
   }

    
}
