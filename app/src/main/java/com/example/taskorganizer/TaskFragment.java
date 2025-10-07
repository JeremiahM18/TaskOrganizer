package com.example.taskorganizer;

import android.content.Context;
import android.location.OnNmeaMessageListener;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TaskFragment extends Fragment {

    private TaskViewModel tm;

    public TaskFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        tm = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        EditText etTask = view.findViewById(R.id.etTask);
        EditText etName = view.findViewById(R.id.etName);
        Button btnAdd =
    }
}