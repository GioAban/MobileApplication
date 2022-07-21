package com.example.agritech.fragments;

import android.content.Intent;
import android.os.Bundle;


import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agritech.R;


import com.example.agritech.cucumber;
import com.example.agritech.melon;
import com.example.agritech.nepheliumlappaceum;
import com.example.agritech.papaya;
import com.example.agritech.pineapple;
import com.example.agritech.watermelon;

public class FruitFragment extends Fragment{

    CardView melonCrd, cucumberCrd, papayaCrd, watermelonCrd, pineappleCrd, rambutanCrd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fruit, container, false);


        melonCrd = view.findViewById(R.id.melonCard);
        cucumberCrd = view.findViewById(R.id.cucumberCard);
        papayaCrd = view.findViewById(R.id.papayaCard);
        watermelonCrd = view.findViewById(R.id.watermelonCard);
        pineappleCrd = view.findViewById(R.id.pineappleCard);
        rambutanCrd = view.findViewById(R.id.rambutanCard);

        melonCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), melon.class);
                startActivity(in);
            }
        });

        cucumberCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), cucumber.class);
                startActivity(in);
            }
        });

        papayaCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), papaya.class);
                startActivity(in);
            }
        });

        watermelonCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), watermelon.class);
                startActivity(in);
            }
        });
        pineappleCrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), pineapple.class);
                startActivity(in);
            }
        });
        rambutanCrd .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), nepheliumlappaceum.class);
                startActivity(in);
            }
        });

        return view;
    }



}