package com.example.android.carros;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView lstopciones;
    private Resources res;
    private Intent i;
    private String opc [];
    private Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lstopciones = (ListView)findViewById(R.id.lstOpciones);
        res = this.getResources();
        contexto=this;

        opc = res.getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        lstopciones.setAdapter(adapter);

        lstopciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:
                        i = new Intent(Principal.this,RegistroCarros.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Principal.this,Listado_ListView.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
