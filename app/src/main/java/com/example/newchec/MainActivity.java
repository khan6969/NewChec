package com.example.newchec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
      FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.nav);
        navigationView.setOnNavigationItemSelectedListener(nav);
        if (savedInstanceState == null) {
            navigationView.setSelectedItemId(R.id.home);
            fragmentManager = getSupportFragmentManager();
            Home homeFragment = new Home();
            fragmentManager.beginTransaction().replace(R.id.allfragment,homeFragment).commit();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //on back press send to home from app
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener nav =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()){
                        case R.id.category:
                            fragment = new Category();
                            break;

                        case R.id.home:
                            fragment = new Home();
                            break;

                        case R.id.brand:

                            fragment = new Brand();

                            break;

                        case R.id.bag:
                            fragment = new Bag();
                            break;

                        case R.id.account:
                            fragment = new Account();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.allfragment,fragment).commit();
                    return true;
                }
            };
}