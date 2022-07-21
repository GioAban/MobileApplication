package com.example.agritech.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agritech.BANANA;
import com.example.agritech.COCONUT;
import com.example.agritech.R;
import com.example.agritech.SUGARCANE;
import com.example.agritech.SWEETCORN;
import com.example.agritech.papaya;


public class CropFragment extends Fragment {

CardView sweetcorn, coconut, sugarcane, banana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crop, container, false);

        sweetcorn = view.findViewById(R.id.sweetcorn);
        coconut = view.findViewById(R.id.coconut);
        sugarcane = view.findViewById(R.id.sugarcane);
        banana = view.findViewById(R.id.banana);

        sweetcorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SWEETCORN.class);
                startActivity(i);
            }
        });


        coconut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), COCONUT.class);
                startActivity(i);
            }
        });

        sugarcane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SUGARCANE.class);
                startActivity(i);
            }
        });

        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BANANA.class);
                startActivity(i);
            }
        });



        return view;
    }
}