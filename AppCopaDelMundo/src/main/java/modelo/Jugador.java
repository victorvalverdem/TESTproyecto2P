package com.mycompany.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.control.Alert;

public class Jugador {
    
    private String team;
    private String coach;
    private String nombre;
    private String numCamiseta;
    // Al momento de serializar el archivo se define la versión, 
    //sino sale que es un objeto de una clase diferente, por ejemplo tipo Object
    private static final long serialVersionUID = 8799656478674716638L;

    public String getTeam() {
        return team;
    }

    public String getCoach() {
        return coach;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumCamiseta() {
        return numCamiseta;
    }
    
    
    
    public Jugador(String team,String coach,String nombre,String numCamiseta){
        
        this.team = team;
        this.coach = coach;
        this.nombre = nombre;
        this.numCamiseta = numCamiseta;
        
    }
    
    
    public static ArrayList<Jugador> readListFromFileSer(String nomfile) throws FileNotFoundException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(nomfile)))){
            ArrayList<Jugador> jugadores= (ArrayList<Jugador>)in.readObject();
            in.close();
            return jugadores;
        } catch (IOException | ClassNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el archivo.");
            a.show();
        }
        return null;
    }

    
    
    public static void saveListToFileSer(String nomfile, ArrayList<Jugador> jugadores){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(nomfile)))){
            out.writeObject(jugadores);
            //Libera la memoria del buffer
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "No se encontró el archivo.");
            a.show();
        } catch (IOException ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "No se pudo abrir el archivo.");
            a.show();
        } 
    }

    
}
