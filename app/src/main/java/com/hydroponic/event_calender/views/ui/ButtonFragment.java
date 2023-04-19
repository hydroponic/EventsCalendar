package com.hydroponic.event_calender.views.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hydroponic.event_calender.R;


public class ButtonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button button = view.findViewById(R.id.button_cont);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("processed");
                Navigation.findNavController(view).navigate(R.id.action_buttonFragment_to_mainActivity2);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}