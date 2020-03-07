package com.manank.gymapp.ui.workout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.manank.gymapp.AddWorkout;
import com.manank.gymapp.CustomWorkoutAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.LoginActivity;
import com.manank.gymapp.MyListData;
import com.manank.gymapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;


import java.io.Serializable;
import com.squareup.picasso.Picasso;


public class WorkoutFragment extends Fragment{








    DatabaseHelper db;
    Cursor data;
    CustomWorkoutAdapter adapter;
    ListView list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout, container, false);

//        list = root.findViewById(R.id.workout_list);
////        db = new DatabaseHelper(getActivity().getApplicationContext());
////        data = db.getWorkout();
////
////        if(data!=null) {
////            adapter = new CustomWorkoutAdapter(getActivity().getApplicationContext(),data,0);
////            list.setAdapter(adapter);
////        }
////
        Button add = root.findViewById(R.id.fwinsert);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getActivity().getApplicationContext(), AddWorkout.class);
//                startActivity(i);
                login();

            }
        });

        return root;
    }

//
//
//    private MyListData[] listdata;
//
//
//    public void getDataset(){
//        final MyListData myListData = listdata[position];
//
//        Picasso.get().load("https://yourfitnessapp.000webhostapp.com/images/"+listdata[position].getId()+".PNG").into(holder.imageView);
//
//    }


    public String URL_REGIST="https://yourfitnessapp.000webhostapp.com/";


    JSONArray array;
    MyListData[] myListData = null;

    public void login(){

        String URLline = URL_REGIST+"imga.php";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            String st = "https://yourfitnessapp.000webhostapp.com/images/";
                            array=new JSONArray(response);
                            myListData=new MyListData[array.length()];
                            JSONObject obj;
                            for(int x=0;x<array.length();x++){
                                obj=array.getJSONObject(x);
                                myListData[x]=new MyListData(obj.getString("ExerciseID"),obj.getString("Exercise_Name"),st+obj.getString("ExerciseID")+".PNG");
                            }

                            Toast.makeText(getActivity().getApplicationContext(),"done:"+myListData[array.length()-1].getId(),Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();

                return params;
            }
        };

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        requestQueue.add(stringRequest);

    }



}
