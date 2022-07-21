package com.example.agritech;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.agritech.fragments.CropFragment;
import com.example.agritech.fragments.FruitFragment;
import com.example.agritech.fragments.VegetableFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position){
            case 0:
                return new VegetableFragment();
            case 1:
                return new FruitFragment();
            case 2:
                return new CropFragment();
            default:
                return new VegetableFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
