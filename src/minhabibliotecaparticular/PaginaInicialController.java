/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package minhabibliotecaparticular;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author barba
 */
public class PaginaInicialController implements Initializable {

    @FXML
    private Button BotaoVisualizar;
    
    @FXML
    private AnchorPane janelaPaginaInicial;
    @FXML
    private Button botaoAdd;
    @FXML
    private Button botaoEditar;
    
    InnerShadow sombra = new InnerShadow();
    MotionBlur blur = new MotionBlur();
    @FXML
    private Button botaoSobre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //transiçãoAparecer();
    }    

    @FXML
    private void VisualizarBotaoClk(ActionEvent event) throws IOException {
        mudarDePagina("visualizar livros", "visualizar");
    }
    
    private void transiçãoAparecer(){
        FadeTransition transição = new FadeTransition(Duration.millis(1000), janelaPaginaInicial);
        transição.setFromValue(0);
        transição.setToValue(1);
        transição.play();
    }


    @FXML
    private void botaoEditarClicado(ActionEvent event) throws IOException {
        mudarDePagina("editar livro", "editar");
    }

    @FXML
    private void btnVisalizarMouseLonge(MouseEvent event) {
        BotaoVisualizar.setEffect(null);
    }

    @FXML
    private void btnVisalizarMouseProximo(MouseEvent event) {
        BotaoVisualizar.setEffect(blur);
    }

    @FXML
    private void btnAddMouseProximo(MouseEvent event) {
        botaoAdd.setEffect(blur);
    }

    @FXML
    private void btnEditarMouseLonge(MouseEvent event) {
        botaoEditar.setEffect(null);
    }

    @FXML
    private void btnEditarMouseProximo(MouseEvent event) {
        botaoEditar.setEffect(blur);
    }

    @FXML
    private void btnAddMouseLonge(MouseEvent event) {
        botaoAdd.setEffect(null);
    }

    @FXML
    private void botaoSobreMouseLonge(MouseEvent event) {
        botaoSobre.setEffect(null);
    }

    @FXML
    private void botaoSobreMouseProximo(MouseEvent event) {
        botaoSobre.setEffect(sombra);
    }

    @FXML
    private void botaoAddClicado(ActionEvent event) throws IOException {
        mudarDePagina("adicionar livro", "adicionar");
    }

    @FXML
    private void botaoSobreClicado(ActionEvent event) throws IOException {
        mudarDePagina("sobre", "ver sobre");
    }
    
    private void mudarDePagina (String caminho,String botaoTipo) throws IOException{
        System.out.println("Botao de "+botaoTipo+" livro da biblioteca foi clicado");
        //trocar de janela
        Parent root = FXMLLoader.load(getClass().getResource(caminho+".fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)BotaoVisualizar.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
    }
    
    
}
