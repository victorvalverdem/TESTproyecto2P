/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmvm.appcopadelmundo;

import static com.vmvm.appcopadelmundo.App.path;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author victo
 */
public class ConsultaCopasController implements Initializable {
    
    @FXML
    TextField txtYear;
    
    @FXML
    VBox gridContainer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){}
    
    public void consultar(ActionEvent e){
        String anio = txtYear.getText();
        String[] datos = App.datosCopaDelAnio(Integer.parseInt(anio));
        //PROTOCOLO DE DIALOGBOX CON AÑO INVALIDO
        //Realmente se atrapa una YearCupMismatch
        try{
        mostrarDatosEnUnaGrid(datos);
        } catch (Exception x){
            System.out.println("Error en el proceso de mostrar datos históricos en una grid");
            System.out.println(x.getMessage());
        }
        
    }
    
    public void mostrarDatosEnUnaGrid(String[] datos) throws FileNotFoundException{
        
        //VBox rootVistaCopas = (VBox)txtYear.getScene().getRoot();
        gridContainer.getChildren().clear();
        
        //Creacion del GridPane principal
        GridPane grid = new GridPane();
        
        //SECCION 0.1 - IMPLEMENTACION DE LAS ETIQUETAS DATOS GENERALES/PREMIOS
        VBox cajaPremios = new VBox();
        VBox cajaDatosGenerales = new VBox();
        
        Label lblPremios = new Label("Premios");
        Label lblDatosGenerales = new Label("Datos Generales");
        
        Separator sepPremios = new Separator();
        Separator sepDatosGenerales = new Separator();
        
        cajaPremios.getChildren().addAll(lblPremios, sepPremios);
        cajaDatosGenerales.getChildren().addAll(lblDatosGenerales, sepDatosGenerales);
        
        grid.add(cajaPremios, 0,0);
        grid.add(cajaDatosGenerales, 3, 0);
        

        // SECCION 1 - ETIQUETAS
        grid.add(new Label("Primero"), 0, 1);
        grid.add(new Label("Segundo"), 0, 2);
        grid.add(new Label("Tercero"), 0, 3);
        grid.add(new Label("Cuarto"), 0, 4);

        //SECCION 2 - PAIS CON BANDERA
        HBox primero = new HBox(new ImageView(new Image(new FileInputStream(App.path+datos[0]+".png"), 20,20,true,true)), new Label(datos[0]));
        HBox segundo = new HBox(new ImageView(new Image(new FileInputStream(App.path+datos[1]+".png"),20,20,true,true)), new Label(datos[1]));
        HBox tercero = new HBox(new ImageView(new Image(new FileInputStream(App.path+datos[2]+".png"),20,20,true,true)), new Label(datos[2]));
        HBox cuarto = new HBox(new ImageView(new Image(new FileInputStream(App.path+datos[3]+".png"),20,20,true,true)), new Label(datos[3]));
        grid.add(primero, 1, 1);
        grid.add(segundo, 1, 2);
        grid.add(tercero, 1, 3);
        grid.add(cuarto, 1, 4);
        //TO DO MÉTODOS PARA CONSEGUIR BANDERA (ESTATICOS EN PRINCIPAL?)
        
        //SECCION 3 - NUMERO DE VECES CAMPEON
        
        //ImageView copa = new ImageView(new Image(new FileInputStream(App.path+"WorldCupTrophy.png"), 20,20,true,true));
        for(int i=0; i<4; i++){
            HBox contenedorCopas = new HBox();
            for(int j=0;j<calcularCopas(datos[i]);j++){
                contenedorCopas.getChildren().add(new ImageView(new Image(new FileInputStream(App.path+"WorldCupTrophy.png"), 20,20,true,true)));
     
            }
            
            contenedorCopas.setSpacing(5);
            grid.add(contenedorCopas,2,i+1);
            
        }
        
        

        // SECCION 4 - DATOS GENERALES
        grid.add(new Label("Goles anotados: "+datos[5]), 3, 1);
        grid.add(new Label("Equipos: "+datos[6]), 3, 2);
        grid.add(new Label("Partidos jugados: "+datos[7]), 3, 3);
        grid.add(new Label("Asistencias: "+datos[8]), 3, 4);
        
       grid.setHgap(20);
       grid.setVgap(20);
       grid.setPadding(new Insets(0,0,0,100));
       
        
       gridContainer.getChildren().addAll(grid);
    
    }
    
    public int calcularCopas(String pais){
        int contadorCopas = 0;
        try(BufferedReader bf = new BufferedReader(new FileReader(path + "WorldCups.csv"))){
            bf.readLine(); //cabecera
            String linea = bf.readLine();
            while(linea!= null){
                String[] datos = linea.split(",");
                if(datos[2].equals(pais)){
                    contadorCopas++;
                }
                linea = bf.readLine();
            }
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return contadorCopas;
    }
    
    
}