
package controle;

import classe.pessoa;
import dao.conexao;
import dao.pessoa_dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.tela1;

public class ctrl {
    
    private tela1 t;
    
    public ctrl(tela1 t){
        this.t = t;
    }
    
    public void registar() throws SQLException{
        
        String idString = t.getjTextFieldID().getText();
        //converter para int
        int idpessoa = Integer.parseInt(idString);
        
        String nome = t.getjTextFieldNome().getText();
        String cpd = t.getjTextFieldCPD().getText();
        String contato = t.getjTextFieldContato().getText();
        
        if (nome.isEmpty() || cpd.isEmpty() || contato.isEmpty()) {
        JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS SÃO OBRIGATORIOS!");
        return;
        }
                
        pessoa salvar_pessoa = new pessoa(idpessoa, nome, cpd, contato);
        
        try{
        Connection conexao = new conexao().getConnection();
        pessoa_dao pdao = new pessoa_dao(conexao);
        pdao.insert(salvar_pessoa);
        
        JOptionPane.showMessageDialog(null, "CADASTRO FEITO COM SUCESSO!");        
        }catch (SQLException ex){
            Logger.getLogger(ctrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar() throws SQLException{
        
        String nome = t.getjTextFieldNome().getText();
        String cpd = t.getjTextFieldCPD().getText();
        String contato = t.getjTextFieldContato().getText();
        
        String idString = t.getjTextFieldID().getText();
        //converter para int
        int idpessoa = Integer.parseInt(idString);
        
        if (nome.isEmpty() || cpd.isEmpty() || contato.isEmpty()) {
        JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS SÃO OBRIGATORIOS!");
        return;
        }
                
        pessoa att_pessoa = new pessoa(idpessoa ,nome, cpd, contato);
        
        try{
        Connection conexao = new conexao().getConnection();
        pessoa_dao pdao = new pessoa_dao(conexao);
        pdao.update(att_pessoa);
        
        JOptionPane.showMessageDialog(null, "ATUALIZADO COM SUCESSO!");        
        }catch (SQLException ex){
            Logger.getLogger(ctrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletar()throws SQLException{
        
        String idString = t.getjTextFieldID().getText();
        //converter para int
        int idpessoa = Integer.parseInt(idString);
        
        pessoa apagar_pessoa = new pessoa(idpessoa);
        
        try{
        Connection conexao = new conexao().getConnection();
        pessoa_dao pdao = new pessoa_dao(conexao);
        pdao.delete(apagar_pessoa);
        
        JOptionPane.showMessageDialog(null, "APAGADO COM SUCESSO!");        
        }catch (SQLException ex){
            Logger.getLogger(ctrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
