package com.manank.gymapp.ui.workout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.manank.gymapp.CustomWorkoutAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.R;
import com.manank.gymapp.ViewWorkout;


public class WorkoutFragment extends Fragment{

    DatabaseHelper db;
    Cursor data;
    CustomWorkoutAdapter adapter;
    ListView list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout, container, false);

        list = root.findViewById(R.id.workout_list);
        db = new DatabaseHelper(getActivity().getApplicationContext());
        data = db.getWorkout();

        if(data!=null) {
            adapter = new CustomWorkoutAdapter(getActivity().getApplicationContext(),data,0);
            list.setAdapter(adapter);
       }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity().getApplicationContext(), ViewWorkout.class);
                in.putExtra("id",l);
                startActivity(in);
            }
        });

        return root;
    }




}
