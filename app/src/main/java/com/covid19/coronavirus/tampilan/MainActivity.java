package com.covid19.coronavirus.tampilan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.covid19.coronavirus.tampilan.Fragment.FragmentHome;
import com.covid19.coronavirus.tampilan.Fragment.FragmentInformasi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.covid19.coronavirus.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment;
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    fragment = new FragmentHome();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame_layout,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_informasi:
                    fragment = new FragmentInformasi();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame_layout,fragment,fragment.getClass().getSimpleName())
                            .commit();
                    return true;


            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if (savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.navigation_home);
        }
    }
}
