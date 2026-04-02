/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package minhabibliotecaparticular;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author barba
 */
public class MinhaBibliotecaParticular extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        //carregar pagina inicial
        
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene paginaInicial = new Scene (root);
        primaryStage.setScene(paginaInicial);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Biblioteca Particular de Barbara");
        primaryStage.getIcons().add( new Image( MinhaBibliotecaParticular.class.getResourceAsStream( "/imgs/janelaIcone.png" )));
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(761);
       
        
    }
    
    
}
