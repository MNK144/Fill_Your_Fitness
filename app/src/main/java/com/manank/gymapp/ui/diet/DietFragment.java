package com.manank.gymapp.ui.diet;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.manank.gymapp.CustomDietAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.R;

public class DietFragment extends Fragment {

    DatabaseHelper db;
    Cursor data;
    CustomDietAdapter adapter;
    ListView list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_diet, container, false);

        list = root.findViewById(R.id.diet_list);
        db = new DatabaseHelper(getActivity().getApplicationContext());
        data = db.getDiet();

        if(data!=null) {
            adapter = new CustomDietAdapter(getActivity().getApplicationContext(),data,0);
            //adapter.setRoot(root);
            list.setAdapter(adapter);
        }

        return root;
    }
}