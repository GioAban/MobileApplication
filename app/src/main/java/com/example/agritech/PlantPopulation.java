package com.example.agritech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class PlantPopulation extends AppCompatActivity {

    TextView tvPlantPopulation;
    TextInputEditText edtPlantSpacing, edtRowSpacing, edtLandArea;
    Button btnCalculate;
    MaterialAlertDialogBuilder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_plant_population);

        tvPlantPopulation = findViewById(R.id.totalPopulation);
        edtPlantSpacing = findViewById(R.id.textInputPlant);
        edtRowSpacing = findViewById(R.id.textInputRow);
        edtLandArea = findViewById(R.id.textInputArea);
        btnCalculate = findViewById(R.id.btnCalculate);


        //The value get is from Tomato.java
        float plantSpacing = getIntent().getFloatExtra("PLANT",0);
        float rowSpacing = getIntent().getFloatExtra("ROW",0);
        // Value get from Tomato.java will be set to EditText as hint
        edtPlantSpacing.setHint(plantSpacing + "");
        edtRowSpacing.setHint(rowSpacing + "");

        builder = new MaterialAlertDialogBuilder(PlantPopulation.this);

        builder.setTitle("Recommended spacing's");
        builder.setMessage("Plant to plant spacing : "+ plantSpacing +"\nRow to row spacing : " + rowSpacing
        + "\n\nYou can also input the spacing you want.");

        // builder.setIcon(R.drawable.ic_baseline_help_center_2 4);
        builder.setPositiveButton("Ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add function here for OK
                    }
                });
        builder.show();



        //Button calculate
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float plantSpacing = 0, rowSpacing = 0;
                float product, area = 0,  total;


                boolean have = true;


                try {
                     plantSpacing = Float.parseFloat(edtPlantSpacing.getText().toString().trim());
                }catch (Exception e){
                    Toast.makeText(PlantPopulation.this, "Invalid input for plant to plant spacing", Toast.LENGTH_SHORT).show();
                    have = false;
                }

                try {
                    rowSpacing = Float.parseFloat(edtRowSpacing.getText().toString().trim());
                }catch (Exception e){
                    Toast.makeText(PlantPopulation.this, "Invalid input for row to row spacing", Toast.LENGTH_SHORT).show();
                    have = false;
                }

                try {
                    area = Float.parseFloat(edtLandArea.getText().toString().trim());
                }catch (Exception e){
                    Toast.makeText(PlantPopulation.this, "Invalid input for Area of planting", Toast.LENGTH_SHORT).show();
                    have = false;
                }


                product = plantSpacing * rowSpacing;
                total =  area / product;
                int totalInt = (int) (total);

                if(have == true) { tvPlantPopulation.setText(totalInt+""); }
            }
        });




    }
}