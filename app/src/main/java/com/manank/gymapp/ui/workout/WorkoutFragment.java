package com.manank.gymapp.ui.workout;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.R;

public class WorkoutFragment extends Fragment{
    String[] fromColumns = {"Excercise Name", "Description","Photo"};
    int[] toViews = {R.id.ename,R.id.descr,R.id.pic};
    DatabaseHelper db;
    Cursor data;
    SimpleCursorAdapter adapter;
    ListView workouts;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_workout, container, false);


        db = new DatabaseHelper(getActivity().getApplicationContext());



        return root;
    }

}
