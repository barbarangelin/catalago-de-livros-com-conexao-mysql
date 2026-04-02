
package minhabibliotecaparticular;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author barba
 */
public class EditarLivroController implements Initializable {

    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoIr;
    @FXML
    private TextField nomeCaixa;
    @FXML
    private TextField idCaixa;
    
    InnerShadow sombra = new InnerShadow();
    @FXML
    private TextArea listaLivros;
    
    private String id_livro;
    
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void botaoVoltarMouselonge(MouseEvent event) {
        botaoVoltar.setEffect(null);
    }

    @FXML
    private void botaoVoltarMousePerto(MouseEvent event) {
        botaoVoltar.setEffect(sombra);
    }

    @FXML
    private void botaoVoltarClicado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pagina inicial.fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoIr.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
        s.setMinHeight(480);
        s.setMinWidth(761);
    }

    @FXML
    private void botaoIrClicado(ActionEvent event) throws SQLException, IOException {
        if (idCaixa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Digite um ID válido","ID não discado",JOptionPane.WARNING_MESSAGE);
        } else {
            String in_in=conexãoDataBaseIDchecagem();
            //id nao encontrado
            if (in_in.equals("0")){
                JOptionPane.showMessageDialog(null, "ID não encontrado","ID error",JOptionPane.WARNING_MESSAGE);
            }
            //id encontrado
            else {
                System.out.println("ID discado: "+idCaixa.getText());
                int opção = JOptionPane.showConfirmDialog(null,"Deseja editar o livro "+conexãoDataBaseNomeChecagem()+"?", "Confirmar edição de livro",JOptionPane.OK_CANCEL_OPTION);
                if (opção==JOptionPane.OK_OPTION) {
                    id_livro=idCaixa.getText();
                    paginaEdicaoLivro(idCaixa.getText());
                }
            }
        }
    }
    
    private String conexãoDataBaseIDchecagem() throws SQLException{
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            ResultSet rs = null;
            rs = conexão.createStatement().executeQuery("select count(*) as is_in from itens where id="+idCaixa.getText()+";");
            while (rs.next()){
                if (rs.getString("is_in").equals("0")) System.out.println("ID não encontrado");
                else System.out.println("ID foi encontrado");
                return rs.getString("is_in");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
        return null;
 
    }
    
    private String conexãoDataBaseNomeChecagem() throws SQLException{
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            ResultSet rs = null;
            rs = conexão.createStatement().executeQuery("select nome_livro as is_in from itens where id="+idCaixa.getText()+";");
            while (rs.next()){
                return rs.getString("is_in");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
        return null;
 
    }
    
    private void conexãoDataBaseLista()throws SQLException{
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            ResultSet rs = null;
            rs = conexão.createStatement().executeQuery("select * from itens where nome_livro like '"+nomeCaixa.getText()+"%' order by autor_livro");
            listaLivros.clear();
            while(rs.next()){
                listaLivros.setText(listaLivros.getText()+"["+rs.getString("id")+"] "+rs.getString("nome_livro")+"\n");
            }
        
        
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
    }

  
    
    private void paginaEdicaoLivro(String id) throws IOException{
        FXMLLoader paginaEdicaoLivroCarregador = new FXMLLoader(getClass().getResource("editar livro edicao.fxml"));
        Parent root = paginaEdicaoLivroCarregador.load();
        //manda o id do livro para a pagina da edição do livro de acordo com o id
        EditarLivroEdicaoController controlador = (EditarLivroEdicaoController)paginaEdicaoLivroCarregador.getController();
        controlador.setId_livro(id);
        System.out.println("Controlador: "+controlador.getId_livro());
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoIr.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
        s.setMinHeight(480);
        s.setMinWidth(761);
    }

    @FXML
    private void nomeLivroAtt(KeyEvent event) throws SQLException {
        conexãoDataBaseLista();
    }
 
}
