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
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
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
public class AdicionarLivroController implements Initializable {


    @FXML
    private Button voltarBotao;
    @FXML
    private TextField nomeCaixa;
    @FXML
    private TextField autorCaixa;
    @FXML
    private TextField editoraCaixa;
    @FXML
    private Button addBotao;
    
    Reflection reflexao = new Reflection();
    MotionBlur blur = new MotionBlur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void VoltarBotaoMouseLonge(MouseEvent event) {
        voltarBotao.setEffect(null);
    }

    @FXML
    private void voltarBotaoMousePerto(MouseEvent event) {
        voltarBotao.setEffect(reflexao);
    }

    @FXML
    private void voltarBotaoClicado(ActionEvent event) throws IOException {
        mudarDePagina("pagina inicial", "voltar");
    }

    @FXML
    private void nomeCaixaDiscado(KeyEvent event) {
        nomeCaixa.setEffect(blur);
    }

    @FXML
    private void nomeCaixaLiberado(KeyEvent event) {
        nomeCaixa.setEffect(null);
    }

    @FXML
    private void autorCaixaTeclado(KeyEvent event) {
        autorCaixa.setEffect(blur);               
    }

    @FXML
    private void autorCaixaLiberado(KeyEvent event) {
        autorCaixa.setEffect(null); 
    }

    @FXML
    private void editoraCaixaTeclado(KeyEvent event) {
        editoraCaixa.setEffect(blur);
    }

    @FXML
    private void editoraCaixaLiberado(KeyEvent event) {
        editoraCaixa.setEffect(null);
    }

    @FXML
    private void addBotaoMouseLonge(MouseEvent event) {
        addBotao.setEffect(null);
    }

    @FXML
    private void addBotaoMousePerto(MouseEvent event) {
        addBotao.setEffect(reflexao);
    }

    @FXML
    private void addBotaoClicado(ActionEvent event) throws SQLException, IOException {
        if (nomeCaixa.getText().isEmpty()&&autorCaixa.getText().isEmpty()&&editoraCaixa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma caixa foi preenchida","Erro encontrado",JOptionPane.ERROR_MESSAGE);
        }
        else {
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/SEU DATABASE","SEU USUÁRIO","SUA SENHA");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            PreparedStatement estamento = conexão.prepareStatement("insert into itens (nome_livro,autor_livro,editora_livro) values"
                    + " (?,?,?)");
            estamento.setString(1, nomeCaixa.getText());
            estamento.setString(2, autorCaixa.getText());
            estamento.setString(3, editoraCaixa.getText());
            int coluna = estamento.executeUpdate();
            if (coluna==0) System.out.println("Houve algum erro durante a adição do novo livro no sistema");
            else {
                System.out.println("O livro "+nomeCaixa+" foi adicionado com sucesso");
                JOptionPane.showMessageDialog(null, "O livro "+nomeCaixa.getText()+" foi adicionado com sucesso!","Operação finalizada",JOptionPane.INFORMATION_MESSAGE);
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
    }
    
    private void mudarDePagina (String caminho,String botaoTipo) throws IOException{
        System.out.println("Botao de "+botaoTipo+" foi clicado");
        //trocar de janela
        Parent root = FXMLLoader.load(getClass().getResource(caminho+".fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)addBotao.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
    }

}
