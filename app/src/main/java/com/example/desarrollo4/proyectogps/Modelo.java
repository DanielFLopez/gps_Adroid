package com.example.desarrollo4.proyectogps;

import com.orm.SugarRecord;

/**
 * Created by desarrollo4 on 11/11/16.
 */

public class Modelo extends SugarRecord {

    String nombre, fecha;
    float longitud, latitud;

    public Modelo(){

    }

    public Modelo(String nombre, String fecha, float longitud, float latitud){
        this.nombre = nombre;
        this.fecha = fecha;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNombre(){
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public float getLongitud() {
        return longitud;
    }

    public float getLatitud() {
        return latitud;
    }

}
