import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Henrique Lopes
 */
public class ConexaoBD {

    public Statement stm;  //ResPonsavel por preparar e realizar pesquisas no banco de dados.

    public ResultSet rs;  //Responsavel por armazenar o resultado de uma pesquisa passada para o statement.

    private String driver = "com.mysql.jdbc.Driver";  //Responsavel por identificar o serviço de banco de dados.

    private String caminho = "jdbc:mysql://localhost:3306/seubanco?useSSL=false";  //Responsavel por setar o local do banco de dados.

    private String usuario = "root";  //Usuario padrao do banco mysql ou postgre.

    private String senha = "senhabanco";

    public Connection con; //Responsavel por realizar a conexao com o banco de dados.
    

    public void conexao() {  //Método responsavel por realizar a conexao com o banco.
        try {
            System.setProperty("jdbc.Drivers", driver);  //Seta a propiedade do driver de conexao.

            con = DriverManager.getConnection(caminho, usuario, senha);  //Realiza a conexao com o banco de dados.  CONN retorna true or false.

            //JOptionPane.showMessageDialog(null, "Concectado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão!\nErro: " + ex.getMessage());
        }
    }

    public void desconecta() {  //Metodo para fechar a conexao com o banco de dados.
        try {
            con.close();  //Fecha a conexão.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão!\nErro: " + ex.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro de ExecutaSql!\nErro: " + ex.getMessage());
        }
    }
}
  
