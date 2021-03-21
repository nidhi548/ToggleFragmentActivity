package com.example.togglefragmentactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonToggleFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    int toggle = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        firstFragment = new FirstFragment();
//        secondFragment = new SecondFragment();
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        init();
    }

    private void init() {
        buttonToggleFragment = findViewById(R.id.button_add_fragment);
        fragmentTransaction = fragmentTransaction.add(R.id.fragment_container,firstFragment);
        fragmentTransaction.commit();
        buttonToggleFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggle ==0) {
                    FragmentTransaction fg2 = fragmentManager.beginTransaction();
                    fg2.replace(R.id.fragment_container, new SecondFragment()).commit();
                    toggle = 1;
                }
                else {
                    FragmentTransaction fg1 = fragmentManager.beginTransaction();
                    fg1.replace(R.id.fragment_container, new FirstFragment()).commit();
                    toggle = 0;
                }
            }
        });
    }
}