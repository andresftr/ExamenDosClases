package com.holamundo.examendosclases;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteDos extends Activity {
    private TableLayout tabla;
    private ArrayList<Celular> celulares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_dos);
        tabla = findViewById(R.id.tabla);
        celulares = Datos.obtener();
          String marca;
          int cap, pos=1;
        for (int i = 0; i < celulares.size(); i++) {
             marca = celulares.get(i).getMarca().toString();
             cap= celulares.get(i).getRam();
            if (marca.equalsIgnoreCase("Samsung")&& cap>=2 && cap<=4){
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);
                TextView c4 = new TextView(this);
                TextView c5 = new TextView(this);
                TextView c6 = new TextView(this);

                c1.setText("" + pos++);
                c2.setText(celulares.get(i).getColor());
                c3.setText(celulares.get(i).getMarca());
                c4.setText(celulares.get(i).getSistOp());
                c5.setText(String.valueOf(celulares.get(i).getRam()));
                c6.setText(String.valueOf(celulares.get(i).getPrecio()));

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);
                fila.addView(c6);

                tabla.addView(fila);
            }
        }
    }
}
