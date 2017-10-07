package com.example.android.carros;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroCarros extends AppCompatActivity {

    private EditText cajaplaca,cajaprecio;
    private Resources res;
    private Spinner cajamarca;
    private Spinner cajamodelo;
    private Spinner cajacolor;
    private String [] marca;
    private String [] modelo;
    private String [] color;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carros);

        cajaplaca = (EditText)findViewById(R.id.txtPlaca);
        cajaprecio = (EditText)findViewById(R.id.txtPrecio);
        cajamarca = (Spinner)findViewById(R.id.spnMarca);
        cajamodelo = (Spinner)findViewById(R.id.spnModelo);
        cajacolor = (Spinner)findViewById(R.id.spnColor);
        res = this.getResources();

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

        marca = res.getStringArray(R.array.marca);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,marca);
        cajamarca.setAdapter(adapter);

        modelo = res.getStringArray(R.array.modelo);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,modelo);
        cajamodelo.setAdapter(adapter2);

        color = res.getStringArray(R.array.color);
        ArrayAdapter<String> adapter3 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,color);
        cajacolor.setAdapter(adapter3);
    }


    public void guardar (View v){
        String placa, precio;
        int marca,modelo,color;

        placa = cajaplaca.getText().toString();
        precio = cajaprecio.getText().toString();

        marca = cajamarca.getSelectedItemPosition();
        modelo = cajamodelo.getSelectedItemPosition();
        color = cajacolor.getSelectedItemPosition();

        boolean valido = true;

        if (placa.isEmpty()) {
            cajaplaca.setError("Ingrese la Placa");
            cajaplaca.requestFocus();
            valido = false;

        } else if (precio.isEmpty()) {
            cajaprecio.setError("Ingrese el precio");
            cajaprecio.requestFocus();
            valido = false;
        }

        if (valido) {

        Carro c=new Carro(Metodos.fotoAleatoria(fotos),placa, marca, modelo, color, precio);
        c.guardar();

        Toast.makeText(this,res.getString(R.string.registro_guardado),Toast.LENGTH_SHORT).show();
        limpiar();

        }
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cajaplaca.setText("");
        cajaprecio.setText("");
        cajamarca.setSelection(0);
        cajamodelo.setSelection(0);
        cajacolor.setSelection(0);
    }

}
