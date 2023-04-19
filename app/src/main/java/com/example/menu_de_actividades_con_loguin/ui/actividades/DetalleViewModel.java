package com.example.menu_de_actividades_con_loguin.ui.actividades;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import com.example.menu_de_actividades_con_loguin.models.Actividad;

public class DetalleViewModel extends AndroidViewModel {

    private MutableLiveData<Actividad> mutableActividad;
    private Context context;

    public DetalleViewModel(@NonNull Application application) {
        super(application);

    }
    // TODO: Implement the ViewModel
    public LiveData<Actividad> getMutableActividad(){
        if(mutableActividad == null){
            mutableActividad = new MutableLiveData<>();
        }
        return mutableActividad;
    }
    public void recuperarActividad(Bundle bundle){
        Actividad actividad = (Actividad) bundle.getSerializable("actividad");
        mutableActividad.setValue(actividad);
    }

}