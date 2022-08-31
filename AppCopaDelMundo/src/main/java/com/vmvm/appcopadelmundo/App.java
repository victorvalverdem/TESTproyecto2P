package com.vmvm.appcopadelmundo;

import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String path = "src/main/resources/com/vmvm/appcopadelmundo/";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader vista = new FXMLLoader(App.class.getResource("Inicio.fxml"));
        Parent root = vista.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static String[] datosCopaDelAnio(int year){
        String dato[] = new String[9];
        try(BufferedReader bf = new BufferedReader(new FileReader(path + "WorldCups.csv"))){
            bf.readLine(); //cabecera
            String linea = bf.readLine();
            while(linea!= null){
                String[] datos = linea.split(",");
                if(Integer.parseInt(datos[0])==year){
                    dato[0] = datos[2]; //Primero
                    dato[1]= datos[3]; //Segundo
                    dato[2] =    datos[4]; //Tercero
                    dato[3] =    datos[5]; //Cuarto
                    dato[4]= "POR DEFINIR"; //Veces campeon
                    dato[5] =    datos[6]; //Goles anotados
                    dato[6] =    datos[7]; //Equipos calificados
                    dato[7] =    datos[8]; //Partidos jugados
                    dato[8] =    datos[9]; //Asistencia
                }
                linea = bf.readLine();
            }
            
        } catch (Exception e){
            System.out.println("Error en lectura de datos históricos");
            //Catch Exception YearCupMismatch, string="No se jugó en ese año el mundial" (va en alguna label o Alert)
        }
        
        return dato;
    }
    
    public static String[] datosDelPartido(String ronda, String local, String visitante){
        /*
        Year|Datetime|Stage|Stadium|City|Home Team Name|Home Team Goals|Away Team Goals|Away Team Name|Win conditions|Attendance|Half-time Home Goals|Half-time Away Goals|Referee|Assistant 1|Assistant 2|RoundID|MatchID|Home Team Initials|Away Team Initials
2014|12 Jun 2014 - 17:00 |Group A|Arena de Sao Paulo|Sao Paulo |Brazil|3|1|Croatia| |62103|1|1|NISHIMURA Yuichi (JPN)|SAGARA Toru (JPN)|NAGI Toshiyuki (JPN)|255931|300186456|BRA|CRO
2014|13 Jun 2014 - 13:00 |Group A|Estadio das Dunas|Natal |Mexico|1|0|Cameroon| |39216|0|0|ROLDAN Wilmar (COL)|CLAVIJO Humberto (COL)|DIAZ Eduardo (COL)|255931|300186492|MEX|CMR
2014|13 Jun 2014 - 16:00 |Group B|Arena Fonte Nova|Salvador |Spain|1|5|Netherlands| |48173|1|1|Nicola RIZZOLI (ITA)|Renato FAVERANI (ITA)|Andrea STEFANI (ITA)|255931|300186510|ESP|NED

        */
        //String dato[] = new String[9]; <------ Definir el dato que devuelve esta funcion
        String[] dato = new String[7];
        
        try(BufferedReader bf = new BufferedReader(new FileReader(path + "WorldCupMatchesBrasil2014.csv"))){
            bf.readLine(); //cabecera
            String linea = bf.readLine();
            while(linea!= null){
                String[] datos = linea.split("|");
                if(datos[2].equals("Group "+ronda) && datos[5].equals(local) && datos[8].equals(visitante)){
                    String fecha = datos[1];
                    //Grupo directamente con lo pasado como argumento de la funcion
                    String estadio = datos[3];
                    String ciudad = datos[4];
                    String Nlocal = datos[5];
                    String Glocal = datos[6];
                    String Gvisita = datos[7];
                    String Nvisita = datos[8];
                    
                    dato[0] = fecha;
                    dato[1] = estadio;
                    dato[2] = ciudad;
                    dato[3] = Nlocal;
                    dato[4] = Glocal;
                    dato[5] = Gvisita;
                    dato[6] = Nvisita;
                }
                linea = bf.readLine();
            }
            
        } catch (Exception e){
            System.out.println("Error");
        }
        
        return dato;
        
        
    }

}