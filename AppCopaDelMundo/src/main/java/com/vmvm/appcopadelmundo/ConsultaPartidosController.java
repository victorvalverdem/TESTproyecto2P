/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vmvm.appcopadelmundo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author victo
 */
public class ConsultaPartidosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ComboBox<String> pickerFase;
    @FXML
    HBox contenedorFase;
    @FXML
    VBox rootConsultaPartidos;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pickerFase.getItems().addAll("Grupos","Ronda de 16","Cuartos","Semifinal","Final");
    }
    
    
    /*
    1. VER DONDE ES MÁS CONVENIENTE HACER VALIDACIONES, CONSIDERAR VALIDACIONES BOOLEANAS
    2. DEFINIR NUEVOS CONTENEDORES PARA REUSO, PRINCIPALMENTE CUANDO SE DEBE BORRAR EL TAG DE GRUPO PARA LA ELECCIÓN NO-GRUPO;
    */
    
    @FXML
    public void seleccionarFase(ActionEvent e){
        
        if(pickerFase.getValue().equals("Grupos")){
            if(contenedorFase.getChildren().size() == 2){
                addPickerGrupos();
                //Que addPickerGrupos retorne la respuesta al action event para pasárselo al addPickerEquipos
                if(rootConsultaPartidos.getChildren().size() == 2){
                addPickerEquipos();  
                }
            }
      
        } else {
            if(contenedorFase.getChildren().size() > 2){
                contenedorFase.getChildren().clear();
                contenedorFase.getChildren().addAll(new Label("Fases: "), pickerFase);
            }
            if(rootConsultaPartidos.getChildren().size() == 2){
                addPickerEquipos(); //Pasarle como parametro la fase, para que la funcion cargue los equipos de esa fase
            }
         
        }
        
    }
    
    public void addPickerGrupos(){
        ComboBox<String> pickerGrupo = new ComboBox();
        pickerGrupo.getItems().addAll("A","B","C","D","E","F");
        
        contenedorFase.getChildren().addAll(
        new Label("Grupos: "),
        pickerGrupo
        );
        
    }
    
    public void addPickerEquipos(){
        
        ComboBox<String> pickerLocal = new ComboBox();
        ComboBox<String> pickerVisitante = new ComboBox();
        pickerLocal.getItems().addAll("EQUIPOS ADECUADOS");
        pickerVisitante.getItems().addAll("LOS MISMOS EQUIPOS DEL OTRO PICKER");
        
        HBox contenedorEquipos = new HBox();
        contenedorEquipos.getChildren().addAll(
        new Label("Equipo 1"),
        pickerLocal,
        new Label("Equipo 2"),
        pickerVisitante
        );
        
        rootConsultaPartidos.getChildren().addAll(contenedorEquipos);
    }
    
    public void mostrarDatosDelPartido(String[] dato){
        
        VBox contenedorResultadosPartido = new VBox();
        
        Label lblResultadosPartido = new Label("Resultados del partido");
        Label lblFecha = new Label("FECHA EN ESPAÑOL POR DEFINIR");
        Separator separador = new Separator();
        
        //Caja Principal
        HBox contenedorCajaDetalles = new HBox();
        //
        
        
        VBox contenedorDetalles = new VBox(new Label(dato[0]), new Label("Grupo X"), new Label(dato[1]), new Label(dato[2]));
        HBox contenedorLocal = new HBox(new Label("Aquí su foto"), new Label(dato[3]));
        VBox contenedorResultado = new VBox(new Label("FINAL DEL PARTIDO"), new Label(dato[4]+"-"+dato[5]));
        HBox contenedorVisitante = new HBox(new Label("Aquí su foto"), new Label(dato[6]));

        contenedorCajaDetalles.getChildren().addAll(contenedorDetalles, contenedorLocal, contenedorResultado, contenedorVisitante);
        
        
        contenedorResultadosPartido.getChildren().addAll(lblResultadosPartido, lblFecha, separador, contenedorCajaDetalles);
        
    }

    
    
    
}
