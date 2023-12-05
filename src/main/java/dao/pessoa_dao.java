
package dao;

import classe.pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pessoa_dao {
    private final Connection conexao;

    public pessoa_dao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public void insert(pessoa p) throws SQLException{
        
        String sql = "insert into pessoa (idpessoa, nome, cpd, contato) values (?, ?, ?, ?)";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, p.getIdpessoa());
        statement.setString(2, p.getNome());
        statement.setString(3, p.getCpd());
        statement.setString(4, p.getContato());
        statement.execute();
    }
    
    public void update(pessoa p) throws SQLException{
        
        String sql = "update pessoa set nome = ?, cpd = ?, contato = ? where idpessoa= ?";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, p.getNome());
        statement.setString(2, p.getCpd());
        statement.setString(3, p.getContato());
        statement.setInt(4, p.getIdpessoa());
        statement.execute();
    }
    
    public void delete(pessoa p) throws SQLException{
        
        String sql = "delete from pessoa where idpessoa = ?";
        
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, p.getIdpessoa());
        statement.execute();
        
    }
}
