package com.mycompany.modelo;

public class DatoPartido {
              
    private final String dateTime;
    private final String stage;
    private final String stadium;
    private final String city;
    private final String equipo1;
    private final String golesEq1;
    private final String equipo2;
    private final String golesEq2;

    public String getDateTime() {
        return dateTime;
    }

    public String getStage() {
        return stage;
    }

    public String getStadium() {
        return stadium;
    }

    public String getCity() {
        return city;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public String getGolesEq1() {
        return golesEq1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public String getGolesEq2() {
        return golesEq2;
    }
    
    
    public DatoPartido(String dateTime,String stage,String stadium,String city,String equipo1,String golesEq1,String equipo2,String golesEq2){
        
        this.dateTime = dateTime;
        this.stage = stage;
        this.stadium = stadium;
        this.city = city;
        this.equipo1 = equipo1;
        this.golesEq1 = golesEq1;
        this.equipo2 = equipo2;
        this.golesEq2 = golesEq2;
        
    }
    
    
}
