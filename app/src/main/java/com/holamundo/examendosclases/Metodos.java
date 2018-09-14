package com.holamundo.examendosclases;

import java.util.ArrayList;

public class Metodos {

    public static int reporte4 (ArrayList<Celular> cel){
        String marca, color;
        int conteo=0;
        for (int i = 0; i <cel.size() ; i++) {
            marca= cel.get(i).getMarca().toString();
            color= cel.get(i).getColor().toString();

            if (marca.equalsIgnoreCase("Apple") && color.equalsIgnoreCase("negro")){
                conteo++;
            }
        }
        return conteo;
    }

}
