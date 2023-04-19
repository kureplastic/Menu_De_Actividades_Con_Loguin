package com.example.menu_de_actividades_con_loguin.ui.supermercados;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu_de_actividades_con_loguin.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MercadosFragment extends Fragment {

    private static final LatLng SUPER1=new LatLng(-33.181605, -66.312728);
    private static final LatLng SUPER2=new LatLng(-33.1831357,-66.3139977);
    private static final LatLng SUPER3=new LatLng(-33.1843899,-66.3129358);
    private static final LatLng LAPUNTA=new LatLng(-33.179748, -66.314788);
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.addMarker(new MarkerOptions().position(SUPER1).title("Super Mercado Aiello"));
            googleMap.addMarker(new MarkerOptions().position(SUPER2).title("Mini Mercado El Coloso"));
            googleMap.addMarker(new MarkerOptions().position(SUPER3).title("Mini Mercado Tio Mecha"));
            CameraPosition camPos=new CameraPosition.Builder()
                    .target(LAPUNTA)
                    .zoom(15)
                    .bearing(0)
                    .tilt(40)
                    .build();
            CameraUpdate update= CameraUpdateFactory.newCameraPosition(camPos);
            googleMap.animateCamera(update);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mercados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}