package beans;

import beans.exceptions.ConexaoBD;
import entities.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDao {
    
    private Connection conexao;//Cria metodo de conexao
    
    public ProdutosDao() throws SQLException{
       this.conexao = ConexaoBD.getConexao();
    }
    
   public Boolean inserir(Produtos produtos) throws SQLException{
       
        Boolean retorno = false;
        
        String sql = "INSERT INTO produtos (produto, tipo, codigo_convenio, codigo_barras, imagem) values(?, ?, ?, ?, ?)";
        
        PreparedStatement pst = conexao.prepareStatement(sql);
         try{
        pst.setString(1, produtos.getProduto());
        pst.setString(2, produtos.getTipo());
        pst.setInt(3, produtos.getCodigo_convenio());
        pst.setInt(4, produtos.getCodigo_barras());
        pst.setBytes(5, produtos.getImagem());
        
        pst.executeUpdate();
        retorno = true;
            }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
         return retorno;
   }     
   
   public Produtos buscar(Integer id) throws SQLException{
       Produtos retorno = null;
       
       String sql = "SELECT id_produto,imagem FROM produtos WHERE id_produto=?";      
       
       PreparedStatement pst = conexao.prepareStatement(sql);
       
       try {
           pst.setInt(1, id);
           ResultSet rs = pst.executeQuery();
           
           if(rs.next()){
               retorno = new Produtos();
               retorno.setId_produto(rs.getLong("id_produto"));
               retorno.setImagem(rs.getBytes("imagem"));
           }
       } catch (Exception e) {
           e.printStackTrace();
           retorno = null;
       }
       
       return retorno;
   }
}
