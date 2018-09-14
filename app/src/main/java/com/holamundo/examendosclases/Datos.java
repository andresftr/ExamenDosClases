package com.holamundo.examendosclases;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Celular> celulares = new ArrayList<>();

    public static void guardar (Celular cel){
        celulares.add(cel);
    }

    public static ArrayList<Celular> obtener(){
        return celulares;
    }
}
