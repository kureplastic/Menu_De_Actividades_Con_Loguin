package com.example.menu_de_actividades_con_loguin.ui.actividades;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu_de_actividades_con_loguin.R;
import com.example.menu_de_actividades_con_loguin.databinding.ItemDetalleBinding;
import com.example.menu_de_actividades_con_loguin.models.Actividad;

public class DetalleFragment extends Fragment {

    private DetalleViewModel mViewModel;
    private ItemDetalleBinding binding;


    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        binding = ItemDetalleBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        //esto deberia estar dentro del viewmodel con un mutable de actividad
        Bundle recuperar = getArguments();
        Actividad actividad = (Actividad) recuperar.getSerializable("actividad");

        binding.tvDetalleNombre.setText(actividad.getNombre());
        binding.tvDetalleFecha.setText(actividad.getFecha());
        binding.tvDetalleHora.setText(actividad.getHora());
        binding.tvDetalleLugar.setText(actividad.getLugar());
        binding.tvDetalleDescripcion.setText(actividad.getDescripcion());
        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetalleViewModel.class);
        // TODO: Use the ViewModel
    }

}