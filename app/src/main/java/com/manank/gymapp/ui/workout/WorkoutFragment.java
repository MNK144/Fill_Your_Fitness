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

/*
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/
import com.manank.gymapp.AddWorkout;
import com.manank.gymapp.CustomWorkoutAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.LoginActivity;
import com.manank.gymapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

public class WorkoutFragment extends Fragment{

    public String URL_REGIST="https://yourfitnessapp.000webhostapp.com/imga.php";



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
                //onCallData();
            }
        });

        return root;
    }




/*
    SharedPreferences sharedPreferences;
    public void onCallData(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Toast.makeText(getActivity().getApplicationContext(), "try", Toast.LENGTH_SHORT).show();
                            Log.d("JSON",response);
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray=jsonObject.getJSONArray("exercises");
                            if (success.equals("1")) {
                                Toast.makeText(getActivity().getApplicationContext(), "login Success", Toast.LENGTH_SHORT).show();


                                for (int i=0 ;i<jsonArray.length();i++)
                                {
                                    JSONObject object=jsonArray.getJSONObject(i);
                                    String name=object.getString("ExerciseID").trim();
                                    String email=object.getString("Exercise_Name").trim();
                                    System.out.println(name+email);
                                    Blob bb ;
                                    Toast.makeText(getActivity().getApplicationContext(), "login Success", Toast.LENGTH_SHORT).show();
                                }

//                                sharedPreferences=getSharedPreferences("Savednaata", Context.MODE_PRIVATE);
//                                SharedPreferences.Editor editor=sharedPreferences.edit();
//                                editor.putString("value",memail);
//                                editor.apply();
//                                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
//                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(getActivity().getApplicationContext(), "login error", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getActivity().getApplicationContext(), "login fail" + e.toString(), Toast.LENGTH_SHORT).show();
                            // reg.setVisibility(View.GONE);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getActivity().getApplicationContext(), "login failed" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
//                params.put("email",memail);
//                params.put("password",mpassword);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);
    }*/
}
