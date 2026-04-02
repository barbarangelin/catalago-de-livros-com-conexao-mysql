/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package minhabibliotecaparticular;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author barba
 */
public class SobreController implements Initializable {

    @FXML
    private Button botaoVoltar;
    
    Bloom brilho = new Bloom();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void botaoVoltarMouseLonge(MouseEvent event) {
        botaoVoltar.setEffect(null);
    }

    @FXML
    private void botaoVoltarMousePerto(MouseEvent event) {
        botaoVoltar.setEffect(brilho);
    }

    @FXML
    private void botaoVoltarClicado(ActionEvent event) throws IOException {
        mudarDePagina("pagina inicial", "voltar");
    }
    
    private void mudarDePagina (String caminho,String botaoTipo) throws IOException{
        System.out.println("Botao de "+botaoTipo+" foi clicado");
        //trocar de janela
        Parent root = FXMLLoader.load(getClass().getResource(caminho+".fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoVoltar.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
    }
    
    
    
    
}
