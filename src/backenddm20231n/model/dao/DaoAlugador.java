/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Alugador;
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
public class DaoAlugador {

private final Connection c;
    
    public DaoAlugador() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Alugador excluir(Alugador aluEnt) throws SQLException{
        String sql = "delete from alugador WHERE idAlugador = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1,aluEnt.getIdAlugador());
        stmt.execute();
        stmt.close();
        c.close();
        return aluEnt;
    }
    
    public Alugador buscar(Alugador aluEnt) throws SQLException{
        String sql = "select * from alugador WHERE idAlugador = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            stmt.setInt(1,aluEnt.getIdAlugador());
            ResultSet rs = stmt.executeQuery();
            Alugador aluSaida = null;
            while (rs.next()) {      
                aluSaida = new Alugador(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4));
            }
            stmt.close();
        return aluSaida;
   }

    public Alugador inserir(Alugador aluEnt) throws SQLException{
        String sql = "insert into alugador" + " (nome, telefone, cpf)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,aluEnt.getNome());
        stmt.setInt(2,aluEnt.getTelefone());
        stmt.setInt(3,aluEnt.getCpf());


        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int idAlugador = rs.getInt(1);
            aluEnt.setIdAlugador(idAlugador);
        }
        stmt.close();
        return aluEnt;
    }

    public Alugador alterar(Alugador aluEnt) throws SQLException{
        String sql = "UPDATE alugador SET nome = ?, telefone = ?, cpf = ? WHERE idAlugador = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,aluEnt.getNome());
        stmt.setInt(2,aluEnt.getTelefone());
        stmt.setInt(3,aluEnt.getCpf());
        stmt.setInt(4,aluEnt.getIdAlugador());
        
        


        stmt.execute();
        stmt.close();
        return aluEnt;
    }

   public List<Alugador> listar(Alugador aluEnt) throws SQLException{
 

        List<Alugador> listaalus = new ArrayList<>();
        
        String sql = "select * from alugador where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
  
        stmt.setString(1,"%" + aluEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      

            Alugador alu = new Alugador(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4)
            );

            listaalus.add(alu);
        }
        
        rs.close();
        stmt.close();
        return listaalus;
   
   }

    
}
