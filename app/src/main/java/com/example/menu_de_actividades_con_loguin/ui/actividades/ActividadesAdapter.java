package com.example.menu_de_actividades_con_loguin.ui.actividades;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu_de_actividades_con_loguin.R;
import com.example.menu_de_actividades_con_loguin.models.Actividad;

import java.io.Serializable;
import java.util.ArrayList;

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.ViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Actividad> actividades;

    public ActividadesAdapter(Context context,ArrayList<Actividad> actividades, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
        this.actividades = actividades;
    }
    @NonNull
    @Override
    public ActividadesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= inflater.inflate(R.layout.item_actividad,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadesAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //por cada item en actividades hacer lo siguiente
        holder.tvNombre.setText(actividades.get(position).getNombre());
        holder.tvFecha.setText(actividades.get(position).getFecha());
        holder.tvHora.setText(actividades.get(position).getHora());
        Log.d(" adapter","paso2");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llevar a actividad nueva,
                // crear un bundle con todos los datos de actividad y presentarlos en un nuevo fragment
                Bundle bundle = new Bundle();
                bundle.putSerializable("actividad", actividades.get(position));
                //usar clase NavigationController
                Navigation.findNavController((Activity) context,R.id.nav_host_fragment_content_navigation).navigate(R.id.nav_detalle,bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombre, tvFecha, tvHora;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvHora = itemView.findViewById(R.id.tvHora);
        }
    }
}
