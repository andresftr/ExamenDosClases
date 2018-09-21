package com.holamundo.examendosclases;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteTres extends Activity {
    private TableLayout tabla;
    private ArrayList<Celular> celulares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_tres);
        tabla = findViewById(R.id.tabla);
        celulares = Datos.obtener();
        String marca, color, sistema;
        int pos=1, precio, menor=0, posicion=0;
        for (int i = 0; i < celulares.size(); i++) {
            menor = celulares.get(0).getPrecio();
            marca = celulares.get(i).getMarca().toString();
            color = celulares.get(i).getColor().toString();
            sistema = celulares.get(i).getSistOp().toString();
            precio = celulares.get(i).getPrecio();
            if (marca.equalsIgnoreCase("Huawei") && color.equalsIgnoreCase(getString(R.string.color2)) && sistema.equalsIgnoreCase("Android")) {
            if (precio <= menor){
                menor= precio;
                posicion=i;
                }
            }
        }
        TableRow fila = new TableRow(this);
        TextView c1 = new TextView(this);
        TextView c2 = new TextView(this);
        TextView c3 = new TextView(this);
        TextView c4 = new TextView(this);
        TextView c5 = new TextView(this);
        TextView c6 = new TextView(this);

        c1.setText("" + pos++);
        c2.setText(celulares.get(posicion).getMarca());
        c3.setText(celulares.get(posicion).getColor());
        c4.setText(celulares.get(posicion).getSistOp());
        c5.setText(String.valueOf(celulares.get(posicion).getRam()));
        c6.setText(String.valueOf(celulares.get(posicion).getPrecio()));

        fila.addView(c1);
        fila.addView(c2);
        fila.addView(c3);
        fila.addView(c4);
        fila.addView(c5);
        fila.addView(c6);

        tabla.addView(fila);
    }
}
