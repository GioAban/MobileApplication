package com.example.agritech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Tomato extends AppCompatActivity {


    //Floating action button variables - Plant Calculation
    private FloatingActionButton fab1_mainBulb, fab2_CalPlant;
    //private TextView calPlantText;
    private Animation fabOpen, fabClose, rotateForward, rotateBackward;
    private boolean isOpen = false; // by default it is false

    MaterialAlertDialogBuilder builder;

    //For expandable variables declaration
    LinearLayout detailsSeedlings;
    LinearLayout detailsFertilizer;
    LinearLayout detailsPest;
    ImageView arrowImage1, arrowImage2, arrowImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_tomato);


        fab1_mainBulb = findViewById(R.id.fab1);
        fab2_CalPlant = findViewById(R.id.plantCal);


        //calPlantText = findViewById(R.id.calPlant);

        //Animation
        fabOpen = AnimationUtils.loadAnimation(Tomato.this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(Tomato.this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(Tomato.this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(Tomato.this, R.anim.rotate_backward);

        //expandable initialization
        detailsSeedlings = findViewById(R.id.details1gone);
        detailsFertilizer = findViewById(R.id.details2gone);
        detailsPest = findViewById(R.id.details3gone);
        arrowImage1 = findViewById(R.id.flipArrow1);
        arrowImage2 = findViewById(R.id.flipArrow2);
        arrowImage3 = findViewById(R.id.flipArrow3);



        //set the click listener on the MAIN FAB
        fab1_mainBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animateFab();
            }
        });
        //Plant Cal
        fab2_CalPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float rowSpacing = 0.5f;
                float plantSpacing = 0.5f;

                Intent intent = new Intent(getApplicationContext(), PlantPopulation.class);
                intent.putExtra("ROW", rowSpacing);
                intent.putExtra("PLANT", plantSpacing);
                startActivity(intent);

            }
        });

    }


    // call this function when we click floating action button
        private void animateFab(){
        if(isOpen){
            fab1_mainBulb.startAnimation(rotateForward);
            fab2_CalPlant.startAnimation(fabClose);
            fab2_CalPlant.setClickable(false);
            isOpen=false;
        }else{
            fab1_mainBulb.startAnimation(rotateBackward);
            fab2_CalPlant.startAnimation(fabOpen);
            fab2_CalPlant.setClickable(true);
            isOpen=true;
        }
        }

    // call this function when we click expandable card
        public void expandSeedlings(View view){
             if(detailsSeedlings.getVisibility() == View.GONE) {
                 TransitionManager.beginDelayedTransition(detailsSeedlings, new AutoTransition());
                 detailsSeedlings.setVisibility(View.VISIBLE);
                arrowImage1.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
             }else{
                 TransitionManager.beginDelayedTransition(detailsSeedlings, new AutoTransition());
                 detailsSeedlings.setVisibility(View.GONE);
                arrowImage1.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
             }


        }

        public void expandFertilizer(View view){
            if(detailsFertilizer.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(detailsFertilizer, new AutoTransition());
                detailsFertilizer.setVisibility(View.VISIBLE);
                arrowImage2.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
            }else{
                TransitionManager.beginDelayedTransition(detailsFertilizer, new AutoTransition());
                detailsFertilizer.setVisibility(View.GONE);
                arrowImage2.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
            }
        }

        public void expandPest(View view) {
            if(detailsPest.getVisibility() == View.GONE) {
                TransitionManager.beginDelayedTransition(detailsPest, new AutoTransition());
                detailsPest.setVisibility(View.VISIBLE);
                arrowImage3.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
            }else{
                TransitionManager.beginDelayedTransition(detailsPest, new AutoTransition());
                detailsPest.setVisibility(View.GONE);
                arrowImage3.setImageResource(R.drawable.ic_baseline_arrow_drop_down_24);
            }
        }


    public void plantSpacing(View view) {
        Toast.makeText(this, "Plant to plant spacing", Toast.LENGTH_SHORT).show();
    }

    public void rowSpacing(View view) {
        Toast.makeText(this, "Row to row spacing", Toast.LENGTH_SHORT).show();
    }

    public void seedDepth(View view) {
        Toast.makeText(this, "Depth sow", Toast.LENGTH_SHORT).show();
    }

    public void sprout(View view) {
        Toast.makeText(this, "Sprout", Toast.LENGTH_SHORT).show();
    }

    public void hardening(View view) {
        Toast.makeText(this, "Hardening", Toast.LENGTH_SHORT).show();
    }

    public void transplanting(View view) {
        Toast.makeText(this, "Transplanting", Toast.LENGTH_SHORT).show();
    }

    public void potash(View view) {
        builder = new MaterialAlertDialogBuilder(Tomato.this);

        builder.setTitle("Potassium fertilizer");
        builder.setMessage("Potassium is the third key nutrient of commercial fertilizers. " +
                "It helps strengthen plants' abilities to resist disease and plays an important " +
                "role in increasing crop yields and overall quality.  ");

        // builder.setIcon(R.drawable.ic_baseline_help_center_2 4);
        builder.setPositiveButton("Ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add function here for OK
                    }
                });
        builder.show();
    }

    public void urea(View view) {
        builder = new MaterialAlertDialogBuilder(Tomato.this);

        builder.setTitle("Urea fertilizer");
        builder.setMessage("Urea fertilizer is a stable, organic fertilizer " +
                "that can improve the quality of your soil, provide nitrogen to " +
                "your plants, and increase the yield of your crops.");

        // builder.setIcon(R.drawable.ic_baseline_help_center_2 4);
        builder.setPositiveButton("Ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add function here for OK
                    }
                });
        builder.show();
    }

    public void complete(View view) {
        builder = new MaterialAlertDialogBuilder(Tomato.this);

        builder.setTitle("Complete Fertilizer");
        builder.setMessage("A complete fertilizer is a " +
                "fertilizer blend or mix that contains the " +
                "three main plant nutrients: nitrogen (N), phosphorus " +
                "(P), and potassium (K), in the forms of potash, phosphoric acid, and nitrogen. ");

        // builder.setIcon(R.drawable.ic_baseline_help_center_2 4);
        builder.setPositiveButton("Ok", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //add function here for OK
                    }
                });
        builder.show();
    }
}
