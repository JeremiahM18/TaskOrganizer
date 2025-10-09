package com.example.taskorganizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.LinkedList;


public class ListFragment extends Fragment {

    private TaskViewModel tm;
    private ArrayAdapter<String> adapter;

    public ListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);//
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState){
        super.onViewCreated(v, savedInstanceState);

        tm = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);

        ListView listView = v.findViewById(R.id.listView);

        // Simple built-in row layout
        adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, new ArrayList<String>());

        listView.setAdapter(adapter);

        // Observe LiveDate
        tm.getTask().observe(getViewLifecycleOwner(), new Observer<LinkedList<String>>() {
            @Override
            public void onChanged(LinkedList<String> items) {
                adapter.clear();
                if(items != null) {
                    adapter.addAll(items);
                    adapter.notifyDataSetChanged();
                }

            }
        });
    }

}