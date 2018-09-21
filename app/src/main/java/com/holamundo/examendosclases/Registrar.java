package com.holamundo.examendosclases;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registrar extends Activity {
    private Spinner cmbMarca, cmbColor, cmbSistOp;
    private EditText txtRam, txtPrecio;
    private Resources recursos;
    private String marc[], col[], sist[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        recursos=this.getResources();
        cmbMarca = findViewById(R.id.cmbMarca);
        cmbColor = findViewById(R.id.cmbColor);
        cmbSistOp = findViewById(R.id.cmbSistemaOp);

        marc = recursos.getStringArray(R.array.marcas);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,marc);
        cmbMarca.setAdapter(adapter);

        col = recursos.getStringArray(R.array.colores);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,col);
        cmbColor.setAdapter(adapter1);

        sist = recursos.getStringArray(R.array.sistemas);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sist);
        cmbSistOp.setAdapter(adapter2);

        txtRam = findViewById(R.id.txtRam);
        txtPrecio = findViewById(R.id.txtPrecio);
    }
    
    public void guardar(View v){
        if (validar()) {
            String marca, color, sistOperativo;
            int ram, precio;
            marca = cmbMarca.getSelectedItem().toString();
            color = cmbColor.getSelectedItem().toString();
            sistOperativo = cmbSistOp.getSelectedItem().toString();
            ram = Integer.parseInt(txtRam.getText().toString());
            precio = Integer.parseInt(txtPrecio.getText().toString());

            Celular cel = new Celular(marca, color, sistOperativo, ram, precio);
            cel.guardar();

            Toast.makeText(this, recursos.getString(R.string.guardado), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validar(){
        if (cmbMarca.getSelectedItemPosition()==0){
            Toast.makeText(this,R.string.error_1,Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cmbColor.getSelectedItemPosition()==0){
            Toast.makeText(this,R.string.error_2,Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cmbSistOp.getSelectedItemPosition()==0){
            Toast.makeText(this,R.string.error_3,Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtRam.getText().toString().isEmpty()){
            txtRam.setError(recursos.getString(R.string.error_4));
            txtRam.requestFocus();
            return false;
        }
        int ram = Integer.parseInt(txtRam.getText().toString());
        if (ram<=0){
            txtRam.setError(recursos.getString(R.string.error_5));
            txtRam.requestFocus();
            return false;
        }
        if (txtPrecio.getText().toString().isEmpty()){
            txtPrecio.setError(recursos.getString(R.string.error_4));
            txtPrecio.requestFocus();
            return false;
        }
        int precio = Integer.parseInt(txtPrecio.getText().toString());
        if (precio<=0){
            txtPrecio.setError(recursos.getString(R.string.error_5));
            txtPrecio.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        borrar();
    }

    public void borrar(){
        cmbMarca.setSelection(0);
        cmbColor.setSelection(0);
        cmbSistOp.setSelection(0);
        txtPrecio.setText("");
        txtRam.setText("");
        cmbMarca.requestFocus();


    }


}
