package com.example.menu_de_actividades_con_loguin.ui.llamar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu_de_actividades_con_loguin.R;
import com.example.menu_de_actividades_con_loguin.databinding.FragmentLlamarBinding;

public class LlamarFragment extends Fragment {

    private LlamarViewModel mViewModel;
    private FragmentLlamarBinding binding;

    public static LlamarFragment newInstance() {
        return new LlamarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(LlamarViewModel.class);
        binding = FragmentLlamarBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        binding.btFlotanteLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // funcion validacion
                mViewModel.Validar(binding.etLlamar.getText().toString());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LlamarViewModel.class);
        // TODO: Use the ViewModel
    }

}