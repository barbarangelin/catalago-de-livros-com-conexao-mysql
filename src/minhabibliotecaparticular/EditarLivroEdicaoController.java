/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package minhabibliotecaparticular;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.MotionBlur;
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
public class EditarLivroEdicaoController implements Initializable {

    @FXML
    private TextField nomeCaixa;
    @FXML
    private Button botaoVoltar;
    @FXML
    private TextField autorCaixa;
    @FXML
    private TextField editoraCaixa;
    @FXML
    private Button botaoIr;
    
    String id_livro;
    @FXML
    private Button botaoExcluir;

    public String getId_livro() {
        return id_livro;
    }

    public void setId_livro(String id_livro) {
        this.id_livro = id_livro;
    }
    
    
    MotionBlur blur = new MotionBlur();
    InnerShadow sombra = new InnerShadow();

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("\nSerá editado o livro com id="+id_livro);
    }    

    @FXML
    private void nomeLivroTeclado(KeyEvent event) {
        nomeCaixa.setEffect(blur);
    }

    @FXML
    private void nomeLivroLiberado(KeyEvent event) {
        nomeCaixa.setEffect(null);
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
        voltarPaginaAnterior("editar livro");
    }

    @FXML
    private void autorLivroTeclado(KeyEvent event) {
        autorCaixa.setEffect(blur);
    }

    @FXML
    private void editoraLivroTeclado(KeyEvent event) {
        editoraCaixa.setEffect(blur);
    }

    @FXML
    private void botaoIrMouselonge(MouseEvent event) {
        botaoIr.setEffect(null);
    }

    @FXML
    private void botaoIrMousePerto(MouseEvent event) {
        botaoIr.setEffect(sombra);
    }

    @FXML
    private void botaoIrClicado(ActionEvent event) throws SQLException, IOException {
        if (nomeCaixa.getText().isEmpty()&&autorCaixa.getText().isEmpty()&&editoraCaixa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha ao menos uma caixa", "Nenhuma caixa preenchida", JOptionPane.ERROR_MESSAGE);
        }
        else {
            conexaoDataBaseEdiçãoAutor();
        conexaoDataBaseEdiçãoNome();
        conexaoDataBaseEdiçãoEditora();
        JOptionPane.showMessageDialog(null, "O livro "+nomeCaixa.getText()+" foi editado com sucesso", "Edição concluída",0);
        voltarPaginaAnterior("pagina inicial");
        }
    }

    @FXML
    private void autorLivroLiberado(KeyEvent event) {
        autorCaixa.setEffect(null);
    }

    @FXML
    private void editoraLivroLiberado(KeyEvent event) {
        editoraCaixa.setEffect(null);
    }
    
    //funções para as edições
    private void conexaoDataBaseEdiçãoNome() throws SQLException{
        if (nomeCaixa.getText().isEmpty()==false){
            Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            PreparedStatement estamento = conexão.prepareStatement("update itens set nome_livro=? where id="+id_livro);
            estamento.setString(1, nomeCaixa.getText());
            int coluna = estamento.executeUpdate();
            if (coluna==0) System.out.println("Houve algum erro durante a atualização na coluna do nome");
            else System.out.println("Coluna nome foi atualizada com sucesso para "+nomeCaixa.getText());
        
        
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
        }
    }
    
    private void conexaoDataBaseEdiçãoAutor() throws SQLException{
        if(autorCaixa.getText().isEmpty()==false){
            Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            PreparedStatement estamento = conexão.prepareStatement("update itens set autor_livro=? where id="+id_livro);
            estamento.setString(1, autorCaixa.getText());
            int coluna = estamento.executeUpdate();
            if (coluna==0) System.out.println("Houve algum erro durante a atualização na coluna do autor(a)");
            else System.out.println("Coluna autor(a) foi atualizada com sucesso para "+autorCaixa.getText());
        
        
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
        }
    }
    
    private void conexaoDataBaseEdiçãoEditora() throws SQLException{
        if(autorCaixa.getText().isEmpty()==false){
            Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            PreparedStatement estamento = conexão.prepareStatement("update itens set editora_livro=? where id="+id_livro);
            estamento.setString(1, editoraCaixa.getText());
            int coluna = estamento.executeUpdate();
            if (coluna==0) System.out.println("Houve algum erro durante a atualização na coluna do autor(a)");
            else System.out.println("Coluna editora foi atualizada com sucesso para "+editoraCaixa.getText());
        
        
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de date base não disponível");
        }
        finally{ //fecha conexão se existente
            if (conexão != null){
                conexão.close();
            }
        }
        }
    }
    
    private void voltarPaginaAnterior(String caminho) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(caminho+".fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoVoltar.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
        s.setMinHeight(480);
        s.setMinWidth(761);
    }

    @FXML
    private void botaoExcluirMouselonge(MouseEvent event) {
        botaoExcluir.setEffect(null);
    }

    @FXML
    private void botaoExcluirMousePerto(MouseEvent event) {
        botaoExcluir.setEffect(sombra);
    }

    @FXML
    private void botaoExcluirClicado(ActionEvent event) throws SQLException, IOException {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o livro?","Exclusão de livro",JOptionPane.YES_NO_OPTION);
        if (opcao==JOptionPane.YES_OPTION){
            excluirLivro();
        }
    }
    
    private void excluirLivro() throws SQLException, IOException{
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            PreparedStatement estamento = conexão.prepareStatement("delete from itens where id="+id_livro);
            int coluna = estamento.executeUpdate();
            if (coluna==0) System.out.println("Houve algum erro durante a adição do novo livro no sistema");
            else {
                System.out.println("O livro foi excluido com sucesso");
                JOptionPane.showMessageDialog(null, "O livro "+nomeCaixa.getText()+" foi excluido com sucesso!","Operação finalizada",JOptionPane.INFORMATION_MESSAGE);
                mudarDePagina("pagina inicial", "voltar ao inicio");
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
    
        private void mudarDePagina (String caminho,String botaoTipo) throws IOException{
        System.out.println("Botao de "+botaoTipo+" foi clicado");
        //trocar de janela
        Parent root = FXMLLoader.load(getClass().getResource(caminho+".fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoExcluir.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
    }
    
}
