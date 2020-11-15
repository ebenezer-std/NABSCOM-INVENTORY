package com.example.nabscom;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        overridePendingTransition(R.anim.slide_in,R.anim.slide_in);
        initFrag();
    }
    private  void initBottomNavView(){
        Log.d(TAG, "initBottomNavView: Initializing the bottom navigation view");
        bottomNavigationView.clearAnimation();
    }

    private  void initFrag(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame,homeFragment,getString(R.string.home_tag));
        transaction.addToBackStack(getString(R.string.home_tag));
        transaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Log.d(TAG, "onNavigationItemSelected: homeFragmentSelected");

                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame,homeFragment,getString(R.string.home_tag));
                transaction.addToBackStack(getString(R.string.home_tag));
                transaction.commit();

                item.setChecked(true);
                break;
            case R.id.category:
                Log.d(TAG, "onNavigationItemSelected: Category Fragment selected");

                CategoryFragment categoryFragment = new CategoryFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.main_content_frame,categoryFragment,getString(R.string.home_tag));
                transaction1.addToBackStack(getString(R.string.home_tag));
                transaction1.commit();

                item.setChecked(true);
                break;
            case R.id.contact:
                Log.d(TAG, "onNavigationItemSelected: Contacts Fragment Selected");
                item.setChecked(true);
                
        }
        return false;
    }

//    @Override
//    public void inflateViewCategoryFragment(Product product) {
//        CategoryFragment categoryFragment = new CategoryFragment();
//
//        Bundle args = new Bundle();
//        args.putParcelable(getString(R.string.myProduct),product);
//        categoryFragment.setArguments(args);
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_content_frame,categoryFragment,"Category Fragment");
//        transaction.addToBackStack("Category Fragment");
//        transaction.commit();
//
//    }
}