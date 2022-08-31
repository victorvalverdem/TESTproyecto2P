/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmvm.appcopadelmundo;

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
import javafx.stage.Stage;

/**
 *
 * @author victo
 */
public class InicioController implements Initializable {
    
    @FXML
    Button btnConsultaCopa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    }
    
    @FXML
    public void consultarCopasMundiales(ActionEvent e) throws IOException{
        FXMLLoader vistaConsulta = new FXMLLoader(App.class.getResource("ConsultaCopas.fxml"));
        Parent rootVistaConsulta = vistaConsulta.load();
        
        Stage stagePrincipal = (Stage)btnConsultaCopa.getScene().getWindow();
        stagePrincipal.setScene(new Scene(rootVistaConsulta));
        
    }
    
    @FXML
    public void consultarPartidos(ActionEvent e)throws IOException {
        Stage ventanaConsultaPartidos = new Stage();
        ventanaConsultaPartidos.setTitle("Consulta los partidos del mundial 2014");
        
        FXMLLoader vistaConsultaPartidos = new FXMLLoader(App.class.getResource("ConsultaPartidos.fxml"));
        Parent rootConsultaPartidos = vistaConsultaPartidos.load();
        Scene escenaConsultaPartidos = new Scene(rootConsultaPartidos);
        
        ventanaConsultaPartidos.setScene(escenaConsultaPartidos);
        ventanaConsultaPartidos.show();
        
        
        
    }
    
    
}
