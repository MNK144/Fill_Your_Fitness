package com.manank.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class ViewDiet extends AppCompatActivity {
    DatabaseHelper db;
    TextView title,desc,time,cal,crb,prt;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_diet);
        db = new DatabaseHelper(this);
        int id;
        title = findViewById(R.id.vdt);
        desc = findViewById(R.id.vdd);
        imageView = findViewById(R.id.vdimg);
        time = findViewById(R.id.vdtime);
        cal = findViewById(R.id.vdcal);
        crb = findViewById(R.id.calcar);
        prt = findViewById(R.id.calprt);

        Cursor data;
        data=db.getDiet();
        id = (int)getIntent().getLongExtra("id",0);

        data.move(id);
        title.setText(data.getString(1));
        desc.setText(data.getString(2));
        time.setText(time.getText().toString()+data.getString(4));
        cal.setText(cal.getText().toString()+data.getString(5)+"kcal");
        Double dcrb = (Double.parseDouble(data.getString(5))*4.4);
        Double dprt = (Double.parseDouble(data.getString(5))*2.3);
        crb.setText(crb.getText().toString()+dcrb.toString().subSequence(0,2)+"gm");
        prt.setText(prt.getText().toString()+dprt.toString().subSequence(0,2)+"gm");

        String img = data.getString(3);


        //Load Image...DISABLED DOWNLOADED IMAGES
        //File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/FillYourFitness/.Diets");
        //File imageFile = new File(path, String.valueOf(img));
        //imageView.setImageDrawable(Drawable.createFromPath(imageFile.toString()));
        int imgid = getResources().getIdentifier(img.substring(0,img.length()-4).toLowerCase(),"mipmap",getPackageName());
        imageView.setImageDrawable(getDrawable(imgid));
    }
}
