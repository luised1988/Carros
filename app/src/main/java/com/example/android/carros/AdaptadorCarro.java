package com.example.android.carros;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 07/10/2017.
 */

public class AdaptadorCarro extends BaseAdapter {

    private Context contexto;
    private ArrayList<Carro> carros;
    private Resources res;
    private String [] m,mo;

    public AdaptadorCarro(Context contexto, ArrayList<Carro>carros){
        this.contexto=contexto;
        this.carros=carros;
        res=contexto.getResources();
        m=res.getStringArray(R.array.marca);
        mo=res.getStringArray(R.array.modelo);

    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        res=contexto.getResources();
        View v = view;

        LayoutInflater inf = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inf.inflate(R.layout.item_lista,null);

        Carro c = carros.get(i);

        ImageView foto = (ImageView)v.findViewById(R.id.imgFoto);
        TextView placa = (TextView) v.findViewById(R.id.lblPlaca);
        TextView marca = (TextView) v.findViewById(R.id.lblMarca);
        TextView modelo = (TextView) v.findViewById(R.id.lblModelo);
        TextView precio = (TextView) v.findViewById(R.id.lblPrecio);

        foto.setImageDrawable(ResourcesCompat.getDrawable(res,c.getFoto(),null));
        placa.setText(c.getPlaca());
        marca.setText(m[c.getMarca()]);
        modelo.setText(mo[c.getModelo()]);
        precio.setText(c.getPrecio());

        return v;
    }
}
