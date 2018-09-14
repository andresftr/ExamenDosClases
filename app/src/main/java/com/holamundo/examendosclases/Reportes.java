package com.holamundo.examendosclases;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Reportes extends Activity {
    private ListView lv;
    private String[] opc;
    private Intent in;
    private ArrayList celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        celular = Datos.obtener();
        lv = findViewById(R.id.lstReportes);
        opc = getResources().getStringArray(R.array.opReportes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opc);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        in = new Intent(Reportes.this, ReporteDos.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Reportes.this, ReporteTres.class);
                        startActivity(in);
                        break;
                    case 2:
                        int numero;
                        String resultado;
                        numero= Metodos.reporte4(celular);
                       resultado= getResources().getString(R.string.mensaje4)+ String.valueOf(numero);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Reportes.this);
                        builder.setTitle(R.string.reporte4);
                        builder.setMessage(resultado);
                        builder.setNeutralButton("Ok", null);
                        Dialog dialog = builder.create();
                        dialog.show();

                        break;
                }
            }
        });
    }
}
