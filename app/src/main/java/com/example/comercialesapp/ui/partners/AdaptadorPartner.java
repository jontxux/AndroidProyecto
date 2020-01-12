package com.example.comercialesapp.ui.partners;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.comercialesapp.R;

import java.util.ArrayList;

public class AdaptadorPartner extends ArrayAdapter{
    private Activity contexto;
    private ArrayList<Partner> datos;

    public AdaptadorPartner(Activity context, ArrayList<Partner> datos) {
        super(context, R.layout.listview_partner, datos);
        this.contexto = context;
        this.datos = datos;
    }

    private static class ViewHolder{
        private EditText nombre;
        private EditText telefono;
        private EditText correo;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Partner partner;
        partner = datos.get(position);
        View item;

        if (convertView == null) {
            LayoutInflater inflater = contexto.getLayoutInflater();
            item = inflater.inflate(R.layout.listview_partner, null);
            final ViewHolder holder = new ViewHolder();
            holder.nombre = item.findViewById(R.id.txtNombreMostrar);
            holder.telefono = item.findViewById(R.id.txtTelefonomostrar);
            holder.correo = item.findViewById(R.id.txtCorreoMostrar);
            item.setTag(holder);
        } else {
            item = convertView;
        }

        ViewHolder holder = (ViewHolder) item.getTag();
        holder.nombre.setText(partner.getNombre());
        holder.telefono.setText(partner.getTelefono());
        holder.correo.setText(partner.getCorreo());

        return item;
    }
}