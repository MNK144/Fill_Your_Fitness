package com.manank.gymapp.ui.workout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.manank.gymapp.AddWorkout;
import com.manank.gymapp.CustomWorkoutAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.R;

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

        Button add = root.findViewById(R.id.fwinsert);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), AddWorkout.class);
                startActivity(i);
            }
        });

        return root;
    }
}
