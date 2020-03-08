package com.manank.gymapp.ui.diet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.manank.gymapp.CustomDietAdapter;
import com.manank.gymapp.DatabaseHelper;
import com.manank.gymapp.R;
import com.manank.gymapp.ViewDiet;

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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity().getApplicationContext(), ViewDiet.class);
                in.putExtra("id",l);
                startActivity(in);
            }
        });

        return root;
    }
}