package com.example.menu_de_actividades_con_loguin.ui.actividades;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.menu_de_actividades_con_loguin.models.Actividad;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ActividadesViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<ArrayList<Actividad>> mActividades;
    private ArrayList<Actividad> actividades;

    public ActividadesViewModel(@NonNull Application application){
        super(application);
        Log.d("entrada","entro");
        mActividades = new MutableLiveData<>();
        actividades = new ArrayList<>();
        //llenar actividades
        actividades.add(new Actividad("correr","salir a correr por 3 min.","20/09/1993","16:00","La Punta"));
        actividades.add(new Actividad("natacion","clase de natacion.","21/04/2023","16:00","San Luis"));
        actividades.add(new Actividad("atletismo","practicas de atletismo por 2 hrs.","20/5/2023","16:00","Juana Koslay"));
        //pasar peliculas al mutable
        mActividades.setValue(actividades);
    }

public LiveData<ArrayList<Actividad>> getMActividades(){return mActividades;}





}