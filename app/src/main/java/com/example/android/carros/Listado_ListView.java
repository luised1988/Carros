package com.example.android.carros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Listado_ListView extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Carro> carros;
    private Context contexto;
    private AdaptadorCarro adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado__list_view);

        lista = (ListView)findViewById(R.id.lstListadoCarros);
        contexto = this.getApplicationContext();
        carros = Datos.obteberPersonas();
        adapter = new AdaptadorCarro(contexto,carros);
        lista.setAdapter(adapter);


    }
}
