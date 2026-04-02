/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package minhabibliotecaparticular;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.Window;
import com.mysql.cj.protocol.Resultset;
import javafx.scene.effect.SepiaTone;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author barba
 */
public class VisualizarLivrosController implements Initializable {

    @FXML
    private TextArea areaNome;
    @FXML
    private TextArea areaAutor;
    @FXML
    private TextArea areaEditora;
    @FXML
    private Button botaoVoltar;
    
    SepiaTone sepia = new SepiaTone();
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conexãoDataBase();
        } catch (SQLException ex) {
            Logger.getLogger(VisualizarLivrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void botaoVoltarClicado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pagina inicial.fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoVoltar.getScene().getWindow();
        Stage s = (Stage) janela;
        s.setScene(visualizarLivros);
    }
    
    private void conexãoDataBase()throws SQLException{
        Connection conexão = null;
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/BibliotecaParticular","root","Mel865723#");
            System.out.println("Conexão com o data base da biblioteca particular foi bem sucedido");
            ResultSet rs = null;
            rs = conexão.createStatement().executeQuery("select * from itens order by autor_livro");
            while(rs.next()){
                areaNome.setText(areaNome.getText()+"["+rs.getString("id")+"] "+rs.getString("nome_livro")+"\n");
                areaAutor.setText(areaAutor.getText()+"["+rs.getString("id")+"] "+rs.getString("autor_livro")+"\n");
                areaEditora.setText(areaEditora.getText()+"["+rs.getString("id")+"] "+rs.getString("editora_livro")+"\n");
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

    @FXML
    private void areaNomeMouseLonge(MouseEvent event) {
        areaNome.setEffect(null);
    }

    @FXML
    private void areaNomeMousePerto(MouseEvent event) {
        areaNome.setEffect(sepia);
    }

    @FXML
    private void areaAutorMouseLonge(MouseEvent event) {
        areaAutor.setEffect(null);
    }

    @FXML
    private void areaAutorMousePerto(MouseEvent event) {
        areaAutor.setEffect(sepia);
    }

    @FXML
    private void areaEditoraMouseLonge(MouseEvent event) {
        areaEditora.setEffect(null);
    }

    @FXML
    private void areaEditoraMousePerto(MouseEvent event) {
        areaEditora.setEffect(sepia);
    }
    
}
