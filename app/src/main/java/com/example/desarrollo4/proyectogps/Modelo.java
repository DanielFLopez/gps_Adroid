package com.example.desarrollo4.proyectogps;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by desarrollo4 on 11/11/16.
 */

public class Modelo extends SugarRecord {

    String nombre, fecha;
    double longitud, latitud;

    public Modelo(){
    }

    public Modelo(String nombre, String fecha, double longitud, double latitud){
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

    public double getLongitud() {
        return longitud;
    }

    public double getLatitud() {
        return latitud;
    }
}
