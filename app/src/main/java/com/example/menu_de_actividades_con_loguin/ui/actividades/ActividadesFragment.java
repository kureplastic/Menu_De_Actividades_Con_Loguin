package com.example.menu_de_actividades_con_loguin.ui.actividades;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu_de_actividades_con_loguin.databinding.FragmentActividadesBinding;
import com.example.menu_de_actividades_con_loguin.models.Actividad;

import java.util.ArrayList;

public class ActividadesFragment extends Fragment {

    private ActividadesViewModel actividadesViewModel;
    private FragmentActividadesBinding binding;

    public static ActividadesFragment newInstance() {
        return new ActividadesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        actividadesViewModel = new ViewModelProvider(this).get(ActividadesViewModel.class);
        binding = FragmentActividadesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //armar grilla
        GridLayoutManager grilla = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        binding.rvListaActividades.setLayoutManager(grilla);
        //observer para el mutable
        actividadesViewModel.getMActividades().observe(getViewLifecycleOwner(), new Observer<ArrayList<Actividad>>() {
            @Override
            public void onChanged(ArrayList<Actividad> actividades) {
                ActividadesAdapter adapter = new ActividadesAdapter(getContext(),actividades,getLayoutInflater());
                binding.rvListaActividades.setAdapter(adapter);
            }
        });

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}