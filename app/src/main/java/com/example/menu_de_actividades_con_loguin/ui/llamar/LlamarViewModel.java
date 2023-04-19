package com.example.menu_de_actividades_con_loguin.ui.llamar;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamarViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> mutableValidar;
    private Context context;

    public LlamarViewModel(@NonNull Application application) {
        super(application);
        mutableValidar = new MutableLiveData<>();
        context = application.getApplicationContext();
    }

    public MutableLiveData<Boolean> getMutableValidar() {
        return mutableValidar;
    }

    public void Validar(String numerotel){
        if(numerotel.equals("")){
            Toast.makeText(context, "Numero no valido, debe ingresar un numero telefonico", Toast.LENGTH_SHORT).show();
            mutableValidar.setValue(false);
        }
        else {
            mutableValidar.setValue(true);
            iniciarActionLlamar(numerotel);
        }
    }

    public void iniciarActionLlamar(String tel){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +tel));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}