package com.manank.gymapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        Cursor c = db.getSession();

        //Session Checking

        if(c.getCount()==0) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
            this.finish();
        }



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_bmi, R.id.nav_diet,
                R.id.nav_calorie, R.id.nav_share, R.id.nav_feedback)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //LayoutInflater factory = getLayoutInflater();
        //View text = factory.inflate(R.layout.nav_header_main,null);
        try {


            NavigationView nav = (NavigationView) findViewById(R.id.mobile_navigation);
            Log.d("TEST",String.valueOf(nav==null));
            View headerView = nav.inflateHeaderView(R.layout.nav_header_main);
            TextView uemail = headerView.findViewById(R.id.uemail);
            String s;
            while (c.moveToNext()) {
                s = c.getString(1);
                Log.d("STR", uemail.getText().toString());
                uemail.setText(s);
                Log.d("STR", uemail.getText().toString());
            }
        }
        catch (Exception e)
        {
            Log.d("TEST","Fucked up\n" + e);
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
