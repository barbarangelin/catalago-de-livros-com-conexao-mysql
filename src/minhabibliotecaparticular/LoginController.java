/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package minhabibliotecaparticular;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author barba
 */
public class LoginController implements Initializable {
    @FXML
    private TextField loginCaixa;
    @FXML
    private PasswordField senhaCaixa;
    @FXML
    private Button botaoIr;
    @FXML
    private TextArea textoAviso;
    @FXML
    private AnchorPane janelaLogin;
    
    Reflection reflefxão = new Reflection();
    MotionBlur blur = new MotionBlur();
    @FXML
    private ImageView imgPerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        transiçãoAparecer();
    }    

    @FXML
    private void validarLogin(ActionEvent event) throws IOException {
        System.out.println("O botão de validar conta foi clicado");
        if (loginCaixa.getText().equals("1") && senhaCaixa.getText().equals("1")){
            transiçãoSumir();
            contaValidadeCorretamente();
        } else {
            contaValidadeIncorretamente();
        }
    }
    
    private void contaValidadeCorretamente() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("pagina inicial.fxml"));
        Scene visualizarLivros = new Scene (root);
        Window janela = (Stage)botaoIr.getScene().getWindow();
        Stage s = (Stage) janela;
        //colocar janela nova na visualização
        s.setScene(visualizarLivros);
        s.setMinHeight(480);
        s.setMinWidth(761);
    }
    
    
    
    private void contaValidadeIncorretamente(){
        JOptionPane.showMessageDialog(null, "Login ou Senha foi digitado incorretamente","Erro no login",JOptionPane.WARNING_MESSAGE);
    }
    
    private void transiçãoAparecer(){
        FadeTransition transição = new FadeTransition(Duration.millis(2000), janelaLogin);
        transição.setFromValue(0);
        transição.setToValue(1);
        transição.play();
    }
    
    private void transiçãoSumir(){
        FadeTransition transição = new FadeTransition(Duration.millis(1000), janelaLogin);
        transição.setFromValue(1);
        transição.setToValue(0);
        transição.play();
    }

    @FXML
    private void teclaPressionadaLogin(KeyEvent event) {
        loginCaixa.setEffect(blur);
    }

    @FXML
    private void teclaLiberadaLogin(KeyEvent event) {
        loginCaixa.setEffect(null);
    }

    @FXML
    private void teclaPressionadaSenha(KeyEvent event) {
        senhaCaixa.setEffect(blur);
    }

    @FXML
    private void teclaLiberadaSenha(KeyEvent event) {
        senhaCaixa.setEffect(null);
    }

    @FXML
    private void perfilMouseLonge(MouseEvent event) {
        imgPerfil.setEffect(null);
    }

    @FXML
    private void perfilMouseProximo(MouseEvent event) {
        imgPerfil.setEffect(reflefxão);
    }
    
}
